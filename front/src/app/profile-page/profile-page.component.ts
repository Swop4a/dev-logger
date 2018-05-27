import { Component, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';

import { AppState } from '../reducers/rootReducer';

import {
  State as UserState,
  GET_CURRENT_USER,
} from '../reducers/account.reducer';
import {
  State as PostsState,
  GET_USER_POSTS,
} from '../reducers/posts';

import { User } from '../user';
import { SearchPost } from '../search-post';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.scss']
})
export class ProfilePageComponent implements OnInit {
  user: User;
  posts: SearchPost[];

  constructor(
    private store: Store<AppState>,
  ) { }

  ngOnInit() {
    this.store.dispatch({ type: GET_CURRENT_USER });

    this.store.select<UserState>('account').subscribe(
      account => this.user = account.user,
    );
    this.store.select<PostsState>('posts').subscribe(
      postsData => this.posts = postsData.posts,
    );
  }

}
