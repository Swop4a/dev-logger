import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable()
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const searchPosts = [
      {
        id: 1,
        title: 'Vassa pupkin killed his grandmother',
        tags: ['java', 'hyava', 'allah', 'babah'],
        rating: 200,
        views: 700,
        created: new Date(),
        image: 'assets/full-logo@3x.png',
      },
      {
        id: 2,
        title: 'Wtf post',
        tags: ['java', 'hyava', 'allah', 'babah'],
        rating: 200,
        views: 700,
        created: new Date(),
        image: 'assets/full-logo@3x.png',
      },
      {
        id: 3,
        title: 'Omg what a grean title for some post',
        tags: ['java', 'hyava', 'allah', 'babah'],
        rating: 200,
        views: 700,
        created: new Date(),
        image: 'assets/full-logo@3x.png',
      },
      {
        id: 4,
        title: 'Alexander actualy started to build the blog',
        tags: ['netuvremeni', 'ebalrot', 'antihype'],
        rating: 30,
        views: 70,
        created: new Date(),
        image: 'assets/full-logo@3x.png',
      },
    ];

    return { searchPosts };
  }
}
