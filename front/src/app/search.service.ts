import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { SearchPost } from './search-post';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  // TODO: move to the search service
  options: SearchPost[] = [
    {
      id: 1,
      title: 'Vassa pupkin killed his grandmother',
    },
    {
      id: 2,
      title: 'Wtf post',
    },
    {
      id: 3,
      title: 'Omg what a grean title for some post',
    },
  ];

  constructor() { }

  searchPosts(title: string): Observable<SearchPost[]> {
    // NOTE: здесь нужно чтобы:
    // 1. ассинхронно запрос к серву
    // 2. ассинхронно ответ
    // return kll this.$filteredOptions = this.search.valueChanges.pipe(
    //   startWith(''),
    //   map(val => this.filter(val))
    // );
    // return this.http.get<Hero>(`${this.heroesUrl}/${id}`)
    //   .pipe(
    //     tap(_ => this.log(`fetched hero with id=${id}`)),
    //     catchError(this.handleError<Hero>('getHero')),
    //   );
  }

  filter(val: string) {
    return this.options.filter(option =>
      option.title.toLowerCase().includes(val.toLowerCase()));
  }
}
