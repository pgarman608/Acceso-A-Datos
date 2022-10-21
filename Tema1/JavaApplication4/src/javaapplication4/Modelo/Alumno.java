/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.Modelo;

import java.util.Date;

/**
 *
 * @author Serrperry
 */
public class Alumno {
    private static int matricula = 0;
    private String nombre;
    private Date fechaNac;
    private float notaFinal;
    private int edad;

    public Alumno(String nombre, Date fechaNac, float notaFinal, int edad) {
        this.matricula++;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.notaFinal = notaFinal;
        this.edad = edad;
    }

    public static int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
