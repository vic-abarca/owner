package biblioteca.salas.duoc.biblioteca.salas.duoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.sawgger.v3.oas.annotations.media.Schema;

@Schema(description = "codigo unico de la carrera", example = "INF001")
private String codigo;

@Schema(description = "nombre de la carrera", example = "Ingenieria en Informatica")
private String nombre;

@Schema(description = "cantidad de semestres de la carrera", example = "8")
private Integer semestres;

@Entity
@Table(name = "carrera")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
    @Id
    private String codigo;
    private String nombre;


}
