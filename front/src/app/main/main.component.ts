import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Observable } from 'rxjs';
import { TOGGLE_POSTS, TOGGLE_SMART_POSTS, State } from '../store/posts';
import AppState from '../store/appState';

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
  postsInfo$: Observable<State>;
  smartLenta = true;
  selectedPostsType = 0;

  constructor(
    public postsService: PostsService,
    private store: Store<AppState>,
  ) { }

  ngOnInit() {
    this.postsService.getPosts().subscribe(posts => this.posts = posts);

    this.postsInfo$ = this.store.select<State>('posts');
  }

  changePostsType(postsType: number) {
    console.log(`Posts type changed to ${postsType}`);
    // TODO: here we should perform request to another kind of posts
  }

}
