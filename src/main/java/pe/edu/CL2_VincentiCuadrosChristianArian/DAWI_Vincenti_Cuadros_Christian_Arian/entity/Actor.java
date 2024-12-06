package pe.edu.CL2_VincentiCuadrosChristianArian.DAWI_Vincenti_Cuadros_Christian_Arian.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "actor")
    private List<FilmActor> filmActors;
}
