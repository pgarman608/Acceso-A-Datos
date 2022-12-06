/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import modelos.Alumnos;
import modelos.Examenes;
import modelos.Matriculas;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author usuario
 */
public class CntrlFicheros {
    public static long exportJSON(ArrayList<Examenes> examenes){
        long error = 0;
        File fichero = new File("" + examenes.get(0).getId().getCcodalu() + "-" + examenes.get(0).getId().getCcodcurso() + ".json");
        try {
            FileWriter writer = new FileWriter(fichero);
            writer.write("{\n");
            writer.write("\t\"Matricula\": {\n");
            writer.write("\t\t\"CodigoAlumno\" : \"" + examenes.get(0).getId().getCcodalu() + "\",\n");
            writer.write("\t\t\"CodigoCurso\" : \"" + examenes.get(0).getId().getCcodcurso() + "\"\n");
            writer.write("\t},\n");
            writer.write("\t\"Examenes\": [\n");
            for (int i = 0; i < examenes.size(); i++) {
                writer.write("\t\t{\n");
                writer.write("\t\t\t\"Numero\": \""+examenes.get(i).getId().getNnumexam()+"\",\n");
                writer.write("\t\t\t\"Fecha\": \""+examenes.get(i).getDfecexam()+"\",\n");
                writer.write("\t\t\t\"Nota\": \""+examenes.get(i).getNnotaexam()+"\"\n");
                //EL ultimo } le quitaremos la coma
                if (i < examenes.size()-1) {
                    writer.write("\t\t},\n");
                }else{
                    writer.write("\t\t}\n");
                }
                
            }
            writer.write("\t]\n");
            writer.write("}");
            //Cerraremos el escritor
            writer.close();
        } catch (Exception e) {
            error = -1;
        }
        return error;
    }
    public static long exportarMatriculas(ArrayList<Matriculas> matriculados, ArrayList<Alumnos> alumnos){
        long error = 0;
        //Crearemos el documento y algunos elementos del array de 
        Document doc = null;
        Element raiz = null;
        Element eleAlumno = null;
        Element eleCursos = null;
        try {
            //Inicializaremos el documento
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException ex) {
            error = -1;
        }
        //Crearemos la raiz y la añadiremos al documaento
        raiz = doc.createElement("Alumnos");
        doc.appendChild(raiz);
        for (int i = 0; i < alumnos.size(); i++) {
            //Crememos el alumno y lo añadiremos a la raiz
            eleAlumno = doc.createElement("Alumno");
            raiz.appendChild(eleAlumno);
            //Escribiremos dentro del alumno todos sus atributos
            Node nodoCodigoALumno = doc.createElement("CodigoAlu");
            nodoCodigoALumno.setTextContent(alumnos.get(i).getCcodalu());
            eleAlumno.appendChild(nodoCodigoALumno);
            Node nodoNombreALumno = doc.createElement("NombreAlu");
            nodoNombreALumno.setTextContent(alumnos.get(i).getCnomalu());
            eleAlumno.appendChild(nodoNombreALumno);
            //Crearemos los cursos y lo añadiremos al alumno
            eleCursos = doc.createElement("Cursos");
            eleAlumno.appendChild(eleCursos);
            //Buscaremos en la lista de matriculados
            for (int j = 0; j < matriculados.size(); j++) {
                //Eligiremos los que tenga el mismo código que el alumno
                if (matriculados.get(j).getAlumnos().getCcodalu().equals(alumnos.get(i).getCcodalu())) {
                    //Crearemos el curso
                    Node nodoCurso = doc.createElement("Curso");
                    //Crearemos los atributos del curso
                    Node nodoCodigoCurso = doc.createElement("CodigoCur");
                    Node nodoNombreCurso = doc.createElement("NombreCur");
                    Node nodoNExamenesCurso = doc.createElement("NumExamenes");
                    //Guardaremos el curso en el Elemento eleCursos
                    eleCursos.appendChild(nodoCurso);
                    //Escribiremos los atributos del curso
                    nodoCodigoCurso.setTextContent(matriculados.get(i).getCursos().getCcodcurso());
                    nodoNombreCurso.setTextContent(matriculados.get(i).getCursos().getCnomcurso());
                    nodoNExamenesCurso.setTextContent(""+matriculados.get(i).getCursos().getNnumexa());
                    //Guardaremos los atributos del curso en el nodoCurso
                    nodoCurso.appendChild(nodoCodigoCurso);
                    nodoCurso.appendChild(nodoNombreCurso);
                    nodoCurso.appendChild(nodoNExamenesCurso);
                }
            }
        }
        //Comprobaremos que la lista de alumnos no este vacia
        if (alumnos.isEmpty()) {
            //Crearemos el nodo de Alumno y lo guardaremos en la raiz
            eleAlumno = doc.createElement("Alumno");
            raiz.appendChild(eleAlumno);
        }
        //Crearemos el transformador
        Transformer trans = null;
        try {
            trans = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException ex) {
            error = -1;
        }
        //Crearemos el arbol DOM con el documento creado anteriormente
        DOMSource dom = new DOMSource(doc);
        //Guardaremos los resultados en AlumnosCursos.xml
        StreamResult sr = new StreamResult(new File("AlumnosCursos.xml"));
        try {
            //Crearemos el fichero .xml
            trans.transform(dom, sr);
        } catch (TransformerException ex) {
            error = -1;
        }
        return error;
    }
}
