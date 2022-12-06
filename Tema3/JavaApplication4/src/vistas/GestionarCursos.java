package vistas;


import controladores.CntrlCursos;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.Cursos;

public class GestionarCursos extends javax.swing.JDialog {
    
    private DefaultTableModel modelo;
    private ArrayList<Cursos> cursos;
    private int rowTableCursos;
    
    public GestionarCursos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cursos = CntrlCursos.getCursos();
        modelo = (DefaultTableModel) jTableCursos.getModel();
        
        jTableCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jTableCursos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rowTableCursos = jTableCursos.rowAtPoint(e.getPoint());
                jtfCodigo.setText(cursos.get(rowTableCursos).getCcodcurso());
                jtfNExamenes.setText(""+cursos.get(rowTableCursos).getNnumexa());
                jtfNombre.setText(cursos.get(rowTableCursos).getCnomcurso());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rowTableCursos = -1;
                jtfCodigo.setText("");
                jtfNExamenes.setText("");
                jtfNombre.setText("");
            }
        });
        
        actualizarTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCursos = new javax.swing.JTable();
        jbtnAdd = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnConsult = new javax.swing.JButton();
        jbtnModify = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfNExamenes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Curso", "Nombre Curso", "Nº Examenes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableCursos);

        jbtnAdd.setText("ADD");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jbtnDelete.setText("DELETE");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jbtnConsult.setText("CONSULT");
        jbtnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConsultActionPerformed(evt);
            }
        });

        jbtnModify.setText("MODIFY");
        jbtnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModifyActionPerformed(evt);
            }
        });

        jLabel1.setText("CODIGO CURSO");

        jLabel2.setText("NOMBRE CURSO");

        jLabel3.setText("Nº EXAMENES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnConsult)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnModify))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfNExamenes, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(jtfNombre))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAdd)
                    .addComponent(jbtnDelete)
                    .addComponent(jbtnConsult)
                    .addComponent(jbtnModify))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNExamenes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        String nombre = jtfNombre.getText();
        String codigo = jtfCodigo.getText();
        String num = jtfNExamenes.getText();
        if (nombre != null && codigo != null && num != null) {
            if (!nombre.replaceAll(" ", "").equals("") && !codigo.replaceAll(" ", "").equals("") && !num.replaceAll(" ", "").equals("")) {
                if (isNumeric(num)) {
                    if (-1 != CntrlCursos.addCurso(new Cursos(codigo,nombre,Short.parseShort(num)))) {
                        JOptionPane.showMessageDialog(this, "Curso añadido");
                    }else{
                        JOptionPane.showMessageDialog(this, "Error de Primary key");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "El apartado de numero de examenes no es un numero ");
                }
            }else{
                JOptionPane.showMessageDialog(this, "No puede estar el nombre ni el codigo vacios");
            }
        }else{
            JOptionPane.showMessageDialog(this, "No puede estar el nombre ni el codigo vacios");
        }
        actualizarTabla();
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        if (rowTableCursos > -1) {
            if (CntrlCursos.existMatriculaCurso(cursos.get(rowTableCursos).getCcodcurso())) {
                if (0 == CntrlCursos.delCurso(cursos.get(rowTableCursos))) {
                    JOptionPane.showMessageDialog(this, "Curso eliminado");
                } else {
                    JOptionPane.showMessageDialog(this, "Error de la base de datos");
                }                
            }else{
                JOptionPane.showMessageDialog(this,"No se puede eliminar un curso por que ya tiene gente matriculada en el");
            }
        }else{
            JOptionPane.showMessageDialog(this,"Elige un curso de la tabla");
        }
        actualizarTabla();
    }//GEN-LAST:event_jbtnDeleteActionPerformed
    private boolean consultar=true;
    private void jbtnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConsultActionPerformed
        TableRowSorter<TableModel> filtrar = new TableRowSorter<>(modelo);
        jTableCursos.setRowSorter(filtrar);
        if (rowTableCursos > -1) {
            consultar = !consultar;
            if (!consultar) {
                filtrar.setRowFilter(RowFilter.regexFilter(cursos.get(rowTableCursos).getCcodcurso(), 0));
            }else{
                filtrar.setRowFilter(null);
            }
        }else{
            filtrar.setRowFilter(null);
            JOptionPane.showMessageDialog(this,"Elige un curso de la tabla");
        }
    }//GEN-LAST:event_jbtnConsultActionPerformed

    private void jbtnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModifyActionPerformed
        if (rowTableCursos > -1 && !jtfCodigo.getText().equals("")) {
            cursos.get(rowTableCursos).setCcodcurso(jtfCodigo.getText());
            cursos.get(rowTableCursos).setCnomcurso(jtfNombre.getText());
            cursos.get(rowTableCursos).setNnumexa(Short.parseShort(jtfNExamenes.getText()));
            CntrlCursos.delCurso(cursos.get(rowTableCursos));
        }else{
            JOptionPane.showMessageDialog(this,"Elige un curso de la tabla");
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
            java.util.logging.Logger.getLogger(GestionarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarCursos dialog = new GestionarCursos(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCursos;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnConsult;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnModify;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNExamenes;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
    private void actualizarTabla(){
        cursos = CntrlCursos.getCursos();
        modelo.setRowCount(0);
        for (int i = 0; i < cursos.size(); i++) {
            modelo.addRow(new Object[]{cursos.get(i).getCcodcurso(),cursos.get(i).getCnomcurso(),cursos.get(i).getNnumexa()});
        }
    }
    private boolean isNumeric(String msg){
        boolean aux = true;
        try {
            short prueba = Short.parseShort(msg);
        } catch (Exception e) {
            aux = false;
        }
        return aux;
    }
}
