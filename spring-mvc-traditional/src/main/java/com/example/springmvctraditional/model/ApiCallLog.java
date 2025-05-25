package com.example.springmvctraditional.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Data
@Document("calls_log")
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallLog {
    private Instant timestamp = Instant.now();
    private String endpoint;
    private List<Flight> flights;
}