package johnoliveira.weeklyproject_u5_w1.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "postazioni")
public class Postazione {
    @Id
    private String codice;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoSala; // l'enum TipoPostazionbe

    private int numeroMassimoOccupanti;

    @ManyToOne // più postazioni possono essere in un edificio
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
}

