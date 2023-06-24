package codes.murat.heresspring.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @GenericGenerator(name = "uuid2")
    @Column(nullable = false, updatable = false, columnDefinition = "UUID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    private String id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;
}
