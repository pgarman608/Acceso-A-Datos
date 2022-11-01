
package javaapplication4.Vista;

import java.io.File;
import javaapplication4.Controlador.Utilities;
import javaapplication4.Modelo.Alumno;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Index extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private int numMatriculaTabla = -1;
    private JFileChooser elegirFichero;
    private TableRowSorter tableRS;
    public Index() {
        initComponents();
        //Tendremos un modelo de la tabla para poder añadir y eliminar
        modelo = (DefaultTableModel) this.jt_Alumnos.getModel();
        jt_Alumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Inicializar
        elegirFichero = new JFileChooser();
        elegirFichero.setFileSelectionMode(JFileChooser.FILES_ONLY);
        tableRS = new TableRowSorter(modelo);
        jt_Alumnos.setRowSorter(tableRS);
        jt_Alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int row = jt_Alumnos.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    numMatriculaTabla = (int) jt_Alumnos.getValueAt(row, 0);
                }
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                numMatriculaTabla = -1;
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbt_Alta = new javax.swing.JButton();
        jbt_Baja = new javax.swing.JButton();
        jbt_Editar = new javax.swing.JButton();
        jbt_Filtro = new javax.swing.JButton();
        jbt_EliFiltro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Alumnos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcb_Importar = new javax.swing.JComboBox<>();
        jtf_Importar = new javax.swing.JTextField();
        jbt_Importar = new javax.swing.JButton();
        jbt_Buscar_I = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcb_Exportar = new javax.swing.JComboBox<>();
        jbt_Exportar = new javax.swing.JButton();
        jtf_Exportar = new javax.swing.JTextField();
        jbt_Buscar_E = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Examen 1-2");
        setPreferredSize(new java.awt.Dimension(600, 600));
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

        jbt_Editar.setText("Editar");
        jbt_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_EditarActionPerformed(evt);
            }
        });

        jbt_Filtro.setText("Filtro");
        jbt_Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_FiltroActionPerformed(evt);
            }
        });

        jbt_EliFiltro.setText("Eli. Filtro");
        jbt_EliFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_EliFiltroActionPerformed(evt);
            }
        });

        jt_Alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nombre", "Fecha Nac", "Nota Media", "Edad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Importar desde:"));

        jLabel1.setText("Origen");

        jLabel2.setText("Fichero");

        jcb_Importar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ficheros Planos", "Ficheros Serializable", "Ficheros de Acceso Random", "Ficheros XML" }));

        jbt_Importar.setText("Importar");
        jbt_Importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ImportarActionPerformed(evt);
            }
        });

        jbt_Buscar_I.setText("Buscar");
        jbt_Buscar_I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_Buscar_IActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_Importar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbt_Importar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_Importar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jbt_Buscar_I)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcb_Importar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_Importar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_Buscar_I))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbt_Importar))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Exportar a:"));

        jLabel3.setText("Destino");

        jLabel4.setText("Nombre");

        jcb_Exportar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ficheros Planos", "Ficheros Serializable", "Ficheros de Acceso Random", "Ficheros XML" }));

        jbt_Exportar.setText("Exportar");
        jbt_Exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ExportarActionPerformed(evt);
            }
        });

        jbt_Buscar_E.setText("Buscar");
        jbt_Buscar_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_Buscar_EActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcb_Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbt_Exportar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jbt_Buscar_E)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcb_Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_Buscar_E))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbt_Exportar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbt_Alta)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_Baja)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_Editar)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_Filtro)
                        .addGap(18, 18, 18)
                        .addComponent(jbt_EliFiltro)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_Alta)
                    .addComponent(jbt_Baja)
                    .addComponent(jbt_Editar)
                    .addComponent(jbt_Filtro)
                    .addComponent(jbt_EliFiltro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_AltaActionPerformed
        AlumnosjDialog addAjD = new AlumnosjDialog(this, true);
        addAjD.setVisible(true);
        this.actualizarTabla();
    }//GEN-LAST:event_jbt_AltaActionPerformed

    private void jbt_BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_BajaActionPerformed
        if (numMatriculaTabla >= 0) {
            if (JOptionPane.showConfirmDialog(this, "¿Estas seguro de elimnar el alumno?") == JOptionPane.OK_OPTION) {
                Utilities.bajaAlumno(numMatriculaTabla);
                actualizarTabla();
            }
        }else{
            JOptionPane.showMessageDialog(this, "No has seleccionado ningun alumno");
        }
    }//GEN-LAST:event_jbt_BajaActionPerformed

    private void jbt_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_EditarActionPerformed
        if (numMatriculaTabla >= 0) {
            System.out.println("1");
            AlumnosjDialog modAlumnos = new AlumnosjDialog(this, true);
            modAlumnos.setjtfMatriculaEnable(false);
            Alumno alumnoModificar = Utilities.getAlumnoMatricula(numMatriculaTabla);
            Utilities.bajaAlumno(numMatriculaTabla);
            modAlumnos.setjtfMatriculaText(alumnoModificar.getMatricula());
            modAlumnos.setjtfNombreText(alumnoModificar.getNombre());
            modAlumnos.setjtfEdadText(alumnoModificar.getEdad());
            modAlumnos.setjtfFechaNText(alumnoModificar.getFechaNac());
            modAlumnos.setjtfNotaMText(alumnoModificar.getNotaMedia());
            modAlumnos.setVisible(true);
            if (modAlumnos.isActive()) {
                Utilities.alumnos.add(alumnoModificar);
            }
            actualizarTabla();
        }
    }//GEN-LAST:event_jbt_EditarActionPerformed

    private void jbt_FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_FiltroActionPerformed
        FilterDialog fd = new FilterDialog(this, true);
        fd.setVisible(true);
        tableRS.setRowFilter(RowFilter.regexFilter(Utilities.filtro.getFiltrar(), Utilities.filtro.getPosicion()));
        
    }//GEN-LAST:event_jbt_FiltroActionPerformed

    private void jbt_EliFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_EliFiltroActionPerformed
        tableRS.setRowFilter(null);
    }//GEN-LAST:event_jbt_EliFiltroActionPerformed

    private void jbt_Buscar_IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_Buscar_IActionPerformed
        if (elegirFichero.showDialog(this,"Elige el fichero")!= JFileChooser.CANCEL_OPTION) {
            jtf_Importar.setText(elegirFichero.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jbt_Buscar_IActionPerformed

    private void jbt_ImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ImportarActionPerformed
        File f1 = new File(jtf_Importar.getText());
        if (f1.exists() && f1.isFile()) {
            Utilities.importarArchivos(f1,jcb_Importar.getSelectedItem().toString());
            actualizarTabla();
        }else{
            JOptionPane.showMessageDialog(this, "EL fichero no existe");
        }
    }//GEN-LAST:event_jbt_ImportarActionPerformed

    private void jbt_Buscar_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_Buscar_EActionPerformed
        if (elegirFichero.showDialog(this,"Elige el fichero")!= JFileChooser.CANCEL_OPTION) {
            jtf_Exportar.setText(elegirFichero.getSelectedFile().getAbsoluteFile().toString());
        }
    }//GEN-LAST:event_jbt_Buscar_EActionPerformed

    private void jbt_ExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ExportarActionPerformed
        File f1 = new File(jtf_Exportar.getText());
        if (f1.exists() && f1.isFile()) {
            Utilities.exportarArchivos(f1,jcb_Exportar.getSelectedItem().toString());
        }else{
            JOptionPane.showMessageDialog(this, "EL fichero no existe");
        }
    }//GEN-LAST:event_jbt_ExportarActionPerformed

    private void actualizarTabla(){
        modelo.setRowCount(0);
        for (int i = 0; i < Utilities.alumnos.size(); i++) {
            Object[] rowAlumno = new Object[5];
            rowAlumno[0] = Utilities.alumnos.get(i).getMatricula();
            rowAlumno[1] = Utilities.alumnos.get(i).getNombre();
            rowAlumno[2] = Utilities.alumnos.get(i).getFechaNac();
            rowAlumno[3] = Utilities.alumnos.get(i).getNotaMedia();
            rowAlumno[4] = Utilities.alumnos.get(i).getEdad();
            this.modelo.addRow(rowAlumno);
        }
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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_Alta;
    private javax.swing.JButton jbt_Baja;
    private javax.swing.JButton jbt_Buscar_E;
    private javax.swing.JButton jbt_Buscar_I;
    private javax.swing.JButton jbt_Editar;
    private javax.swing.JButton jbt_EliFiltro;
    private javax.swing.JButton jbt_Exportar;
    private javax.swing.JButton jbt_Filtro;
    private javax.swing.JButton jbt_Importar;
    private javax.swing.JComboBox<String> jcb_Exportar;
    private javax.swing.JComboBox<String> jcb_Importar;
    private javax.swing.JTable jt_Alumnos;
    private javax.swing.JTextField jtf_Exportar;
    private javax.swing.JTextField jtf_Importar;
    // End of variables declaration//GEN-END:variables
}
