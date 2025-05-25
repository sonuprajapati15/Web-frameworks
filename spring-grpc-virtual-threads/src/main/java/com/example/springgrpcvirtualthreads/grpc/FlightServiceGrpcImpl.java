package com.example.springgrpcvirtualthreads.grpc;

import com.example.springgrpcvirtualthreads.model.Flight;
import com.example.springgrpcvirtualthreads.service.FlightService;
import flight.FlightOuterClass;
import flight.FlightServiceGrpc;
import flight.FlightOuterClass.FlightsResponse;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class FlightServiceGrpcImpl extends FlightServiceGrpc.FlightServiceImplBase {

    private final FlightService flightService;

    @Override
    public void getFlights(com.google.protobuf.Empty request, StreamObserver<FlightsResponse> responseObserver) {
        List<Flight> flights = flightService.getFlights();
        FlightsResponse.Builder builder = FlightsResponse.newBuilder();
        flights.forEach(f -> builder.addFlights(convert(f)));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void streamFlights(com.google.protobuf.Empty request, StreamObserver<FlightOuterClass.Flight> responseObserver) {
        List<Flight> flights = flightService.getFlights();
        for (Flight f : flights) {
            responseObserver.onNext(convert(f));
        }
        responseObserver.onCompleted();
    }

    // Conversion from model.Flight to protobuf Flight
    private FlightOuterClass.Flight convert(Flight f) {
        FlightOuterClass.Flight.Builder builder = FlightOuterClass.Flight.newBuilder()
            .setAircraftType(defaultStr(f.getAircraftType()))
            .setArrivalTime(defaultStr(f.getArrivalTime()))
            .setBaggage(defaultStr(f.getBaggage()))
            .setBoardingTime(defaultStr(f.getBoardingTime()))
            .setCabinClass(defaultStr(f.getCabinClass()))
            .setCancellationPolicy(defaultStr(f.getCancellationPolicy()))
            .setChangePolicy(defaultStr(f.getChangePolicy()))
            .setCheckInCounter(defaultStr(f.getCheckInCounter()))
            .setCovidSafety(defaultStr(f.getCovidSafety()))
            .setDate(defaultStr(f.getDate()))
            .setDepartureTime(defaultStr(f.getDepartureTime()))
            .setDuration(defaultStr(f.getDuration()))
            .setEcoFriendly(defaultStr(f.getEcoFriendly()))
            .setEntertainment(defaultStr(f.getEntertainment()))
            .setExtraLegroom(defaultStr(f.getExtraLegroom()))
            .setFareClass(defaultStr(f.getFareClass()))
            .setFlightId(defaultStr(f.getFlightId()))
            .setFlightNumber(defaultStr(f.getFlightNumber()))
            .setFlightType(defaultStr(f.getFlightType()))
            .setFrom(defaultStr(f.getFrom()))
            .setGate(defaultStr(f.getGate()))
            .setInfantPolicy(defaultStr(f.getInfantPolicy()))
            .setLastUpdated(defaultStr(f.getLastUpdated()))
            .setLoungeAccess(defaultStr(f.getLoungeAccess()))
            .setMeal(defaultStr(f.getMeal()))
            .setOnTimePerformance(defaultStr(f.getOnTimePerformance()))
            .setPetPolicy(defaultStr(f.getPetPolicy()))
            .setPowerOutlet(defaultStr(f.getPowerOutlet()))
            .setPrice(f.getPrice())
            .setPriorityBoarding(defaultStr(f.getPriorityBoarding()))
            .setRating(f.getRating())
            .setRecliningAngle(defaultStr(f.getRecliningAngle()))
            .setReviewsCount(f.getReviewsCount())
            .setSeatPitch(defaultStr(f.getSeatPitch()))
            .setSeatType(defaultStr(f.getSeatType()))
            .setSeatWidth(defaultStr(f.getSeatWidth()))
            .setTerminal(defaultStr(f.getTerminal()))
            .setTo(defaultStr(f.getTo()))
            .setTotalStops(f.getTotalStops())
            .setUsbPort(defaultStr(f.getUsbPort()))
            .setVendorLogo(defaultStr(f.getVendor_logo()))
            .setVendorName(defaultStr(f.getVendor_name()))
            .setWifi(defaultStr(f.getWifi()));

        if (f.getAirline() != null) {
            builder.setAirline(
                FlightOuterClass.Airline.newBuilder()
                    .setLogo(defaultStr(f.getAirline().getLogo()))
                    .setName(defaultStr(f.getAirline().getName()))
                    .build()
            );
        }
        if (f.getLayovers() != null) {
            builder.addAllLayovers(f.getLayovers());
        }
        return builder.build();
    }

    private String defaultStr(String s) {
        return s == null ? "" : s;
    }
}