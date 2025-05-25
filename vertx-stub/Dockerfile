FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/vertx-app-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]