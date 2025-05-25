package com.example.springwebflux.controller;

import com.example.springwebflux.model.Flight;
import com.example.springwebflux.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Flight> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Flight> streamFlights() {
        return flightService.getFlights();
    }
}