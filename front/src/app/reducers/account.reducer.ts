import { Action } from '@ngrx/store';

import { User } from '../user';
import { ActionWithPayload } from './rootReducer';

export const REGISTER_USER = 'REGISTER_USER';
export const REGISTER_USER_COMPLETE = 'REGISTER_USER_COMPLETE';
export const REGISTER_USER_FAILURE = 'REGISTER_USER_FAILURE';

export const GET_CURRENT_USER = 'GET_CURRENT_USER';
export const GET_CURRENT_USER_SUCCESS = 'GET_CURRENT_USER_SUCCESS';
export const GET_CURRENT_USER_FAILURE = 'GET_CURRENT_USER_FAILURE';

export const GET_AUTH_TOKEN = 'GET_AUTH_TOKEN';
export const GET_AUTH_TOKEN_SUCCESS = 'GET_AUTH_TOKEN_SUCCESS';
export const GET_AUTH_TOKEN_FAILURE = 'GET_AUTH_TOKEN_FAILURE';

export const LOGIN = 'LOGIN';
export const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
export const LOGIN_FAILURE = 'LOGIN_FAILURE';

export interface State {
  user?: User;
  isLoggedIn: boolean;
}

export const initialState: State = {
  user: null,
  isLoggedIn: false,
};

export function reducer(state = initialState, action: ActionWithPayload): State {
  switch (action.type) {
    case LOGIN_SUCCESS:
      return {
        ...state,
        isLoggedIn: true,
        user: action.payload,
      };

    case LOGIN_FAILURE:
      return {
        ...state,
        isLoggedIn: false,
        user: null,
      };

    case GET_CURRENT_USER_SUCCESS:
      return {
        ...state,
        user: action.payload,
      };

    default:
      return state;
  }
}

export interface RegisterUserAction extends Action {
  payload: {
    username: string;
    password: string;
  };
}

export interface RegisterUserSuccessAction extends Action {
  payload?: User;
}


export interface LoginAction extends Action {
  payload?: {
    username: string;
    password: string;
  };
}

export interface LoginSuccessAction extends Action {
  payload?: User;
}

export interface GetCurrentUserSuccessAction extends Action {
  payload?: User;
}
