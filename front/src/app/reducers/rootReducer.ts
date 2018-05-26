import { Action } from '@ngrx/store';
import { State as PostsState, postsReducer } from './posts';

export interface AppState {
  posts: PostsState;
}

export interface ActionWithPayload extends Action {
  payload?: any;
}

export const rootReducer = {
  posts: postsReducer,
};
