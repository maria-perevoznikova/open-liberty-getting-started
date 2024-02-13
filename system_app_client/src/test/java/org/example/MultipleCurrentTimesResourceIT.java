package org.example;

import org.junit.Test;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.logging.Logger;

import static java.net.http.HttpClient.newHttpClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MultipleCurrentTimesResourceIT {

    private static final Logger logger = Logger.getLogger("MultipleCurrentTimesResourceIT");

    private static final String URL = "http://localhost:9090/system-app-client/client/multiple-current-times";

    @Test
    public void returnsValidResponse() throws Exception {
        HttpRequest request = HttpRequest.newBuilder(URI.create(URL)).GET().timeout(Duration.ofSeconds(10)).build();
        long startMillis = System.currentTimeMillis();

        HttpResponse<String> response = newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        long endMillis = System.currentTimeMillis();
        double execTime = (endMillis - startMillis) / 1000.;
        logger.warning("Request exec time " + execTime);

        assertEquals(200, response.statusCode());
        assertTrue(execTime < 2);
    }
}
