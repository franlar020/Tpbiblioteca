package unlar.edu.ar;

import unlar.edu.ar.objets.Biblioteca;
import unlar.edu.ar.objets.Estudiante;
import unlar.edu.ar.objets.Libro;

public class App 
{
    public static void main( String[] args )
    {
        // 1. Creamos la biblioteca
        Biblioteca miBiblioteca = new Biblioteca();

        // 2. Creacion de estudiantes 

        Estudiante est1 = new Estudiante("12345", "Juan Perez", "Ingeniería en Sistemas", "juan@mail.com");
        Estudiante est2 = new Estudiante("67890", "María Gómez", "Licenciatura en Informática", "maria@mail.com");
        Estudiante est3 = new Estudiante("54321", "Carlos López", "Analista Programador Universitario", "carlos@mail.com");

        miBiblioteca.registrarEstudiante(est1);
        miBiblioteca.registrarEstudiante(est2);
        miBiblioteca.registrarEstudiante(est3);

        // 3. Creacion de libros

        Libro l1 = new Libro ("Java para principiantes", "John Doe", "111-222-333", 2020, true);
        Libro l2 = new Libro ("Estructuras de Datos en Java", "Jane Smith", "444-555-666", 2019, true);
        Libro l3 = new Libro ("Algoritmos y Programación", "Alice Johnson", "777-888-999", 2021, true);
        Libro l4 = new Libro ("Diseño de Software", "Bob Brown", "000-111-222", 2018, true);
        Libro l5 = new Libro ("Bases de Datos", "Charlie Davis", "333-444-555", 2022, true);

        miBiblioteca.agregarLibro(l1);
        miBiblioteca.agregarLibro(l2);
        miBiblioteca.agregarLibro(l3);
        miBiblioteca.agregarLibro(l4);
        miBiblioteca.agregarLibro(l5);

        System.out.println("---- Sistema de Gestión de Biblioteca ----");
        System.out.println("Estudiantes registrados: " + miBiblioteca.getRegistroEstudiantes().size());
        System.out.println("Libros en catalogo: " + miBiblioteca.getCatalogoLibros().size());

        // --- Prueba de Excepciones ---

        System.out.println("\n--- Ejecutando Casos de Prueba ---");

        try {
            //Prueba exitorsa
            miBiblioteca.registrarPrestamo("12345", "Java para principiantes");

            //Forzar LibroNoDisponibleException (intertan el mismo libro)

            System.out.println("Re-intentando prestamo del mismo libro....");
             miBiblioteca.registrarPrestamo("12345", "Java para principiantes");

        
        } catch (Exception e) {
            System.out.println("CAPTURA: " + e.getMessage());
        }

        try {
            //Forzar EstudianteNoEncontradoException
            System.out.println("\nIntentando préstamo a legajo inexistente...");
            miBiblioteca.registrarPrestamo("99999", "Estructuras de Datos en Java");

        } catch (Exception e){
            System.out.println("CAPTURA: " + e.getMessage());
        }

        // Calculo de Multa Recursiva

        System.out.println("\n--- Probando Cálculo de Multa (Recursividad) ---");
        double valorLibro = 1000.0;
        int diasRetraso = 15;
        double multa = miBiblioteca.calcularMulta(diasRetraso, valorLibro);

        System.out.println("Valor del libro: $" + valorLibro);
        System.out.println("Días de retraso: " + diasRetraso);
        System.out.println("Multa calculada (1% por día): $" + multa);

    }
}
