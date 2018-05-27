import { Action } from '@ngrx/store';
import { State as PostsState, postsReducer } from './posts';
import {
  State as AccountState,
  reducer as accountReducer,
} from './account.reducer';

export interface AppState {
  posts: PostsState;
}

export interface ActionWithPayload extends Action {
  payload?: any;
}

export const rootReducer = {
  posts: postsReducer,
  account: accountReducer,
};
