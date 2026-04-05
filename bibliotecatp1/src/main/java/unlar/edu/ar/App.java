package unlar.edu.ar;
import unlar.edu.ar.objects.Biblioteca;
import unlar.edu.ar.objects.Estudiante;
import unlar.edu.ar.objects.Libro;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    
        System.out.println("Prueba de multa");
        double valorLibro = 100.0;
        int diasRetraso1 = 0;
        int diasRetraso2 = 15;
        
        double multa1 = Biblioteca.calcularMulta( diasRetraso1, valorLibro);
        double multa2 = Biblioteca.calcularMulta(diasRetraso2, valorLibro);
        
        System.out.println("Multa 1: " + multa1);
        System.out.println("------------------------------ ");
        System.out.println("Multa 2: " + multa2);
    }
}
