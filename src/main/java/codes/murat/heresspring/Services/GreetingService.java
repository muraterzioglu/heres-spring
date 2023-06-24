package codes.murat.heresspring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class GreetingService {

    private static final Map<Long, String> greetings = new HashMap<Long, String>();

    public Map<Long, String > getGreeting() {
        return greetings;
    }

    public Map<Long, String > getGreeting(long id) {
        HashMap<Long, String> specificContent = new HashMap<Long, String>();
        specificContent.put(id, greetings.get(id));

        return specificContent;
    }

    public Map<Long, String> postGreeting(long id, String content) {
        HashMap<Long, String> newContent = new HashMap<Long, String>();
        newContent.put(id, content);

        greetings.put(id, content);

        return newContent;
    }
}