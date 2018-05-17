import { Component, OnInit } from '@angular/core';

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
  smartLenta = true;
  postsType = 0;

  constructor(
    public postsService: PostsService,
  ) { }

  ngOnInit() {
    this.postsService.getPosts().subscribe(posts => this.posts = posts);
  }

}
