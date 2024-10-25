package johnoliveira.weeklyproject_u5_w1.services;


import johnoliveira.weeklyproject_u5_w1.entities.Edificio;
import johnoliveira.weeklyproject_u5_w1.exceptions.NotFoundException;
import johnoliveira.weeklyproject_u5_w1.exceptions.ValidationException;
import johnoliveira.weeklyproject_u5_w1.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@Slf4j
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    //creo un nuovo edificio con controlli
    public void creaEdificio(Edificio edificio) {
        if (edificio.getNome().isEmpty()) {
            throw new ValidationException("Il nome dell'edificio non può essere vuoto");
        }

        edificioRepository.save(edificio);
        log.info("L'edificio " + edificio.getNome() + " è stato creato correttamente");
    }

    // cerco un edificio per ID
    public Edificio trovaEdificioPerId(Long id) {
        return edificioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Edificio non trovato con ID: " + id));
    }

    // cerco edifici per città e indirizzo
    public List<Edificio> trovaEdificiPerCittaEIndirizzo(String citta, String indirizzo) {
        return edificioRepository.findByCittaAndIndirizzo(citta, indirizzo);
    }

    // Elimino un edificio
    public void eliminaEdificio(Long id) {
        if (!edificioRepository.existsById(id)) {
            throw new NotFoundException("Edificio non trovato con ID: " + id);
        }
        edificioRepository.deleteById(id);
        log.info("L'edificio con ID: " + id + " è stato eliminato con successo");
    }

   
}
