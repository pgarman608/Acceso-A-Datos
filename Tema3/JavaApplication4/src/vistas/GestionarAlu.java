package vistas;

import controladores.CntrlAlumnos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.Alumnos;

public class GestionarAlu extends javax.swing.JDialog {
    private DefaultTableModel modelo;
    private ArrayList<Alumnos> alumnos;
    private int rowTableAlumnos;
    public GestionarAlu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        rowTableAlumnos = 0;
        alumnos = CntrlAlumnos.getAlumnos();
        
        modelo = (DefaultTableModel) jTableAlumnos.getModel();
        
        jTableAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jTableAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowTableAlumnos = jTableAlumnos.rowAtPoint(e.getPoint());
                jtfCodAlu.setText(alumnos.get(rowTableAlumnos).getCcodalu());
                jtfNombre.setText(alumnos.get(rowTableAlumnos).getCnomalu());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rowTableAlumnos = -1;
                jtfCodAlu.setText("");
                jtfNombre.setText("");
            }
        });
        
        actualizarTabla();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jbtnAdd = new javax.swing.JButton();
        jbtnConsult = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnModify = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfCodAlu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Alumno", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableAlumnos);

        jbtnAdd.setText("ADD");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jbtnConsult.setText("CONSULT");
        jbtnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConsultActionPerformed(evt);
            }
        });

        jbtnDelete.setText("DELETE");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jbtnModify.setText("MODIFY");
        jbtnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModifyActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo Alumno:");

        jLabel2.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnDelete)
                            .addComponent(jbtnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jbtnModify))
                            .addComponent(jbtnConsult)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 122, Short.MAX_VALUE))
                    .addComponent(jtfNombre)
                    .addComponent(jtfCodAlu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtfCodAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAdd)
                    .addComponent(jbtnConsult))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDelete)
                    .addComponent(jbtnModify))
                .addGap(84, 84, 84))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        
        String nombre = jtfNombre.getText();
        String codigo = jtfCodAlu.getText();
        
        if (nombre != null && codigo != null) {
            if (!nombre.replaceAll(" ", "").equals("") && !codigo.replaceAll(" ", "").equals("")) {
                if (-1 != CntrlAlumnos.addAlumno(new Alumnos(codigo,nombre))) {
                    JOptionPane.showMessageDialog(this, "Alumno añadido");
                }else{
                    JOptionPane.showMessageDialog(this, "Error de Primary key");
                }
            }else{
                JOptionPane.showMessageDialog(this, "No puede estar el nombre ni el codigo vacios");
            }
        }else{
            JOptionPane.showMessageDialog(this, "No puede estar el nombre ni el codigo vacios");
        }
        actualizarTabla();
    }//GEN-LAST:event_jbtnAddActionPerformed

    private boolean consultar = true;
    
    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed

        if (rowTableAlumnos > -1) {
            if (CntrlAlumnos.existMatriculaAlumno(alumnos.get(rowTableAlumnos).getCcodalu())) {
                if (0 == CntrlAlumnos.delAlumno(alumnos.get(rowTableAlumnos))) {
                    JOptionPane.showMessageDialog(this, "Usuario eliminado");
                } else {
                    JOptionPane.showMessageDialog(this, "Error de la base de datos");
                }
            }else{
                JOptionPane.showMessageDialog(this,"No se puede eliminar al alumno por que ya esta matriculado");
            }
        }else{
            JOptionPane.showMessageDialog(this,"Elige un Alumno de la tabla");
        }
        actualizarTabla();
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConsultActionPerformed
        TableRowSorter<TableModel> filtrar = new TableRowSorter<>(modelo);
        jTableAlumnos.setRowSorter(filtrar);
        if (rowTableAlumnos > -1) {
            consultar = !consultar;
            if (!consultar) {
                filtrar.setRowFilter(RowFilter.regexFilter(alumnos.get(rowTableAlumnos).getCcodalu(), 0));
            }else{
                filtrar.setRowFilter(null);
            }
        }else{
            filtrar.setRowFilter(null);
            JOptionPane.showMessageDialog(this,"Elige un curso de la tabla");
        }
    }//GEN-LAST:event_jbtnConsultActionPerformed

    private void jbtnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModifyActionPerformed
        if (rowTableAlumnos > -1 && !jtfCodAlu.getText().equals("")) {
            alumnos.get(rowTableAlumnos).setCcodalu(jtfCodAlu.getText());
            alumnos.get(rowTableAlumnos).setCnomalu(jtfNombre.getText());
            CntrlAlumnos.modAlumno(alumnos.get(rowTableAlumnos));
        }else{
            JOptionPane.showMessageDialog(this,"Elige un Alumno de la tabla");
        }
        actualizarTabla();
    }//GEN-LAST:event_jbtnModifyActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarAlu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarAlu dialog = new GestionarAlu(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnConsult;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnModify;
    private javax.swing.JTextField jtfCodAlu;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
    
    private void actualizarTabla(){
        alumnos = CntrlAlumnos.getAlumnos();
        modelo.setRowCount(0);
        for (int i = 0; i < alumnos.size(); i++) {
            modelo.addRow(new Object[]{alumnos.get(i).getCcodalu(),alumnos.get(i).getCnomalu()});
        }
    }

}
