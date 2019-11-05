
package ejercicio3java2;
import java.util.Scanner;

/**
 *
 * @author Usuario DAM 1
 */
public class Ejercicio3Java2 {
    
    public static Boolean esPrimo(int numero){
        
        boolean primo = true;
        for(int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                primo = false;
            }
            break;
        }
        return primo;
    }
    
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeros[] = new int[10];
        int m;
        int primos[] = new int[10];
        
        
        for(int i=0; i < 10; i++)
        { 
            System.out.println("Introduce elemento " + (i+1) + ": ");
            m = sc.nextInt();
            numeros[i]=m;
        }
        
        
        
        for(int i= 0; i < 10; i++)
        {
            System.out.print(" " + i + "\t");
        }
        
        
        System.out.println(" ");
        
        
        for(int i= 0; i < 10;i++)
        {
            System.out.print(" " + numeros[i] + "\t");   
        }
        
        
        System.out.println(" ");
        
        
        System.out.println("El array con los primos primero es: ");
        
        for (int i = 0; i < 10; i++) {
            if(esPrimo(numeros[i]) == true){
                primos[i] = numeros[i];
            
        }
                
        }
        
        
        for(int i= 0; i < 10;i++)
        {
            System.out.print(" " + primos[i] + "\t");   
        }
            
        

        
    
    }

}