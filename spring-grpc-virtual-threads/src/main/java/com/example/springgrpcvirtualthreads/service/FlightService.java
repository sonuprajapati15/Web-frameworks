package com.example.springgrpcvirtualthreads.service;

import com.example.springgrpcvirtualthreads.model.ApiCallLog;
import com.example.springgrpcvirtualthreads.model.Flight;
import com.example.springgrpcvirtualthreads.repository.ApiCallLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightService {
    private static final String THIRD_PARTY_URL = "http://localhost:8900/vendor/supplier/stream/flights";

    @Autowired
    private ApiCallLogRepository logRepository;
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