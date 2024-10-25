package johnoliveira.weeklyproject_u5_w1;

import johnoliveira.weeklyproject_u5_w1.entities.*;
import johnoliveira.weeklyproject_u5_w1.services.EdificioService;
import johnoliveira.weeklyproject_u5_w1.services.PostazioneService;
import johnoliveira.weeklyproject_u5_w1.services.PrenotazioneService;
import johnoliveira.weeklyproject_u5_w1.services.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) {
        // ordine di salvataggio penso corretto, ci feve essere prima un edificio per esserci la postazione e deve
        // esserci prima un utente per poter creare la prenotazione.
        // creazione di un edificio di esempio
        Edificio edificio1 = new Edificio("Edificio A", "Via Roma 1", "Milano");
        edificioService.salvaEdificio(edificio1);

        // creazione di una postazione di esempio
        Postazione postazione1 = new Postazione("POST001", "Sala riunioni grande", TipoPostazione.SALA_RIUNIONI, 10, edificio1);
        postazioneService.salvaPostazione(postazione1);

        // ccreazione di un utente di esempio
        Utente utente1 = new Utente("john_oli", "John Oliver", "john.oliver@example.com");
        utenteService.saveUser(utente1);

        // creazione di una prenotazione di esempio
        Prenotazione prenotazione1 = new Prenotazione(utente1, postazione1, LocalDate.now().plusDays(1));
        prenotazioneService.salvaPrenotazione(prenotazione1);

        log.info("Dati caricati con successo.");
    }
}

