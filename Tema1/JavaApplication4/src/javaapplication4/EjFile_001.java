/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class EjFile_001 {

    private static File f1;
    
    public static void main(String[] args) {
        /**
         * Forma sencilla pero no podremos ver propiedades de los archivos
         * f1 = new File("."); //Coje todos los ficheros de la carpeta JavaApplication4
         * String[] listaFicheros = f1.list(); //Los guardas en un array statico
         * for (String listaFichero : listaFicheros) {
         *      System.out.println(listaFichero); //Los representas en "Pantalla" 
         * }
         * Ver atributos de una lista de files
         * f1 = new File("."); File[] listaFicheros = f1.listFiles(); //En vez
         *                                                            de usar un
         *      array de string usamos un array de File 
         * for (File listaFichero : listaFicheros) {
         *      System.out.println(listaFichero.canExecute()); //En este bucle
         *                                                  pondremos sout para 
                                                            ver atributos
         * }
         * Crear e eliminar archivos
        f1 = new File("C:\\Users\\usuario\\Desktop\\prueba.txt");
        System.out.println(f1.getAbsoluteFile());
        if (f1.exists()) {
            System.out.println("El fichero existe");
            int opcion = JOptionPane.showConfirmDialog(null, "Deseas eliminarlo");
            if (opcion == 0) {
                f1.delete();
                JOptionPane.showMessageDialog(null,"Archivo eliminado");
            }
        }else{
            System.out.println("El fichero no existe");
            try{
                f1.createNewFile();
            }catch(IOException e){
                JOptionPane.showMessageDialog(null,"No se ha podido crear el archivo");
            }
            JOptionPane.showMessageDialog(null,"Archivo creado");
        }
         */
        if (args.length == 1) {
            f1 = new File(args[0]);
            //Hacer lo que hemos hecho en la anterior codigos
            //...
        }
    }
}
