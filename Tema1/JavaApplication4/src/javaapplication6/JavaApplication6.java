/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class JavaApplication6 {

    private static File f;
    private static FileReader fr;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Apuntamos a un fichero con esa ruta
        f = new File(".//src//javaapplication6//JavaApplication6.java");
        // Comprobaremos si el fichero al que apunta exite, si es un fichero 
        // y si se puede leer
        if (f.exists() && f.isFile() && f.canRead()) {
            // Nos crearemos un lectpr para poder leer la informacion del archivo
            // que hemos apuntado anterior mente
            fr = new FileReader(f);
            //Creo una variable auxiliar para guardarnos las letras que hiremos
            //leyendo del fichero
            int aux = 1;
            while(aux != -1){
                aux = fr.read();
                System.out.print((char)aux);
                //Puede que el archivo esté corrupto Hacer trycatch
            }
            JOptionPane.showMessageDialog(null, "Mensaje terminado");
            fr.close();
        }else{
            JOptionPane.showMessageDialog(null, "No existe el fichero");
        }
        
    }
}
