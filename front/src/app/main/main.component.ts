import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import {
  TOGGLE_POSTS,
  TOGGLE_SMART_POSTS,
  GET_POSTS,
  State as PostsState,
} from '../store/posts';
import { AppState } from '../store/rootReducer';

import { PostsService } from '../posts.service';
import { SearchPost } from '../search-post';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
  encapsulation: 2,
})
export class MainComponent implements OnInit {
  postsState: PostsState;

  constructor(
    private store: Store<AppState>,
  ) { }

  ngOnInit() {
    this.store.select<PostsState>('posts').subscribe(
      postsState => this.postsState = postsState,
    );

    this.store.dispatch({ type: GET_POSTS, payload: this.postsState });
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
