FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/account-service.jar account-service.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "account-service.jar"]