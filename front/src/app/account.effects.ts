import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Actions, Effect, ofType } from '@ngrx/effects';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { pluck, mergeMap, catchError, map, tap } from 'rxjs/operators';

import {
  ACCOUNT_SERVICE_URL,
  AUTH_URL,
} from './consts';

import { User } from './user';

import {
  REGISTER_USER,
  REGISTER_USER_COMPLETE,
  REGISTER_USER_FAILURE,

  LOGIN,
  LOGIN_SUCCESS,
  LOGIN_FAILURE,

  RegisterUserAction,

  LoginAction,
  LoginSuccessAction,
} from './reducers/account.reducer';

@Injectable()
export class AccountEffects {
  private accountServiceURL = ACCOUNT_SERVICE_URL;
  private authUrl = AUTH_URL;

  constructor(
    private actions$: Actions,
    private http: HttpClient,
    private router: Router,
  ) {}

  @Effect()
  registerUser$: Observable<LoginAction> = this.actions$.pipe(
    ofType(REGISTER_USER),
    mergeMap(({ payload }: RegisterUserAction) =>
      this.http.post(
        this.accountServiceURL,
        payload,
      ).pipe(
        map(() => ({
          type: LOGIN,
          payload: {
            username: payload.username,
            password: payload.password,
          }
        })),
        catchError(() => of({ type: REGISTER_USER_FAILURE })),
      ),
    ),
  );

  @Effect()
  login$: Observable<LoginSuccessAction> = this.actions$.pipe(
    ofType(LOGIN),
    mergeMap(
      (action: LoginAction) => {
        const token = localStorage.getItem('token');

        if (token) {
          return of(token);
        }

        return this.http.post<string>(this.authUrl, {
          ...action.payload,
          scope: 'ui',
          grant_type: 'password',
        }).pipe(
          map<any, string>((authData) => authData.access_token)
        );
      },
      (action, token) => {
        localStorage.setItem('token', token);
        return token;
      }
    ),
    mergeMap(
      token => this.http.get(
        `${this.authUrl}/current`,
        {
          headers: new HttpHeaders({
            Authorization: 'Bearer ' + token,
          }),
        },
      ).pipe(
        tap(_ => this.router.navigate(['/'])),
        map((userData: User) => ({
          type: LOGIN_SUCCESS,
          payload: userData,
        }))
      ),
    ),
    catchError(() => of({ type: LOGIN_FAILURE })),
  );
}
