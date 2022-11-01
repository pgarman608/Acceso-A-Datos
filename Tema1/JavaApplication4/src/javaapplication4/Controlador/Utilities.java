package javaapplication4.Controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication4.Modelo.Alumno;
import javaapplication4.Modelo.Filtro;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Utilities {
    public static ArrayList<Alumno> alumnos = new ArrayList<>();
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Filtro filtro = new Filtro();
    private int elegirBaja = -1;
    private static final int TAMANIO = 132;
    private static int xne = 0;
    private static Long pos;
    private static RandomAccessFile raf;
    private static DocumentBuilder dber1;
    private static Document doc;
    private static Element raiz;
    
    public static void darAlta(Object[] objetos){
        try {
            alumnos.add(new Alumno(Integer.parseInt((String)objetos[0]),
                    String.valueOf(objetos[1]),
                    (String) objetos[2],
                    Float.parseFloat((String)objetos[3]), 
                    Integer.parseInt((String)objetos[4])));
        }catch (ParseException ex){}
    }
    public static int existeAlumno(int matricula){
        int aux = 1;
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getMatricula() == matricula) {
               aux = -1;
            }
        }
        return aux;
    }
    public static int comprobarTipoAlumno(Object[] aluComprobar){
        int aux = 1;
        Object prueba = null;
        try{
            prueba = Integer.parseInt((String) aluComprobar[0]);
            prueba = String.valueOf(aluComprobar[1]);
            prueba = sdf.parse((String)aluComprobar[2]);
            prueba = Float.parseFloat((String) aluComprobar[3]);
            prueba = Integer.parseInt((String) aluComprobar[4]);
        }catch(Exception ex){
            aux = -1;
        }
        return aux;
    }
    public static int comprobarAlumno(Object[] aluComprobar) throws ParseException{
        int aux = 1;
        if (Integer.parseInt((String)aluComprobar[0]) <= 0 || aluComprobar[1] == null || aluComprobar[1].equals("") 
                || aluComprobar[2] == null || aluComprobar[2].equals("")
                || Float.parseFloat((String) aluComprobar[3]) <= 0.0 ||Integer.parseInt((String)aluComprobar[4]) <= 0) {
            aux = -1;
        }
        return aux;
    }
    public static void bajaAlumno(int Matricula){
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getMatricula() == Matricula) {
                alumnos.remove(i);
            }
        }
    }
    public static Alumno getAlumnoMatricula(int Matricula){
        Alumno alumnoDevolver = null;
        for (Alumno alumno : alumnos) {
            if (alumno.getMatricula() == Matricula) {
                alumnoDevolver = alumno;
            }
        }
        return alumnoDevolver;
    }
    public static int comprobartfFiltros(String[] textFields, int posSelect) {
        int aux = 1;
        int comprobarInt;
        float comprobarFloat;
        Date comprobarDate;
        String comprobarString = textFields[posSelect];
        try {
            switch (posSelect) {
                case 0:
                    comprobarInt = Integer.parseInt(comprobarString);
                    if (comprobarInt <= 0) {
                        aux = -1;
                    }
                    break;
                case 1:
                    if (comprobarString == null || comprobarString.equals("")
                            || comprobarCharEspeciales(comprobarString) == -1) {
                        aux = -1;
                    }
                    break;
                case 2:
                    if (comprobarString == null || comprobarString.equals("")) {
                        aux = -1;
                    }
                    comprobarDate = sdf.parse(comprobarString);
                    break;
                case 3:
                    comprobarFloat = Float.parseFloat(comprobarString);
                    if (comprobarFloat <= 0.0) {
                        aux = -1;
                    }
                    break;
                case 4:
                    comprobarInt = Integer.parseInt(comprobarString);
                    if (comprobarInt <= 0) {
                        aux = -1;
                    }
                    break;
            }
        } catch (Exception e) {aux = -1;}
        return aux;
    }
    public static int comprobarCharEspeciales(String msg){
        int aux = 1;
        for (char caracter : msg.toCharArray()) {
            if (!((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z') || (caracter == ' '))) {
                aux = -1;
            }
        }
        return aux;
    }
    public static int exportarArchivos(File f1, String accion) {
        int error = 1;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        FileWriter fw = null;
        switch (accion) {
            case "Ficheros Planos":
                try {
                    fw = new FileWriter(f1);
                    String guardar = "";
                    for (Alumno alumno : alumnos) {
                        guardar += alumno.toString();
                    }
                    fw.write(guardar);
                    fw.close();
                } catch (IOException ex) {error = -2;}
                break;
            case "Ficheros Serializable":
                try {
                    fileOutputStream = new FileOutputStream(f1);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(alumnos);
                } catch (FileNotFoundException ex) {error=-1;
                } catch (IOException ex) {error = -2;}
                break;
            case "Ficheros de Acceso Random":
                try {
                    raf = new RandomAccessFile(f1,"rw");
                } catch (FileNotFoundException ex) {error = -1;}
                for (Alumno alumno : alumnos) {
                    int asd = calcularPosRAF(alumno.getMatricula());
                    int alta = -1;
                    try {
                        raf.seek(pos);
                        xne = raf.readInt();
                        if (xne == 0) {
                            alta = 0;
                        }
                    } catch (IOException ex) {alta = 0;}
                    if (alta == 0) {
                        try {
                            raf.seek(pos);
                            raf.writeInt(alumno.getMatricula());
                            byte[] nombre = ByteBuffer.allocate(50).put(alumno.getNombre().getBytes()).array();
                            raf.writeChars(new String(nombre));
                            raf.writeChars(alumno.getFechaNac());
                            raf.writeInt(alumno.getEdad());
                            raf.writeFloat(alumno.getNotaMedia());
                        } catch (IOException ex) {error=-2;}
                    }
                }
                try {
                    raf.close();
                } catch (IOException ex) {error=-2;}
                break;
            case "Ficheros XML":
                    try {
                        dber1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        doc = dber1.newDocument();
                        raiz = doc.createElement("Alumnos");
                        doc.appendChild(raiz);
                        for (Alumno alumno : alumnos) {
                            Element eleAlumno = doc.createElement("Alumno");
                            raiz.appendChild(eleAlumno);
                            
                            Element aluMatricula = doc.createElement("Matricula");
                            aluMatricula.setTextContent(""+alumno.getMatricula());
                            eleAlumno.appendChild(aluMatricula);
                            
                            Element aluNombre = doc.createElement("Nombre");
                            aluNombre.setTextContent(""+alumno.getNombre());
                            eleAlumno.appendChild(aluNombre);
                            
                            Element aluFecha = doc.createElement("Fecha");
                            aluFecha.setTextContent(""+alumno.getFechaNac());
                            eleAlumno.appendChild(aluFecha);
                            
                            Element aluNotaM = doc.createElement("NotaMedia");
                            aluNotaM.setTextContent(""+alumno.getNotaMedia());
                            eleAlumno.appendChild(aluNotaM);
                            
                            Element aluEdad = doc.createElement("Edad");
                            aluEdad.setTextContent(""+alumno.getEdad());
                            eleAlumno.appendChild(aluEdad);
                            
                        }
                        Transformer trans = null;
                        try {
                            trans = TransformerFactory.newInstance().newTransformer();
                        } catch (TransformerConfigurationException ex) {error = -5;}
                        DOMSource dom = new DOMSource(doc);
                        StreamResult sr = new StreamResult(f1);
                        trans.transform(dom, sr);
                        } catch (ParserConfigurationException ex) {error = -4;
                        } catch (TransformerException ex) {error = -6;}
                break;
        }
        return error;
    }

    private static int calcularPosRAF(int matricula){
        int error = 1;
        try{
            pos = ((Long.parseLong(""+matricula)-1)*TAMANIO);
        }catch(NumberFormatException nfe){error = -3;}
        return error;
    }
    
    public static int importarArchivos(File f1, String accion) {
        int error = 1;
        FileReader fr1 = null;
        BufferedReader br = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        ArrayList<Alumno> nuevo = new ArrayList<>();
        String[] strAlumno = new String[5];
        switch(accion){
            case "Ficheros Planos":
                try {
                    fr1 = new FileReader(f1);
                    br = new BufferedReader(fr1);
                    String linea = "";
                    while ((linea = br.readLine()) != null) {
                        for (int i = 0; i < 5; i++) {
                            if (i != 4) {
                                strAlumno[i] = linea.substring(0, linea.indexOf("*"));
                                linea = linea.substring(linea.indexOf("*") + 1, linea.length());
                            }else{
                                strAlumno[i] = linea;
                            }
                        }
                        nuevo.add(new Alumno(Integer.parseInt(strAlumno[0])
                                , strAlumno[1], strAlumno[2]
                                , Float.parseFloat(strAlumno[3])
                                , Integer.parseInt(strAlumno[4])));
                    }
                    addArrayAlumnos(nuevo);
                    fr1.close();
                    br.close();
                } catch (FileNotFoundException ex) {error = -1;
                } catch (IOException ex) {error = -2;
                } catch (ParseException ex) {error = -3;}
                break;
            case "Ficheros Serializable":
                try {
                    fileInputStream = new FileInputStream(f1);
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    nuevo = (ArrayList<Alumno>) objectInputStream.readObject();
                    addArrayAlumnos(nuevo);
                    fileInputStream.close();
                    objectInputStream.close();
                } catch (FileNotFoundException ex) {error = -1;
                } catch (IOException ex) {error = -2;
                } catch (ClassNotFoundException ex) {error = -4;}
                break;  
            case "Ficheros de Acceso Random":
                try {
                    raf = new RandomAccessFile(f1,"rw");
                } catch (FileNotFoundException ex) {error = -1;}
                for (int i = 1; i <= (f1.length()/TAMANIO); i++) {
                    calcularPosRAF(i);
                    int alta = -1;
                    try {
                        raf.seek(pos);
                        xne = raf.readInt();
                        if (xne != 0) {
                            alta = 0;
                        }
                    } catch (IOException ex) {
                    }
                    if (alta == 0) {
                        strAlumno[0] = "" + xne;
                        try {
                            byte[] nombre = new byte[100];
                            raf.read(nombre);
                            strAlumno[1] = new String(nombre, StandardCharsets.UTF_8);
                            byte[] fecha = new byte[20];
                            raf.read(fecha);
                            strAlumno[2] = corregirFecha(fecha);
                            strAlumno[4] = "" + raf.readInt();
                            strAlumno[3] = "" + raf.readFloat();
                            System.out.println();
                            nuevo.add(new Alumno(Integer.parseInt(strAlumno[0]),
                                     strAlumno[1], strAlumno[2],
                                     Float.parseFloat(strAlumno[3]),
                                     Integer.parseInt(strAlumno[4])));
                        } catch (IOException ex) {
                            error = -2;
                        } catch (ParseException ex) {
                        }
                        addArrayAlumnos(nuevo);
                    }
                }
                break;
            case "Ficheros XML":
                try {
                    dber1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    doc = dber1.parse(f1);
                    raiz = doc.getDocumentElement();
                    if (raiz.getTagName().equals("Alumnos")) {
                        NodeList nodos1 = raiz.getElementsByTagName("Alumno");
                        for (int i = 0; i < nodos1.getLength(); i++) {
                            NodeList nodos2 = nodos1.item(i).getChildNodes();
                            for (int j = 0; j < nodos2.getLength(); j++) {
                                if (nodos2.item(j) instanceof Element) {
                                    switch (nodos2.item(j).getNodeName()) {
                                        case "Matricula":
                                            strAlumno[0] = nodos2.item(j).getTextContent();
                                            break;
                                        case "Nombre":
                                            strAlumno[1] = nodos2.item(j).getTextContent();
                                            break;
                                        case "Fecha":
                                            strAlumno[2] = nodos2.item(j).getTextContent();
                                            break;
                                        case "NotaMedia":
                                            strAlumno[3] = nodos2.item(j).getTextContent();
                                            break;
                                        case "Edad":
                                            strAlumno[4] = nodos2.item(j).getTextContent();
                                            break;
                                    }
                                }
                            }
                            nuevo.add(new Alumno(Integer.parseInt(strAlumno[0])
                                , strAlumno[1], strAlumno[2]
                                , Float.parseFloat(strAlumno[3])
                                , Integer.parseInt(strAlumno[4])));
                        }
                        addArrayAlumnos(nuevo);
                    }else{
                        error = -7;
                    }
                } catch (ParserConfigurationException ex) {error = -5;
                } catch (SAXException ex) {error = -6;
                } catch (IOException ex) {error = -2;
                } catch (ParseException ex) {}
                break;
        }
        return error;
    }
    private static void addArrayAlumnos(ArrayList<Alumno> nuevo){
        for (int i = 0; i < nuevo.size(); i++) {
            if (Utilities.existeAlumno(nuevo.get(i).getMatricula()) == 1) {
                alumnos.add(nuevo.get(i));
            }
        }
    }
    private static String corregirFecha(byte[] fecha){
        String aux = "";
        for (char chr : new String(fecha).toCharArray()) {
            if ((int)chr != 0) {
                aux += chr;
            }
        }
        return aux;
    }
}