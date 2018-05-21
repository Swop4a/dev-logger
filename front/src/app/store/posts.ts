import { Action } from '@ngrx/store';

export const TOGGLE_POSTS = 'TOGGLE_POSTS';
export const TOGGLE_SMART_POSTS = 'TOGGLE_SMART_POSTS';

export interface State {
  postsType: string;
  isSmart: boolean;
}

const initialState: State = {
  postsType: 'feed',
  isSmart: true,
};

export function postsReducer(state: State = initialState, action: Action) {
  switch (action.type) {
    case TOGGLE_POSTS:
      return {
        ...state,
        postsType: state.postsType === 'feed' ? 'my' : 'feed',
      };

    case TOGGLE_SMART_POSTS:
      return {
        ...state,
        isSmart: !state.isSmart,
      };

    default:
      return state;
  }
}
