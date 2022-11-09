package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Alumno;
import modelos.Curso;
import vistas.Index;

public class CtlTablas {
    private int numFilas;
    private ArrayList<Alumno> listAlumnos;
    private ArrayList<Curso> listCursos;
    private PreparedStatement psp;
    private String sentenciaSQL;
    private ResultSet resultados;

    public CtlTablas() {
        this.listAlumnos = new ArrayList<>();
        this.listCursos = new ArrayList<>();
    }
    
    public ArrayList<Alumno> recogerAlumnos(){
        listAlumnos.removeAll(listAlumnos);
        if (Index.con != null) {
            sentenciaSQL = "SELECT * FROM ALUMNOS";
            try{
                psp = Index.con.prepareStatement(sentenciaSQL);
                resultados = psp.executeQuery();
                while (resultados.next() == true) {
                    String codigoA = resultados.getString("cCodAlu");
                    String nombre = resultados.getString("cNomAlu");
                    System.out.println(codigoA + nombre);
                    listAlumnos.add(new Alumno(codigoA,nombre));
                }
                psp.close();
                resultados.close();
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return listAlumnos;
    }
    public ArrayList<Curso> recogerCursos(){
        listCursos.removeAll(listCursos);
        if (Index.con != null) {
            sentenciaSQL = "SELECT * FROM CURSOS";
            try{
                psp = Index.con.prepareStatement(sentenciaSQL);
                resultados = psp.executeQuery();
                while (resultados.next() == true) {
                    String codigoC = resultados.getString("cCodCurso");
                    String nombre = resultados.getString("cNomCurso");
                    int nExamenes = resultados.getInt("nNumExa");
                    System.out.println(codigoC + nombre + nExamenes);
                    listCursos.add(new Curso(codigoC,nombre,nExamenes));
                }
                
                psp.close();
                resultados.close();
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return listCursos;
    }
}
