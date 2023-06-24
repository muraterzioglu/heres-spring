package codes.murat.heresspring.Controllers;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import codes.murat.heresspring.Services.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService service;
    private final AtomicLong counter = new AtomicLong();

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("")
    public Map<Long, String> greeting(@RequestParam(value = "id", defaultValue = "0") long id) {
        if (id > 0) {
            return service.getGreeting(id);
        }
        return service.getGreeting();
    }

    @PostMapping("")
    public Map<Long, String> postGreeting(@RequestParam(value = "content", defaultValue = "Hello World!") String content) {
        return service.postGreeting(counter.incrementAndGet(), content);
    }
}