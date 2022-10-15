
import java.awt.event.MouseEvent;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.FILES_ONLY;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class Index extends javax.swing.JFrame {
    private SimpleDateFormat dateFormat;
    private DefaultTableModel modelo;
    private ArrayList<Alumno> alumnos;
    private File f1;
    private FileReader fr1;
    private FileWriter fw1;
    private FileInputStream fis1;
    private FileOutputStream fos1;
    private ObjectInputStream ois1;
    private ObjectOutputStream oos1;
    private int valorTabla;
    private JFileChooser jfc;
    public Index() {
        initComponents();
        this.setTitle("Examen 1 | Acceso a datos | Pablo Garcia");
        modelo = (DefaultTableModel) jt_Alumnos.getModel();
        alumnos = new ArrayList<Alumno>();
        jt_Alumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jfc = new JFileChooser();
        jtf_Export.setEditable(false);
        jt_Alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jt_Alumnos.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    valorTabla = Integer.parseInt(jt_Alumnos.getValueAt(row, 0).toString());
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                valorTabla =0;
            }
        });
        jcb_import.setSelectedItem("Hola");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbt_Alta = new javax.swing.JButton();
        jbt_Baja = new javax.swing.JButton();
        jbt_Modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Alumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_import = new javax.swing.JTextField();
        jcb_import = new javax.swing.JComboBox<>();
        jbt_Import = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcb_Export = new javax.swing.JComboBox<>();
        jtf_Export = new javax.swing.JTextField();
        jbt_Export = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jbt_Alta.setText("Alta");
        jbt_Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_AltaActionPerformed(evt);
            }
        });

        jbt_Baja.setText("Baja");
        jbt_Baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_BajaActionPerformed(evt);
            }
        });

        jbt_Modificar.setText("Modificar");
        jbt_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ModificarActionPerformed(evt);
            }
        });

        jt_Alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nombre", "Fecha Nacimiento", "Nota Media", "Edad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_Alumnos);

        jLabel1.setText("Importar a:");

        jLabel2.setText("Destino:");

        jLabel3.setText("Nombre:");

        jcb_import.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ficheros Objetos Serializables", "Ficheros de texto" }));

        jbt_Import.setText("Buscar");
        jbt_Import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ImportActionPerformed(evt);
            }
        });

        jLabel4.setText("Exportar a:");

        jLabel5.setText("Destino:");

        jLabel6.setText("Nombre:");

        jcb_Export.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ficheros Objetos Serializables", "Ficheros de texto" }));

        jbt_Export.setText("Buscar");
        jbt_Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbt_Alta)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_Baja)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_Modificar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcb_import, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_Export, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_import, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jtf_Export, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbt_Import)
                            .addComponent(jbt_Export))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_Alta)
                    .addComponent(jbt_Baja)
                    .addComponent(jbt_Modificar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_import, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_import, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_Import))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_Export, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_Export, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jbt_Export))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_AltaActionPerformed
        Alumno alumno = new Alumno();
        alumno.setMatricula(Integer.parseInt(JOptionPane.showInputDialog(this,
                "Introduce el numero de matricula")));
        alumno.setNombre(JOptionPane.showInputDialog(this, "Introduce el Nombre"));
        alumno.setFecha(JOptionPane.showInputDialog(this, "Introduce la fecha"));
        alumno.setNotaM(Integer.parseInt(JOptionPane.showInputDialog(this,
                "Introduce la nota media del alumno")));
        alumno.setEdad(Integer.parseInt(JOptionPane.showInputDialog(this,
                "Introduce la edad del alumno")));
        System.out.println(alumno.toString());
        this.alumnos.add(alumno);
        JOptionPane.showMessageDialog(this, "Alumno añadido");
        this.actualizarTabla();
    }//GEN-LAST:event_jbt_AltaActionPerformed

    private void jbt_BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_BajaActionPerformed
        try {
            for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = alumnos.get(i);
                if (alumno.getMatricula() == valorTabla) {
                    alumnos.remove(i);
                    JOptionPane.showMessageDialog(this, "Alumno elimniado");
                }
            }
        } catch (NumberFormatException e) {}
        this.actualizarTabla();
    }//GEN-LAST:event_jbt_BajaActionPerformed

    private void jbt_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ModificarActionPerformed
        try{
            for (int i = 0; i < alumnos.size(); i++) {
                Alumno alumno = alumnos.get(i);
                if (alumno.getMatricula() == valorTabla) {
                    alumnos.get(i).setMatricula(Integer.parseInt(
                            JOptionPane.showInputDialog(this,
                                    "Introduce el nuevo numero de matricula")));
                    alumnos.get(i).setNombre(JOptionPane.showInputDialog(this,
                            "Introduce el nuevo Nombre"));
                    alumnos.get(i).setNotaM(Integer.parseInt(
                            JOptionPane.showInputDialog(this,
                                    "Introduce la nueva nota media del alumno")));
                    alumnos.get(i).setFecha(JOptionPane.showInputDialog(this,
                            "Introduce la nueva fecha de Nacimiento"));
                    alumnos.get(i).setEdad(Integer.parseInt(
                            JOptionPane.showInputDialog(this,
                                    "Introduce la edad del alumno")));
                    JOptionPane.showMessageDialog(this, "Alumno elimniado");
                }
            }
        }catch(NumberFormatException ex){}
        this.actualizarTabla();
    }//GEN-LAST:event_jbt_ModificarActionPerformed

    private void jbt_ImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ImportActionPerformed
        jfc.setFileSelectionMode(FILES_ONLY);
        jfc.setDialogTitle("Elige el fichero que desee importar");
        jfc.showDialog(this, "Aceptar");
        f1 = jfc.getSelectedFile();
        jtf_import.setText(f1.toString());
        if ("Ficheros Objetos Serializables".equals(jcb_import.getSelectedItem()) ) {
            try {
                fis1 = new FileInputStream(f1);
                ois1 = new ObjectInputStream(fis1);
                ArrayList<Alumno> alumnos2 = (ArrayList<Alumno>) ois1.readObject();
                for (Alumno alumno : alumnos2) {
                    alumnos.add(alumno);
                }
                fis1.close();
                ois1.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se a encontrado el fichero");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error de I/O");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se encuentra la clase en el fichero");
            }
        }else{
            try {
                fr1 = new FileReader(f1);
                BufferedReader br1 = new BufferedReader(fr1);
                String aux = br1.readLine();
                int dividir = aux.indexOf('*');
                int dividir2 = 0;
                while(dividir != -1){
                    String aux2 = aux.substring(dividir2,dividir);

                }
                
                
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se a encontrado el fichero");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error de I/O");
            }
        }
        this.actualizarTabla();
    }//GEN-LAST:event_jbt_ImportActionPerformed

    private void jbt_ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ExportActionPerformed
        jfc.setFileSelectionMode(FILES_ONLY);
        jfc.setDialogTitle("Elige el fichero que desee importar");
        jfc.showDialog(this, "Aceptar");
        f1 = jfc.getSelectedFile();
        jtf_Export.setText(f1.toString());
        if ("Ficheros Objetos Serializables".equals(jcb_import.getSelectedItem()) ) {
            try {
                fos1 = new FileOutputStream(f1);
                oos1 = new ObjectOutputStream(fos1);
                oos1.writeObject(alumnos);
                fos1.close();
                oos1.close();
            }  catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "No se a encontrado el fichero");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error de I/O");
            }
        }else{
            try {
                fw1 = new FileWriter(f1);
                for (Alumno alumno : alumnos) {
                    fw1.write(alumno.toString());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error de I/O");
            }
        }
    }//GEN-LAST:event_jbt_ExportActionPerformed
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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_Alta;
    private javax.swing.JButton jbt_Baja;
    private javax.swing.JButton jbt_Export;
    private javax.swing.JButton jbt_Import;
    private javax.swing.JButton jbt_Modificar;
    private javax.swing.JComboBox<String> jcb_Export;
    private javax.swing.JComboBox<String> jcb_import;
    private javax.swing.JTable jt_Alumnos;
    private javax.swing.JTextField jtf_Export;
    private javax.swing.JTextField jtf_import;
    // End of variables declaration//GEN-END:variables
    private void actualizarTabla(){
        this.modelo.setRowCount(0);
        for (Alumno alumno : alumnos) {
            Object[] obj = new Object[5];
            obj[0] = alumno.getMatricula();
            obj[1] = alumno.getNombre();
            obj[2] = alumno.getFecha();
            obj[3] = alumno.getNotaM();
            obj[4] = alumno.getEdad();
            this.modelo.addRow(obj);
        }
    }
}
