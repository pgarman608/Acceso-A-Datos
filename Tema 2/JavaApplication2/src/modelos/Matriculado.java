package modelos;

public class Matriculado {
    private String codigoAlumno;
    private String nombreAlumno;
    private String codigoCurso;
    private String nombreCurso;
    private int nExamenes;

    public Matriculado(String codigoAlumno, String nombreAlumno, String codigoCurso, String nombreCurso, int nExamenes) {
        this.codigoAlumno = codigoAlumno;
        this.nombreAlumno = nombreAlumno;
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.nExamenes = nExamenes;
    }

    public Matriculado() {
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getnExamenes() {
        return nExamenes;
    }

    public void setnExamenes(int nExamenes) {
        this.nExamenes = nExamenes;
    }

    @Override
    public String toString() {
        return getCodigoAlumno() + " - " + getNombreAlumno() + " | " + getCodigoCurso() + " - " + getNombreCurso() + " - " + getnExamenes();
    }
    
}