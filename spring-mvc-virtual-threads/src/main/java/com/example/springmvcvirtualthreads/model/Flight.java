package com.example.springmvcvirtualthreads.model;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

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

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public void setCancellationPolicy(String cancellationPolicy) {
        this.cancellationPolicy = cancellationPolicy;
    }

    public void setChangePolicy(String changePolicy) {
        this.changePolicy = changePolicy;
    }

    public void setCheckInCounter(String checkInCounter) {
        this.checkInCounter = checkInCounter;
    }

    public void setCovidSafety(String covidSafety) {
        this.covidSafety = covidSafety;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setEcoFriendly(String ecoFriendly) {
        this.ecoFriendly = ecoFriendly;
    }

    public void setEntertainment(String entertainment) {
        this.entertainment = entertainment;
    }

    public void setExtraLegroom(String extraLegroom) {
        this.extraLegroom = extraLegroom;
    }

    public void setFareClass(String fareClass) {
        this.fareClass = fareClass;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public void setInfantPolicy(String infantPolicy) {
        this.infantPolicy = infantPolicy;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setLayovers(List<String> layovers) {
        this.layovers = layovers;
    }

    public void setLoungeAccess(String loungeAccess) {
        this.loungeAccess = loungeAccess;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public void setOnTimePerformance(String onTimePerformance) {
        this.onTimePerformance = onTimePerformance;
    }

    public void setPetPolicy(String petPolicy) {
        this.petPolicy = petPolicy;
    }

    public void setPowerOutlet(String powerOutlet) {
        this.powerOutlet = powerOutlet;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPriorityBoarding(String priorityBoarding) {
        this.priorityBoarding = priorityBoarding;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setRecliningAngle(String recliningAngle) {
        this.recliningAngle = recliningAngle;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public void setSeatPitch(String seatPitch) {
        this.seatPitch = seatPitch;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setSeatWidth(String seatWidth) {
        this.seatWidth = seatWidth;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setTotalStops(int totalStops) {
        this.totalStops = totalStops;
    }

    public void setUsbPort(String usbPort) {
        this.usbPort = usbPort;
    }

    public void setVendor_logo(String vendor_logo) {
        this.vendor_logo = vendor_logo;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }
}