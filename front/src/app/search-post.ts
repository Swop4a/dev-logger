export interface SearchPost {
  id: string;
  title: string;
  tags: string[];
  type: string;
  content: string;
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
