package unlar.edu.ar.objets;

public class Estudiante {
    private String legajo;
    private String nombre;
    private String carrera;
    private String email;

    public Estudiante() {} // Constructor 

    public Estudiante(String legajo, String nombre, String carrera, String email) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.carrera = carrera;
        this.email = email;
    }

    // Getters y Setters
    public String getLegajo() { return legajo; }
    public void setLegajo(String legajo) { this.legajo = legajo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    // ... (hagan lo mismo para carrera y email)

    @Override
    public String toString() { return "Estudiante: " + nombre + " (" + legajo + ")"; }
}