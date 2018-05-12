FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/post-service.jar post-service.jar

EXPOSE 8085
ENTRYPOINT ["java", "-jar", "post-service.jar"]
