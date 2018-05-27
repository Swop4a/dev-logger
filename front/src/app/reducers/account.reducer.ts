import { Action } from '@ngrx/store';

import { User } from '../user';
import { ActionWithPayload } from './rootReducer';

export const REGISTER_USER = 'REGISTER_USER';
export const REGISTER_USER_COMPLETE = 'REGISTER_USER_COMPLETE';
export const REGISTER_USER_FAILURE = 'REGISTER_USER_FAILURE';

export const GET_AUTH_TOKEN = 'GET_AUTH_TOKEN';
export const GET_AUTH_TOKEN_SUCCESS = 'GET_AUTH_TOKEN_SUCCESS';
export const GET_AUTH_TOKEN_FAILURE = 'GET_AUTH_TOKEN_FAILURE';

export const LOGIN = 'LOGIN';
export const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
export const LOGIN_FAILURE = 'LOGIN_FAILURE';

export interface State {
  user?: User;
}

export const initialState: State = {
  user: null,
};

export function reducer(state = initialState, action: ActionWithPayload): State {
  switch (action.type) {
    case REGISTER_USER_COMPLETE:
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


export interface LoginAction extends Action {
  payload?: {
    username: string;
    password: string;
  };
}

export interface LoginSuccessAction extends Action {
  payload?: User;
}
