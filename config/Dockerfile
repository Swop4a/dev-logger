FROM openjdk:8
MAINTAINER Alexandr Pavkin <alexandr300896@gmail.com>

ADD ./target/config.jar config.jar

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/health || exit 1

EXPOSE 8888
ENTRYPOINT ["java", "-jar", "config.jar"]