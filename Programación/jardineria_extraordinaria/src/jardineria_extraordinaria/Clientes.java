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
public class Clientes {

    private Connection conexion = null;
//Conexión a la base de Datos Academia

    public Clientes() throws SQLException {
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

    //Leer todos los objetos de la base de datos
    public Cliente read(String codigoCliente) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        Cliente resultado = null;

        String sql = "SELECT * FROM clientes WHERE CodigoCliente = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, codigoCliente);
        ResultSet rs = ps.executeQuery();
        ArrayList<Cliente> lista = new ArrayList();
        if (rs.next()) {
            resultado = new Cliente(
                    rs.getString("CodigoCliente"), rs.getString("NombreCliente"),
                    rs.getString("NombreContacto"), rs.getString("ApellidoContacto"),
                    rs.getString("Telefono"), rs.getString("Fax"), rs.getString("Lineadireccion1"),
                    rs.getString("Lineadireccion2"), rs.getString("Ciudad"), rs.getString("Region"), rs.getString("Pais"), rs.getString("CodigoPostal"), rs.getString("CodigoEmpleadoRepVentas"), rs.getDouble("LimiteCredito"));

        }
        return resultado;
    }

    //Crear un objeto en la base de datos
    public void create(Cliente cliente) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, cliente.getCodigoCliente());
        ps.setString(2, cliente.getNombreCliente());
        ps.setString(3, cliente.getNombreContacto());
        ps.setString(4, cliente.getApellidoContacto());
        ps.setString(5, cliente.getTelefono());
        ps.setString(6, cliente.getFax());
        ps.setString(7, cliente.getLineaDireccion1());
        ps.setString(8, cliente.getLineaDireccion2());
        ps.setString(9, cliente.getCiudad());
        ps.setString(10, cliente.getRegion());
        ps.setString(11, cliente.getPais());
        ps.setString(12, cliente.getCodigoPostal());
        ps.setString(13, cliente.getCodigoEmpleadoRepVentas());
        ps.setDouble(14, cliente.getLimiteCredito());

        int rs = ps.executeUpdate();
    }
    //Actualizar un objeto de la base de datos seleccionandolo primero por el codigo de cliente

    public void update(Cliente cliente) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "UPDATE empleados SET NombreCliente = ?, NombreContacto = ?, ApellidoContacto = ?, Telefono = ?, Fax = ?, LineaDireccion1 = ?, LineaDireccion2 = ?, Ciudad = ?, Region = ?, Pais = ?, CodigoPostal = ?, CodigoEmpleadoRepVentas = ?, LimiteCredito = ? WHERE CodigoCliente = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, cliente.getNombreCliente());
        ps.setString(2, cliente.getNombreContacto());
        ps.setString(3, cliente.getApellidoContacto());
        ps.setString(4, cliente.getTelefono());
        ps.setString(5, cliente.getFax());
        ps.setString(6, cliente.getLineaDireccion1());
        ps.setString(7, cliente.getLineaDireccion2());
        ps.setString(8, cliente.getCiudad());
        ps.setString(9, cliente.getRegion());
        ps.setString(10, cliente.getPais());
        ps.setString(11, cliente.getCodigoPostal());
        ps.setString(12, cliente.getCodigoEmpleadoRepVentas());
        ps.setDouble(13, cliente.getLimiteCredito());

        int rs = ps.executeUpdate();
    }
    //Borrar un objeto de la base de datos por el codigo de cliente.

    public void delete(String codigoCliente) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "DELETE FROM clientes WHERE CodigoCliente = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, codigoCliente);
        int rs = ps.executeUpdate();

    }

    //Hacer un listado por pantalla de la base de datos.
    public ArrayList<Cliente> lista() throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        ArrayList<Cliente> lista = new ArrayList();

        String sql = "SELECT * FROM clientes";

        ResultSet rs = conexion.createStatement().executeQuery(sql);

        while (rs.next()) {

            String codigoCliente = rs.getString("CodigoCliente");
            String nombreCliente = rs.getString("NombreCliente");
            String nombreContacto = rs.getString("NombreContacto");
            String apellidoContacto = rs.getString("ApellidoContacto");
            String telefono = rs.getString("Telefono");
            String fax = rs.getString("Fax");
            String lineaDireccion1 = rs.getString("LineaDireccion1");
            String lineaDireccion2 = rs.getString("LineaDireccion2");
            String ciudad = rs.getString("Ciudad");
            String Region = rs.getString("Region");
            String Pais = rs.getString("Pais");
            String CodigoPostal = rs.getString("CodigoPostal");
            String CodigoEmpleadoRepVentas = rs.getString("CodigoEmpleadoRepVentas");
            double LimiteCredito = rs.getDouble("LimiteCredito");
      
            Cliente cli = new Cliente(codigoCliente, nombreCliente, nombreContacto, apellidoContacto, telefono, fax, lineaDireccion1, lineaDireccion2, ciudad, Region, Pais, CodigoPostal, CodigoEmpleadoRepVentas, LimiteCredito);
            lista.add(cli);

        }
        return lista;
    }
}

