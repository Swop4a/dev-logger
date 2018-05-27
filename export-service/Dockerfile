FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/export-service.jar export-service.jar

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "export-service.jar"]