package unlar.edu.ar.objets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import unlar.edu.ar.exception.*¨;

public class Biblioteca {


    //definicion de estructuras de datos

    private ArrayList<Libro> catologLibros;
    private HashMap<String, Estudiante> registroEstudiates; // clave: legajo
    private HashSet<String> prestamosActivos; // legajo de estudiantes con prestamos activos

    public Biblioteca() {
        this.catologLibros = new ArrayList<>();
        this.registroEstudiates = new HashMap<>();
        this.prestamosActivos = new HashSet<>();
    }

    //metodos para agregar datos a las estructuras

    public void agregarLibro(Libro libro) {
        catologLibros.add(libro);
    }

    public void registrarEstudiante(Estudiante estudiante) {
        registroEstudiates.put(estudiante.getLegajo(), estudiante);
    }

    //getters
    public ArrayList<Libro> getCatologLibros() { return catologLibros; }
    public HashMap<String, Estudiante> getRegistroEstudiates() { return registroEstudiates; }
    public HashSet<Prestamo> getPrestamosActivos() { return prestamosActivos; }
    

    // validad si el estudiante existe en el registro
    public void registrarPrestamo(String legajo, String tituloLibro) throws LimitePrestamosExcedidoException {
        if (prestamosActivos.contains(legajo)) {
            throw new LimitePrestamosExcedidoException("El estudiante con legajo " + legajo + " ya tiene un préstamo activo.");
        }

        Estudiante estudiante = registroEstudiates.get(legajo);

        //Validad si el libro existe en el catalogo

        Libro libEncontrado = null;
        for (Libro libro: catologLibros) {
            if (l.getIsbn().equals(isbn)) {
                libEncontrado = libro;
                break;
            }       
        }

        if (libEncontrado == null) {
            throw new IllegalArgumentException("El libro con título " + tituloLibro + " no se encuentra en el catálogo.");
        }

        //validad limite de 3 prestamos por estudiante
        long contador= prestamosActivos.stream().filter(p -> p.getEstudiante().getLegajo().equals(legajo)).count();
        if (contador >= 3) {
            throw new LimitePrestamosExcedidoException("El estudiante con legajo " + legajo + " ha excedido el límite de préstamos activos.");
        }

        //SI esta todo OK, se registra el prestamo
        Prestamo nuevoPrestamo = new Prestamo(libEncontrado, estudiante, LocalDate.now());
        prestamosActivos.add(nuevoPrestamo);
        libEncontrado.setDisponible(false); // Marcar el libro como no disponible

        System.out.println("Préstamo registrado: " + nuevoPrestamo);

    }

    public void registrarDevolucion(String legajo, String tituloLibro) {
        Prestamo prestamoEncontrado = null;
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getEstudiante().getLegajo().equals(legajo) && prestamo.getLibro().getTitulo().equals(tituloLibro)) {
                prestamoEncontrado = prestamo;
                break;
            }
        }

        if (aEliminar != null) {
            prestamosActivos.remove(prestamoEncontrado);
            prestamoEncontrado.getLibro().setDisponible(true); // Marcar el libro como disponible
            System.out.println("Devolución registrada: " + prestamoEncontrado);
        }
    }

    public void buscarLibro(String titulo) {
        for (Libro libro : catologLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(libro);
                return;
            }
        }
        System.out.println("Libro con título '" + titulo + "' no encontrado.");
    }
}
