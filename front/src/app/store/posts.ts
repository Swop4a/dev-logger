import { Action } from '@ngrx/store';

export const TOGGLE_POSTS = 'TOGGLE_POSTS';
export const TOGGLE_SMART_POSTS = 'TOGGLE_SMART_POSTS';

const initialState: State = {
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
}

interface PostsAction extends Action {
  payload?: any;
}
