package bitxon.spring;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Controller {
    @GetMapping("/info")
    public Mono<String> get() {
        return Mono
            .defer(() -> Mono.just("Hello from Spring app"))
            .delaySubscription(Duration.ofMillis(100));
    }
}
