package com.example.graphql.graphql;

import com.example.graphql.model.Flight;
import com.example.graphql.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FlightQueryResolver {

    private final FlightService flightService;

    @QueryMapping
    public List<Flight> flights() {
        return flightService.getFlights();
    }
}