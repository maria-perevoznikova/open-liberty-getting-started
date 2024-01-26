package org.example;

import static org.junit.Assert.*;
import org.junit.Test;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class MultipleCurrentTimesResourceIT {
    private static final String URL = "http://localhost:9090/system-app-client/client/multiple-current-times";

    @Test
    public void returnsValidResponse() throws Exception {
        GetMethod method = new GetMethod(URL);

        int statusCode = new HttpClient().executeMethod(method);
        String response = method.getResponseBodyAsString();

        assertEquals(HttpStatus.SC_OK, statusCode);
        assertEquals("[\"A\",\"B\"]", response);
    }
}
