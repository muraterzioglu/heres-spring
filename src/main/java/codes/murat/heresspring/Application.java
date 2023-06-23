package codes.murat.heresspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class Application {
	private final Map<String, String> homeHashMap = new HashMap<String, String>();

	@RequestMapping("/")
	Map<String, String> home() {
		homeHashMap.put("code", "200");
		homeHashMap.put("message", "Hello World!");
		return homeHashMap;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
