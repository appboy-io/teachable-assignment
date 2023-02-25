FROM gradle:jdk17-alpine as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar --no-daemon

FROM openjdk:17-alpine
RUN mkdir /app
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/api-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-jar", "/app/api-0.0.1-SNAPSHOT.jar"]