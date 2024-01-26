package org.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@RequestScoped
@Path("/multiple-current-times")
public class MultipleCurrentTimesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCurrentTime() {
        return List.of("A", "B");
    }
}

