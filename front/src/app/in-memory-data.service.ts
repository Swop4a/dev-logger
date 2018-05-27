import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

import { SearchPost } from './search-post';

@Injectable()
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const searchPosts: SearchPost[] = [
      {
        id: 'someUnicID1',
        title: 'Vassa pupkin killed his grandmother',
        tags: ['java', 'hyava', 'allah', 'babah'],
        type: 'novost',
        lastUpdate: new Date(),
        statistic: {
          rating: 200,
          views: 700,
          downloads: 1000,
        },
        publicationDate: new Date(),
        publisher: {
          name: 'Biba boy',
          lastSeen: new Date(),
        },
        image: 'assets/spaceHD.jpg',
        content: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Esse numquam deleniti fugit, accusantium placeat. Sit doloremque, dignissimos alias deserunt ratione, quas accusamus id psomeUnicID1? Quisquam natus quo qui itaque, accusamus voluptates illum minima numquam. Odio mollitia est expedita ipsam doloremque sunt possimus. Vero quibusdam eaque consectetur tempora, atque temporibus explicabo, nostrum obcaecati in quasi culpa UnicID1 dolorum, beatae delectus.',
      },
      {
        id: 'someUnicID2',
        title: 'Wtf post',
        tags: ['java', 'hyava', 'allah', 'babah'],
        type: 'novost',
        lastUpdate: new Date(),
        statistic: {
          rating: 200,
          views: 700,
          downloads: 1000,
        },
        publicationDate: new Date(),
        publisher: {
          name: 'Biba boy',
          lastSeen: new Date(),
        },
        image: 'assets/spaceHD.jpg',
        content: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus, cumque qui hic suscipit culpa aperiam iusto incidunt quaerat cupiditate soluta obcaecati neque esse, nulla eaque eius voluptatem porro. Amet, eius soluta eveniet illo? Ipsum, atque iste! Architecto quae, illum ipsa nihil cupiditate aut beatae blanditiis consectetur. Alias beatae ipsam cumque saepe non, odio! Laborum sed, mollitia et adipisci ratione nostrum!',
      },
      {
        id: 'someUnicID5',
        title: 'Omg what a grean title for some post',
        tags: ['java', 'hyava', 'allah', 'babah'],
        type: 'novost',
        lastUpdate: new Date(),
        statistic: {
          rating: 200,
          views: 700,
          downloads: 1000,
        },
        publicationDate: new Date(),
        publisher: {
          name: 'Biba boy',
          lastSeen: new Date(),
        },
        image: 'assets/spaceHD.jpg',
        content: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. A officiis nulla deserunt quae dicta nobis, fugit natus! Fuga facere sunt odit, est maxime, asperiores et blanditiis earum. Sequi illo voluptatum architecto, distinctio doloremque magnam fuga rerum laborum aut excepturi cumque inventore corporis aliquid tempore. Maiores illum praesentium temporibus soluta est a, eum impedit, nobis excepturi quasi, aperiam voluptatum! Impedit, consequuntur.',
      },
      {
        id: 'someUnicID3',
        title: 'Alexander actualy started to build the blog',
        tags: ['netuvremeni', 'ebalrot', 'antihype'],
        type: 'biba type',
        lastUpdate: new Date(),
        statistic: {
          rating: 200,
          views: 700,
          downloads: 1000,
        },
        publisher: {
          name: 'Biba boy',
          lastSeen: new Date(),
        },
        publicationDate: new Date(),
        image: 'assets/spaceHD.jpg',
        content: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis consectetur facilis optio aspernatur dicta enim, recusandae libero deserunt nostrum dolore quos quas veniam placeat, quasi commodi molestias debitis at velit vel saepe quibusdam? Molestias, aliquid? Vel, quasi quis ratione suscipit, libero eligendi cupiditate totam, quod cum aut ex quia eveniet nam repudiandae ipsa nihil inventore voluptatem beatae molestias odit optio.',
      },
    ];

    return { searchPosts };
  }
}
