package org.example;

import static java.net.http.HttpClient.newHttpClient;
import static org.junit.Assert.*;
import org.junit.Test;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class MultipleCurrentTimesResourceIT {
    private static final String URL = "http://localhost:9090/system-app-client/client/multiple-current-times";

    @Test
    public void returnsValidResponse() throws Exception {
        HttpRequest request = HttpRequest.newBuilder(URI.create(URL)).GET().timeout(Duration.ofSeconds(10)).build();
        HttpResponse<String> response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
    }
}
