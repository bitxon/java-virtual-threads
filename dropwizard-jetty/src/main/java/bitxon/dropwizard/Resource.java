package bitxon.dropwizard;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("")
public class Resource {

    @Path("/info")
    @GET
    public String get() throws InterruptedException {
        MILLISECONDS.sleep(100);
        return "Hello from app";
    }


}
