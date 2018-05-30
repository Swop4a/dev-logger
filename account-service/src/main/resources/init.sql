insert into accounts (
  "id",
  "handle",
  "username",
  "image",
  "company",
  "rating",
  "facebook",
  "git_hub",
  "vk",
  "linked_in",
  "skype",
  "telegram"
) values (
  1,
  'JProgrammer',
  'Java programmer',
  'http://www.technologybloggers.org/wp-content/uploads/2013/06/Java-logo-500x500.png',
  'EPAM Systems',
  4.23,
  'https://www.facebook.com/jprogrammer',
  'https://github.com/jprogrammer',
  'https://vk.com/jporgrammer',
  'http://www.linkedin.com/jporgrammer',
  'Jprogrammer',
  '@jprogrammer'
);

insert into interests("id", "interest") values (1, 'Java');
insert into interests("id", "interest") values (1, 'Spring');
insert into interests("id", "interest") values (1, 'Spring Boot');
insert into interests("id", "interest") values (1, 'Git');
insert into interests("id", "interest") values (1, 'Microservices');
insert into interests("id", "interest") values (1, 'MongoDB');

insert into post_ids("id", "post_id") values (1, 'java9');
insert into post_ids("id", "post_id") values (1, 'collections');

insert into accounts (
  "id",
  "handle",
  "username",
  "image",
  "company",
  "rating",
  "facebook",
  "git_hub",
  "vk",
  "linked_in",
  "skype",
  "telegram"
) values (
  2,
  'PProgrammer',
  'Python programmer',
  'https://findicons.com/files/icons/2804/plex/512/python.png',
  'EPAM Systems',
  3.95,
  'https://www.facebook.com/pprogrammer',
  'https://github.com/pprogrammer',
  'https://vk.com/pporgrammer',
  'http://www.linkedin.com/pporgrammer',
  'Pprogrammer',
  '@pprogrammer'
);

insert into interests("id", "interest") values (2, 'Python');
insert into interests("id", "interest") values (2, 'Django');
insert into interests("id", "interest") values (2, 'Tensorflow');
insert into interests("id", "interest") values (2, 'Pyramid');
insert into interests("id", "interest") values (2, 'MongoDB');
insert into interests("id", "interest") values (2, 'Git');

insert into post_ids("id", "post_id") values (2, 'django_orm');
insert into post_ids("id", "post_id") values (2, 'python_gui');

insert into accounts (
  "id",
  "handle",
  "username",
  "image",
  "company",
  "rating",
  "facebook",
  "git_hub",
  "vk",
  "linked_in",
  "skype",
  "telegram"
) values (
  3,
  'PostMaker',
  'Posts publisher',
  'https://sun1-8.userapi.com/c840025/v840025737/77368/qseV7nJitGY.jpg',
  'Dev-logger',
  5.00,
  'https://www.facebook.com/postsmaker',
  'https://github.com/postsmaker',
  'https://vk.com/postsmaker',
  'http://www.linkedin.com/postsmaker',
  'PostsMaker',
  '@postmaker'
);

insert into interests("id", "interest") values (3, 'IT');

insert into post_ids("id", "post_id") values (3, 'multithreading');
insert into post_ids("id", "post_id") values (3, 'spring_in_action');
insert into post_ids("id", "post_id") values (3, 'jvm');
insert into post_ids("id", "post_id") values (3, 'python3');
insert into post_ids("id", "post_id") values (3, 'best_python_ide');
insert into post_ids("id", "post_id") values (3, 'mongodb_for_beginners');
insert into post_ids("id", "post_id") values (3, 'git_for_beginners');

insert into followers_following ("followers_id", "following_id") values (3, 1);
insert into followers_following ("followers_id", "following_id") values (2, 1);
insert into followers_following ("followers_id", "following_id") values (3, 2);
insert into followers_following ("followers_id", "following_id") values (1, 2);