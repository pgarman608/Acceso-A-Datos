package controladores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import modelos.Alumno;
import modelos.Curso;
import modelos.Examen;
import modelos.Matriculado;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author usuario
 */
public class CtlExportar {
    private int error;
    
    public CtlExportar() {
    }
    
    public int exportarBoletin(Matriculado matriculado, ArrayList<Examen> examenes){
        
        error = 0;
        //Tendremos un cursor para que exporte el .json
        File fichero = new File(""+matriculado.getNombreCurso()+""+matriculado.getNombreAlumno()+".json");
        try {
            //Crearemos un FileWriter
            FileWriter escritor = new FileWriter(fichero);
            //Escribiermos el json
            //Primero La matricula con sus atributos
            escritor.write("{\n");
            escritor.write("\t\"CodigoAlumno\": \""+matriculado.getCodigoAlumno()+"\",\n");
            escritor.write("\t\"NombreAlumno\": \""+matriculado.getNombreAlumno()+"\",\n");
            escritor.write("\t\"CodigoCurso\": \""+matriculado.getCodigoCurso()+"\",\n");
            escritor.write("\t\"NombreCurso\": \""+matriculado.getNombreCurso()+"\",\n");
            escritor.write("\t\"NotaMedia\": \""+matriculado.getnExamenes()+"\",\n");
            escritor.write("\t\"Examenes\": [\n");
            //Escribiremos los examenes que tenga el Alumno
            for (int i = 0; i < examenes.size(); i++) {
                escritor.write("\t\t{\n");
                escritor.write("\t\t\t\"Numero\": \""+examenes.get(i).getnExamen()+"\",\n");
                escritor.write("\t\t\t\"Fecha\": \""+examenes.get(i).getFecha()+"\",\n");
                escritor.write("\t\t\t\"Nota\": \""+examenes.get(i).getNota()+"\"\n");
                //EL ultimo } le quitaremos la coma
                if (i < examenes.size()-1) {
                    escritor.write("\t\t},\n");
                }else{
                    escritor.write("\t\t}\n");
                }
                
            }
            escritor.write("\t]\n");
            escritor.write("}");
            //Cerraremos el escritor
            escritor.close();
        } catch (IOException ex) {
            error = -1;
        }
        return error;
    }
    public int exportarMatriculas(ArrayList<Alumno> alumnos,ArrayList<Matriculado> matriculados,ArrayList<Curso> cursos){
        error = 0;
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
            nodoCodigoALumno.setTextContent(alumnos.get(i).getCodigoAlumno());
            eleAlumno.appendChild(nodoCodigoALumno);
            Node nodoNombreALumno = doc.createElement("NombreAlu");
            nodoNombreALumno.setTextContent(alumnos.get(i).getNombre());
            eleAlumno.appendChild(nodoNombreALumno);
            //Crearemos los cursos y lo añadiremos al alumno
            eleCursos = doc.createElement("Cursos");
            eleAlumno.appendChild(eleCursos);
            //Buscaremos en la lista de matriculados
            for (int j = 0; j < matriculados.size(); j++) {
                //Eligiremos los que tenga el mismo código que el alumno
                if (matriculados.get(j).getCodigoAlumno().equals(alumnos.get(i).getCodigoAlumno())) {
                    //Crearemos el curso
                    Node nodoCurso = doc.createElement("Curso");
                    //Crearemos los atributos del curso
                    Node nodoCodigoCurso = doc.createElement("CodigoCur");
                    Node nodoNombreCurso = doc.createElement("NombreCur");
                    Node nodoNExamenesCurso = doc.createElement("NumExamenes");
                    //Guardaremos el curso en el Elemento eleCursos
                    eleCursos.appendChild(nodoCurso);
                    //Escribiremos los atributos del curso
                    nodoCodigoCurso.setTextContent(matriculados.get(i).getCodigoCurso());
                    nodoNombreCurso.setTextContent(matriculados.get(i).getCodigoCurso());
                    nodoNExamenesCurso.setTextContent(""+getNumExamenes(cursos, matriculados.get(i).getCodigoCurso()));
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
    /**
     * Recogeremos de una lista de cursos y su código, el número de exámenes
     * @param cursos La lista de cursos en cual vamos a buscar
     * @param codigo El código que vamos a buscar en la lista
     * @return El numero de Examenes a devolver
     */
    private int getNumExamenes (ArrayList<Curso> cursos,String codigo){
        int numExamenes = 0;
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigoCurso().equals(codigo)) {
                System.out.println(cursos.get(i).getnExamenes());
                numExamenes = cursos.get(i).getnExamenes();
            }
        }
        return numExamenes;
    }
}