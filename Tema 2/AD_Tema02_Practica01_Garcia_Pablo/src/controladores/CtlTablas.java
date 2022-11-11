package controladores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Alumno;
import modelos.Curso;
import modelos.Examen;
import modelos.Matriculado;
import vistas.Index;

public class CtlTablas {
    private int numFilas;
    private ArrayList<Alumno> listAlumnos;
    private ArrayList<Curso> listCursos;
    private ArrayList<Matriculado> listMatriculados;
    private ArrayList<Examen> listExamenes;
    private Statement statement;
    private PreparedStatement prepareStatement; 
    private String sentenciaSQL;
    private ResultSet resultados;
    private CallableStatement callStatement;
    public CtlTablas() {
        //Inicializacemos la listas con las que vamos a trabajar
        this.listAlumnos = new ArrayList<>();
        this.listCursos = new ArrayList<>();
        this.listMatriculados = new ArrayList<>();
        this.listExamenes = new ArrayList<>();
    }
    /**
     * Connectaremos con la base de datos
     * @return Devolveremos la conexión base de datos 
     * @throws SQLException Devolveremos la excepcion de SQL
     */
    public Connection conectarSQL() throws SQLException{
        Connection con = null;
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
                                        , "AD_TEMA02", "AD_TEMA02");
        return con;
    }
    public ArrayList<Alumno> recogerAlumnos(){
        //Vaciaremos la lista de alumnos
        listAlumnos.removeAll(listAlumnos);
        //Comprobaremos que la conexion
        if (Index.con != null) {
            //Crearemos la sentencia de sql
            sentenciaSQL = "SELECT * FROM ALUMNOS";
            try{
                //Crearemos el objeto para ejecutar la sentencia
                statement = Index.con.createStatement();
                //Ejecutaremos la sentencia que nos devolvera una lista de tipo
                //resultset
                resultados = statement.executeQuery(sentenciaSQL);
                //La recogeremos y la guardaremos en un lista de alumnos
                while (resultados.next() == true) {
                    String codigoA = resultados.getString("cCodAlu");
                    String nombre = resultados.getString("cNomAlu");
                    listAlumnos.add(new Alumno(codigoA,nombre));
                }
                //Cerraremos el resultset y el objeto que ejecuta la sentencia
                statement.close();
                resultados.close();
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return listAlumnos;
    }
    public ArrayList<Curso> recogerCursos(){
        //Vaciaremos la lista de Cursos
        listCursos.removeAll(listCursos);
        //Comprobaremos que la conexion
        if (Index.con != null) {
            //Crearemos la sentencia de sql
            sentenciaSQL = "SELECT * FROM CURSOS";
            try{
                //Crearemos el objeto para ejecutar la sentencia
                statement = Index.con.createStatement();
                //Ejecutaremos la sentencia que nos devolvera una lista de tipo
                //resultset
                resultados = statement.executeQuery(sentenciaSQL);
                //La recogeremos y la guardaremos en un lista de alumnos
                while (resultados.next() == true) {
                    String codigoC = resultados.getString("cCodCurso");
                    String nombre = resultados.getString("cNomCurso");
                    int nExamenes = resultados.getInt("nNumExa");
                    listCursos.add(new Curso(codigoC,nombre,nExamenes));
                }
                //Cerraremos el resultset y el objeto que ejecuta la sentencia
                statement.close();
                resultados.close();
            }   catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        return listCursos;
    }
    public int matricularALumnos(String codigoAlumno, String codigoCurso){
        int error = 0;
        //Comprobaremos que la conexion
        if (Index.con != null) {
            //Crearemos la sentencia de sql
            sentenciaSQL = "{call sp_AltaMatricula(?,?,?)}";
            try {
                //Crearemos el objeto para ejecutar la sentencia
                callStatement = Index.con.prepareCall(sentenciaSQL);
                //Guardaremos en los parámetros de la sentencia el código del alumno
                //y del curso
                callStatement.setString(1, codigoAlumno);
                callStatement.setString(2, codigoCurso);
                //Registaremos el parametro de salida 
                callStatement.registerOutParameter(3, Types.NUMERIC);
                //Ejecutaremos el parametro de salida
                callStatement.executeUpdate();
                //Recogeremos el parametro de salida
                error = callStatement.getInt(3);
                //Cerraremos el objeto que ejecuta la sentencia
                callStatement.close();
            } catch (SQLException ex) {
                error = -1;
            }
        }
        return error;
    }
    public ArrayList<Matriculado> recogerMatriculados(){
        //Vaciaremos la lista de Cursos
        listMatriculados.removeAll(listMatriculados);
        //Comprobaremos que la conexion
        if (Index.con != null) {
            //Crearemos la sentencia de sql
            sentenciaSQL = "SELECT * FROM mj";
            try {
                //Crearemos el objeto para ejecutar la sentencia
                statement = Index.con.createStatement();
                //Ejecutaremos la sentencia que nos devolvera una lista de tipo
                //resultset
                resultados =  statement.executeQuery(sentenciaSQL);
                //La recogeremos y la guardaremos en un lista de matriculas
                while (resultados.next()) {                    
                    String codAlu = resultados.getString(1);
                    String nomAlu = resultados.getString(2);
                    String codCur = resultados.getString(3);
                    String nomCur = resultados.getString(4);
                    double notaMedia = resultados.getDouble(5);
                    listMatriculados.add(new Matriculado(codAlu, nomAlu, codCur, nomCur, notaMedia));
                }
                //Cerraremos el resultset y el objeto que ejecuta la sentencia
                statement.close();
                resultados.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de sql");
            }
            
        }
        return listMatriculados;
    }
    public ArrayList<Examen> recogerExamenes(String codAlu, String codCur){
        //Vaciaremos la lista de Cursos
        listExamenes.removeAll(listExamenes);
        //Comprobaremos que la conexion
        if (Index.con != null) {
            //Crearemos la sentencia de sql
            sentenciaSQL = "select nNumExam,dFecExam,nnotaexam "
                    + "FROM EXAMENES "
                    + "where ccodAlu = ? and ccodCurso = ?";
            try {
                //Crearemos el objeto para ejecutar la sentencia
                prepareStatement = Index.con.prepareStatement(sentenciaSQL);
                //Guardaremos en los parámetros de la sentencia el código del alumno
                //y del curso
                prepareStatement.setString(1, codAlu);
                prepareStatement.setString(2, codCur);
                //Ejecutaremos la sentencia que nos devolvera una lista de tipo
                //resultset
                resultados = prepareStatement.executeQuery();
                //La recogeremos y la guardaremos en un lista de matriculas
                while (resultados.next()) {
                    int numExamen = resultados.getInt(1);
                    String fecha = resultados.getString(2);
                    double notaExamen = resultados.getDouble(3);
                    listExamenes.add(new Examen(numExamen, fecha, notaExamen));
                }
                //Cerraremos el resultset y el objeto que ejecuta la sentencia
                prepareStatement.close();
                resultados.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de sql");
            }
            
        }
        return listExamenes;
    }
    public int updateExamen(String codAlu,String codCur, Examen examenCamb){
        int error = 0;
        //Comprobaremos que la conexion
        if (Index.con != null) {
            //Crearemos la sentencia de sql
            sentenciaSQL = "UPDATE EXAMENES "
                    + "SET dFecExam = ?, nNotaExam = ?"
                    + "where cCodAlu = ? and cCodCurso = ? and nNumExam = ?";
            try {
                //Crearemos el objeto para ejecutar la sentencia
                prepareStatement = Index.con.prepareStatement(sentenciaSQL);
                //Guardaremos en los parámetros de la sentencia la fecha y nota
                //del examen, el código del alumno y del curso
                prepareStatement.setString(1, examenCamb.getFecha());
                prepareStatement.setDouble(2, (Double)examenCamb.getNota());
                prepareStatement.setString(3, codAlu);
                prepareStatement.setString(4, codCur);
                prepareStatement.setInt(5, examenCamb.getnExamen());
                //Ejecutaremos la sentencia
                prepareStatement.executeUpdate();
                //Cerraremos el objeto que ejecuta la sentencia
                prepareStatement.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return error;
    }

    public int calcularMedia(String codigoAlumno, String codigoCurso) {
        int error = 0;
        //Comprobaremos que la conexion
        if (Index.con != null) {
            //Crearemos la sentencia de sql
            sentenciaSQL = "{call SP_EXAMEN(?,?,?)}";
            try {
                //Crearemos el objeto para ejecutar la sentencia
                callStatement = Index.con.prepareCall(sentenciaSQL);
                //Guardaremos en los parámetros de la sentencia el código del 
                //alumno y del curso
                callStatement.setString(1, codigoAlumno);
                callStatement.setString(2, codigoCurso);
                //Registaremos el parametro de salida
                callStatement.registerOutParameter(3, Types.NUMERIC);
                //Ejecutaremos la sentencia
                callStatement.executeUpdate();
                //Recogeremos el parámetro de salida
                error = callStatement.getInt(3);
                //Cerraremos el objeto que ejecuta la sentencia
                callStatement.close();
            } catch (SQLException ex) {
                error = -1;
            }
        }
        return error;
    }
}