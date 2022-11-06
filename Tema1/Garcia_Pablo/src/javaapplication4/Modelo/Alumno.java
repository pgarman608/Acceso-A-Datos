
package javaapplication4.Modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import javaapplication4.Controlador.Utilities;

public class Alumno implements Serializable{
    private int matricula;
    private String nombre;
    private Date fechaNac;
    private float notaMedia;
    private int edad;

    public Alumno(int matricula, String nombre, String fechaNac, float notaMedia, int edad) throws ParseException {
        this.matricula = matricula;
        this.nombre = nombre;
        this.setFechaNac(fechaNac);
        this.notaMedia = notaMedia;
        this.edad = edad;
    }

    public Alumno() throws ParseException {
        this.matricula = 1;
        this.nombre = "";
        this.setFechaNac("11/11/1111");
        this.notaMedia = (float) 1.1;
        this.edad = 1;
    }
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public int getMatricula() {
        return this.matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return Utilities.sdf.format(fechaNac);
    }

    public void setFechaNac(String fechaNac) throws ParseException {
        this.fechaNac = Utilities.sdf.parse(fechaNac);
    }

    public float getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(float notaFinal) {
        this.notaMedia = notaFinal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return ""+ getMatricula() + "*" + getNombre() +
                            "*" + getFechaNac() + "*" + getNotaMedia()+ 
                            "*" + getEdad() + "\n";
    }
}
