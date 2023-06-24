package codes.murat.heresspring.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import codes.murat.heresspring.Services.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public GreetingService greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingService(counter.incrementAndGet(), String.format(template, name));
    }
}