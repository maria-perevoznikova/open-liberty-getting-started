package org.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

@RequestScoped
public class CurrentTimeClient {

    private static final String URL = "http://localhost:9080/system/current-time";

    private final Client rsClient = ClientBuilder.newClient();

    public List<String> getCurrentTimes() {
        List<String> result = Collections.synchronizedList(new ArrayList<>());
        try {
            Stream.of(getCurrentTimeAsync(), getCurrentTimeAsync(), getCurrentTimeAsync(), getCurrentTimeAsync(), getCurrentTimeAsync())
                    .map(t -> t.thenAccept(result::add))
                    .forEach(t -> t.toCompletableFuture().join());
        } catch (Exception e) {
            result.add("ERROR: " + e.getMessage());
        }
        return result;
    }

    public CompletionStage<String> getCurrentTimeAsync() {
       return rsClient.target(URL)
                .request(MediaType.APPLICATION_JSON)
                .rx()
                .get(String.class);
    }
}
