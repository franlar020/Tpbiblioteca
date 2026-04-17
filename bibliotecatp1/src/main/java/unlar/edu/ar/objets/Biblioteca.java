package unlar.edu.ar.objets;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import unlar.edu.ar.exception.*;
import lombok.Getter;



public class Biblioteca {

    // 1. Estructuras de datos
    @Getter private ArrayList<Libro> catalogoLibros;
    @Getter private HashMap<String, Estudiante> registroEstudiantes;
    @Getter private HashSet<Prestamo> prestamosActivos;

    public Biblioteca() {
        this.catalogoLibros = new ArrayList<>();
        this.registroEstudiantes = new HashMap<>();
        this.prestamosActivos = new HashSet<>();
    }

    // 2. Métodos para agregar datos
    public void agregarLibro(Libro libro) {
        catalogoLibros.add(libro);
    }

    public void registrarEstudiante(Estudiante estudiante) {
        registroEstudiantes.put(estudiante.getLegajo(), estudiante);
    }

    // 4. Registrar Préstamo
    public void registrarPrestamo(String legajo, String tituloLibro) throws LimitePrestamosExcedidoException, EstudianteNoEncontradoException, LibroNoDisponibleException {
        
        // Validar si el estudiante existe
        Estudiante estudiante = registroEstudiantes.get(legajo);
        if (estudiante == null) {
            throw new EstudianteNoEncontradoException("El legajo " + legajo + " no está registrado.");
        }

        // Validar límite de 3 préstamos
        long contador = prestamosActivos.stream()
                .filter(p -> p.getEstudiante().getLegajo().equals(legajo))
                .count();
        
        if (contador >= 3) {
            throw new LimitePrestamosExcedidoException("El estudiante " + legajo + " ya tiene 3 préstamos activos.");
        }

        // Buscar el libro por título y disponibilidad
        Libro libEncontrado = null;
        for (Libro libro : catalogoLibros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro) && libro.isDisponible()) {
                libEncontrado = libro;
                break;
            }
        }

        if (libEncontrado == null) {
            throw new LibroNoDisponibleException("El libro '" + tituloLibro + "' no existe o no está disponible.");
        }

        // Registrar el préstamo
        Prestamo nuevoPrestamo = new Prestamo(libEncontrado, estudiante, LocalDate.now(), null);
        prestamosActivos.add(nuevoPrestamo);
        libEncontrado.setDisponible(false); // Cambiar estado del libro

        System.out.println("Préstamo registrado con éxito: " + libEncontrado.getTitulo());
    }

    // 5. Registrar Devolución
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

    // 6. Listar préstamos
    public void listarPrestamosEstudiante(String legajo) {
        System.out.println("Buscando préstamos activos para el legajo: " + legajo);
        boolean tienePrestamos = false;
        
        for (Prestamo p : prestamosActivos) {
            if (p.getEstudiante().getLegajo().equals(legajo)) {
                System.out.println(p);
                tienePrestamos = true;
            }
        }
        
        if (!tienePrestamos) {
            System.out.println("El estudiante no tiene préstamos activos actualmente.");
        }
    }

    // 7. calcular multa
    public double calcularMulta(int diasRetraso, double valorLibro) {
        // Caso base: si no hay retraso
        if (diasRetraso <= 0) {
            return 0;
        }

        if (diasRetraso > 30) {
            return calcularMulta(30, valorLibro);
        }
        
        // Caso recursivo: 1% del valor del libro + la multa del día anterior
        return (valorLibro * 0.01) + calcularMulta(diasRetraso - 1, valorLibro);
    }
}