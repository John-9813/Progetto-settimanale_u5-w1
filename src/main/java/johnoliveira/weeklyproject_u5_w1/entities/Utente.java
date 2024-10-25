package johnoliveira.weeklyproject_u5_w1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
// per ora uso tutte le annotazioni
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id; // lo ho cambiato in Long per un problema al tipo di id
    @Column(nullable = false, unique = true) // per garantire che ci possa essere un solo username per utente
    private String username;
    @Column(nullable = false)
    private String nomeCompleto;
    @Column(nullable = false)
    private String email;

    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

}
