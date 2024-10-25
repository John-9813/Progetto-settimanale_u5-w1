package johnoliveira.weeklyproject_u5_w1.repositories;


import johnoliveira.weeklyproject_u5_w1.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    List<Edificio> findByCittaAndIndirizzo(String citta, String indirizzo);
}

