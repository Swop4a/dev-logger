import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable()
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const searchPosts = [
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

    return { searchPosts };
  }
}
