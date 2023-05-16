FROM amazoncorretto:11-alpine-jdk
MAINTAINER FNC
COPY target/fnc-0.0.1-SNAPSHOT.jar fnc-app.jar
ENTRYPOINT ["java","-jar","/fnc-app.jar"]
EXPOSE 8080
