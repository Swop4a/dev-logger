import { Component, OnInit, Input } from '@angular/core';

import { SearchPost } from '../search-post';

@Component({
  selector: 'app-post-preview',
  templateUrl: './post-preview.component.html',
  styleUrls: ['./post-preview.component.scss']
})
export class PostPreviewComponent implements OnInit {
  @Input() post: SearchPost;

  constructor() { }

  ngOnInit() {
  }

}
