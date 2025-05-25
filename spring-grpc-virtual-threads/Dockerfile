FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/spring-grpc-virtual-threads.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]