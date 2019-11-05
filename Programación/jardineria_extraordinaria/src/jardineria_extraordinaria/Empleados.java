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
public class Empleados {
    private Connection conexion = null;
//Conexión a la base de Datos Academia

    public Empleados() throws SQLException {
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
    public Empleado read(String codigoEmpleado) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        Empleado resultado = null;

        String sql = "SELECT * FROM empleados WHERE CodigoEmpleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, codigoEmpleado);
        ResultSet rs = ps.executeQuery();
        ArrayList<Empleado> lista = new ArrayList();
        if (rs.next()) {
            resultado = new Empleado(
                    rs.getString("codigoEmpleado"), rs.getString("nombre"),
                    rs.getString("apellido1"), rs.getString("apellido2"),
                    rs.getString("extension"), rs.getString("email"),rs.getString("codigoOficina"),
                    rs.getString("codigoJefe"),rs.getString("puesto"));
                    

        }
        return resultado;
    }

    //Create
    public void create(Empleado empleado) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "INSERT INTO empleados VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, empleado.getCodigoEmpleado());
        ps.setString(2, empleado.getNombre());
        ps.setString(3, empleado.getApellido1());
        ps.setString(4, empleado.getApellido2());
        ps.setString(5, empleado.getExtension());
        ps.setString(6, empleado.getEmail());
        ps.setString(7, empleado.getCodigoOficina());
        ps.setString(8, empleado.getCodigoJefe());
        ps.setString(9, empleado.getPuesto());

        int rs = ps.executeUpdate();
    }
    //Update

    public void update(Empleado empleado) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "UPDATE empleados SET Nombre = ?, Apellido1 = ?, Apellido2 = ?, Extension = ?, Email = ?, codigoOficina = ?, codigoJefe = ?, Puesto = ? WHERE CodigoEmpleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido1());
        ps.setString(3, empleado.getApellido2());
        ps.setString(4, empleado.getExtension());
        ps.setString(5, empleado.getEmail());
        ps.setString(6, empleado.getCodigoOficina());
        ps.setString(7, empleado.getCodigoJefe());
        ps.setString(8, empleado.getPuesto());

        int rs = ps.executeUpdate();
    }
    //Delete

    public void delete(String codigoEmpleado) throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        String sql = "DELETE FROM empleados WHERE CodigoEmpleado = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, codigoEmpleado);
        int rs = ps.executeUpdate();

    }

    //ArrayList
    public ArrayList<Empleado> lista() throws SQLException {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jardineria", "jardineria", "jardineria");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage() + "Vuelva a conectarse a la base de datos");
            System.exit(1);
        }

        ArrayList<Empleado> lista = new ArrayList();

        String sql = "SELECT * FROM empleados";

        ResultSet rs = conexion.createStatement().executeQuery(sql);

        while (rs.next()) {

            String codigoEmpleado = rs.getString("CodigoEmpleado");
            String nombre = rs.getString("Nombre");
            String apellido1 = rs.getString("Apellido1");
            String apellido2 = rs.getString("Apellido2");
            String extension = rs.getString("Extension");
            String email = rs.getString("Email");
            String codigoOficina = rs.getString("CodigoOficina");
            String codigoJefe = rs.getString("CodigoJefe");
            String puesto = rs.getString("Puesto");

            Empleado emp = new Empleado(codigoEmpleado, nombre, apellido1, apellido2, extension, email, codigoOficina, codigoJefe, puesto);
            lista.add(emp);

        }
        return lista;
    }
   
}
