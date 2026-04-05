package unlar.edu.ar;

import unlar.edu.ar.objets.Biblioteca;
import unlar.edu.ar.objets.Estudiante;
import unlar.edu.ar.objets.Libro;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Biblioteca miBiblioteca = new Biblioteca();

        System.out.println("\n--- Prueba de multa ---");
        double valorLibro = 100.0;
        int diasRetraso1 = 0;
        int diasRetraso2 = 15;


        double multa1 = miBiblioteca.calcularMulta(diasRetraso1, valorLibro);
        double multa2 = miBiblioteca.calcularMulta(diasRetraso2, valorLibro);

        System.out.println("Multa 1 (0 dias): $" + multa1);
        System.out.println("------------------------------------");
        System.out.println("Multa 2 (15 dias): $" + multa2);
    }
}
