/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serrperry
 */
public class PRueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f1 = new File(".\\Antonio.dat");
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            f1.createNewFile();
            FileOutputStream fos = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Alumno al1 = new Alumno(10,20.,"pa","pa","pa",new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2020"));
            Alumno al2 = new Alumno(10,20.,"la","la","la",new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2020"));
            Alumno al3 = new Alumno(10,20.,"ka","ka","ka",new SimpleDateFormat("dd/MM/yyyy").parse("10/10/2020"));
            alumnos.add(al3);
            alumnos.add(al2);
            alumnos.add(al1);
            for (Alumno alumno : alumnos) {
                oos.writeObject((Object)alumno);
            }
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            String str = "";
            Object obj;
            while ((obj = ois.readObject()) != null) {                
                if (obj instanceof Alumno) {
                    System.out.println(obj); 
                    //obj = ois.readObject();
                }
            }
            ois.close();
            oos.close();
            fis.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error 1");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("Error 3");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PRueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
