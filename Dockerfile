FROM adoptopenjdk/openjdk11:jdk-11.0.7_10-alpine-slim as build
RUN mkdir -p /usr/share/build
WORKDIR /usr/share/build
ADD target/cloudevents-0.0.1-SNAPSHOT.jar .

FROM adoptopenjdk/openjdk11:jre-11.0.7_10-alpine
COPY --from=build /usr/share/build/cloudevents-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
