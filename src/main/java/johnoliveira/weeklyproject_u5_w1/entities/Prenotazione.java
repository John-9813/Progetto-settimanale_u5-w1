package johnoliveira.weeklyproject_u5_w1.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // più prenotazioni possono esser efettuate da un utente
    @JoinColumn(name = "utente_username")
    private Utente utente;

    @ManyToOne // più postazioni possono essere prenotate da un utente
    @JoinColumn(name = "postazione_codice")
    private Postazione postazione;

    private LocalDate dataPrenotazione;

    // metodo per il runner


    public Prenotazione(LocalDate dataPrenotazione, Utente utente, Postazione postazione) {
        this.dataPrenotazione = dataPrenotazione;
        this.utente = utente;
        this.postazione = postazione;
    }
}

