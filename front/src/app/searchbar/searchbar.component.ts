import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith, filter } from 'rxjs/operators';
import { Router } from '@angular/router';

import { SearchService } from '../search.service';
import { SearchPost } from '../search-post';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.scss']
})
export class SearchbarComponent implements OnInit {
  search: FormControl = new FormControl();

  $filteredOptions: Observable<SearchPost[]>;

  constructor(
    private router: Router,
    private searchService: SearchService,
  ) { }

  ngOnInit() {
    this.$filteredOptions = this.search.valueChanges.pipe(
      startWith(''),
      map(val => this.searchService.searchPosts(val)),
    );
  }


  getPost(title: SearchPost['title']) {
    // NOTE: запрос поста должен просиходить на маунте страницы поста
    // this.router.navigate(['posts', this.searchService. options.find(option => option.title === title).id]);
    // this.search.reset('');
  }

}
