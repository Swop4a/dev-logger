FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/post-service.jar /app/
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/post-service.jar"]
