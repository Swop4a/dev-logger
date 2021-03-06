import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

import { SearchPost } from '../search-post';

@Component({
  selector: 'app-post-preview',
  templateUrl: './post-preview.component.html',
  encapsulation: 2,
  styleUrls: ['./post-preview.component.scss']
})
export class PostPreviewComponent implements OnInit {
  @Input() post: SearchPost;
  @Input() hideContent: boolean;
  @Input() isFavorite: boolean;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  seeMore() {
    this.router.navigate(['posts', this.post.id]);
  }

}
