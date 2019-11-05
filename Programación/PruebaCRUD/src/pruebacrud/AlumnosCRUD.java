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

public class AlumnosCRUD {

    Connection conexion;

    public AlumnosCRUD() {
        try {
            conexion = null;
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "academia", "academia");
        } catch (SQLException sqlE) {
            System.out.println("Error de conexion: \n" + sqlE);
        }
    }

    public ArrayList<Alumnos> consulta() throws SQLException {

        ArrayList<Alumnos> lista = new ArrayList<>();
        Alumnos alum = new Alumnos();
        String consulta = "select * from alumnos";

        ResultSet rs = conexion.createStatement().executeQuery(consulta);
        while (rs.next()) {
            Integer id = rs.getInt("idAlumno");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            Date fechaNacimiento = rs.getDate("fechaNacimiento");

            alum.setIdAlumno(id);
            alum.setNombre(nombre);
            alum.setApellidos(apellidos);
            alum.setEmail(email);
            alum.setFechaNacimiento(fechaNacimiento);

            lista.add(alum);
        }
        return lista;
    } //listar alum

    public Integer addAlumn(Alumnos alumn) throws SQLException {
        Integer resultado = null;
        String sql = "INSERT INTO alumnos (idAlumno,nombre,apellidos,email,fechaNacimiento) VALUES (?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setInt(1, alumn.getIdAlumno());
        ps.setString(2, alumn.getNombre());
        ps.setString(3, alumn.getApellidos());
        ps.setString(4, alumn.getEmail());
        ps.setDate(5, alumn.getFechaNacimiento());

        resultado = ps.executeUpdate();

        return resultado;
    }

    public int updateProfe(Alumnos alumn) throws SQLException {
        String sql = "UPDATE alumnos SET nombre = ?, apellidos = ?, email = ?, FechaNacimiento = ? WHERE idAlumno = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, alumn.getNombre());
        ps.setString(2, alumn.getApellidos());
        ps.setString(3, alumn.getEmail());
        ps.setDate(4, alumn.getFechaNacimiento());
        ps.setInt(5, alumn.getIdAlumno());

        return ps.executeUpdate();
    }

    public void borrarProfe(Integer id) throws SQLException {
        String sentencia = "delete from alumnos where idAlumno = " + id + ";";
        conexion.createStatement().executeUpdate(sentencia);

    }
}

