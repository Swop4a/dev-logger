export interface SearchPost {
  id: string;
  title: string;
  tags: string[];
  statistic: {
    rating: number;
    views: number;
  };
  publicationDate: Date;
  image: string;
  content: string;
}
