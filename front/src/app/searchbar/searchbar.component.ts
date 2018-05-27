import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
import { Router } from '@angular/router';

import { PostsService } from '../posts.service';
import { SearchPost } from '../search-post';

// TODO: rework
@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.scss']
})
export class SearchbarComponent implements OnInit {
  search: FormControl = new FormControl();

  posts$: Observable<SearchPost[]>;

  constructor(
    private router: Router,
    private searchService: PostsService,
  ) { }

  ngOnInit() {
    this.posts$ = this.search.valueChanges.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.searchService.searchPosts(term)),
    );
  }


  getPost(id: SearchPost['id']) {
    this.search.reset('');
    this.router.navigate(['posts', id]);
  }

}
