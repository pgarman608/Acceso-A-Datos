package javaapplication4;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Serrperry
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //Crearemos un documentbuilder a partir del DocumentBuilderFactory
        //Para crear el Document del xml que necesitemos 
        // @Exception ParseConfigurationException
        DocumentBuilder dber = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        //Con el documentBuilder haremos un parse de un fichero que eligamos xml
        // @Exception SAXException, IOException
        Document doc1 = dber.parse(new File("catalogo1.xml"));
        //Con el document sacaremos el elemento o nodo raiz del xml
        Element raiz = doc1.getDocumentElement();
        //Con el getTagName() nos devuelve el nombre de la tag string
        System.out.println("<"+raiz.getTagName()+">");
        //Con el metodo getElementsByTagName(String) nos devolvera una lista de 
        //elements hijos del elemento anterior con el nombre de la tag seleccionado
        NodeList nodelist = doc1.getElementsByTagName("CD");
        //Con el metodo getlenght() nos dira el numero de nodos o element que ha
        //encontrado
        for (int i = 0; i < nodelist.getLength(); i++) {
            //Con el item(int) nos dara el nodo o elemento en esa posicion con
            //el int
            Node node = nodelist.item(i);
            //Con el getNodeName() nos dara el nombre del nodo <(nombre)>
            //Con el getTextContent() nos dara el texto dentro de las boquillas
            //<>(texto)<>
            System.out.println("\t<"+node.getNodeName()+"> " + node.getTextContent() + " </" + node.getNodeName() + ">");
        }
        System.out.println("</"+raiz.getTagName()+">");
    }
}
