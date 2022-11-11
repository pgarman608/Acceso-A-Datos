package modelos;

public class Examen {
    private int nExamen;
    private String fecha;
    private double nota;

    public Examen(int nExamen, String fecha, double nota) {
        this.nExamen = nExamen;
        this.fecha = fecha;
        this.nota = nota;
    }

    public Examen() {
    }

    public int getnExamen() {
        return nExamen;
    }

    public void setnExamen(int nExamen) {
        this.nExamen = nExamen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return getnExamen() + " - " + getFecha() + " - " + getNota();
    }
    
}