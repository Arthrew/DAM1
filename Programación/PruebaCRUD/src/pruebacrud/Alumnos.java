
package pruebacrud;

import java.sql.Date;

/**
 *
 * @author lopez
 */

public class Alumnos {

    private Integer idAlumno;
    private String Nombre;
    private String Apellidos;
    private String email;
    private Date FechaNacimiento;

    public Alumnos() {
    }

    public Alumnos(Integer idAlumno, String Nombre, String Apellidos, String email, Date FechaNacimiento) {
        this.idAlumno = idAlumno;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.email = email;
        this.FechaNacimiento = FechaNacimiento;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

}

