package bitxon.spring;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/info")
    public String get() throws InterruptedException {
        MILLISECONDS.sleep(100);
        return "Hello from Spring app";
    }
}
