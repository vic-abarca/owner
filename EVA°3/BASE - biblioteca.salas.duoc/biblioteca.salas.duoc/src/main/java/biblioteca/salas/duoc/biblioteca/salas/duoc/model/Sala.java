package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sala")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sala {
    @Id
    private Integer codigo;
    private String nombre;
    private Integer capacidad;
    private Integer idInstituo;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoSala tipoSala;

    // Getters and Setters

@Schema(description = "Identificador de la sala", example = "1")
private Long id;
@Schema(description = "Nombre de la sala", example = "Sala de Estudio")
private String nombre;
@Schema(description = "Capacidad máxima de la sala", example = "30")
private Integer capacidad;

}
