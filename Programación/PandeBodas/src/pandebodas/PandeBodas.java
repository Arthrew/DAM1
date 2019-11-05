/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandebodas;
import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class PandeBodas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int casos;
        String asientos[] = new String[1000];
        Scanner sc = new Scanner(System.in);
        
        casos = sc.nextInt();
        
        for(int i = 0; i <= casos; i++){
            
            String asiento;
            asiento = sc.nextLine();
            asientos[i] = asiento;
        
    }
    
}
}
