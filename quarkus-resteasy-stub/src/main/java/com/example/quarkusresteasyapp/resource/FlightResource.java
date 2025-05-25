package com.example.quarkusresteasyapp.resource;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.sse.Sse;
import jakarta.ws.rs.sse.SseEventSink;
import jakarta.ws.rs.core.Context;
import org.bson.Document;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.annotations.SseElementType;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Path("/flights")
@ApplicationScoped
public class FlightResource {

    @Inject
    MongoClient mongoClient;

    @ConfigProperty(name = "third.party.url", defaultValue = "http://localhost:8900/vendor/supplier/stream/flights")
    String thirdPartyUrl;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getFlights() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(thirdPartyUrl))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String flights = response.body();
            logToMongo(flights);
            return flights;
        } catch (Exception e) {
            return "{\"error\":\"Third-party call failed: " + e.getMessage() + "\"}";
        }
    }

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.APPLICATION_JSON)
    public void streamFlights(@Context SseEventSink eventSink, @Context Sse sse) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(thirdPartyUrl))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String flights = response.body();
            logToMongo(flights);
            eventSink.send(sse.newEvent(flights));
            eventSink.close();
        } catch (Exception e) {
            eventSink.send(sse.newEvent("{\"error\":\"Third-party call failed: " + e.getMessage() + "\"}"));
            eventSink.close();
        }
    }

    private void logToMongo(String flightsJson) {
        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("calls_log");
        Document log = new Document()
                .append("endpoint", thirdPartyUrl)
                .append("timestamp", System.currentTimeMillis())
                .append("flights", Document.parse("{\"flights\":" + flightsJson + "}").get("flights"));
        collection.insertOne(log);
    }
}