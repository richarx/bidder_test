package com.databerries.bidder;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.dropwizard.DropwizardMetricsOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.redis.RedisClient;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;


public class WebServer extends AbstractVerticle {

    private RedisClient redis;
    int nbr = 0;


    public static void main(String[] args) {
        WebServer ws = new WebServer();

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(ws);
    }

    @Override
    public void start() throws Exception {

        JsonObject config = new JsonObject()
                .put("host", "127.0.0.1")
                .put("port", 6379);

        redis = RedisClient.create(Vertx.vertx(), config);

        HttpServer server = vertx.createHttpServer();

        server.requestHandler(res -> {

            System.out.println(nbr++);

            getInBase("nonexistantkey", res);

        }).listen(8000);
      }

    public void getInBase(String key, HttpServerRequest request) {

        redis.get(key, res -> {

            if (res.succeeded()) {

                if (res.result() == null || res.result().isEmpty()) {
                    request.response().setStatusCode(200).end();
                } else {
                    request.response().setStatusCode(200).end();
                }

            } else {
                request.response().setStatusCode(200).end();
            }

        });
    }
}
