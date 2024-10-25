package johnoliveira.weeklyproject_u5_w1.repositories;


import johnoliveira.weeklyproject_u5_w1.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    // metodi-derived querys da // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html e esercizi
    List<Utente> findByUsernameAndEmail(String username, String email);

    // usato su UtenteService per il controllo email s egià esistente
    boolean existsByEmail(String email);

}

