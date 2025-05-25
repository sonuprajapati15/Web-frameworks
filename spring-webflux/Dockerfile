FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/spring-webflux.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]