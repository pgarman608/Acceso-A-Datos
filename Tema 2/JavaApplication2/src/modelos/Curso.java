package modelos;

public class Curso {
    private String codigoCurso;
    private String nombreCurso;
    private int nExamenes;

    public Curso(String codigoCurso, String nombreCurso, int nExamenes) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.nExamenes = nExamenes;
    }

    public Curso() {
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
        return getCodigoCurso() + " - " + getNombreCurso() + " - " + getnExamenes();
    }
    
}