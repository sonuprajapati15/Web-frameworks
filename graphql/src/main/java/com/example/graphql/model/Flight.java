package com.example.graphql.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document("flights")
public class Flight {
    private String aircraftType;
    private Airline airline;
    private String arrivalTime;
    private String baggage;
    private String boardingTime;
    private String cabinClass;
    private String cancellationPolicy;
    private String changePolicy;
    private String checkInCounter;
    private String covidSafety;
    private String date;
    private String departureTime;
    private String duration;
    private String ecoFriendly;
    private String entertainment;
    private String extraLegroom;
    private String fareClass;
    private String flightId;
    private String flightNumber;
    private String flightType;
    private String from;
    private String gate;
    private String infantPolicy;
    private String lastUpdated;
    private List<String> layovers;
    private String loungeAccess;
    private String meal;
    private String onTimePerformance;
    private String petPolicy;
    private String powerOutlet;
    private int price;
    private String priorityBoarding;
    private double rating;
    private String recliningAngle;
    private int reviewsCount;
    private String seatPitch;
    private String seatType;
    private String seatWidth;
    private String terminal;
    private String to;
    private int totalStops;
    private String usbPort;
    private String vendor_logo;
    private String vendor_name;
    private String wifi;
}