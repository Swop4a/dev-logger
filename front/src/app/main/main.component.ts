import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { TOGGLE_POSTS, TOGGLE_SMART_POSTS, State as PostsState } from '../store/posts';
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
  posts: SearchPost[];
  postsInfo: PostsState;

  constructor(
    public postsService: PostsService,
    private store: Store<AppState>,
  ) { }

  ngOnInit() {
    this.postsService.getPosts().subscribe(posts => this.posts = posts);

    this.store.select<PostsState>('posts').subscribe(
      postsInfo => this.postsInfo = postsInfo,
    );
  }

  changePostsType(postsType: number) {
    this.store.dispatch({ type: TOGGLE_POSTS, payload: postsType });
    // TODO: here we should perform request to another kind of posts
  }

  toggleSmartLenta(isSmart: boolean) {
    this.store.dispatch({ type: TOGGLE_SMART_POSTS, payload: isSmart });
    // TODO: here we should perform request to another kind of posts
  }
}
