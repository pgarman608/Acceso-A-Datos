package modelos;
// Generated 02-dic-2022 14:08:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cursos generated by hbm2java
 */
public class Cursos  implements java.io.Serializable {


     private String ccodcurso;
     private String cnomcurso;
     private short nnumexa;
     private Set matriculases = new HashSet(0);

    public Cursos() {
    }

	
    public Cursos(String ccodcurso, String cnomcurso, short nnumexa) {
        this.ccodcurso = ccodcurso;
        this.cnomcurso = cnomcurso;
        this.nnumexa = nnumexa;
    }
    public Cursos(String ccodcurso, String cnomcurso, short nnumexa, Set matriculases) {
       this.ccodcurso = ccodcurso;
       this.cnomcurso = cnomcurso;
       this.nnumexa = nnumexa;
       this.matriculases = matriculases;
    }
   
    public String getCcodcurso() {
        return this.ccodcurso;
    }
    
    public void setCcodcurso(String ccodcurso) {
        this.ccodcurso = ccodcurso;
    }
    public String getCnomcurso() {
        return this.cnomcurso;
    }
    
    public void setCnomcurso(String cnomcurso) {
        this.cnomcurso = cnomcurso;
    }
    public short getNnumexa() {
        return this.nnumexa;
    }
    
    public void setNnumexa(short nnumexa) {
        this.nnumexa = nnumexa;
    }
    public Set getMatriculases() {
        return this.matriculases;
    }
    
    public void setMatriculases(Set matriculases) {
        this.matriculases = matriculases;
    }




}


