import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';

import { PasswordValidation } from '../password-validation';

import {
  LOGIN,
  REGISTER_USER,

  LoginAction,
  RegisterUserAction,
} from '../reducers/account.reducer';

import { AppState } from '../reducers/rootReducer';

@Component({
  selector: 'app-auth-register',
  templateUrl: './auth-register.component.html',
  styleUrls: ['./auth-register.component.scss']
})
export class AuthRegisterComponent implements OnInit {
  loginForm: FormGroup;
  registerForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private store: Store<AppState>,
  ) { }

  ngOnInit() {
    this.createForms();
  }

  // TODO: add errors handling
  // TODO: block buttons on request
  createForms() {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });

    this.registerForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required, PasswordValidation.MatchPassword],
    });
  }

  onLogin() {
    const formModel = this.loginForm.value;

    this.store.dispatch<LoginAction>({
      type: LOGIN,
      payload: formModel,
    });
  }

  onRegister() {
    const formModel = this.registerForm.value;

    this.store.dispatch<RegisterUserAction>({
      type: REGISTER_USER,
      payload: formModel,
    });
  }

}
