package codes.murat.heresspring.Services;

import codes.murat.heresspring.Entities.Greeting;
import codes.murat.heresspring.Repositories.GreetingRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class GreetingService {

    GreetingRepository greetingRepository;

    public ResponseEntity<List<Greeting>> getGreetings() {
        List<Greeting> greetings = new ArrayList<>(greetingRepository.findAll());

        return new ResponseEntity<>(greetings, HttpStatus.OK);
    }

    public ResponseEntity<Greeting> getGreetingById(long id) {
        Greeting greeting = greetingRepository.findById(id).orElse(null);

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    public ResponseEntity<Greeting> addGreeting(Greeting greeting) {
        greetingRepository.save(new Greeting(greeting.getMessage(), greeting.isActive()));

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}