package unlar.edu.ar.objets;

import java.time.LocalDate;
import java.util.Objects; // Necesario para el hashCode

public class Prestamo {
    private Libro libro;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Estudiante estudiante, LocalDate fechaPrestamo) {
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
    }

    // --- Getters ---
    public Libro getLibro() { return libro; }
    public Estudiante getEstudiante() { return estudiante; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getLocalDate() { return fechaPrestamo; } // Alias por si lo usás así en App
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }

    // --- Setters ---
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    // --- Métodos de Comparación (Para que el HashSet funcione bien) ---
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Prestamo prestamo = (Prestamo) obj;
        return Objects.equals(libro, prestamo.libro) && 
               Objects.equals(estudiante, prestamo.estudiante);
    }

    @Override
    public int hashCode() {
        // Genera un ID único basado en el libro y el estudiante
        return Objects.hash(libro, estudiante);
    }

    // --- Método toString (Solo una vez) ---
    @Override
    public String toString() {
        return "Prestamo: " + libro.getTitulo() + " a " + estudiante.getNombre() + 
               " (Fecha: " + fechaPrestamo + ")";
    }
}