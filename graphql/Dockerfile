FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/graphql.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]