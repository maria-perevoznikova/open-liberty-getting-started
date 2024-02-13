package org.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@RequestScoped
@Path("/multiple-current-times")
public class MultipleCurrentTimesResource {

    @Inject
    private CurrentTimeClient client;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCurrentTimes() {
        return client.getCurrentTimes();
    }
}

