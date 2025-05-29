# Metrics Demo Spring Boot Project

A simple Spring Boot project to demonstrate JVM, CPU, and thread metrics exposure and collection, with endpoints to simulate CPU-bound and IO-bound workloads.

## Endpoints

- `GET /cpu` - Starts a CPU-bound workload utilizing all available CPU cores.
- `GET /io` - Starts an IO-bound workload using 20 threads that sleep for 5s.
- `/actuator/metrics` - View all available actuator metrics.
- `/actuator/prometheus` - Prometheus-formatted metrics endpoint.

## How to Run

1. Build the project:
    ```
    mvn clean package
    ```
2. Run the application:
    ```
    java -jar target/metrics-demo-0.0.1-SNAPSHOT.jar
    ```
3. Access endpoints as described above.

## Observing Metrics

- Use `/actuator/metrics` or `/actuator/prometheus` to see JVM, CPU, and thread metrics.
- Watch JVM metrics in the console for live reporting.

---