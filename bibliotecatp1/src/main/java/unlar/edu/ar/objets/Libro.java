package unlar.edu.ar.objets;

public class Libro {
    private String titulo, autor, isbn;
    private int anio;
    private boolean disponible;

    public Libro(String titulo, String autor, String isbn, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anio = anio;
        this.disponible = true;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public int getAnio() { return anio; }
    public boolean isDisponible() { return disponible; }

    // Setters
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
