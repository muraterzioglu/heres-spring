package codes.murat.heresspring.Controllers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import codes.murat.heresspring.Entities.Greeting;
import codes.murat.heresspring.Services.GreetingService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Greeting>> greeting() {
        return service.getGreetings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getTutorialById(@PathVariable("id") long id) {
        return service.getGreetingById(id);
    }

    @PostMapping("")
    public ResponseEntity<Greeting> postGreeting(@RequestBody Greeting greeting) {
        return service.addGreeting(greeting);
    }
}