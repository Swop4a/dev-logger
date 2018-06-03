FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/notification-service.jar notification-service.jar

EXPOSE 8084
ENTRYPOINT ["java", "-jar", "notification-service.jar"]