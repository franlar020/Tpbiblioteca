package unlar.edu.ar.objets;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Genera getters, setters, toString, equals y hashCode
@AllArgsConstructor // Genera un constructor con todos los campos
@NoArgsConstructor // Genera un constructor vacio

public class Prestamo {
    private Libro libro;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public LocalDate getLocalDate() {
    return fechaPrestamo;
}

}

