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
    
    public static void darAlta(String[] objetos){
        //Cogeremos el array de String y lo guardaremos como alumno en el array
        //de alumnos
        try {
            alumnos.add(new Alumno(Integer.parseInt(objetos[0]),
                    objetos[1],
                    objetos[2],
                    Float.parseFloat(objetos[3]), 
                    Integer.parseInt(objetos[4])));
        }catch (ParseException ex){}
    }
    public static int existeAlumno(int matricula){
        int aux = 1;
        //Comprobaremos si existe el número de matrícula introducido.
        //Si no existe devolveremos -1
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getMatricula() == matricula) {
               aux = -1;
            }
        }
        return aux;
    }
    public static int comprobarTipoAlumno(String[] aluComprobar){
        int aux = 1;
        Object prueba = null;
        try{
            //Comprobaremos el tipo de alumno intentándolo pasar a otro tipo
            //de variable. Si da una excepción sacamos un -1
            prueba = Integer.parseInt(aluComprobar[0]);
            prueba = aluComprobar[1];
            prueba = sdf.parse(aluComprobar[2]);
            prueba = Float.parseFloat(aluComprobar[3]);
            prueba = Integer.parseInt(aluComprobar[4]);
        }catch(Exception ex){
            aux = -1;
        }
        return aux;
    }
    public static int comprobarAlumno(String[] aluComprobar) throws ParseException{
        //Comprobamos que la informacion del array de string es correcta
        //Si la informacion es incorrecta devolverá un -1
        int aux = 1;
        if (Integer.parseInt(aluComprobar[0]) <= 0 || aluComprobar[1] == null || aluComprobar[1].equals("") 
                || aluComprobar[2] == null || aluComprobar[2].equals("")
                || Float.parseFloat(aluComprobar[3]) <= 0.0 ||Integer.parseInt(aluComprobar[4]) <= 0) {
            aux = -1;
        }
        return aux;
    }
    public static void bajaAlumno(int Matricula){
        //Borraremos el alumno del array indicando por el número de matrícula pasado por parámetro
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getMatricula() == Matricula) {
                alumnos.remove(i);
            }
        }
    }
    public static Alumno getAlumnoMatricula(int Matricula){
        Alumno alumnoDevolver = null;
        //Devolveremos un alumno con el número de matrícula pasado por parámetro
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
        //En este método comprobaremos según la posición introducida por parámetro 
        //si la información es correcta del array de String. Si es incorrecta 
        //la información sacaremos un -1
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
        //Comprobaremos que el string no tenga números o caracteres especiales
        for (char caracter : msg.toCharArray()) {
            if (!((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z') || (caracter == ' '))) {
                aux = -1;
            }
        }
        return aux;
    }
    public static int exportarArchivos(File f1, String accion) {
        int error = 1;
        //Tendremos un switch para la acción introducida por un parámetro tipo string y según la acción exportaremos al cursor introducido 
        //Si alguna exportación da error devolverá un int
        switch (accion) {
            case "Ficheros Planos":
                error = exportPlanos(f1);
                break;
            case "Ficheros Serializable":
                error = exportSerializable(f1);
                break;
            case "Ficheros de Acceso Random":
                error = exportRAF(f1);
                break;
            case "Ficheros XML":
                error = exportXML(f1);
                break;
            case "Ficheros JSON":
                error = exportPlanos(f1);
                break;
        }
        return error;
    }
    private static int exportPlanos(File f1){
        int error = 1;
        FileWriter fw = null;
        //Exportaremos a un fichero plano con el cursor introducido por parámetro 
        //y guardaremos el toString de todos los alumnos del array
        //Si da alguna excepción devolverá un número entero negativo
        try {
            fw = new FileWriter(f1);
            String guardar = "";
            for (Alumno alumno : alumnos) {
                guardar += alumno.toString();
            }
            fw.write(guardar);
            fw.close();
        } catch (IOException ex) {
            error = -1;
        }
        return error;
    }
    private static int exportSerializable(File f1){
        int error = 1;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        //Exportaremos a un fichero serializadle el arraylist de alumnos al cursor
        //introducido por parámetro
        //Si da alguna excepción devolveremos un número negativo
        try {
            fileOutputStream = new FileOutputStream(f1);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(alumnos);
        } catch (FileNotFoundException ex) {
            error = -2;
        } catch (IOException ex) {
            error = -1;
        }
        return error;
    }
    private static int exportRAF(File f1){
        int error = 1;
        //Exportaremos a un fichero de acceso aleatorio cada alumno del arraylist 
        //de alumnos teniendo en cuenta el cursor pasado por parámetro y 
        //el ID que será la matrícula de cada alumno
        //Si da alguna excepción devolveremos un número negativo
        try {
            raf = new RandomAccessFile(f1, "rw");
        } catch (FileNotFoundException ex) {
            error = -2;
        }
        for (Alumno alumno : alumnos) {
            error = calcularPosRAF(alumno.getMatricula());
            int alta = -1;
            try {
                raf.seek(pos);
                xne = raf.readInt();
                if (xne == 0) {
                    alta = 0;
                }
            } catch (IOException ex) {
                alta = 0;
            }
            if (alta == 0) {
                try {
                    raf.seek(pos);
                    raf.writeInt(alumno.getMatricula());
                    byte[] nombre = ByteBuffer.allocate(50).put(alumno.getNombre().getBytes()).array();
                    raf.writeChars(new String(nombre));
                    raf.writeChars(alumno.getFechaNac());
                    raf.writeInt(alumno.getEdad());
                    raf.writeFloat(alumno.getNotaMedia());
                } catch (IOException ex) {
                    error = -1;
                }
            }
        }
        try {
            raf.close();
        } catch (IOException ex) {error = -1;}
        return error;
    }
    private static int exportXML(File f1){
        int error = 1;
        //Exportaremos a un fichero XML cada alumno del arraylist de alumnos teniendo
        //en cuenta el cursor pasado por parámetro
        //Si da alguna excepción devolveremos un número negativo
        try {
            dber1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = dber1.newDocument();
            raiz = doc.createElement("Alumnos");
            doc.appendChild(raiz);
            for (Alumno alumno : alumnos) {
                Element eleAlumno = doc.createElement("Alumno");
                raiz.appendChild(eleAlumno);

                Element aluMatricula = doc.createElement("Matricula");
                aluMatricula.setTextContent("" + alumno.getMatricula());
                eleAlumno.appendChild(aluMatricula);

                Element aluNombre = doc.createElement("Nombre");
                aluNombre.setTextContent("" + alumno.getNombre());
                eleAlumno.appendChild(aluNombre);

                Element aluFecha = doc.createElement("Fecha");
                aluFecha.setTextContent("" + alumno.getFechaNac());
                eleAlumno.appendChild(aluFecha);

                Element aluNotaM = doc.createElement("NotaMedia");
                aluNotaM.setTextContent("" + alumno.getNotaMedia());
                eleAlumno.appendChild(aluNotaM);

                Element aluEdad = doc.createElement("Edad");
                aluEdad.setTextContent("" + alumno.getEdad());
                eleAlumno.appendChild(aluEdad);

            }
            Transformer trans = null;
            try {
                trans = TransformerFactory.newInstance().newTransformer();
            } catch (TransformerConfigurationException ex) {
                error = -4;
            }
            DOMSource dom = new DOMSource(doc);
            StreamResult sr = new StreamResult(f1);
            trans.transform(dom, sr);
        } catch (ParserConfigurationException ex) {
            error = -3;
        } catch (TransformerException ex) {
            error = -5;
        }
        return error;
    }
    private static int calcularPosRAF(int matricula){
        int error = 1;
        //Calcularemos la posicion del cursor para los archivos de acceso aleatorio
        //teniendo en cuenta el numero de la traicula introducida por parámetro
        //Si da alguna excepción devolveremos un número negativo
        try{
            pos = ((Long.parseLong(""+matricula)-1)*TAMANIO);
        }catch(NumberFormatException nfe){error = -6;}
        return error;
    }
    
    public static int importarArchivos(File f1, String accion) {
        int error = 1;
        ArrayList<Alumno> nuevo = new ArrayList<>();
        String[] strAlumno = new String[5];
        //Tendremos un switch para la acción introducida por un parámetro tipo 
        //string y según la acción  importar a un nuevo array de alumnos el 
        //array pasandolos por un array de String
        //Si alguna importación da error devolverá un int
        switch(accion){
            case "Ficheros Planos":
                error = importPlanos(f1, nuevo, strAlumno);
                break;
            case "Ficheros Serializable":
                error = importSerializabe(f1, nuevo);
                break;  
            case "Ficheros de Acceso Random":
                error = importRAF(f1, nuevo, strAlumno);
                break;
            case "Ficheros XML":
                error = importXML(f1,nuevo,strAlumno);
                break;
            case "Ficheros JSON":
                error = importPlanos(f1, nuevo, strAlumno);
                break;
        }
        return error;
    }
    private static int importXML(File f1,ArrayList<Alumno> nuevo,String[] strAlumno){
        int error = 1;
        //Importaremos desde un fichero XML la información de los alumnos
        //introduciéndolo en el arraylist nuevo. Al final lo pasaremos el array de
        //alumnos nuevo al array de alumnos general
        //Si da alguna excepción devolveremos un número negativo
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
                    nuevo.add(new Alumno(Integer.parseInt(strAlumno[0]),
                             strAlumno[1], strAlumno[2],
                             Float.parseFloat(strAlumno[3]),
                             Integer.parseInt(strAlumno[4])));
                }
                addArrayAlumnos(nuevo);
            } else {
                error = -7;
            }
        } catch (ParserConfigurationException ex) {
            error = -3;
        } catch (SAXException ex) {
            error = -9;
        } catch (IOException ex) {
            error = -1;
        } catch (ParseException ex) {error = -8;}
        return error;
    }
    private static int importRAF(File f1,ArrayList<Alumno> nuevo,String[] strAlumno){
        int error = 1;
        //Importaremos desde un fichero de acceso aleatorio teniendo en cuenta el 
        //cursor, el número de alumnos que puede haber en el fichero y pasando
        //primero todos los alumnos a un array de string. Para terminar guardo 
        //cada alumno en el array de alumnos nuevo y despues viejo teniendo en cuenta 
        //que no se repita el número de matrícula
        //Si da alguna excepción devolveremos un número negativo
        try {
            raf = new RandomAccessFile(f1, "rw");
        } catch (FileNotFoundException ex) {
            error = -1;
        }
        for (int i = 1; i <= (f1.length() / TAMANIO); i++) {
            error = calcularPosRAF(i);
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
                    strAlumno[1] = new String(nombre, StandardCharsets.UTF_16);
                    byte[] fecha = new byte[20];
                    raf.read(fecha);
                    strAlumno[2] = new String(fecha, StandardCharsets.UTF_16);
                    strAlumno[4] = "" + raf.readInt();
                    strAlumno[3] = "" + raf.readFloat();
                    System.out.println();
                    nuevo.add(new Alumno(Integer.parseInt(strAlumno[0]),
                            strAlumno[1], strAlumno[2],
                            Float.parseFloat(strAlumno[3]),
                            Integer.parseInt(strAlumno[4])));
                } catch (IOException ex) {error = -1;
                } catch (ParseException ex) {error =-8;}
                addArrayAlumnos(nuevo);
                try {
                    raf.close();
                } catch (IOException ex) {error=-1;}
            }
        }
        return error;
    }
    private static int importSerializabe(File f1,ArrayList<Alumno> nuevo){
        int error = 1;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        //Importaremos desde un fichero serializable teniendo en cuenta el 
        //cursor y pasando el array de alumnos que hay dentro al array general
        //de alumnos
        //Si da alguna excepción devolveremos un número negativo
        try {
            fileInputStream = new FileInputStream(f1);
            objectInputStream = new ObjectInputStream(fileInputStream);
            nuevo = (ArrayList<Alumno>) objectInputStream.readObject();
            addArrayAlumnos(nuevo);
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException ex) {
            error = -2;
        } catch (IOException ex) {
            error = -1;
        } catch (ClassNotFoundException ex) {
            error = -10;
        }
        return error;
    }
    private static int importPlanos(File f1,ArrayList<Alumno> nuevo,String[] strAlumno){
        int error = 1;
        FileReader fr1 = null;
        BufferedReader br = null;
        //Importaremos desde un fichero plano teniendo en cuenta el cursor, 
        //recogiendo la información del fichero dividido en asteriscos al array 
        //de alumnos nuevo y a su vez al array de alumnos general
        //Si da alguna excepción devolveremos un número negativo
        try {
            fr1 = new FileReader(f1);
            br = new BufferedReader(fr1);
            String linea = "";
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < 5; i++) {
                    if (i != 4) {
                        strAlumno[i] = linea.substring(0, linea.indexOf("*"));
                        linea = linea.substring(linea.indexOf("*") + 1, linea.length());
                    } else {
                        strAlumno[i] = linea;
                    }
                }
                nuevo.add(new Alumno(Integer.parseInt(strAlumno[0]),
                         strAlumno[1], strAlumno[2],
                         Float.parseFloat(strAlumno[3]),
                         Integer.parseInt(strAlumno[4])));
            }
            addArrayAlumnos(nuevo);
            fr1.close();
            br.close();
        } catch (FileNotFoundException ex) {
            error = -2;
        } catch (IOException ex) {
            error = -1;
        } catch (ParseException ex) {
            error = -8;
        }
        return error;
    }
    private static void addArrayAlumnos(ArrayList<Alumno> nuevo){
        //Añadiremos los alumnos de array de alumnos nuevo al array de alumnos nuevo
        //teniendo en cuenta que que el numero de matricula no se repite
        for (int i = 0; i < nuevo.size(); i++) {
            if (Utilities.existeAlumno(nuevo.get(i).getMatricula()) == 1) {
                alumnos.add(nuevo.get(i));
            }
        }
    }
    public static String sacarError(int error){
        String aux = "";
        //Según el numero que introduzcamos por parametro nos sacará un texto
        //con el error seleccionado
        switch(error){
            case -1:
                aux = "Error de I/O";
                break;
            case -2:
                aux = "Error de fichero no encontrado";
                break;
            case -3:
                aux = "Error de XML/ParseConf";
                break;
            case -4:
                aux = "Error de XML/TransConf";
                break;
            case -5:
                aux = "Error de XML/Trans";
                break;
            case -6:
                aux = "Error de formato de numero";
                break;
            case -7:
                aux = "No encuentra el alumno";
                break;
            case -8:
                aux = "Error de Parseo";
                break;
            case -9:
                aux = "Error de XML/SAX";
                break;
            case -10:
                aux = "Error de clase no encontrada";
                break;
        }
        return aux;
    }
}