import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { SearchPost } from '../search-post';
import { PostsService } from '../posts.service';

@Component({
  selector: 'app-post-page',
  templateUrl: './post-page.component.html',
  styleUrls: ['./post-page.component.scss']
})
export class PostPageComponent implements OnInit {
  post: SearchPost;

  constructor(
    public route: ActivatedRoute,
    public posts: PostsService,
  ) { }

  ngOnInit() {
    this.posts.getPost(this.route.snapshot.paramMap.get('id'))
      .subscribe(post => this.post = post);
  }

}
