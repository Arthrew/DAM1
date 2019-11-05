
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fechas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author smlar
 */
public class Fechas {

    /**
     * Muestra el número de años entre ahora y la fecha pasada por parametro
     * @param fecha 
     * @return 
     */
    static Integer mostrarEdad(LocalDate fecha) {
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fecha, ahora); 
        return periodo.getYears();
        
    }
    
    /**
     * Ejemplo de cálculo de años entre dos fechas
     */
    public static void main(String[] args) {
        
    /* Primer ejemplo, la fecha actual se pone usando el método of de LocalDate
    LocalDate fechanacimiento1 = LocalDate.of(1967, 1, 26);
    
    /* Segundo ejemplo: La fecha actual se lee a partir de una String usando
        la clase DateTimeFormatter
     */
    LocalDate fechanacimiento =  
      LocalDate.parse("1999-02-25", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  
        System.out.println("Edad: "+ mostrarEdad(fechanacimiento) +" años");
    }
    
}
