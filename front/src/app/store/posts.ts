import { Action } from '@ngrx/store';
import { SearchPost } from '../search-post';

export const TOGGLE_POSTS = 'TOGGLE_POSTS';
export const GET_POSTS = 'GET_POSTS';
export const TOGGLE_SMART_POSTS = 'TOGGLE_SMART_POSTS';
export const GET_POSTS_COMPLETED = 'GET_POSTS_COMPLETED';
export const GET_POSTS_FAILED = 'GET_POSTS_FAILED';

const initialState: State = {
  posts: [],
  postsType: 0, // 0 is a "feed", 1 is a "my posts"
  isSmart: false,
};

export function postsReducer(state: State = initialState, action: PostsAction): State {
  switch (action.type) {
    case TOGGLE_POSTS:
      return {
        ...state,
        postsType: action.payload ? action.payload : state.postsType === 0 ? 1 : 0,
      };

    case GET_POSTS_COMPLETED:
      return {
        ...state,
        posts: action.payload,
      };

    case TOGGLE_SMART_POSTS:
      return {
        ...state,
        isSmart: action.payload ? action.payload : !state.isSmart,
      };

    default:
      return state;
  }
}

export interface State {
  postsType: number;
  isSmart: boolean;
  posts: SearchPost[];
}

export interface PostsAction extends Action {
  payload?: any;
}

export interface GetPostsAction extends Action {
  payload: {
    postsType: State['postsType'];
    isSmart: State['isSmart'];
  };
}

export interface GetPostsCompletedAction extends Action {
  payload?: SearchPost[];
}
