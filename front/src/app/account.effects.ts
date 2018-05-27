import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Actions, Effect, ofType } from '@ngrx/effects';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of, empty } from 'rxjs';
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

  GET_CURRENT_USER,
  GET_CURRENT_USER_SUCCESS,
  GET_CURRENT_USER_FAILURE,

  RegisterUserAction,
  RegisterUserSuccessAction,

  LoginAction,
  LoginSuccessAction,
  GetCurrentUserSuccessAction,
} from './reducers/account.reducer';

import {
  GET_USER_POSTS,
} from './reducers/posts';

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
  registerUser$: Observable<RegisterUserSuccessAction> = this.actions$.pipe(
    ofType(REGISTER_USER),
    mergeMap(({ payload }: RegisterUserAction) =>
      this.register(payload),
      ({ payload }) => payload,
    ),
    mergeMap(
      payload => this.requestToken(payload),
      (_, token) => token,
    ),
    mergeMap(
      token => this.getCurrentUser(token).pipe(
        map((userData: User) => ({
          type: REGISTER_USER_COMPLETE,
          payload: userData,
        })),
      ),
    ),
    catchError(() => of({ type: REGISTER_USER_FAILURE }))
  );

  @Effect()
  login$: Observable<LoginSuccessAction> = this.actions$.pipe(
    ofType(LOGIN),
    mergeMap(
      ({ payload }: LoginAction) => this.requestToken(payload),
      (_, token) => token,
    ),
    mergeMap(
      token => this.getCurrentUser(token).pipe(
        tap(_ => this.router.navigate(['/'])),
        map((userData: User) => ({
          type: LOGIN_SUCCESS,
          payload: userData,
        }))
      ),
    ),
    catchError(() => of({ type: LOGIN_FAILURE }))
  );

  @Effect()
  getCurrentUser$: Observable<GetCurrentUserSuccessAction> = this.actions$.pipe(
    ofType(GET_CURRENT_USER),
    mergeMap(
      () => {
        const token = localStorage.getItem('token');

        return this.getCurrentUser(token).pipe(
          mergeMap((userData) => [
            {
              type: GET_CURRENT_USER_SUCCESS,
              payload: userData,
            },
            { type: GET_USER_POSTS },
          ]),
        );
      },
    ),
    catchError((error) => of({ type: GET_CURRENT_USER_FAILURE })),
  );

  private register(userData) {
    return this.http.post(
      this.accountServiceURL,
      userData,
    );
  }

  private requestToken(userData): Observable<string> {
    return this.http.post<string>(this.authUrl, {
        ...userData,
        scope: 'ui',
        grant_type: 'password',
      },
      { headers: new HttpHeaders({ 'Authorization': 'Basic YnJvd3Nlcjo=' })
    }).pipe(
      map<any, string>((authData) => authData.access_token),
      tap(newToken =>  localStorage.setItem('token', newToken)),
      catchError(() => {
        localStorage.removeItem('token');
        return empty();
      }),
    );
  }

  private getCurrentUser(token: string) {
    return this.http.get<User>(
      `${this.authUrl}/current`,
      {
        headers: new HttpHeaders({
          Authorization: `Bearer ${token}`,
        }),
      },
    );
  }
}
