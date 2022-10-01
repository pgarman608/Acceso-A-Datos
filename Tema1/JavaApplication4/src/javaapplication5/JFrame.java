package javaapplication5;

import java.io.File;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Pablo García Manzano
 */
public class JFrame extends javax.swing.JFrame {
    private File fileDireccion;
    private DefaultTableModel modeloTabla;
    private Object[] datosTabla;
    private TableRowSorter<TableModel> filtradorTabla;
    public JFrame() {
        //Iniciaremos los componentes introducidos en el apartado de Design
        initComponents();
        //Crearemos un array estatico para guardar en un futuro la informacion
        //que saquemos de la direccion introducida
        this.datosTabla = new Object[4];
        //Crearemos un modelo de la tabla prinicipal para que podamos introducir
        //y eliminar datos de la tabla
        this.modeloTabla = (DefaultTableModel) this.tabla.getModel();
        //Crearemos una clase que venga de tableRowSorter para poder ordenar y
        //filtrar la tabla
        this.filtradorTabla = new TableRowSorter<TableModel>(this.modeloTabla);
    }
    /**
     * Crearemos un metodo con el que podamos eliminar todos las filas de 
     * la tabla
     */
    private void removeAllRows(){
        //Tendremos un bucle donde nos moveremos por todas las firas de la tabla
        for( int i = modeloTabla.getRowCount() - 1; i >= 0; i-- ){
            //Y con este metodo que nos da DefaultTableModel iremos eliminando
            //todas las filas una a una
            modeloTabla.removeRow(i);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_directorio = new javax.swing.JLabel();
        jl_extension = new javax.swing.JLabel();
        btn_Extension = new javax.swing.JButton();
        btn_directorio = new javax.swing.JButton();
        jt_Directorio = new javax.swing.JTextField();
        jt_Extension = new javax.swing.JTextField();
        jl_fallo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Practica 01 | T1 Manejo de ficheros | Hecho por: Pablo García Manzano");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 400));

        jl_directorio.setForeground(new java.awt.Color(0, 0, 255));
        jl_directorio.setText("Indique Directorio");

        jl_extension.setForeground(new java.awt.Color(0, 0, 255));
        jl_extension.setText("Indique Extension");

        btn_Extension.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Lupa.png"))); // NOI18N
        btn_Extension.setMaximumSize(new java.awt.Dimension(64, 64));
        btn_Extension.setMinimumSize(new java.awt.Dimension(64, 64));
        btn_Extension.setPreferredSize(new java.awt.Dimension(32, 32));
        btn_Extension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExtensionActionPerformed(evt);
            }
        });

        btn_directorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Lupa.png"))); // NOI18N
        btn_directorio.setMaximumSize(new java.awt.Dimension(64, 64));
        btn_directorio.setMinimumSize(new java.awt.Dimension(64, 64));
        btn_directorio.setPreferredSize(new java.awt.Dimension(32, 32));
        btn_directorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_directorioActionPerformed(evt);
            }
        });

        jt_Directorio.setForeground(new java.awt.Color(0, 255, 0));

        jt_Extension.setForeground(new java.awt.Color(0, 255, 0));

        jl_fallo.setForeground(new java.awt.Color(255, 0, 0));
        jl_fallo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_fallo.setText(" ");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Extension", "Tamaño", "F/D"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_directorio)
                                .addGap(18, 18, 18)
                                .addComponent(jt_Directorio, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_directorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_extension)
                                .addGap(18, 18, 18)
                                .addComponent(jt_Extension, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Extension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jl_fallo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_directorio)
                            .addComponent(jt_Directorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_directorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_extension)
                            .addComponent(jt_Extension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Extension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jl_fallo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_directorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_directorioActionPerformed
        //Eliminaremos los filtros y las filas que tengan anteriormente creadas
        this.tabla.setRowSorter(null);
        this.removeAllRows();
        this.filtradorTabla.setRowFilter(null);
        //Guardaremos en un cursor el texto del Text field de directorio 
        this.fileDireccion = new File(this.jt_Directorio.getText());
        //Comprobaremos que no existe la direccion del cursor o que este vacio
        if (!this.fileDireccion.exists() || this.jt_Directorio.getText().equals("")) {
            //Eliminaremos el texto del text field de directorio
            this.jt_Directorio.setText("");
            //Pondremos que la ruta introducida no existe en el label de fallos
            this.jl_fallo.setText("No existe la ruta");
        }else{
            //Eliminamos la informacion del label de fallos
            this.jl_fallo.setText(" ");
            //Crearemos un bucle que guarde cada ubicacion encontrada en el cursor
            for (File file : this.fileDireccion.listFiles()) {
                String ext = "";
                int pExt = file.getName().lastIndexOf(".");
                if (pExt > 0) {
                    ext = file.getName().substring(pExt);
                }
                this.datosTabla[0] = file.getName();
                this.datosTabla[1] = ext;
                this.datosTabla[2] = file.length();
                this.datosTabla[3] = this.esFoD(file);
                this.modeloTabla.addRow(datosTabla);
            }
        }
    }//GEN-LAST:event_btn_directorioActionPerformed
    /**
     * En este evento tendremos que filtrar la tabla por la extension que hallamos
     * puesto en el Text field que está al lado de Indique extension y la tabla
     * generada anteriormente
     * @param evt 
     */
    private void btn_ExtensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExtensionActionPerformed
        //Miramos que la tabla no este vacia
        if (this.modeloTabla.getRowCount() == 0) {
            //Si esta vacia le diremos que la tabla no debe estar vacia
            this.jl_fallo.setText("La tabla no debe esta vacia");
        }else{
            //Miramos que el text field no esté vacio 
            if (this.jt_Extension.getText().equals("")) {
                //Se lo decimos que ese apartado no debe estar vacio
                this.jl_fallo.setText("El apartado de indicar la extension esta vacio");
            } else {
                //Filtraremos por la text field de extension y la segunda 
                //posicion de la tabla
                this.tabla.setRowSorter(filtradorTabla);
                this.filtradorTabla.setRowFilter(RowFilter.regexFilter(this.jt_Extension.getText(), 1));
            }
        }
    }//GEN-LAST:event_btn_ExtensionActionPerformed
    /**
     * En este metodo veremos con un cursor que si es un fichero o un directorio.
     * Según si es directorio o fichero sacaremos un texto donde diga que es.
     * @param file El cursor que utilizaremos 
     * @return El texto que sacaremos según si es fichero o directorio
     */
    private String esFoD(File file){
        //Crearemos una variable para guardad el texto: "Es un direcorio" o 
        //"Es un Fichero"
        String aux = "";
        //Le preguntamos al cursor si es un directorio
        if (file.isDirectory()) {
            //Sabiendo que es un directorio guardaremos en la variable "Es un 
            //Directorio"
            aux = "Es un Directorio";
        } else {
            //Le preguntamos al cursor si es un fichero
            if (file.isFile()) {
                //Sabiendo que es un fichero guardaremos en la variable "Es un 
                //fichero"
                aux = "Es un Fichero";
            }
        }
        return aux;
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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Extension;
    private javax.swing.JButton btn_directorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_directorio;
    private javax.swing.JLabel jl_extension;
    private javax.swing.JLabel jl_fallo;
    private javax.swing.JTextField jt_Directorio;
    private javax.swing.JTextField jt_Extension;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
