package unlar.edu.ar.objets;

import java.time.localDate;

public class Prestamo {

    // Atributos
    private Libro libro;
    private Estudiante estudiante;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    // Constructor
    
    public Prestamo(Libro libro, Estudiante estudiante, LocalDate fechaPrestamo) {
        this.libro = libro;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
    }

    // Getters
    public Libro getLibro() { return libro; }
    public Estudiante getEstudiante() { return estudiante; }
    public LocalDate getFechaPrestamo() { return fechaPrestamo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }

    // Setters
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
    { this.fechaDevolucion = fechaDevolucion; } 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Prestamo prestamo = (Prestamo) obj;
        return libro.equals(prestamo.libro) && estudiante.equals(prestamo.estudiante);
    }

    @Override
    public string toString() {
        return "Prestamo: " + libro.getTitulo() + " a " + estudiante.getNombre();
    }


}
