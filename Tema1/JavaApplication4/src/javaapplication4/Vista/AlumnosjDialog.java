package javaapplication4.Vista;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication4.Controlador.Utilities;
import javax.swing.JOptionPane;

public class AlumnosjDialog extends javax.swing.JDialog {
    public int exited;
    public AlumnosjDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Alumno/a");
        exited = 1;
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
        jtfMatricula = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfFecha = new javax.swing.JTextField();
        jtfNotaM = new javax.swing.JTextField();
        jtfEdad = new javax.swing.JTextField();
        jbtConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Alumno/a");

        jLabel2.setText("Matricula : ");

        jLabel3.setText("Nombre : ");

        jLabel4.setText("Fecha de Nacimiento : ");

        jLabel5.setText("Nota Media : ");

        jLabel6.setText("Edad : ");

        jbtConfirmar.setText("Confirmar");
        jbtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1)
                        .addGap(0, 178, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNombre)
                            .addComponent(jtfMatricula)
                            .addComponent(jtfFecha)
                            .addComponent(jtfNotaM)
                            .addComponent(jtfEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfNotaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarActionPerformed
        Object[] objAlumno = new Object[5];
        objAlumno[0] = jtfMatricula.getText();
        objAlumno[1] = jtfNombre.getText();
        objAlumno[2] = jtfFecha.getText();
        objAlumno[3] = jtfNotaM.getText();
        objAlumno[4] = jtfEdad.getText();
        try {
            if (Utilities.comprobarTipoAlumno(objAlumno) == 1 && Utilities.comprobarAlumno(objAlumno) == 1) {
                if (Utilities.existeAlumno(Integer.parseInt((String)objAlumno[0])) == 1) {
                    if (Utilities.comprobarCharEspeciales((String)objAlumno[1]) == 1) {
                        String nombreLenght = (String)objAlumno[1];
                        if (nombreLenght.length() < 50) {
                            if (JOptionPane.showConfirmDialog(this, "¿Estas Seguro?") == JOptionPane.OK_OPTION) {
                                Utilities.darAlta(objAlumno);
                                this.dispose();
                            }
                        }else{
                            JOptionPane.showMessageDialog(this, "El nombre no puede"
                                + " tener más 50 linea");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "El nombre no puede"
                                + " tener caracteres especiales");
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "La matricula ya existe");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Tipos de datos erroneos");
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"El formato de la fecha es incorrecta");
        }
    }//GEN-LAST:event_jbtConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(AlumnosjDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnosjDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnosjDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnosjDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AlumnosjDialog dialog = new AlumnosjDialog(new javax.swing.JFrame(), true);
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
    public void setjtfMatriculaEnable(boolean enable){
        jtfMatricula.setEnabled(enable);
    }
    public void setjtfMatriculaText(int matricula){
        jtfMatricula.setText(""+matricula);
    }
    public void setjtfNombreText(String nombre){
        jtfNombre.setText(nombre);
    }
    public void setjtfFechaNText(String fechaN){
        jtfFecha.setText(fechaN);
    }
    public void setjtfNotaMText(float notaF){
        jtfNotaM.setText(""+notaF);
    }
    public void setjtfEdadText(int edad){
        jtfEdad.setText(""+edad);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JTextField jtfEdad;
    private javax.swing.JTextField jtfFecha;
    private javax.swing.JTextField jtfMatricula;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNotaM;
    // End of variables declaration//GEN-END:variables
}
