package javaapplication6;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JavaApplication6 {

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilder dber1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dber1.newDocument();
        Element raiz = doc.createElement("Anio");
        doc.appendChild(raiz);

        for (int i = 1; i <= 12; i++) {
            Element mes = doc.createElement("Mes");
            mes.setTextContent("Mes " + i);
            raiz.appendChild(mes);
        }
        
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        DOMSource dom = new DOMSource(doc);
        StreamResult sr = new StreamResult(new File("prueba.xml"));
        trans.transform(dom, sr);
    }
}
