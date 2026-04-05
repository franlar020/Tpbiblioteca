package unlar.edu.ar.objets;

public class Libro {
    private String titulo, autor, isbn;
    private int anio;
    private boolean disponible;

    public String getTitulo() {
    return titulo;
}

    public Libro(String titulo, String autor, String isbn, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anio = anio;
        this.disponible = true;
    }

    public void setDisponible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDisponible'");
    }
}
