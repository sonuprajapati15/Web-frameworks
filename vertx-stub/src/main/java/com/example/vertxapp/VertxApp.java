package com.example.vertxapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerHandler;
import io.vertx.core.http.HttpServerResponse;

public class VertxApp extends AbstractVerticle {

    private static final String THIRD_PARTY_URL = "http://localhost:8900/vendor/supplier/stream/flights";
    private MongoClient mongo;

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new VertxApp());
    }

    @Override
    public void start() {
        JsonObject config = new JsonObject()
                .put("connection_string", "mongodb://localhost:27017")
                .put("db_name", "test");
        mongo = MongoClient.createShared(vertx, config);

        Router router = Router.router(vertx);
        router.route().handler(LoggerHandler.create());
        router.route().handler(BodyHandler.create());

        // GET /flights - returns JSON array
        router.get("/flights").handler(ctx -> {
            vertx.createHttpClient().getAbs(THIRD_PARTY_URL)
                .send()
                .onSuccess(res -> {
                    JsonArray flights = res.bodyAsJsonArray();
                    logToMongo(flights);
                    ctx.response()
                        .putHeader("Content-Type", "application/json")
                        .end(flights.encode());
                })
                .onFailure(err -> ctx.response().setStatusCode(502).end("Third-party call failed: " + err.getMessage()));
        });

        // GET /flights/stream - returns event stream
        router.get("/flights/stream").handler(ctx -> {
            vertx.createHttpClient().getAbs(THIRD_PARTY_URL)
                .send()
                .onSuccess(res -> {
                    JsonArray flights = res.bodyAsJsonArray();
                    logToMongo(flights);
                    HttpServerResponse response = ctx.response();
                    response.setChunked(true);
                    response.putHeader("Content-Type", "text/event-stream");
                    for (Object f : flights) {
                        response.write("data: " + ((JsonObject)f).encode() + "\n\n");
                    }
                    response.end();
                })
                .onFailure(err -> ctx.response().setStatusCode(502).end("Third-party call failed: " + err.getMessage()));
        });

        vertx.createHttpServer().requestHandler(router).listen(8080, http -> {
            if (http.succeeded()) {
                System.out.println("Vert.x HTTP server started on port 8080");
            } else {
                http.cause().printStackTrace();
            }
        });
    }

    private void logToMongo(JsonArray flights) {
        JsonObject log = new JsonObject()
                .put("endpoint", THIRD_PARTY_URL)
                .put("timestamp", System.currentTimeMillis())
                .put("flights", flights);
        mongo.save("calls_log", log)
            .onFailure(Throwable::printStackTrace);
    }
}