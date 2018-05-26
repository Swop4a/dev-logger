import { Action } from '@ngrx/store';

import { User } from '../user';
import { ActionWithPayload } from './rootReducer';

export const REGISTER_USER = 'REGISTER_USER';
export const REGISTER_USER_COMPLETE = 'REGISTER_USER_COMPLETE';
export const REGISTER_USER_FAILURE = 'REGISTER_USER_FAILURE';

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

export interface RegisterUserAction {
  user: string;
  password: string;
}

export interface RegisterUserCompleteAction extends Action {
  payload?: User;
}
