import { State as PostsState, postsReducer } from './posts';

export interface AppState {
  posts: PostsState;
}

export const rootReducer = {
  posts: postsReducer,
};
