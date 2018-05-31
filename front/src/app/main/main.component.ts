import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';

import {
  TOGGLE_POSTS,
  TOGGLE_SMART_POSTS,
  GET_POSTS,
  State as PostsState,
  GetPostsAction,
} from '../reducers/posts';
import {
  State as AccountState,
} from '../reducers/account.reducer';
import { AppState } from '../reducers/rootReducer';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
  encapsulation: 2,
})
export class MainComponent implements OnInit {
  postsState: PostsState;
  isLoggedIn = false;

  constructor(
    private store: Store<AppState>,
  ) { }

  // TODO: disable my posts
  ngOnInit() {
    // TODO: do it with selectors(dont pass here unnecessary data)
    this.store.select<PostsState>('posts').subscribe(
      postsState => this.postsState = postsState,
    );
    this.store.select<AccountState>('account').subscribe(
      userData => this.isLoggedIn = userData.isLoggedIn,
    );

    this.store.dispatch<GetPostsAction>({
      type: GET_POSTS,
      payload: {
        postsType: this.postsState.postsType,
        isSmart: this.postsState.isSmart,
      },
    });
  }

  changePostsType(postsType: number) {
    this.store.dispatch({ type: TOGGLE_POSTS, payload: postsType });
    this.store.dispatch({ type: GET_POSTS, payload: this.postsState });
  }

  toggleSmartLenta(isSmart: boolean) {
    this.store.dispatch({ type: TOGGLE_SMART_POSTS, payload: isSmart });
    this.store.dispatch({ type: GET_POSTS, payload: this.postsState });
  }
}
