/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudejemplo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class CRUDEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Departamento dep = new Departamento();
        Departamentos bddep = null;

        dep.setDept_no(70);
        dep.setDnombre("INFORMÁTICA");
        dep.setLoc("MADRID");

        try {
            bddep = new Departamentos();
            bddep.Create(dep);
        } catch (SQLException ex) {
            System.err.println("Error al insertar: " + ex.getSQLState() + " " + ex.getMessage());
        } finally {
            try {
                if (bddep != null) {
                    bddep.Close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar BBDD: " + ex.getSQLState() + " " + ex.getMessage());
            }
        }

    }

}
