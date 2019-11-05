
package cuborubik;

import java.util.Scanner;


public class CuboRubik {

    
    public static void main(String[] args) {
        double caras,casos;
        Scanner sc = new Scanner(System.in);
        
        casos = sc.nextInt();
        
        for(int i = 0; i < casos; i++){
            caras =  sc.nextInt();
            
            if ( caras >= 2 && caras <= 1000000){
            caras = (caras * caras * caras)-((caras-2)*(caras-2)*(caras-2));
            System.out.println(caras);
            }else{
                System.exit(0);
            }
            
        }
        
    }
    
}
