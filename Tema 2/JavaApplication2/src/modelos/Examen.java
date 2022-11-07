package modelos;

public class Examen {
    private int nExamen;
    private String fecha;
    private int nota;

    public Examen(int nExamen, String fecha, int nota) {
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return getnExamen() + " - " + getFecha() + " - " + getNota();
    }
    
}