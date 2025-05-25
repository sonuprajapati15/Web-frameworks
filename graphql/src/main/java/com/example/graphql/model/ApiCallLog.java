package com.example.graphql.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Data
@Document("calls_log")
public class ApiCallLog {
    private Instant timestamp = Instant.now();
    private String endpoint;
    private List<Flight> flights;
}