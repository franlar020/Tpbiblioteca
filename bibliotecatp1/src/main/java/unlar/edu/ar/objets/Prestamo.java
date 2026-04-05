package unlar.edu.ar.objets;

import java.time.LocalDate; // Corregida la mayúscula

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

    public Libro getLibro() { return libro; }
    public Estudiante getEstudiante() { return estudiante; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() { // String con S mayúscula
        return "Prestamo: " + libro.getTitulo() + " a " + estudiante.getNombre();
    }
}