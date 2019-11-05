
package pruebacrud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lopez
 */

public class ProfesoresCRUD {

    Connection conexion;

    public ProfesoresCRUD() {
        try {
            conexion = null;
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "academia","academia");
        } catch (SQLException sqlE) {
            System.out.println("Error de conexion: \n" + sqlE);
        }
    }

    public ArrayList<Profesores> consulta() throws SQLException {

        ArrayList<Profesores> lista = new ArrayList<>();
        Profesores profes = new Profesores();
        String consulta = "select * from profesores";

        ResultSet rs = conexion.createStatement().executeQuery(consulta);
        while (rs.next()) {
            Integer id = rs.getInt("idProfesor");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");

            profes.setIdProfesor(id);
            profes.setNombre(nombre);
            profes.setApellidos(apellidos);
            profes.setEmail(email);

            lista.add(profes);
        }
        return lista;
    } //listar profes

    public Integer addProfe(Profesores profes) throws SQLException {
        Integer resultado = null;
        String sql = "INSERT INTO profesores (idProfesor,nombre,apellidos,email) VALUES (?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, profes.getIdProfesor());
        ps.setString(2, profes.getNombre());
        ps.setString(3, profes.getApellidos());
        ps.setString(4, profes.getEmail());

        resultado = ps.executeUpdate();

        return resultado;
    }

    public int updateProfe(Profesores profes) throws SQLException {
        String sql = "UPDATE profesores SET nombre = ?, apellidos = ?, email = ? WHERE idProfesor = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, profes.getNombre());
        ps.setString(2, profes.getApellidos());
        ps.setString(3, profes.getEmail());
        ps.setInt(4, profes.getIdProfesor());

        return ps.executeUpdate();
    }

    public void borrarProfe(Integer id) throws SQLException {
        String sentencia = "delete from profesores where idProfesor = " + id + ";";
        conexion.createStatement().executeUpdate(sentencia);

    }
}

