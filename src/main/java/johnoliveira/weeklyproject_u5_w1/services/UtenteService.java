package johnoliveira.weeklyproject_u5_w1.services;


import johnoliveira.weeklyproject_u5_w1.entities.Utente;
import johnoliveira.weeklyproject_u5_w1.exceptions.NotFoundException;
import johnoliveira.weeklyproject_u5_w1.exceptions.ValidationException;
import johnoliveira.weeklyproject_u5_w1.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

@Slf4j
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    // serve per creare un nuovo utente
//    public Utente creaUtente(Utente utente) {
//        return utenteRepository.save(utente);
//    }

    //crea un nuovo utente con controlli
    public void saveUser(Utente newUtente) {
        // Controllo che l'email fornita non sia già nel db
        if (utenteRepository.existsByEmail(newUtente.getEmail()))
            throw new ValidationException("Email già in uso!");
        // Effettuo ulteriori controlli di validazione dei campi forniti
        if (newUtente.getUsername().length() < 2)
            throw new ValidationException("Lo username non può essere più corto di 2 caratteri");
        // Salvo l'utente
        utenteRepository.save(newUtente);
        // Log di avvenuto salvataggio
        log.info("L'utente " + newUtente.getUsername() + " è stato salvato correttamente!");
    }

    // cerco un utente per ID
    public Utente trovaUtentePerId(Long id) {
        return utenteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Utente non trovato con ID: " + id));
    }

    // cerca tutti gli utenti
    public List<Utente> trovaTuttiGliUtenti() {
        return utenteRepository.findAll();
    }

    // aggiorna un utente
    public Utente aggiornaUtente(Long id, Utente utenteAggiornato) {
        Utente utente = trovaUtentePerId(id);
        utente.setUsername(utenteAggiornato.getUsername());
        utente.setNomeCompleto(utenteAggiornato.getNomeCompleto());
        utente.setEmail(utenteAggiornato.getEmail());

        Utente utenteModificato = utenteRepository.save(utente);
        log.info("L'utente con id " + utenteModificato.getId() + " è stato modificato correttamente");
        return utenteModificato;
    }

    // elimina un utente
    public void eliminaUtente(Long id) {
        if (!utenteRepository.existsById(id)) {
            throw new NotFoundException("Utente non trovato con ID: " + id);
        }
        utenteRepository.deleteById(id);
        log.info("L'utente con ID " + id + " è stato eliminato con successo");
    }
}

