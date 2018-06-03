FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/gateway.jar gateway.jar

EXPOSE 4000
ENTRYPOINT ["java", "-jar", "gateway.jar"]