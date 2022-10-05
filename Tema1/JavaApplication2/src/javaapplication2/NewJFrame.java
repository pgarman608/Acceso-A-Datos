/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.EOFException;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class NewJFrame extends javax.swing.JFrame{

    private ArrayList<Alumno> alumnos;
    private final String file = ".//Adapter.dat";
    private DefaultTableModel modelo;
    public NewJFrame() {
        initComponents();
        this.setTitle("Alumnos | Fechas y Files 16bits");
        this.alumnos = new ArrayList<>();
        this.modelo = (DefaultTableModel) this.jt_Alumnos.getModel();
        this.jt_Alumnos.setModel(this.modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jtf_apellido1 = new javax.swing.JTextField();
        jtf_apellido2 = new javax.swing.JTextField();
        jtf_NotaM = new javax.swing.JTextField();
        jtf_Exp = new javax.swing.JTextField();
        jtf_Fecha = new javax.swing.JTextField();
        jb_Alta = new javax.swing.JButton();
        jb_Guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Alumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 380));

        jLabel1.setText("Alumno/s:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido 1:");

        jLabel4.setText("Apellido 2:");

        jLabel5.setText("Nota Media:");

        jLabel6.setText("Experiencia:");

        jLabel7.setText("Fecha de Nacimento");

        jb_Alta.setText("Dar de Alta");
        jb_Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_AltaActionPerformed(evt);
            }
        });

        jb_Guardar.setText("Guardar");
        jb_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_GuardarActionPerformed(evt);
            }
        });

        jt_Alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido 1", "Apellido 2", "Num Exp", "Nota Media", "FechaNac"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_Alumnos);
        if (jt_Alumnos.getColumnModel().getColumnCount() > 0) {
            jt_Alumnos.getColumnModel().getColumn(0).setResizable(false);
            jt_Alumnos.getColumnModel().getColumn(1).setResizable(false);
            jt_Alumnos.getColumnModel().getColumn(2).setResizable(false);
            jt_Alumnos.getColumnModel().getColumn(3).setResizable(false);
            jt_Alumnos.getColumnModel().getColumn(4).setResizable(false);
            jt_Alumnos.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setText("Actualizar Tabla");
        jButton1.setActionCommand("jb_Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_nombre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_apellido1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_apellido2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_NotaM))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jtf_Exp))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jb_Alta))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb_Guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jtf_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(479, 479, 479)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtf_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtf_apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtf_NotaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtf_Exp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtf_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jb_Alta)
                            .addComponent(jb_Guardar)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Llamaremos a comprobar datos para que nos saque el alumno
     * Lo añadiremos al arrayList que esta fuera del metodo
     * Pondremos todos los datos vacios
     * Sacaremos por pantalla un mensaje de que se a podido dar de alta
     * @param evt 
     */
    private void jb_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_AltaActionPerformed
        this.alumnos.add(this.comprobarDatos());
        this.jtf_Exp.setText("");
        this.jtf_Fecha.setText("");
        this.jtf_NotaM.setText("");
        this.jtf_apellido1.setText("");
        this.jtf_apellido2.setText("");
        this.jtf_nombre.setText("");
        JOptionPane.showMessageDialog(this, "Se ha dado de alta al alumno correctamente");
    }//GEN-LAST:event_jb_AltaActionPerformed
    /**
     * Escribiremos el ArrayList de alumnos en el archivo seleccionado
     * Cerraremos los objetos de escribir para no tener problemas
     * Castearemos las Excepciones 
     * Sacaremos por pantalla un mensaje de que se a podido guardar
     * @param evt 
     */
    private void jb_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_GuardarActionPerformed
        File f1 = new File(this.file);
        FileOutputStream fos1;
        ObjectOutputStream oos1;
        try {
            fos1 = new FileOutputStream(f1,false);
            oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(alumnos);
            fos1.close();
            oos1.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error1");
        } catch (IOException ex) {
            System.out.println("Error2");
        }
        JOptionPane.showMessageDialog(this, "Todos los alumnos guardados en la"
                + " base de datos");
    }//GEN-LAST:event_jb_GuardarActionPerformed
    /**
     * Guardaremos todos los datos del Array que hemos sacado del fichero en una Tabla
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<Alumno> alu3 = this.actualizarTabla();
        Object[] obja = new Object[6];
        for (int i = 0; i < alu3.size(); i++) {
            obja[0] = alu3.get(i).getNombre();
            obja[1] = alu3.get(i).getApellido1();
            obja[2] = alu3.get(i).getApellido2();
            obja[3] = alu3.get(i).getNumExp();
            obja[4] = alu3.get(i).getNotaMedia();
            obja[5] = alu3.get(i).getFechaNacCompleto();
            this.modelo.addRow(obja);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Leeremos el Arraylist de alumnos guardado en fichero para guardarlos en la tabla
     * @return El ArrayList de alumnos del fichero
     */
    private Alumno comprobarDatos(){
       int ne;
       double nm;
       Date fn = null;
       String aux;
       Alumno alumno = null;
       ne = Integer.parseInt(this.jtf_Exp.getText());
       nm = Double.parseDouble(this.jtf_NotaM.getText());
       aux = this.jtf_Fecha.getText().toString();
       try{
            fn = new SimpleDateFormat("dd/MM/yyyy").parse(aux);
            alumno = new Alumno(ne,nm,this.jtf_nombre.getText(),
            this.jtf_apellido1.getText(),this.jtf_apellido2.getText(),fn);
        }catch(ParseException e){
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto (dd/mm/yyyy)");
        }
       return alumno;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    @SuppressWarnings("unchecked")
    private ArrayList<Alumno> actualizarTabla(){
        File f1 = new File(this.file);
        FileInputStream fis1;
        ObjectInputStream ois1;
        ArrayList<Alumno> alumnos2 = new ArrayList<>();
        try {
            fis1 = new FileInputStream(f1);
            ois1 = new ObjectInputStream(fis1);
            alumnos2 = (ArrayList<Alumno>) ois1.readObject();
            fis1.close();
            ois1.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error 1");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error 2");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return alumnos2;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_Alta;
    private javax.swing.JButton jb_Guardar;
    private javax.swing.JTable jt_Alumnos;
    private javax.swing.JTextField jtf_Exp;
    private javax.swing.JTextField jtf_Fecha;
    private javax.swing.JTextField jtf_NotaM;
    private javax.swing.JTextField jtf_apellido1;
    private javax.swing.JTextField jtf_apellido2;
    private javax.swing.JTextField jtf_nombre;
    // End of variables declaration//GEN-END:variables
}
