package com.example.springmvcvirtualthreads.controller;

import com.example.springmvcvirtualthreads.model.Flight;
import com.example.springmvcvirtualthreads.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

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