
package lavadora;
import libreria.Suma;
import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class lavadora {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿La ropa es blanca o de color?");
        System.out.println("Presiona 1 - ropa blanca / 2 - ropa color ");
        int TipodeRopa = sc.nextInt();
        
        System.out.println("¿Cuantos kilos de ropa?");
        int kilos = sc.nextInt();
        
        Suma mensajero = new Suma(kilos, TipodeRopa);
        mensajero.CicloFinalizado();
        
        
    }
    
}
