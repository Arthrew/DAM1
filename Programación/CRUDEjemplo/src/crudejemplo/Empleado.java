/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudejemplo;

import java.time.LocalDate;

/**
 *
 * @author Sergio
 */
public class Empleado {
    private int emp_no;
    private String apellido;
    private String oficio;
    private int dir;
    private LocalDate fecha_alt;
    private float salario;
    private float comision;
    private int dept_no;

    public Empleado() {
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public LocalDate getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(LocalDate fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }
    
    
}
