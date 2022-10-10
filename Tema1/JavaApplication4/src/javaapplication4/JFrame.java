package javaapplication4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrame extends javax.swing.JFrame {
    //expediente = 4 bytes (int)
    //nombre = 200 bytes (2x100 caracteres)
    //fecha = 20 ()
    //nota1 = 8 ()
    //nota2 = 8 ()
    //notaFinal = 8 ()
    private final int TAMANO = 248;
    private File f1;
    private RandomAccessFile raf1;
    private Long pos;
    private DefaultTableModel modeloTabla;
    private int xne;
    public JFrame() {
        initComponents();
        this.f1 = new File("Alumno.dat");
        this.modeloTabla = (DefaultTableModel) jt_Tabla.getModel();
        f1 = new File("Alumno.dat");
        this.xne = 0;
        try {
            raf1 = new RandomAccessFile(f1,"rw");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se encuentra el fichero donde vamos a escribir");
        }
        actualizarTabla();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtf_Posicion = new javax.swing.JTextField();
        jtf_Nombre = new javax.swing.JTextField();
        jtf_FechaN = new javax.swing.JTextField();
        jtf_Nota1 = new javax.swing.JTextField();
        jtf_Nota2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jtf_NotaF = new javax.swing.JTextField();
        jbt_Alta = new javax.swing.JButton();
        jbt_Baja = new javax.swing.JButton();
        jbt_Consulta = new javax.swing.JButton();
        jbt_Modificar = new javax.swing.JButton();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta | Alumno |");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Posicion");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nota 1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nota 2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nota Final");

        jtf_Posicion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtf_Nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtf_FechaN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtf_Nota1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtf_Nota2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jt_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicion", "Nombre", "FechaNac", "Nota 1", "Nota 2", "Nota final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_Tabla);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha Nac");

        jtf_NotaF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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

        jbt_Consulta.setText("Consulta");
        jbt_Consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ConsultaActionPerformed(evt);
            }
        });

        jbt_Modificar.setText("Modificar");
        jbt_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_FechaN)
                            .addComponent(jtf_Nombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_Posicion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_NotaF, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_Nota2)
                                    .addComponent(jtf_Nota1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbt_Alta)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_Baja)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbt_Consulta)
                                .addGap(18, 18, 18)
                                .addComponent(jbt_Modificar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_Posicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_FechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_Nota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_Nota2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtf_NotaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_Alta)
                    .addComponent(jbt_Baja)
                    .addComponent(jbt_Consulta)
                    .addComponent(jbt_Modificar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_AltaActionPerformed
        this.calcularPos();
        int alta = -1;
        try{
            raf1.seek(pos);
            xne = raf1.readInt();
            if(xne == 0){
                alta = 0;
            }            
        }catch(IOException ex){
            //si da una excepcion significa que es la primera vez y por lo tanto esta vacio y se
            //puede escribir
            alta = 0;
        }
        if (alta == 0) {
            try{
                try{                    
                    //leo el identificador ya que ha sumado automaticamente 4
                    xne = Integer.parseInt(jtf_Posicion.getText());                   
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Formato numérico no correcto");
                }
                raf1.seek(pos);
                if ( jtf_Nombre.getText().length() < 100) {
                    raf1.writeInt(xne);
                    byte[] chars = ByteBuffer.allocate(100).put(this.jtf_Nombre.getText().getBytes()).array();
                    raf1.writeChars(new String(chars));
                    Date dat = null;
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
                    try {
                        dat = formato.parse(this.jtf_FechaN.getText());
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(this, "El formato de la fecha es incorrecto");
                    }
                    raf1.writeChars(formato.format(dat));
                    int numAux = 0;
                    try {
                        numAux = 1;
                        raf1.writeDouble(Double.parseDouble(this.jtf_Nota1.getText()));
                        numAux = 2;
                        raf1.writeDouble(Double.parseDouble(this.jtf_Nota2.getText()));
                        numAux = 3;
                        raf1.writeDouble(Double.parseDouble(this.jtf_NotaF.getText()));
                    } catch (NumberFormatException e) {
                        switch(numAux){
                            case 1:
                                JOptionPane.showMessageDialog(this, "EL formato de la nota 1 es incorrecto (Escribir numeros como 5.2 o 9.34)");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(this, "EL formato de la nota 2 es incorrecto (Escribir numeros como 5.2 o 9.34)");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(this, "EL formato de la nota final es incorrecto (Escribir numeros como 5.2 o 9.34)");
                                break;
                        }
                    }
                    this.actualizarTabla();
                }else{
                    JOptionPane.showMessageDialog(this,"Introduce un nombre menor de 100 caracteres");
                }
            }catch(IOException ex){
                JOptionPane.showMessageDialog(this, "Hay problemas con el archivo");
            }
        }else{
            JOptionPane.showMessageDialog(this, "La posicion ya está completa");
        }
    }//GEN-LAST:event_jbt_AltaActionPerformed

    private void jbt_BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_BajaActionPerformed
        this.calcularPos();
        int baja = 0;
        try{
            raf1.seek(pos);
            xne = raf1.readInt();
            if(xne == 0){
                baja = -1;
            }            
        }catch(IOException ex){
            baja = -1;
        }
        if (baja == 0) {
            try{
                raf1.seek(pos);
                raf1.writeInt(0);
                this.actualizarTabla();
            }catch(IOException ex){
                JOptionPane.showMessageDialog(this, "Hay problemas con el archivo");
            }
        }else{
            JOptionPane.showMessageDialog(this, "La posicion no existe");
        }
    }//GEN-LAST:event_jbt_BajaActionPerformed

    private void jbt_ConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ConsultaActionPerformed
        this.calcularPos();
        int consulta = 0;
        try {
            raf1.seek(this.pos);
            xne = raf1.readInt();
            if (xne == 0) {
                consulta = -1;
            }
        } catch (IOException ex) {
            consulta = -1;
        }
        if (consulta == 0) {
            verenJTF();
        }
    }//GEN-LAST:event_jbt_ConsultaActionPerformed
    private void verenJTF(){
        jtf_Posicion.setText(""+xne);
        try {
            byte[] str = new byte[200];
            byte[] str2 = new byte[20];
            raf1.readFully(str);
            jtf_Nombre.setText(new String(str));
            raf1.readFully(str2);
            jtf_FechaN.setText(new String(str2));
            jtf_Nota1.setText("" + raf1.readDouble());
            jtf_Nota2.setText("" + raf1.readDouble());
            jtf_NotaF.setText("" + raf1.readDouble());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,"Error con el fichero");
        }
    }
    private void jbt_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ModificarActionPerformed
        this.calcularPos();
        int modificar = 0;
        try{
            raf1.seek(pos);
            xne = raf1.readInt();
            if(xne == 0){
                modificar = -1;
            }            
        }catch(IOException ex){
            modificar = -1;
        }
        if (modificar == 0) {
            
        }
    }//GEN-LAST:event_jbt_ModificarActionPerformed
    private void calcularPos(){
        try{
            pos = ((Long.parseLong(this.jtf_Posicion.getText())-1) * TAMANO);
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(this, "Introduzca numeros en el apartado de la posicion");
        }
    }
        private void actualizarTabla() {
        this.modeloTabla.setRowCount(0);
        try {
            int nr =(int) this.raf1.length() /TAMANO;
            for (int i = 1; i <= nr; i++) {
                pos = (long)(i-1) * TAMANO;
                raf1.seek(pos);
                int aux = raf1.readInt();
                if (aux != 0) {
                    Object[] objs = new Object[6];
                    objs[0] = aux;
                    byte[] byte1 = new byte[200];
                    raf1.readFully(byte1);
                    objs[1] = new String(byte1);
                    byte[] byte2 = new byte[20];
                    raf1.readFully(byte2);
                    System.out.println(new String(byte2));
                    objs[2] = new String(byte2);
                    objs[3] = raf1.readDouble();
                    objs[4] = raf1.readDouble();
                    objs[5] = raf1.readDouble();
                    this.modeloTabla.addRow(objs);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Hay problemas con el archivo");
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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_Alta;
    private javax.swing.JButton jbt_Baja;
    private javax.swing.JButton jbt_Consulta;
    private javax.swing.JButton jbt_Modificar;
    private javax.swing.JTable jt_Tabla;
    private javax.swing.JTextField jtf_FechaN;
    private javax.swing.JTextField jtf_Nombre;
    private javax.swing.JTextField jtf_Nota1;
    private javax.swing.JTextField jtf_Nota2;
    private javax.swing.JTextField jtf_NotaF;
    private javax.swing.JTextField jtf_Posicion;
    // End of variables declaration//GEN-END:variables
}