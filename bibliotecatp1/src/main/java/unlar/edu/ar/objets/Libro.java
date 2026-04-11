package unlar.edu.ar.objets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Libro {
    // Atributos privados (Encapsulamiento)
    private String titulo;
    private String autor;
    private String isbn;
    private int anio;
    private boolean disponible = true; // Por defecto, el libro está disponible
 } 

