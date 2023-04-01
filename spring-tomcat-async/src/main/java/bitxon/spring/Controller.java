package bitxon.spring;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Async
    @GetMapping("/info")
    public CompletableFuture<String> get() throws InterruptedException {
        MILLISECONDS.sleep(100);
        return CompletableFuture.completedFuture("Hello from app");
    }
}
