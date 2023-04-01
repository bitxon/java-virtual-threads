package bitxon.dropwizard.test;

import bitxon.dropwizard.DropwizardApplication;

import io.dropwizard.core.Configuration;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(DropwizardExtensionsSupport.class)
class DropwizardTest {

    private static final DropwizardAppExtension<Configuration> EXT = new DropwizardAppExtension<>(
        DropwizardApplication.class,
        "config.yml",
        ConfigOverride.randomPorts()
    );


    @Test
    void get() {
        // when
        var response = EXT.client()
            .target(String.format("http://localhost:%d/info", EXT.getLocalPort()))
            .request()
            .get();

        // then
        Assertions.assertEquals(200, response.getStatus());
        Assertions.assertEquals("Hello from app", response.readEntity(String.class));
    }

}
