/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Alumno;
import vistas.Index;

/**
 *
 * @author usuario
 */
public class CtlAlumnos {
    private int numFilas;
    private ArrayList<Alumno> listAlumnos;
    private PreparedStatement psp;
    private String sentenciaSQL;
    private ResultSet resultados;

    public CtlAlumnos() {
        listAlumnos = new ArrayList<>();
    }
    
    public ArrayList<Alumno> recogerAlumnos(){
        listAlumnos.removeAll(listAlumnos);
        if (Index.con != null) {
            sentenciaSQL = "SELECT * FROM ALUMNOS";
            
            try{
                psp = Index.con.prepareStatement(sentenciaSQL);

                resultados = psp.executeQuery();
                System.out.println(resultados.next());
                while (resultados.next() == true) {
                    String codigoA = resultados.getString(0);
                    String nombre = resultados.getString(1);
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
}
