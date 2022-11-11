package modelos;

public class Alumno {
    private String codigoAlumno;
    private String nombre;

    public Alumno(String codigoAlumno, String nombre) {
        this.codigoAlumno = codigoAlumno;
        this.nombre = nombre;
    }

    public Alumno() {
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return getCodigoAlumno() + " - " + getNombre();
    }
}