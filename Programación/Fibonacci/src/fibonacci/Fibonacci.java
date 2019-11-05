/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author lopez
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long f1 = 0;
        long f2 = 1;
        long f3;
        int i = 0;
        
        while (i < 51){
            f3 = f1 + f2;
            System.out.println((i+1) + ":  " +  + f1);
            f1=f2;
            f2=f3;
            i++;
            
        }
    }
    
}
