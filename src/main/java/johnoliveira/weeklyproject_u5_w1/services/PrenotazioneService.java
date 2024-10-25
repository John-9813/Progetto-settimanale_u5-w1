package johnoliveira.weeklyproject_u5_w1.services;

import johnoliveira.weeklyproject_u5_w1.entities.Prenotazione;
import johnoliveira.weeklyproject_u5_w1.exceptions.NotFoundException;
import johnoliveira.weeklyproject_u5_w1.exceptions.ValidationException;
import johnoliveira.weeklyproject_u5_w1.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@Slf4j
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    // crea una nuova prenotazione
    public void creaPrenotazione(Prenotazione prenotazione) {
        // controllo che non sia già prenotata per quella data
        prenotazioneRepository.findByUtenteAndPostazioneAndDataPrenotazione(
                prenotazione.getUtente(), prenotazione.getPostazione(), prenotazione.getDataPrenotazione()
        ).ifPresent(existing -> {
            throw new ValidationException("La postazione è già prenotata per la data specificata");
        });

        prenotazioneRepository.save(prenotazione);
        log.info("La prenotazione è stata creata per l'utente " + prenotazione.getUtente().getUsername());
    }

    //cerca una prenotazione per ID
    public Prenotazione trovaPrenotazionePerId(Long id) {
        return prenotazioneRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Prentazione non trovata con ID " + id));
    }

    //trova tutte le prenotazioni per una postazione specifica
    public List<Prenotazione> trovaPrenotazioniPerPostazione(String codicePostazione) {
        return prenotazioneRepository.findByPostazioneCodice(codicePostazione);
    }

    // Elimina una prenotazione
    public void eliminaPrenotazione(Long id) {
        if (!prenotazioneRepository.existsById(id)) {
            throw new NotFoundException("Prenotazione non trovata con ID: " + id);
        }
        prenotazioneRepository.deleteById(id);
        log.info("La prenotazione con ID: " + id + " è stata eliminata con successo");
    }


}

