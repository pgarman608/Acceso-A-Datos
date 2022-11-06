
package javaapplication4.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaapplication4.Controlador.Utilities;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
public class FilterDialog extends javax.swing.JDialog implements ActionListener{
    private int posSelect;
    public FilterDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Inicializaremos la posición de la elección de radiobutton en 0
        posSelect = 0;
        //Deshabilitaremos los txtfiels de inicio
        jtfFechaNF.setEnabled(false);
        jtfMatriculaF.setEnabled(false);
        jtfNotaMF.setEnabled(false);
        jtfNombreF.setEnabled(false);
        jtfEdadF.setEnabled(false);
        //Añadiremos el actionListener implementados en la clase
        jrbEdad.addActionListener(this);
        jrbFecha.addActionListener(this);
        jrbMatricula.addActionListener(this);
        jrbNombre.addActionListener(this);
        jrbNotaM.addActionListener(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFiltros = new javax.swing.ButtonGroup();
        jrbMatricula = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jrbNombre = new javax.swing.JRadioButton();
        jrbFecha = new javax.swing.JRadioButton();
        jrbNotaM = new javax.swing.JRadioButton();
        jrbEdad = new javax.swing.JRadioButton();
        jtfMatriculaF = new javax.swing.JTextField();
        jtfNombreF = new javax.swing.JTextField();
        jtfFechaNF = new javax.swing.JTextField();
        jtfNotaMF = new javax.swing.JTextField();
        jtfEdadF = new javax.swing.JTextField();
        jbtFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtros");

        bgFiltros.add(jrbMatricula);
        jrbMatricula.setText("Matricula");

        jLabel1.setText("Filtrar Tabla : ");

        bgFiltros.add(jrbNombre);
        jrbNombre.setText("Nombre");

        bgFiltros.add(jrbFecha);
        jrbFecha.setText("Fecha de Nacimiento");

        bgFiltros.add(jrbNotaM);
        jrbNotaM.setText("Nota Media");

        bgFiltros.add(jrbEdad);
        jrbEdad.setText("Edad");

        jbtFiltrar.setText("Filtrar");
        jbtFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtFiltrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1)
                        .addGap(0, 140, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbMatricula)
                            .addComponent(jrbNombre)
                            .addComponent(jrbFecha)
                            .addComponent(jrbNotaM)
                            .addComponent(jrbEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfMatriculaF)
                            .addComponent(jtfNombreF)
                            .addComponent(jtfFechaNF)
                            .addComponent(jtfNotaMF)
                            .addComponent(jtfEdadF, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMatricula)
                    .addComponent(jtfMatriculaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNombre)
                    .addComponent(jtfNombreF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbFecha)
                    .addComponent(jtfFechaNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNotaM)
                    .addComponent(jtfNotaMF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbEdad)
                    .addComponent(jtfEdadF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtFiltrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFiltrarActionPerformed
        //Comprobamos que la posición seleccionada no sea 0
        if (posSelect == 0) {
            JOptionPane.showMessageDialog(this,"Elije e introduze el datos");
        }else{
            //Crearemos un array de String para guardar el texto escrito
            String[] textFields = new String[5];
            textFields[4] = jtfEdadF.getText();
            textFields[0] = jtfMatriculaF.getText();
            textFields[2] = jtfFechaNF.getText();
            textFields[1] = jtfNombreF.getText();
            textFields[3] = jtfNotaMF.getText();
            //Comprobaremos los txtfields del filtro
            if (Utilities.comprobartfFiltros(textFields,posSelect-1) == 1) {
                //Guardaremos en una variable creada en utilites de la clase Filtro
                //que guardará la información a filtrar y su posición
                Utilities.filtro.setFiltrar(textFields[posSelect-1]);
                Utilities.filtro.setPosicion(posSelect-1);
                //Cerraremos el jDialog
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Introduzca informacion "
                        + "correcta en la dato elegido");
            }
        }
    }//GEN-LAST:event_jbtFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(FilterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FilterDialog dialog = new FilterDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtFiltrar;
    private javax.swing.JRadioButton jrbEdad;
    private javax.swing.JRadioButton jrbFecha;
    private javax.swing.JRadioButton jrbMatricula;
    private javax.swing.JRadioButton jrbNombre;
    private javax.swing.JRadioButton jrbNotaM;
    private javax.swing.JTextField jtfEdadF;
    private javax.swing.JTextField jtfFechaNF;
    private javax.swing.JTextField jtfMatriculaF;
    private javax.swing.JTextField jtfNombreF;
    private javax.swing.JTextField jtfNotaMF;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        //Crearemos una variable que será el radiobutton seleccionado
        JRadioButton selected = (JRadioButton) e.getSource();
        //Tendremos un switch donde cogeremos el texto del radioButton
        switch(String.valueOf( selected.getText())){
            case "Matricula":
                //Setearemos el posSelect a 1
                posSelect = 1;
                //Vaciaremos los textFields
                vaciarTextfield();
                //Habilitaremos el matricula y deshabilitaremos los otros textfields
                jtfFechaNF.setEnabled(false);
                jtfMatriculaF.setEnabled(true);
                jtfNotaMF.setEnabled(false);
                jtfNombreF.setEnabled(false);
                jtfEdadF.setEnabled(false);
                break;
            case "Nombre":
                //Setearemos el posSelect a 2
                posSelect = 2;
                //Vaciaremos los textFields
                vaciarTextfield();
                //Habilitaremos el nombre y deshabilitaremos los otros textfields
                jtfFechaNF.setEnabled(false);
                jtfMatriculaF.setEnabled(false);
                jtfNotaMF.setEnabled(false);
                jtfNombreF.setEnabled(true);
                jtfEdadF.setEnabled(false);
                break;
            case "Fecha de Nacimiento":
                //Setearemos el posSelect a 3
                posSelect = 3;
                //Vaciaremos los textFields
                vaciarTextfield();
                //Habilitaremos el fecha y deshabilitaremos los otros textfields
                jtfFechaNF.setEnabled(true);
                jtfMatriculaF.setEnabled(false);
                jtfNotaMF.setEnabled(false);
                jtfNombreF.setEnabled(false);
                jtfEdadF.setEnabled(false);
                break;
            case "Nota Media":
                //Setearemos el posSelect a 4
                posSelect = 4;
                //Vaciaremos los textFields
                vaciarTextfield();
                //Habilitaremos el nota Media y deshabilitaremos los otros textfields
                jtfFechaNF.setEnabled(false);
                jtfMatriculaF.setEnabled(false);
                jtfNotaMF.setEnabled(true);
                jtfNombreF.setEnabled(false);
                jtfEdadF.setEnabled(false);
                break;
            case "Edad":
                //Setearemos el posSelect a 5
                posSelect = 5;
                //Vaciaremos los textFields
                vaciarTextfield();
                //Habilitaremos el edad y deshabilitaremos los otros textfields
                jtfFechaNF.setEnabled(false);
                jtfMatriculaF.setEnabled(false);
                jtfNotaMF.setEnabled(false);
                jtfNombreF.setEnabled(false);
                jtfEdadF.setEnabled(true);
                break;
        }
    }
    private void vaciarTextfield(){
        //Vaciaremos los textField
        jtfFechaNF.setText("");
        jtfMatriculaF.setText("");
        jtfNotaMF.setText("");
        jtfNombreF.setText("");
        jtfEdadF.setText("");
    }
}