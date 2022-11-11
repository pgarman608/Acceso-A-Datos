package vistas;

import controladores.CtlExportar;
import controladores.CtlTablas;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelos.*;

public class Index extends javax.swing.JFrame{
    
    private DefaultTableModel modeloTablaAlumnos;
    private DefaultTableModel modeloTablaCursos;
    private DefaultTableModel modeloTablaMatriculados;
    private DefaultTableModel modeloTablaExamenes;
    
    private ArrayList<Alumno> listAlumnos;
    private ArrayList<Curso> listCursos;
    private ArrayList<Matriculado> listMatriculados;
    private ArrayList<Examen> listExamenes;
    
    private String rowTableAlumnos = "";
    private String rowTableCursos = "";
    private String rowTableMatriculadosAlu = "";
    private String rowTableMatriculadosCur = "";
    private int posMatriculado = -1;
    private int rowTableExamenes = -1;
    
    private CtlTablas contTablas;
    private CtlExportar export;
    
    public static Connection con;
    
    private Examen examenTemp;
    
    public Index() {
        //Inicializamos los objetos que hemos creado en la carpeta controladores
        export = new CtlExportar();
        contTablas = new CtlTablas();
        try {
            //Conectaremos con la base de datos
            con = contTablas.conectarSQL();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"No se puede conectar con el servidor");
            System.exit(0);
        }
        initComponents();
        //Inicializamos los modelos de las tablas con sus tablas respectivamente
        modeloTablaAlumnos = (DefaultTableModel) jTableAlumnos.getModel();
        modeloTablaCursos = (DefaultTableModel) jTableCursos.getModel();
        modeloTablaMatriculados = (DefaultTableModel) jTableMatriculas.getModel();
        modeloTablaExamenes = (DefaultTableModel) jTableExamenes.getModel();
        //Le diremos a las tablas que solo puedan seleccionar una fila a la vez por tabla
        jTableAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableMatriculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableExamenes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        //Pondremos que nos ordene por el número de Examen la tabla de Exámenes
        TableRowSorter<DefaultTableModel> tablaExamenes = new TableRowSorter<>(modeloTablaExamenes);
        jTableExamenes.setRowSorter(tablaExamenes);
        List<SortKey> sortKey = new ArrayList<>();
        sortKey.add(new SortKey(0, SortOrder.ASCENDING));
        tablaExamenes.setSortKeys(sortKey);
        //Recogeremos los alumnos, cursos y matrículas de la base de datos
        listAlumnos = contTablas.recogerAlumnos();
        listCursos = contTablas.recogerCursos();
        listMatriculados = contTablas.recogerMatriculados();
        //Actualizaremos las tablas
        actualizarTablaAlumnos();
        actualizarTablaCursos();
        actualizarTablaMatriculados();
        //Pondremos a cada tabla un listener con su respectivo adaptador cuando clique en la tabla 
        jTableAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            /**
             * Recogeremos el codigo del alumno de la tabla Alumnos
             */
            public void mouseClicked(MouseEvent e) {
                int row = jTableAlumnos.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    rowTableAlumnos = jTableAlumnos.getValueAt(row, 0).toString();
                }
            }
});
        jTableCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            /**
             * Recogeremos el codigo del curso de la tabla cursos
             */
            public void mouseClicked(MouseEvent e) {
                int row = jTableCursos.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    rowTableCursos = jTableCursos.getValueAt(row, 0).toString();
                }
            }
});
        jTableMatriculas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            /**
             * Recogeremos el codigo del alumno y del curso de la tabla Matriculas
             */
            public void mouseClicked(MouseEvent e) {
                int row = jTableMatriculas.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    rowTableMatriculadosAlu = jTableMatriculas.getValueAt(row, 0).toString();
                    rowTableMatriculadosCur = jTableMatriculas.getValueAt(row, 2).toString();
                    listExamenes = contTablas.recogerExamenes(rowTableMatriculadosAlu, rowTableMatriculadosCur);
                    actualizarTablaExamenes();
                }
            }
});
        jTableExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            /**
             * Recogeremos el numero del examen de la tabla Examenes
             */
            public void mouseClicked(MouseEvent e) {
                int row = jTableExamenes.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    rowTableExamenes = Integer.parseInt(jTableExamenes.getValueAt(row, 0).toString());
                    examenTemp = listExamenes.get(rowTableExamenes-1);
                    jtfFechaExamen.setText(examenTemp.getFecha());
                    jtfNotaExamen.setText(""+examenTemp.getNota());
                }
            }
});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCursos = new javax.swing.JTable();
        jbtnMatricular = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMatriculas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfFechaExamen = new javax.swing.JTextField();
        jtfNotaExamen = new javax.swing.JTextField();
        jbtnActualizarExamen = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableExamenes = new javax.swing.JTable();
        jbtnBoletin = new javax.swing.JButton();
        jbtExportXML = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRACTICA 01");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
        jScrollPane1.setViewportView(jTableAlumnos);

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

        jbtnMatricular.setText("Matricular alumno en el curso");
        jbtnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMatricularActionPerformed(evt);
            }
        });

        jTableMatriculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Alumno", "Nombre Alumno", "Codigo Curso", "Nombre Curso", "Nota Media"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane3.setViewportView(jTableMatriculas);

        jLabel1.setText("Fecha del examen");

        jLabel2.setText("Nota");

        jbtnActualizarExamen.setText("Actualizar");
        jbtnActualizarExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarExamenActionPerformed(evt);
            }
        });

        jTableExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Examen", "Fecha Examen", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane4.setViewportView(jTableExamenes);

        jbtnBoletin.setText("Boletin JSON");
        jbtnBoletin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBoletinActionPerformed(evt);
            }
        });

        jbtExportXML.setText("Listado Matricula XML");
        jbtExportXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExportXMLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbtnActualizarExamen, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jtfNotaExamen)
                                    .addComponent(jtfFechaExamen)))
                            .addComponent(jbtnBoletin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtExportXML, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jbtnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jbtnMatricular)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfFechaExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfNotaExamen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jbtnActualizarExamen)
                        .addGap(26, 26, 26)
                        .addComponent(jbtnBoletin)
                        .addGap(18, 18, 18)
                        .addComponent(jbtExportXML))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMatricularActionPerformed
        //Comprobaremos que tengamos seleccionado alumno y curso de las tablas correspondientes
        if (!rowTableAlumnos.equals("") && !rowTableCursos.equals("")) {
            //Comprobaremos que al matricular alumnos no de error
            if (contTablas.matricularALumnos(rowTableAlumnos, rowTableCursos) == -1) {
                JOptionPane.showMessageDialog(this, "Error en la base de datos");
            }else{
                //Recogeremos los matriculados de la base de datos y actualizaremos la tabla de matriculados
                listMatriculados = contTablas.recogerMatriculados();
                actualizarTablaMatriculados();
            }
        }else{
            JOptionPane.showMessageDialog(this, "No se puede matricular a nadie");
        }
    }//GEN-LAST:event_jbtnMatricularActionPerformed

    private void jbtnActualizarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarExamenActionPerformed
        //Comprobaremos que tengamos algún examen seleccionado 
        if (rowTableExamenes != -1) {
            int error = 0;
            try {
                error = -1;
                //Comprobaremos que lo que está introduciendo el usuario es una fecha
                Date fecha = new SimpleDateFormat("dd-MM-yyyy").parse(jtfFechaExamen.getText());
                error = -2;
                //Comprobaremos que el numero introducido es un double
                double nota= Double.parseDouble(jtfNotaExamen.getText());
                //Guardaremos la fecha y la nota en una variable temporal
                examenTemp.setNota(nota);
                examenTemp.setFecha(new SimpleDateFormat("dd-MM-yyyy").format(fecha));
                //Acturalizaremos la base de datos con el examen y la media
                error = contTablas.updateExamen(rowTableMatriculadosAlu, rowTableMatriculadosCur, examenTemp);
                error = contTablas.calcularMedia(rowTableMatriculadosAlu,rowTableMatriculadosCur);
                //comprobaremos que no devuelva ningun error los metidos anteriores
                if (error ==-1) {
                   JOptionPane.showMessageDialog(this, "Error con SQL");
                }else{
                    //Recogeremos los examenes de la base de datos
                    listExamenes = contTablas.recogerExamenes(rowTableMatriculadosAlu, rowTableMatriculadosCur);
                    //Recogeremos los matriculados de la base de datos
                    listMatriculados = contTablas.recogerMatriculados();
                    //actualizaremos que las tablas de matriculas y examenes
                    actualizarTablaMatriculados();
                    actualizarTablaExamenes();
                }
            } catch (ParseException ex) {
                if (error == -1) {
                    JOptionPane.showMessageDialog(this,"Introduce una fecha correcta, tipo 10-10-2020");
                }else{
                    JOptionPane.showMessageDialog(this,"Introduce una nota correcto");
                } 
            }
        }else{
            JOptionPane.showMessageDialog(this, "Elige un examen");
        }
    }//GEN-LAST:event_jbtnActualizarExamenActionPerformed

    private void jbtnBoletinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBoletinActionPerformed
        //Comprobaremos que tengamos seleccionado una fila de la tabla de matriculados
        if (!rowTableMatriculadosAlu.equals("") && !rowTableMatriculadosCur.equals("")) {
            Matriculado mexpor = null;
            //Recogeremos el alumno matriculado seleccionado
            for (int i = 0; i < listMatriculados.size(); i++) {
                if (listMatriculados.get(i).getCodigoAlumno().equals(rowTableMatriculadosAlu) 
                        && listMatriculados.get(i).getCodigoCurso().equals(rowTableMatriculadosCur)) {
                    mexpor = listMatriculados.get(i);
                }
            }
            //Exportaremos al alumno matriculado con sus examenes
            export.exportarBoletin(mexpor, listExamenes);
        }else{
            JOptionPane.showMessageDialog(this, "No se puede exportar a ningun matriculado");
        }
    }//GEN-LAST:event_jbtnBoletinActionPerformed

    private void jbtExportXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExportXMLActionPerformed
        //Exportaremos los alumnos y el curso matriculado a un XML
        export.exportarMatriculas(listAlumnos, listMatriculados, listCursos);
    }//GEN-LAST:event_jbtExportXMLActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Cuando cerremos al app tambien cerraremos la conexion
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de SQL");
        }
    }//GEN-LAST:event_formWindowClosing
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JTable jTableCursos;
    private javax.swing.JTable jTableExamenes;
    private javax.swing.JTable jTableMatriculas;
    private javax.swing.JButton jbtExportXML;
    private javax.swing.JButton jbtnActualizarExamen;
    private javax.swing.JButton jbtnBoletin;
    private javax.swing.JButton jbtnMatricular;
    private javax.swing.JTextField jtfFechaExamen;
    private javax.swing.JTextField jtfNotaExamen;
    // End of variables declaration//GEN-END:variables
   /**
    * Metodos para actualizar las tablas
    */
    private void actualizarTablaAlumnos(){
        modeloTablaAlumnos.setRowCount(0);
        for (int i = 0; i < listAlumnos.size(); i++) {
            Object[] alumno = new Object[2];
            alumno[0] = listAlumnos.get(i).getCodigoAlumno();
            alumno[1] = listAlumnos.get(i).getNombre();
            modeloTablaAlumnos.addRow(alumno);
        }
    }
    private void actualizarTablaCursos(){
        modeloTablaCursos.setRowCount(0);
        for (int i = 0; i < listCursos.size(); i++) {
            Object[] curso = new Object[3];
            curso[0] = listCursos.get(i).getCodigoCurso();
            curso[1] = listCursos.get(i).getNombreCurso();
            curso[2] = listCursos.get(i).getnExamenes();
            modeloTablaCursos.addRow(curso);
            
        }
    }
    private void actualizarTablaMatriculados(){
        modeloTablaMatriculados.setRowCount(0);
        for (int i = 0; i < listMatriculados.size(); i++) {
            Object[] matriculado = new Object[5];
            matriculado[0] = listMatriculados.get(i).getCodigoAlumno();
            matriculado[1] = listMatriculados.get(i).getNombreAlumno();
            matriculado[2] = listMatriculados.get(i).getCodigoCurso();
            matriculado[3] = listMatriculados.get(i).getNombreCurso();
            matriculado[4] = listMatriculados.get(i).getnExamenes();
            modeloTablaMatriculados.addRow(matriculado);
        }
    }
    private void actualizarTablaExamenes(){
        modeloTablaExamenes.setRowCount(0);
        for (int i = 0; i < listExamenes.size(); i++) {
            Object[] examen = new Object[3];
            examen[0] = listExamenes.get(i).getnExamen();
            examen[1] = listExamenes.get(i).getFecha();
            examen[2] = listExamenes.get(i).getNota();
            modeloTablaExamenes.addRow(examen);
        }
    }
}