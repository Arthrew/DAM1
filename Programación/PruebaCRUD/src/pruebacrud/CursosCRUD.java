
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

public class CursosCRUD {

    Connection conexion;

    public CursosCRUD() {
        try {
            conexion = null;
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/academia", "academia", "academia");
        } catch (SQLException sqlE) {
            System.out.println("Error de conexion: \n" + sqlE);
        }
    }

    public ArrayList<Cursos> consultaCursos() throws SQLException {

        ArrayList<Cursos> lista = new ArrayList<>();
        Cursos cursos = new Cursos();
        String consulta = "select * from cursos";

        ResultSet rs = conexion.createStatement().executeQuery(consulta);
        while (rs.next()) {
            Integer idCurso = rs.getInt("idCurso");
            String nombreCurso = rs.getString("nombreCurso");
            Integer duracionCurso = rs.getInt("duracionCurso");
            Integer idProfesor = rs.getInt("idProfesor");
            Date fechaInicio = rs.getDate("fechaInicio");
            Date fechaFin = rs.getDate("fechaFin");

            cursos.setIdCurso(idCurso);
            cursos.setNombreCurso(nombreCurso);
            cursos.setDuracionCurso(duracionCurso);
            cursos.setIdProfesor(idProfesor);
            cursos.setFechaInicio(fechaInicio);
            cursos.setFechaFin(fechaFin);

            lista.add(cursos);
        }
        return lista;
    } //listar tab2

    public ArrayList<Cursos> consultaMix() throws SQLException {

        ArrayList<Cursos> lista = new ArrayList<Cursos>();

        String consulta = "select * from cursos "
                + "left join profesores "
                + "on cursos.idProfesor = profesores.idProfesor "
                + "order by(cursos.idCurso)";

        ResultSet rs = conexion.createStatement().executeQuery(consulta);
        while (rs.next()) {
            Cursos cursos = new Cursos();
            Profesores profes = new Profesores();
            Integer idCurso = rs.getInt("idCurso");
            String nombreCurso = rs.getString("NombreCurso");
            Integer duracionCurso = rs.getInt("duracionCurso");
            Integer idProfesor = rs.getInt("idProfesor");
            Date fechaInicio = rs.getDate("fechaInicio");
            Date fechaFin = rs.getDate("fechaFin");

            cursos.setIdCurso(idCurso);
            cursos.setNombreCurso(nombreCurso);
            cursos.setDuracionCurso(duracionCurso);
            cursos.setIdProfesor(idProfesor);
            cursos.setFechaInicio(fechaInicio);
            cursos.setFechaFin(fechaFin);

            Integer id = rs.getInt("idProfesor");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");

            profes.setIdProfesor(id);
            profes.setNombre(nombre);
            profes.setApellidos(apellidos);
            profes.setEmail(email);

            cursos.setProfesores(profes);

            lista.add(cursos);
        }
        return lista;
    } //listar ambas

    public Integer addCurso(Cursos cursos) throws SQLException {
        Integer resultado = null;
        String sql = "INSERT INTO cursos (NombreCurso,DuracionCurso,IdProfesor,FechaInicio,FechaFin) VALUES (?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, cursos.getNombreCurso());
        ps.setInt(2, cursos.getDuracionCurso());
        ps.setInt(3, cursos.getIdProfesor());
        ps.setDate(4, cursos.getFechaInicio());
        ps.setDate(5, cursos.getFechaFin());

        return ps.executeUpdate();
    }

    public int updateCurso(Cursos cursos) throws SQLException {
        String sql = "UPDATE cursos SET NombreCurso = ?, DuracionCurso = ?, IdProfesor = ?, FechaInicio = ?, FechaFin = ? WHERE IdCurso = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, cursos.getNombreCurso());
        ps.setInt(2, cursos.getDuracionCurso());
        ps.setInt(3, cursos.getIdProfesor());
        ps.setDate(4, cursos.getFechaInicio());
        ps.setDate(5, cursos.getFechaFin());
        ps.setInt(6, cursos.getIdCurso());

        return ps.executeUpdate();
    }
    
    public void borrarCurso(Integer id) {
        String sentencia = "delete from cursos where idCurso = " + id + ";";
        try {
            conexion.createStatement().executeUpdate(sentencia);
        } catch (SQLException sqlE) {
            System.err.println("Error al borrar: " + sqlE);

        }
    }

}
