package codes.murat.heresspring.Repositories;

import codes.murat.heresspring.Entities.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
    List<Greeting> findByActive(boolean active);

    List<Greeting> findByMessage(String message);
}
