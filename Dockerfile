FROM openjdk:21-slim as builder

WORKDIR /app

COPY gradlew gradlew
COPY gradle gradle

COPY build.gradle.kts settings.gradle.kts /app/

COPY src /app/src
RUN chmod +x gradlew

RUN ./gradlew build --no-daemon

FROM openjdk:21-slim

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]