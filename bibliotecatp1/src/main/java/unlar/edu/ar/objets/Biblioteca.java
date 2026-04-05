package unlar.edu.ar.objets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;




import unlar.edu.ar.exception.*;

public class Biblioteca {


    // Estructuras de datos corregidas
    private ArrayList<Libro> catalogoLibros; // Corregido: catalogoLibros
    private HashMap<String, Estudiante> registroEstudiantes; // Corregido: registroEstudiantes
    private HashSet<Prestamo> prestamosActivos; // Corregido: Debe ser <Prestamo>, no <String>


    //definicion de estructuras de datos

    private ArrayList<Libro> catologLibros;
    private HashMap<String, Estudiante> registroEstudiates; // clave: legajo
    private HashSet<Prestamo> prestamosActivos; // legajo de estudiantes con prestamos activos
    private Object isbn;


    public Biblioteca() {
        this.catalogoLibros = new ArrayList<>();
        this.registroEstudiantes = new HashMap<>();
        this.prestamosActivos = new HashSet<>();
    }

    public void agregarLibro(Libro libro) {
        catalogoLibros.add(libro);
    }

    public void registrarEstudiante(Estudiante estudiante) {
        registroEstudiantes.put(estudiante.getLegajo(), estudiante);
    }

    // Getters
    public ArrayList<Libro> getCatalogoLibros() { return catalogoLibros; }
    public HashMap<String, Estudiante> getRegistroEstudiantes() { return registroEstudiantes; }
    public HashSet<Prestamo> getPrestamosActivos() { return prestamosActivos; }

    public void registrarPrestamo(String legajo, String tituloLibro) throws LimitePrestamosExcedidoException, EstudianteNoEncontradoException, LibroNoDisponibleException {
        
        // 1. Validar si el estudiante existe
        Estudiante estudiante = registroEstudiantes.get(legajo);
        if (estudiante == null) {
            throw new EstudianteNoEncontradoException("El legajo " + legajo + " no está registrado.");
        }

        // 2. Validar límite de 3 préstamos usando Stream
        long contador = prestamosActivos.stream()
                .filter(p -> p.getEstudiante().getLegajo().equals(legajo))
                .count();
        
        if (contador >= 3) {
            throw new LimitePrestamosExcedidoException("El estudiante " + legajo + " ya tiene 3 préstamos.");
        }

        // 3. Buscar el libro por título y disponibilidad
        Libro libEncontrado = null;

        for (Libro libro : catalogoLibros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro) && libro.isDisponible()) {

        for (Libro libro: catologLibros) {
            if (libro.getIsbn().equals(isbn)) {

                libEncontrado = libro;
                break;
            }
        }

        if (libEncontrado == null) {
            throw new LibroNoDisponibleException("El libro '" + tituloLibro + "' no existe o no está disponible.");
        }

        // 4. Registrar préstamo
        Prestamo nuevoPrestamo = new Prestamo(libEncontrado, estudiante, LocalDate.now());
        prestamosActivos.add(nuevoPrestamo);
        libEncontrado.setDisponible(false);

        System.out.println("Préstamo registrado con éxito: " + libEncontrado.getTitulo());
    }

    public void registrarDevolucion(String legajo, String tituloLibro) {
        Prestamo prestamoEncontrado = null;
        for (Prestamo prestamo : prestamosActivos) {
            if (prestamo.getEstudiante().getLegajo().equals(legajo) && 
                prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloLibro)) {
                prestamoEncontrado = prestamo;
                break;
            }
        }

        if (prestamoEncontrado != null) {
            prestamosActivos.remove(prestamoEncontrado);
            prestamoEncontrado.getLibro().setDisponible(true);
            System.out.println("Devolución exitosa de: " + tituloLibro);
        } else {
            System.out.println("No se encontró un préstamo activo para ese legajo y libro.");
        }
    }


    // Punto 2.5: Método recursivo para calcular multa (1% por día hasta 30 días)
    public double calcularMulta(int diasRetraso, double valorLibro) {
        if (diasRetraso <= 0) {
            return 0;
        }
        if (diasRetraso > 30) {
            return calcularMulta(30, valorLibro); // Límite de 30 días según tu lógica
        }
        // 1% del valor del libro + multa del día anterior

    //Listar prestamos de un estudiante especifico
    public void listarPrestamosEstudiante(String legajo) {
        System.out.println("Buscando préstamos activos para el legajo: " + legajo);
        boolean tienePrestamos = false;
        
        for (Prestamo p : prestamosActivos) {
            // Usamos el getter para comparar el legajo
            if (p.getEstudiante().getLegajo().equals(legajo)) {
                System.out.println(p);
                tienePrestamos = true;
            }
        }
        
        if (!tienePrestamos) {
            System.out.println("El estudiante no tiene préstamos activos actualmente.");
        }
    }

    // 2.5 Método recursivo para calcular multa 
    public double calcularMulta(int diasRetraso, double valorLibro) {
        // Caso base y límite de 30 días 
        if (diasRetraso <= 0 || diasRetraso > 30) {
            return 0;
        }
        // 1% por día de retraso calculado recursivamente 

        return (valorLibro * 0.01) + calcularMulta(diasRetraso - 1, valorLibro);
    }
}