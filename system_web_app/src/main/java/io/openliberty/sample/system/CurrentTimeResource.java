package io.openliberty.sample.system;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.TimeUnit;

@RequestScoped
@Path("/current-time")
public class CurrentTimeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CurrentTime getCurrentTime() throws InterruptedException {
        long requestTime = System.currentTimeMillis();
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        long currentTime = System.currentTimeMillis();

        return new CurrentTime(requestTime, currentTime);
    }
}
