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

  isSmartLenta$: Observable<PostsState['isSmart']>;
  selectedPostsType$: Observable<PostsState['postsType']>;

  constructor(
    public postsService: PostsService,
    private store: Store<AppState>,
  ) { }

  ngOnInit() {
    this.postsService.getPosts().subscribe(posts => this.posts = posts);

    this.selectedPostsType$ = this.store.select<PostsState>('posts').pipe(
      map(state => state.postsType),
    );

    this.isSmartLenta$ = this.store.select<PostsState>('posts').pipe(
      map(state => state.isSmart),
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
