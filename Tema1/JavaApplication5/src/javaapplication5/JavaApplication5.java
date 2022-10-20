package javaapplication5;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author usuario
 */
public class JavaApplication5 {
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder bder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc1 = bder.parse(new File("AndroidManifest.xml"));
        Element raiz = doc1.getDocumentElement();
        System.out.println("<"+raiz.getTagName() + ">");
        NodeList nl1 = raiz.getChildNodes();
        for (int i = 0; i < nl1.getLength(); i++) {
            if (nl1.item(i) instanceof Element) {
                loopNodeXml(nl1.item(i),0);
            }
        }
        System.out.println("</"+raiz.getTagName() + ">");
    }
    public static void loopNodeXml(Node n,int numTab) {
        numTab++;
    // Mostramos el del nodo
        if (n.getTextContent() != null && !n.getTextContent().equals("")) {
            System.out.println(getTab(numTab)+"<"+n.getNodeName()+ getAttr(numTab, n)+">");
        }else{
            System.out.println(getTab(numTab)+"<"+n.getNodeName()+ getAttr(numTab, n) + "/>");
        }
        // Obtenemos sus hijos
        NodeList hijos = n.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            // Obtenemos el hijo i
            Node hijo = hijos.item(i);

            // Si es un nodo
            if (hijo.getNodeType() == Node.ELEMENT_NODE) {

                // Recorremos el hijo recursivamente
                loopNodeXml(hijo,numTab);
                
                // si el nodo es un texto y no esta vacio
            } else if (hijo.getNodeType() == Node.TEXT_NODE && !hijo.getTextContent().trim().isEmpty()) {
                // Mostramos el contenido
                System.out.println(getTab(numTab+1) + hijo.getTextContent());
            }
        }
        if (n.getTextContent() != null && !n.getTextContent().equals("")) {
            System.out.println(getTab(numTab)+"</"+n.getNodeName()+">");
        }
        
    }
    private static String getTab(int num){
        String aux = "";
        for (int i = 0; i < num; i++) {
            aux += "\t";
        }
        return aux;
    }
    public static String getAttr(int num,Node hijo){
        String aux = "";
        if (hijo.getAttributes() != null && hijo.getAttributes().getLength() > 0) {
            NamedNodeMap atributos = hijo.getAttributes();
            for (int j = 0; j < atributos.getLength(); j++) {
                aux = "\n";
                Node attr = atributos.item(j);
                aux += getTab(num) + attr.getNodeName() + "=\"" + attr.getTextContent() +"\"";
            }
        }
        return aux;
    }
}
