/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciogrados;

/**
 *
 * @author lopez
 */
public class EjercicioGrados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double faren = 20;
        double celsius;
        
        for( int i = 0; faren <= 300; i++ ){
            celsius = (faren - 32)*(0.5555);
            //celsius = celsius * 0.5; //- 32)*(5/9);
            System.out.println(faren + "º fahrenheit son "+ celsius + "º Celsius" );
            faren += 20;
            
        }
    }
    
}