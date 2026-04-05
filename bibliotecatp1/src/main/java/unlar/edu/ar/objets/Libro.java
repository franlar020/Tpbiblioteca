package unlar.edu.ar.objets;

public class Libro {
    // Atributos privados (Encapsulamiento)
    private String titulo;
    private String autor;
    private String isbn;
    private int anio;
    private boolean disponible;

    // Constructor único y limpio
    public Libro(String titulo, String autor, String isbn, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anio = anio;
        this.disponible = true; // Por defecto, un libro nuevo está disponible
    }

    // --- Getters ---
    public String getTitulo() { 
        return titulo; 
    }

    public String getAutor() { 
        return autor; 
    }

    public String getIsbn() { 
        return isbn; 
    }

    public int getAnio() { 
        return anio; 
    }

    public boolean isDisponible() { 
        return disponible; 
    }

    // --- Setters ---
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método toString (Opcional pero muy útil para ver los datos en consola)
    @Override
    public String toString() {
        return "Libro: " + titulo + " (ISBN: " + isbn + ") - Disponible: " + (disponible ? "Sí" : "No");
    }
}