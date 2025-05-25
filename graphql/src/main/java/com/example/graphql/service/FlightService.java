package com.example.graphql.service;

import com.example.graphql.model.ApiCallLog;
import com.example.graphql.model.Flight;
import com.example.graphql.repository.ApiCallLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private static final String THIRD_PARTY_URL = "http://localhost:8900/vendor/supplier/stream/flights";

    private final ApiCallLogRepository logRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Flight> getFlights() {
        Flight[] flights = restTemplate.getForObject(THIRD_PARTY_URL, Flight[].class);
        List<Flight> flightList = Arrays.asList(flights != null ? flights : new Flight[0]);
        ApiCallLog log = new ApiCallLog();
        log.setEndpoint(THIRD_PARTY_URL);
        log.setFlights(flightList);
        logRepository.save(log);
        return flightList;
    }
}