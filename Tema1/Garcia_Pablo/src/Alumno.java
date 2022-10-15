
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Alumno implements Serializable{
    private int matricula;
    private String nombre;
    private String fecha;
    private int notaM;
    private int edad;
    public Alumno(){
        this.matricula=0;
        this.nombre="";
        this.fecha="";
        this.notaM=0;
        this.edad=0;
    }
    public Alumno(int matricula,String nombre,String fecha,int notaM,int edad){
        this.matricula = matricula;
        this.nombre = nombre;
        this.fecha = fecha;
        this.notaM = notaM;
        this.edad = edad;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public int getNotaM() {
        return notaM;
    }

    public int getEdad() {
        return edad;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNotaM(int notaM) {
        this.notaM = notaM;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return ""+ getMatricula() + "*" + getNombre() +
                            "*" + getFecha() + "*" + getNotaM() + 
                            "*" + getEdad() + "\n";
    }
    
}
