package unlar.edu.ar.objets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
    public HashSet<String> getPrestamosActivos() { return prestamosActivos; }
    
    


}
