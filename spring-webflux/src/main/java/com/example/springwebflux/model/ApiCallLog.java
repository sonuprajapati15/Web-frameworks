package com.example.springwebflux.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@Document("calls_log")
public class ApiCallLog {
    private Instant timestamp = Instant.now();
    private String endpoint;
    private List<Flight> flights;

    public ApiCallLog(String endpoint, List<Flight> flights) {
        this.endpoint = endpoint;
        this.flights = flights;
    }
}