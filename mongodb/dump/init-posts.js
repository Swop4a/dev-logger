print('START INIT POSTS');

db.posts.update(
    {"_id": "welcome-post"},
    {
      "_id" : "welcome-post",
      "_class" : "com.devlogger.post.model.Post",
      "title" : "Welcome to Dev-logger post!",
      "tags" : [
        "java",
        "microservices",
        "blog"
      ],
      "type" : "NEWS",
      "content" : "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac ipsum eget nibh pellentesque porta at a neque. Nulla mollis tellus enim, eu vulputate felis pellentesque ut. Donec volutpat fermentum molestie. In quis ultricies augue. Suspendisse in lacus est. Ut imperdiet auctor libero a facilisis. Cras ultricies mauris a laoreet tempus. Aliquam non dolor sed justo eleifend euismod. Morbi ultricies, quam vitae commodo pulvinar, ipsum elit tincidunt erat, luctus ultrices elit quam a augue. Fusce vitae mauris urna. Aliquam erat volutpat.\n\nEtiam ut suscipit sapien. In ac justo eget ante pharetra ornare lobortis in mi. Aliquam malesuada purus turpis, vel hendrerit tellus congue in. Donec ut ligula et ligula placerat dignissim ac vel enim. In eros lacus, tincidunt non facilisis quis, commodo non ipsum. Aliquam id finibus nisl. Donec eget risus porttitor, vestibulum ex et, varius nulla. Sed fringilla et mauris at tincidunt. Duis sed consequat arcu, sed scelerisque orci. Nam consectetur id sapien non mollis. Fusce id tincidunt quam. Nunc arcu lacus, mattis at leo a, fermentum iaculis sem. Integer erat arcu, egestas ac consectetur vitae, aliquet eu massa. Donec posuere ultrices commodo.\n\nVivamus mollis convallis dolor, at mollis sem cursus et. Aenean gravida lacus rutrum facilisis dictum. Ut ultrices convallis consectetur. Maecenas sit amet dapibus urna. Sed tellus lacus, lacinia a pulvinar ut, sollicitudin sit amet orci. Sed ultrices nisi nec nibh varius, at sollicitudin justo porttitor. Aliquam sagittis condimentum lobortis. Pellentesque tincidunt nibh laoreet ante dignissim, eget viverra turpis sollicitudin. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque vitae magna dolor. Integer bibendum sapien vel tortor lacinia, quis tincidunt metus fermentum. Morbi vestibulum scelerisque tincidunt.\n\nVestibulum laoreet quam eleifend tellus ullamcorper, sit amet pulvinar mi accumsan. Ut vestibulum sit amet orci sollicitudin feugiat. Morbi vitae lectus iaculis, fermentum ante sit amet, maximus libero. Quisque sed felis non lectus tempus ullamcorper sit amet sit amet mauris. Proin pharetra dapibus libero, sed condimentum diam. Nulla magna massa, malesuada eu tempor in, lacinia nec lorem. Fusce interdum fringilla turpis in pharetra. In cursus accumsan felis, eget vulputate enim suscipit in.\n\nSuspendisse sem odio, ullamcorper vel ex eget, dapibus venenatis arcu. Praesent at sodales nisl. Pellentesque at pretium lacus. Sed at enim feugiat, posuere odio in, iaculis ante. Aenean vel neque quis magna iaculis ornare. Donec rhoncus cursus massa non consectetur. Nullam in ornare felis, sodales bibendum dolor. Duis rutrum, neque ut ultrices porta, odio ex gravida risus, vel blandit ipsum purus non lectus. Duis vestibulum rhoncus molestie. Aliquam lectus libero, tincidunt eu lacus non, tincidunt vulputate ipsum. Aenean sodales fermentum rhoncus. Donec ullamcorper facilisis pretium. Morbi aliquam lacus sit amet nunc sollicitudin commodo. Donec lacinia nisi velit, in aliquam leo malesuada quis. Aliquam et sem eget odio mattis vehicula. Duis aliquam rutrum erat, eu lacinia mi tincidunt at.",
      "statistic" : {
        "rating" : NumberLong(5),
        "views" : NumberLong(234),
        "downloads" : NumberLong(32)
      },
      "publicationDate" : ISODate("2018-05-20T18:21:41.756Z"),
      "lastUpdate" : ISODate("2018-05-20T18:21:41.756Z"),
      "publisher" : {
        "name" : "Alexandr Pavkin",
        "lastSeen" : ISODate("2018-05-20T18:21:41.756Z")
      },
      "image" : "https://drive.google.com/file/d/1UmxUdPf-ClQk45pjGYJ7QKCV-8CpLfBE/view?usp=sharing"
    }
);

print('COMPLETE INIT POSTS');