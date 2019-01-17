FROM openjdk:8-jre-alpine

LABEL maintainer="rext.mail@gmail.com"


ENV SPRING_APPLICATION_JSON='{"server.port": 8080}'

VOLUME /tmp

RUN mkdir -p /opt/spring-oauth2
COPY target/spring-oauth2.jar /opt/spring-oauth2
COPY src/main/resources/application.yml /opt/spring-oauth2/
WORKDIR /opt/spring-oauth2

EXPOSE 8080

CMD ["/usr/bin/java", "-jar", "spring-oauth2.jar", "--spring.config.location=file:/opt/spring-oauth2/application.yml"]
