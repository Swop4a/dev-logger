FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/registry.jar registry.jar

EXPOSE 8761
ENTRYPOINT ["java", "-jar", "registry.jar"]