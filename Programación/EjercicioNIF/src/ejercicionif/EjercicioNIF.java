/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicionif;
import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class EjercicioNIF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Integer validar;
        String nif;
        
        Scanner sc = new Scanner(System.in);
        String[] letra = {"T", "R", "W", "A", "G","M", "Y",
                            "F", "P", "D", "X", "B", "N", "J", "Z",
                            "S", "Q", "V", "H", "L", "C", "K", "E"};
        
        System.out.println("Introduce tu NIF (XXXXXXXXX-Z):");
        nif = sc.nextLine();
        
        String[] partes = nif.split("-");
        String parte1 = partes[0];
        String parte2 = partes[1];
        
        System.out.println(parte1);
        
        Integer num = Integer.parseInt(parte1);
        validar = (num % 23);
        
        System.out.println(validar);
        System.out.println(letra[validar]);
        System.out.println(parte2);
        
        if (parte2 == letra[validar] ){
            System.out.println("correcto");  
        }else{
            System.out.println("NIF no valido");
        }
    }
    
}
