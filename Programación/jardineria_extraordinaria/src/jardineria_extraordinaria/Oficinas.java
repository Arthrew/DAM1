/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jardineria_extraordinaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario DAM 1
 */
public class Oficinas {
    private Connection conexion = null;
//Conexión a la base de Datos Academia

    public Oficinas() throws SQLException {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
//Método para cerrar la conexión a la Base de Datos

    public void close() throws SQLException {
        conexion.close();
    }

    //Read
    public Oficina read(String codigoOficina) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        Oficina resultado = null;

        String sql = "SELECT * FROM oficinas WHERE CodigoOficina = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, codigoOficina);
        ResultSet rs = ps.executeQuery();
        ArrayList<Oficina> lista = new ArrayList();
        if (rs.next()) {
            resultado = new Oficina(
                    rs.getString("codigoOficina"), rs.getString("ciudad"),
                    rs.getString("pais"), rs.getString("region"),
                    rs.getString("codigoPostal"), rs.getString("telefono"),rs.getString("lineaDireccion1"),
                    rs.getString("lineaDireccion2"));
                    

        }
        return resultado;
    }

    //Create
    public void create(Oficina oficina) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "INSERT INTO oficinas VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, oficina.getCodigoOficina());
        ps.setString(2, oficina.getCiudad());
        ps.setString(3, oficina.getPais());
        ps.setString(4, oficina.getRegion());
        ps.setString(5, oficina.getCodigoPostal());
        ps.setString(6, oficina.getTelefono());
        ps.setString(7, oficina.getLineaDireccion1());
        ps.setString(8, oficina.getLineaDireccion2());
  

        int rs = ps.executeUpdate();
    }
    //Update

    public void update(Oficina oficina) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "UPDATE oficinas SET Ciudad = ?, Pais = ?, Region = ?, CodigoPostal = ?, Telefono = ?, Lineadireccion1 = ?, LineaDireccion2 = ? WHERE CodigoOficina = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setString(1, oficina.getCiudad());
        ps.setString(2, oficina.getPais());
        ps.setString(3, oficina.getRegion());
        ps.setString(4, oficina.getCodigoPostal());
        ps.setString(5, oficina.getTelefono());
        ps.setString(6, oficina.getLineaDireccion1());
        ps.setString(7, oficina.getLineaDireccion2());

        int rs = ps.executeUpdate();
    }
    //Delete

    public void delete(String codigoOficina) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "DELETE FROM oficinas WHERE CodigoOficina = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, codigoOficina);
        int rs = ps.executeUpdate();

    }

    //ArrayList
    public ArrayList<Oficina> lista() throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        ArrayList<Oficina> lista = new ArrayList();

        String sql = "SELECT * FROM oficinas";

        ResultSet rs = conexion.createStatement().executeQuery(sql);

        while (rs.next()) {

            String codigoOficina = rs.getString("CodigoOficina");
            String ciudad = rs.getString("ciudad");
            String pais = rs.getString("pais");
            String region = rs.getString("region");
            String codigoPostal = rs.getString("codigoPostal");
            String telefono = rs.getString("telefono");
            String lineaDireccion1 = rs.getString("lineaDireccion1");
            String lineaDireccion2 = rs.getString("lineaDireccion2");
            

            Oficina of = new Oficina(codigoOficina, ciudad, pais, region, codigoPostal, telefono, lineaDireccion1, lineaDireccion2);
            lista.add(of);

        }
        return lista;
    }
}

