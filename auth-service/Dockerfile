FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/auth-service.jar auth-service.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "auth-service.jar"]