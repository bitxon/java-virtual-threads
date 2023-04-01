package bitxon.dropwizard;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.core.Application;
import io.dropwizard.core.Configuration;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class DropwizardApplication extends Application<Configuration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-jetty";
    }

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
        // Allow to read config.yml from classpath instead of filesystem
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
    }

    @Override
    public void run(final Configuration configuration, final Environment environment) {
        final var executor = getAsyncExecutor();
        final var resource = new Resource(executor);

        environment.jersey().register(resource);
    }


    private static Executor getAsyncExecutor() {
        return new ThreadPoolExecutor(
            100,
            300 + 2,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(700)
        );
    }
}
