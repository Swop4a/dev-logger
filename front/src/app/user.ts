export interface Favorite {
  postId: string;
  accounts: string[];
  time: Date;
}

export interface User {
  handle: string;
  username: string;
  image: string;
  company: string;
  rating: number;
  interests: string[];
  followers: User[];
  following: User[];
  favorites: Favorite[];
  since: Date;
  lastSeen: Date;
  skype: string;
  gitHub: string;
  telegram: string;
  facebook: string;
  vk: string;
  linkedIn: string;
}
