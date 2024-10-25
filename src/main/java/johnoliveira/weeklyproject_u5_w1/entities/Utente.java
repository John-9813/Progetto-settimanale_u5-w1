package johnoliveira.weeklyproject_u5_w1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// per ora uso tutte le annotazioni
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "utenti")
public class Utente {
    @Id
    private String username;
    private String nomeCompleto;
    private String email;
}
