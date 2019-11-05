
package compararnombres;
import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class CompararNombres {
    
    public static void main(String[] args) {
        String nombre1, letras;
        int num_caracteres = 0, desde = 0, hasta = 0;
        Scanner sc = new Scanner(System.in); 
        
        System.out.print("Introduce una cadena de caracteres: ");
        nombre1 = sc.nextLine();
        
        num_caracteres = nombre1.length();
        
        System.out.println("La cadena de caracteres " + nombre1 + " tiene " + 
                num_caracteres + " caracteres.");
        
        System.out.print("¿Desde que caracter deseas obtener la nueva cadena?: ");
        desde = sc.nextInt();
        System.out.print("¿Hasta que caracter deseas obtener la nueva cadena?: ");
        hasta = sc.nextInt();
        
        letras = nombre1.substring(desde,hasta);
        System.out.println("La nueva cadena es: " + letras);
    }
    
}
