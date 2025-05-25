# Modern Java Server Models – Multi-module Spring Boot Project

This Maven multi-module project demonstrates various modern Java server models, each in its own Spring Boot application, with best-practice starter dependencies, Docker support, Prometheus metrics, and a JMeter load test setup. Each module provides two endpoints:
- `/flights`: Returns data as a JSON list.
- `/flights/stream`: Streams data as Server-Sent Events (SSE).

All modules communicate with a third-party API, log responses to MongoDB, and expose metrics for Prometheus/Grafana.

---

## Project Structure

```
modern-java-server-models/
│
├── pom.xml                    # Parent POM
│
├── spring-mvc-traditional/    # Spring MVC (platform threads)
├── spring-mvc-virtual-threads/# Spring MVC (virtual threads, Java 21+)
├── spring-webflux/            # Spring WebFlux (reactive)
├── spring-grpc-virtual-threads/# gRPC + virtual threads
├── graphql/                   # Spring GraphQL
├── vertx-stub/                # Vert.x (stub, Spring Boot integration not direct)
├── quarkus-resteasy-stub/     # Quarkus RESTEasy (stub, note only)
├── quarkus-resteasy-reactive-stub/# Quarkus RESTEasy Reactive (stub, note only)
│
├── jmeter-loadtest/           # JMeter test plan to simulate high load
│
├── docker-compose.yml         # Runs all modules, MongoDB, Prometheus, Grafana
└── grafana-provisioning/      # Grafana dashboards/datasources
```

---

## Features

- **Two endpoints in each module:** `/flights` (JSON), `/flights/stream` (SSE)
- **Service layer:** Calls a simulated third party (can be stubbed or mocked for demo)
- **MongoDB integration:** Logs API responses in `calls_log`
- **Docker for each module**: Build and run easily.
- **Docker Compose:** Stand up the entire stack—apps, MongoDB, Prometheus, Grafana.
- **Prometheus Metrics:** `/actuator/prometheus` endpoint in each app.
- **Grafana dashboards**: Pre-configured to show per-container metrics and MongoDB stats.
- **JMeter:** Load test plan to hit all modules.

---

## How to Build and Run

### 1. Build all modules

```sh
mvn clean package
```

### 2. Build Docker images

```sh
docker-compose build
```

### 3. Start all services (including MongoDB, Prometheus, Grafana)

```sh
docker-compose up
```

### 4. Access Services

- Spring Boot Apps: `http://localhost:<port>/flights`, `/flights/stream`
- Prometheus: `http://localhost:9090`
- Grafana: `http://localhost:3000` (Login: admin/admin)
- MongoDB: `mongodb://localhost:27017`

### 5. Run JMeter Load Test

```sh
# From the jmeter-loadtest directory
jmeter -n -t loadtest.jmx
```

---

## Notes

- The Quarkus and Vert.x modules are stubs with code comments, as there is no direct Spring Boot starter for them.
- All modules publish Prometheus metrics via Spring Boot Actuator.
- MongoDB and Grafana are included in docker-compose for full-stack observability.

---