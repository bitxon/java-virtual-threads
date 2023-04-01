package gatling.simulation;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class CommonSimulation extends Simulation {

    static final String BASE_URL = System.getProperty("baseUrl", "http://localhost:8080");
    static final int PARALLEL_USERS = Integer.getInteger("parallelUsers", 1000);
    static final int NUMBER_OF_REQUESTS = Integer.getInteger("numberOfRequests", 100);

    //-----------------------------------------------------------------------------------------------------------------

    private static ChainBuilder getInfo() {
        return exec(http("Info")
            .get("/info")
            .check(status().is(200))
        );
    }

    //-----------------------------------------------------------------------------------------------------------------

    HttpProtocolBuilder httpProtocol = http.baseUrl(BASE_URL)
        .acceptHeader("application/json")
        .acceptLanguageHeader("en-US,en;q=0.5");

    ScenarioBuilder scenarioRepeatGetInfo = scenario("Get Info").exec(
        repeat(NUMBER_OF_REQUESTS).on(getInfo())
    );

    //-----------------------------------------------------------------------------------------------------------------

    {
        setUp(
            scenarioRepeatGetInfo.injectClosed(
                constantConcurrentUsers(PARALLEL_USERS).during(10)
            )
        ).protocols(httpProtocol);
    }
}
