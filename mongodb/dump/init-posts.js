print('START INIT POSTS');

use admin;
db.createUser(
    {
      user: "admin",
      pwd: "admin",
      roles: [
        {
          role: "userAdminAnyDatabase",
          db: "admin"
        }
      ]
    }
);

db.posts.update(
    {"_id": "welcome-post"},
    {
      "_id": "welcome-post",
      "title": "Welcome to Dev-logger post!",
      "tags": [
        "java",
        "microservices",
        "blog"
      ],
      "type": "NEWS",
      "content": "\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.\"",
      "statistic": {
        "rating": 5,
        "views": 234,
        "downloads": 32
      },
      "publicationDate": {
        "year": 2018,
        "month": "MAY",
        "dayOfMonth": 20,
        "dayOfWeek": "SUNDAY",
        "dayOfYear": 140,
        "hour": 2,
        "minute": 0,
        "second": 53,
        "nano": 848000000,
        "monthValue": 5,
        "chronology": {
          "id": "ISO",
          "calendarType": "iso8601"
        }
      },
      "lastUpdate": {
        "year": 2018,
        "month": "MAY",
        "dayOfMonth": 20,
        "dayOfWeek": "SUNDAY",
        "dayOfYear": 140,
        "hour": 2,
        "minute": 0,
        "second": 53,
        "nano": 848000000,
        "monthValue": 5,
        "chronology": {
          "id": "ISO",
          "calendarType": "iso8601"
        }
      },
      "image": "img"
    }
);

print('COMPLETE INIT POSTS');