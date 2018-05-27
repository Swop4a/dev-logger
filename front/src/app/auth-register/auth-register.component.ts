import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Store } from '@ngrx/store';

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

  createForms() {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });

    this.registerForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      repeatPassword: ['', Validators.required],
    });
  }

  onLogin() {
    const formModel = this.loginForm.value;

    this.store.dispatch<LoginAction>({
      type: LOGIN,
      payload: formModel,
    });

    // deep copy of form model lairs
    // const secretLairsDeepCopy: Address[] = formModel.secretLairs.map(
    //   (address: Address) => Object.assign({}, address)
    // );

    // return new `Hero` object containing a combination of original hero value(s)
    // and deep copies of changed form model values
    // const saveHero: Hero = {
    //   id: this.hero.id,
    //   name: formModel.name as string,
      // addresses: formModel.secretLairs // <-- bad!
    //   addresses: secretLairsDeepCopy
    // };
    // return saveHero;
  }

  onRegister() {
    const formModel = this.registerForm.value;

    this.store.dispatch<RegisterUserAction>({
      type: REGISTER_USER,
      payload: formModel,
    });
  }

}
