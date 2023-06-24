package codes.murat.heresspring;

import codes.murat.heresspring.AppConfigs.SimpleConfigs;
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
	private final SimpleConfigs configs;
	public Application(SimpleConfigs configs) {
		this.configs = configs;
	}

	@RequestMapping("/")
	Map<String, String> home() {
		homeHashMap.put("code", "200");
		homeHashMap.put("message", "Hello World!");
		homeHashMap.put("author", configs.author);
		homeHashMap.put("propFileDefaultValue", configs.lastname);
		return homeHashMap;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
