
package ejercicio2java2;
import java.util.Scanner;

/**
 * @author Usuario DAM 1
 */
public class Ejercicio2Java2 {
    

    
    public static void main(String[] args) {
        String dia;
        int semana=0;
        String horadia;
        int minutosquedan;
        
        String[] parts ;
        String part1;
        String part2;
        
        
        int hora ;
        int minutos;

        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el dia: ");
        dia = sc.nextLine().toUpperCase();
        
        switch(dia){
            case "LUNES":
                semana = 0;
                break;
            case "MARTES":
                semana = 1;
                break;
            case "MIERCOLES":
                semana = 2;
                break;
            case "JUEVES":
                semana = 3;
                break;
            case "VIERNES":
                semana = 4;
                break;
            default:
                System.out.println("Introduce un dia correcto.");
        }
        do{
        System.out.println("Introduce la hora (hh:mm): ");
        horadia = sc.nextLine();
        
        parts = horadia.split(":");
        part1 = parts[0];
        part2 = parts[1];
        
        
        hora = Integer.parseInt(part1);
        minutos = Integer.parseInt(part2);
        }while(hora > 23 || hora < 0 || minutos > 59 || minutos < 0);
  
        
        hora = hora*60;
        minutosquedan = (6660-((semana*24*60)+(hora + minutos)));
        if(minutosquedan < 0){
            System.out.println("Ya estas en fin de semana");
        }else
            System.out.println("Faltan " + minutosquedan + " minutos para el fin de semana");
        
        
        
        
        
        
    }
    
}
