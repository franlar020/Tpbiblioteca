package unlar.edu.ar;

import unlar.edu.ar.objets.Biblioteca;
import unlar.edu.ar.objets.Estudiante;
import unlar.edu.ar.objets.Libro;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        System.out.println("\n--- Probando Calculo de Multa (Recursividad) ---");
        
        double valorLibro = 1000.0;
        int diasRetraso = 15;
        double multa = biblioteca.calcularMulta(diasRetraso, valorLibro);

        System.out.println("Valor del libro: $" + valorLibro);
        System.out.println("Dias de retraso: " + diasRetraso);
        System.out.println("Multa calculada (1% por dia): $" + multa);
    }
}