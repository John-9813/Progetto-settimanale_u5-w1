package johnoliveira.weeklyproject_u5_w1.repositories;


import johnoliveira.weeklyproject_u5_w1.entities.Postazione;
import johnoliveira.weeklyproject_u5_w1.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, String> {
    // metodo-query per trovare le postazioni per tipo e città
    List<Postazione> findByTipoSalaAndEdificioCitta(TipoPostazione tipoSala, String citta);
}

