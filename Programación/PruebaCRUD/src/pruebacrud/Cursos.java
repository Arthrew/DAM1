
package pruebacrud;

import java.sql.Date;

/**
 *
 * @author lopez
 */

public class Cursos {

    private Integer idCurso;
    private String NombreCurso;
    private Integer duracionCurso;
    private Integer IdProfesor;
    private Date fechaInicio;
    private Date fechaFin;
    private Profesores profesores;

    public Cursos() {
    }

    public Cursos(Integer idCurso, String NombreCurso, Integer duracionCurso, Integer IdProfesor, Date fechaInicio, Date fechaFin, Profesores profesores) {
        this.idCurso = idCurso;
        this.NombreCurso = NombreCurso;
        this.duracionCurso = duracionCurso;
        this.IdProfesor = IdProfesor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.profesores = profesores;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return NombreCurso;
    }

    public void setNombreCurso(String NombreCurso) {
        this.NombreCurso = NombreCurso;
    }

    public Integer getDuracionCurso() {
        return duracionCurso;
    }

    public void setDuracionCurso(Integer duracionCurso) {
        this.duracionCurso = duracionCurso;
    }

    public Integer getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(Integer IdProfesor) {
        this.IdProfesor = IdProfesor;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
    }

}

