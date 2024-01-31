package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

public class CurrentTimeClient {

    private static final String URL = "http://localhost:9080/system/current-time";

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public List<String> getCurrentTimes() {
        try {
            return List.of(
                    getCurrentTime(),
                    getCurrentTime(),
                    getCurrentTime(),
                    getCurrentTime(),
                    getCurrentTime()
            );
        } catch (Exception e) {
            return List.of("ERROR", e.getMessage());
        }
    }

    public String getCurrentTime() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(URL)).GET().timeout(Duration.ofSeconds(5)).build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
}
