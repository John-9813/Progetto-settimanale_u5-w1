package johnoliveira.weeklyproject_u5_w1.services;


import johnoliveira.weeklyproject_u5_w1.entities.Postazione;
import johnoliveira.weeklyproject_u5_w1.entities.TipoPostazione;
import johnoliveira.weeklyproject_u5_w1.exceptions.NotFoundException;
import johnoliveira.weeklyproject_u5_w1.exceptions.ValidationException;
import johnoliveira.weeklyproject_u5_w1.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@Slf4j
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    //creo una nuova postazione
    public void creaPostazione(Postazione postazione) {
        if (postazione.getCodice().isEmpty()) {
            throw new ValidationException("Il codice della postazione non può essere vuoto");
        }

        postazioneRepository.save(postazione);
        log.info("La postazione con codice " + postazione.getCodice() + " è stata creata corettamente");
    }

    // trovo una postazione per id
    public Postazione trovaPostazionePerId(String codice) {
        return postazioneRepository.findById(codice)
                .orElseThrow(() -> new NotFoundException("Postazione non trovata con codice: " + codice));
    }

    // Cerco postazioni per tipo e città
    public List<Postazione> trovaPostazioniPerTipoECitta(TipoPostazione tipoSala, String citta) {
        return postazioneRepository.findByTipoSalaAndEdificioCitta(tipoSala, citta);
    }

    // elimina una postazione
    public void eliminaPostazione(String id) {
        if (!postazioneRepository.existsById(id)) {
            throw new NotFoundException("Postazone non trovata con codice: " + id);
        }
        postazioneRepository.deleteById(id);
        log.info("La postazione con codice: " + id + " è stata elminata con successo");
    }

    //metodo per il runner
    public void salvaPostazione(Postazione postazione1) {
    }
}

