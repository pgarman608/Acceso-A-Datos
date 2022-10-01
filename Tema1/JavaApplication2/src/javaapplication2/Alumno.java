/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Serrperry
 */
public class Alumno implements Serializable{
    
    private int numExp;
    private Double notaMedia;
    private String apellido1, apellido2, nombre;
    private Date fechaNac;
    public static SimpleDateFormat dateForm;
    
    public Alumno(int numExp, Double notaMedia,String nombre,String apellido1,
            String apellido2, Date fechaNac) throws ParseException{
        this.dateForm = new SimpleDateFormat("dd/MM/yyyy");
        this.numExp = numExp;
        this.notaMedia = notaMedia;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getNumExp() {
        return numExp;
    }

    public void setNumExp(int numExp) {
        this.numExp = numExp;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public Date getFechaNacCompleto() {
        return fechaNac;
    }
    public Date getFechaNacDia() {
        return fechaNac;
    }
    public Date getFechaNacMes() {
        return fechaNac;
    }
    public Date getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    @Override
    public String toString(){
        String aux = "";
        aux = "Nombre: " + this.nombre + "\nApellidos: " + this.apellido1 
                + "\nExperiencia: " + this.numExp + "\nNotaMedia: " + this.notaMedia 
                + "\nFecha de Nacimiento: " + this.dateForm.format(fechaNac);
        return aux;
    }
}
