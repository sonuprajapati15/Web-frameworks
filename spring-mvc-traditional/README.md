# Spring MVC Traditional Module

## Overview

This module demonstrates a classic Spring Boot MVC (Servlet-based, thread-per-request) application. It provides two endpoints:
- `GET /flights`: Returns a list of flight objects as JSON.
- `GET /flights/stream`: Streams the same data as Server-Sent Events (`text/event-stream`).

The controller delegates to a service that:
- Calls a third-party API (simulated) to fetch flight data.
- Logs each API response to MongoDB (`calls_log` collection).

## How and When to Use

### When to Use

- **Simplicity & Familiarity:**  
  Use when your team is familiar with the traditional Spring MVC model and you want quick, straightforward development.
- **Low-to-Moderate Concurrency:**  
  Suitable for applications where the number of concurrent requests is expected to be moderate (hundreds to a few thousands).
- **CPU/Memory Availability:**  
  When server hardware resources can support one thread per concurrent request, and requests are not long-blocking (e.g., network IO is fast).
- **Legacy Codebases:**  
  Ideal for integrating with or migrating from existing Java EE/Servlet codebases.

### How to Use

- Build and run the Docker image, ensuring MongoDB is available (see parent project `docker-compose.yml`).
- Access `/flights` for the full data set as JSON.
- Access `/flights/stream` for server-sent event streaming (SSE).

## Limitations

### Technical

- **Thread-per-Request Model:** Each incoming HTTP request is handled by a dedicated (platform/OS) thread. This limits scalability, especially for IO-heavy workloads or high-latency third-party calls.
- **Resource Consumption:** Each thread uses significant memory (typically 1MB stack per thread). On resource-constrained servers, this limits the number of simultaneous requests.
- **Blocking IO:** Any network/database operation blocks the whole thread. For slow third-party APIs or databases, this leads to thread starvation under load.
- **Limited Scalability:** Not suitable for scenarios requiring tens of thousands of concurrent, slow requests (e.g., chat servers, high-latency API aggregation).
- **Streaming Limitations:** Streaming with SSE is supported, but each connection holds a thread, limiting scalability for high fan-out streaming.

### Community & Ecosystem

- **Widespread Adoption:** Large, mature community, lots of documentation, and commercial support.
- **No Active Innovation:** Most innovation in Java web is happening in reactive (WebFlux, Vert.x), virtual threads, or native-cloud frameworks (Quarkus, Micronaut).
- **Long-Term Direction:** For future scalability and cloud-native features, consider Spring WebFlux (reactive) or virtual threads (Java 21+) as more scalable alternatives.

## Future Scope for Organizations

- **Transition Path:**  
  Traditional MVC code can be gradually migrated to virtual threads (Java 21+) with minimal code change, or to WebFlux for fully non-blocking architectures.
- **Cloud Native & Scalability:**  
  For high-traffic, high-latency, or serverless/cloud-native workloads, consider moving to reactive or event-loop based frameworks.
- **Skill Investment:**  
  Teams should invest in learning modern concurrency models (reactive, virtual threads) to future-proof their skills and applications.

## Summary

Spring MVC (traditional) is a proven, reliable choice for many business applications. However, for high scale, IO-bound, or modern cloud-native systems, evaluate more scalable models provided elsewhere in this project.

---