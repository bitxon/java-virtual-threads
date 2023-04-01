package bitxon.dropwizard;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.Executor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;

@Path("")
public class Resource {
    private final Executor executor;

    public Resource(Executor executor) {
        this.executor = executor;
    }

    @Path("/info")
    @GET
    public void get(@Suspended final AsyncResponse asyncResponse) {
        executor.execute(() -> {
            sleep(100);
            asyncResponse.resume("Hello from app");
        });
    }

    private void sleep(long timeout) {
        try {
            MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
