package com.example.springwebflux.service;

import com.example.springwebflux.model.ApiCallLog;
import com.example.springwebflux.model.Flight;
import com.example.springwebflux.repository.ApiCallLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class FlightService {
    private static final String THIRD_PARTY_URL = "http://localhost:8900/vendor/supplier/stream/flights";

    @Autowired
    private ApiCallLogRepository logRepository;
    private final WebClient webClient = WebClient.create();

    public Flux<Flight> getFlights() {
        return webClient.get()
                .uri(THIRD_PARTY_URL)
                .retrieve()
                .bodyToFlux(Flight.class)
                .collectList()
                .flatMapMany(flights -> logRepository.save(new ApiCallLog(THIRD_PARTY_URL, flights))
                        .thenMany(Flux.fromIterable(flights)));
    }
}