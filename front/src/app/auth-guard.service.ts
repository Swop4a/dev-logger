import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

import { Store } from '@ngrx/store';
import { last } from 'rxjs/operators';

import { AppState } from './reducers/rootReducer';
import { State as UserState } from './reducers/account.reducer';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  status: boolean;
  constructor(private router: Router,
              private store$: Store<AppState>) { }

  OnInit() {
    this.store$.select<UserState>('account').subscribe(
      userData => this.status = userData.isLoggedIn,
    );
  }

  canActivate() {
    if (this.status) {
      return true;
    }

    this.router.navigate(['/']);
    return false;
  }
}
