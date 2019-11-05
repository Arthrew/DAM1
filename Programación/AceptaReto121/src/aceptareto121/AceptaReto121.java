
package aceptareto121;

import java.util.Scanner;


public class AceptaReto121 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int num2, contador, num1, extras;

            if (A == 0 &&  B == 0 && C == 0) {
                System.exit(0);
            }

            if (A <= B && C>=A) {
                System.out.println("RUINA");
            
            } else if(B == 0){
                System.out.println(C + " " + C);
            
            }else {
                    contador = C / A;
                    extras = C % A;
                    num2 = (contador * B) + extras;
                    num1 = C + (num2 - extras);
                    
                    while (num2 >= A) {
                        
                        contador = (num2 / A);
                        extras = num2 % A;
                        num1 = num1 + (contador * B);
                        num2 = (contador * B) + extras;
                        
                        
                    }
                    System.out.println(num1 + " " + num2);
            
            }
        }

    }
    
}
