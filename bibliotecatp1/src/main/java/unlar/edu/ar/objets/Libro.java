package unlar.edu.ar.objets;

public class Libro {
    String titulo, autor, isbn;
    int anio;
    boolean disponible;

    public Libro(String titulo, String autor, String isbn, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anio = anio;
        this.disponible = true;
    }
}
