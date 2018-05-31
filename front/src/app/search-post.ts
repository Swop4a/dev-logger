export interface Comment {
  author: string;
  parent?: Comment;
  childes?: Comment[];
  content: string;
}

export interface SearchPost {
  id: string;
  title: string;
  tags: string[];
  type: string;
  content: string;
  comments: Comment[];
  statistic: {
    rating: number;
    views: number;
    downloads: number;
  };
  publicationDate: Date;
  lastUpdate: Date;
  publisher: {
    name: string;
    lastSeen: Date;
  };
  image: string;
}
