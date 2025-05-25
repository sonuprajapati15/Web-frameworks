package com.example.springmvctraditional.controller;

import com.example.springmvctraditional.model.Flight;
import com.example.springmvctraditional.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamFlights() throws IOException {
        SseEmitter emitter = new SseEmitter();
        List<Flight> flights = flightService.getFlights();
        for (Flight flight : flights) {
            try {
                emitter.send(flight);
            } catch (IOException e) {
                emitter.completeWithError(e);
                return emitter;
            }
        }
        emitter.complete();
        return emitter;
    }
}