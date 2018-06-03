FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/search-service.jar search-service.jar

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "search-service.jar"]