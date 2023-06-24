package codes.murat.heresspring.AppConfigs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfigs {
    @Value("${app.author}")
    public String author;

    @Value("${app.lastname:default_value}")
    public String lastname;
}
