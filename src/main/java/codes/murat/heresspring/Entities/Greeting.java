package codes.murat.heresspring.Entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@Table(name = "greetings")
public class Greeting {

    @Id
    @GenericGenerator(name = "uuid2")
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean active = true;

    public Greeting(String message, boolean active) {
        this.message = message;
        this.active = active;
    }

    public String getMessage() {
        return message;
    }

    public boolean isActive() {
        return active;
    }
}
