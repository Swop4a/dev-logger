import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { Store, select } from '@ngrx/store';

import {
  GET_POST,
  State as PostsState,
} from '../store/posts';
import { AppState } from '../store/rootReducer';

import { SearchPost } from '../search-post';

@Component({
  selector: 'app-post-page',
  templateUrl: './post-page.component.html',
  styleUrls: ['./post-page.component.scss']
})
export class PostPageComponent implements OnInit {
  post: SearchPost;

  constructor(
    public route: ActivatedRoute,
    private store: Store<AppState>,
  ) { }

  ngOnInit() {
    this.store.select<PostsState>('posts').subscribe(
      postsInfo => this.post = postsInfo.post,
    );

    this.store.dispatch({
      type: GET_POST,
      payload: {
        id: this.route.snapshot.paramMap.get('id'),
      },
    });
  }
}
