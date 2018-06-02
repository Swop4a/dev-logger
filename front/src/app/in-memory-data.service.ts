import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

import { SearchPost } from './search-post';

@Injectable()
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const searchPosts = [];

    return { searchPosts };
  }
}
