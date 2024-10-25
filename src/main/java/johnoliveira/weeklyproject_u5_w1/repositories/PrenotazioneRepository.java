package johnoliveira.weeklyproject_u5_w1.repositories;


import johnoliveira.weeklyproject_u5_w1.entities.Postazione;
import johnoliveira.weeklyproject_u5_w1.entities.Prenotazione;
import johnoliveira.weeklyproject_u5_w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    //   Optional<Prenotazione> findByUtente(Utente utente);
//    Optional<Prenotazione>findByPostazione(Postazione postazone);
//    Optional<Prenotazione>findByDataPrenotazione(LocalDate dataPrenotazione);

    // Metodo per trovare una prenotazione per utente, postazione e data in una sola volta
    Optional<Prenotazione> findByUtenteAndPostazioneAndDataPrenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione);

    // metodo per trovare prenotazioni di di un utente nella data specifica
    List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

    // cerca la postazione con eventuale codice
    List<Prenotazione> findByPostazioneCodice(String codicePostazione);
}

