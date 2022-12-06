
package vistas;

import controladores.CntrlAlumnos;
import controladores.CntrlCursos;
import controladores.CntrlExamenes;
import controladores.CntrlFicheros;
import controladores.CntrlMatriculas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelos.Alumnos;
import modelos.Cursos;
import modelos.Examenes;
import modelos.Matriculas;

public class Index extends javax.swing.JFrame {
    //Modelos de las tablas
    private DefaultTableModel modeloAlumnos;
    private DefaultTableModel modeloCursos;
    private DefaultTableModel modeloMatriculas;
    private DefaultTableModel modeloExamenes;
    //Filas seleccionadas de las tablas
    private int rowTableAlumnos;
    private int rowTableCursos;
    private int rowTableMatriculas;
    private int rowTableExamenes;
    //Arrays de los objetos de las tablas
    private ArrayList<Alumnos> alumnos;
    private ArrayList<Cursos> cursos;
    private ArrayList<Matriculas> matriculas;
    private ArrayList<Examenes> examenes;
    //Formato de las tablas
    private SimpleDateFormat formatoDate;
    
    public Index() {
        initComponents();
        //Inicializaremos las variables
        formatoDate = new SimpleDateFormat("MM-dd-yyyy");
        
        this.modeloAlumnos = (DefaultTableModel) jTableAlumnos.getModel();
        this.modeloCursos = (DefaultTableModel) jTableCursos.getModel();
        this.modeloMatriculas = (DefaultTableModel) jTableMatriculas.getModel();
        this.modeloExamenes = (DefaultTableModel) jTableExamenes.getModel();
        //Las tablas solo pueden tener una fila seleccionada a la vez
        jTableCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableExamenes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableMatriculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Adapatadores de las tablas para elegir las filas
        jTableAlumnos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Recogeremos la fila de la tabla alumnos
                rowTableAlumnos = jTableAlumnos.rowAtPoint(e.getPoint());
                //Filtrar por la primera columna de la tabla Matriculas el codigo del alumno seleccionado
                TableRowSorter<TableModel> filtrar = new TableRowSorter<>(modeloMatriculas);
                jTableMatriculas.setRowSorter(filtrar);
                filtrar.setRowFilter(RowFilter.regexFilter(alumnos.get(rowTableAlumnos).getCcodalu(), 0));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rowTableAlumnos = -1;
            }
        });
        
        jTableCursos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Recogeremos la fila de la tabla cursos
                rowTableCursos = jTableCursos.rowAtPoint(e.getPoint());
                //Filtrar por la primera columna de la tabla Matriculas el codigo del curso seleccionado
                TableRowSorter<TableModel> filtrar = new TableRowSorter<>(modeloMatriculas);
                jTableMatriculas.setRowSorter(filtrar);
                filtrar.setRowFilter(RowFilter.regexFilter(cursos.get(rowTableCursos).getCcodcurso(), 2));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rowTableCursos = -1;
            }
        });
        jTableMatriculas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Recogeremos la fila de la tabla Matriculas
                rowTableMatriculas = jTableMatriculas.rowAtPoint(e.getPoint());
                //Recogeremos los examenes de la matricula seleccionada
                examenes = CntrlExamenes.getExamenes(matriculas.get(rowTableMatriculas));
                //Actualizaremos la tabla de examenes
                actualizarExamenes();
                //eliminaremos la fila selecionada
                rowTableExamenes = -1;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rowTableMatriculas = -1;
            }
        });
        jTableExamenes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Recogeremos la fila de la tabla examenes
                rowTableExamenes = jTableMatriculas.rowAtPoint(e.getPoint());
                //Comprobaremos que no sea null la fecha y la guardaremos en el jtfFecha
                if (examenes.get(rowTableExamenes).getDfecexam() != null) {
                    jtfFechaExamen.setText(formatoDate.format(examenes.get(rowTableExamenes).getDfecexam()));
                }else{
                    jtfFechaExamen.setText("00-00-0000");
                }
                //Guardaremos la nota en el jtfNotaExamen
                jtfNotaExamen.setText(""+examenes.get(rowTableExamenes).getNnotaexam());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                rowTableExamenes = -1;
            }
        });
        alumnos = new ArrayList<>();
        cursos = new ArrayList<>();
        matriculas = new ArrayList<>();
        examenes = new ArrayList<>();
        //Actualizaremos las tablas
        actualizarAlumnos();
        actualizarCursos();
        actualizarMatriculados();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jtfFechaExamen = new javax.swing.JTextField();
        jtfNotaExamen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jbtnActualizarExamen = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableExamenes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCursos = new javax.swing.JTable();
        jbtnBoletin = new javax.swing.JButton();
        jbtnMatricular = new javax.swing.JButton();
        jbtExportXML = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMatriculas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbtnGestAlu = new javax.swing.JButton();
        jbtnGestCur = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nota");

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

        jbtnBoletin.setText("Boletin JSON");
        jbtnBoletin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBoletinActionPerformed(evt);
            }
        });

        jbtnMatricular.setText("Matricular alumno en el curso");
        jbtnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMatricularActionPerformed(evt);
            }
        });

        jbtExportXML.setText("Listado Matricula XML");
        jbtExportXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExportXMLActionPerformed(evt);
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

        jbtnGestAlu.setText("Gestionar Alumnos");
        jbtnGestAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGestAluActionPerformed(evt);
            }
        });

        jbtnGestCur.setText("Gestionar Cursos");
        jbtnGestCur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGestCurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                            .addComponent(jbtExportXML, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnGestAlu)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jbtnGestCur)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnMatricular)
                    .addComponent(jbtnGestAlu)
                    .addComponent(jbtnGestCur))
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

    private void jbtnActualizarExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarExamenActionPerformed
        //Comrprobaremos si el usuario a elegido una fila de la tabla
        if (rowTableExamenes > -1) {
            
            int error = 0;
            try {
                error = 1;
                //Cambiaremos la fecha del examen seleccionado
                examenes.get(rowTableExamenes).setDfecexam(
                        formatoDate.parse(
                                jtfFechaExamen.getText()));
                error = 2;
                //Cambiaremos la nota del examen seleccionado
                examenes.get(rowTableExamenes).setNnotaexam(
                        BigDecimal.valueOf(
                                Long.parseLong(
                                        jtfNotaExamen.getText())));
                //Modificaremos el examen modificado
                CntrlExamenes.modExamen(examenes.get(rowTableExamenes));
                //Calcularemos la nota media del examen
                calcNotaMedia();
                //Actualizaremos los examenes y matriculados
                actualizarExamenes();
                actualizarMatriculados();
            } catch (Exception e) {
                if (error == 1) {
                    JOptionPane.showMessageDialog(this, "Error con el formato de la fecha");
                }else{
                    JOptionPane.showMessageDialog(this, "Error con el formato de la nota");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Error con el examen");
        }
    }//GEN-LAST:event_jbtnActualizarExamenActionPerformed

    private void jbtnBoletinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBoletinActionPerformed
        //Comprobaremos que tengamos los examenes en el array de examenes
        if (examenes.size() > 0) {
            //Exportaremos el array de examenes a un json
            CntrlFicheros.exportJSON(examenes);
        }else{
            JOptionPane.showMessageDialog(this, "No hay examenes para guardar");
        }
    }//GEN-LAST:event_jbtnBoletinActionPerformed

    private void jbtnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMatricularActionPerformed
        //Comprobaremos que tengamos elegido un alumno y un curso para matricularlo
        if (rowTableAlumnos > -1 && rowTableCursos > -1) {
            //Matricularemos el alumno en el 
            if (CntrlMatriculas.addMatriculas(alumnos.get(rowTableAlumnos).getCcodalu(), cursos.get(rowTableCursos).getCcodcurso()) > -1) {
                JOptionPane.showMessageDialog(this, "Usuario matriculado");
            }else{
                JOptionPane.showMessageDialog(this, "Error al matricular al usuario");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Elige un alumno y un curso para añadir a la matricula");
        }
        //Actualizaremos la tabla de matriculados
        actualizarMatriculados();
    }//GEN-LAST:event_jbtnMatricularActionPerformed

    private void jbtExportXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExportXMLActionPerformed
        //Comprobaremos que tengamos alumnos matriculados en la base de datos
        if (matriculas.size()>0) {
            //Exporataremos a los alumnos matriculados
            CntrlFicheros.exportarMatriculas(matriculas, alumnos);
        }else{
            JOptionPane.showMessageDialog(this, "No hay alumnos Matriculados");
        }
    }//GEN-LAST:event_jbtExportXMLActionPerformed

    private void jbtnGestAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGestAluActionPerformed
        //Abrimos los jdialog del gestor de alumnos
        GestionarAlu gestAlumnos = new GestionarAlu(this, true);
        gestAlumnos.setVisible(true);
        //Cuando cerremos el jdialog de alumnos actualizaremos la tabla de alumnos
        actualizarAlumnos();
        actualizarCursos();
        actualizarMatriculados();
    }//GEN-LAST:event_jbtnGestAluActionPerformed

    private void jbtnGestCurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGestCurActionPerformed
        //Abrimos los jdialog del gestor de cursos
        GestionarCursos gestCursos = new GestionarCursos(this,true);
        gestCursos.setVisible(true);
        //Cuando cerremos el jdialog de alumnos actualizaremos la tabla de cursos
        actualizarAlumnos();
        actualizarCursos();
        actualizarMatriculados();
    }//GEN-LAST:event_jbtnGestCurActionPerformed

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
    private javax.swing.JButton jbtnGestAlu;
    private javax.swing.JButton jbtnGestCur;
    private javax.swing.JButton jbtnMatricular;
    private javax.swing.JTextField jtfFechaExamen;
    private javax.swing.JTextField jtfNotaExamen;
    // End of variables declaration//GEN-END:variables
    private void actualizarAlumnos(){
        //Eliminaremos las columnas de las tabla alumnos con su modelo
        modeloAlumnos.setRowCount(0);
        alumnos = CntrlAlumnos.getAlumnos();
        for (int i = 0; i < alumnos.size(); i++) {
            modeloAlumnos.addRow(new Object[]{alumnos.get(i).getCcodalu(),alumnos.get(i).getCnomalu()});
        }
    }
    private void actualizarCursos(){
        //Eliminaremos las columnas de las tabla cursos con su modelo
        modeloCursos.setRowCount(0);
        cursos = CntrlCursos.getCursos();
        for (int i = 0; i < cursos.size(); i++) {
            modeloCursos.addRow(new Object[]{cursos.get(i).getCcodcurso(),cursos.get(i).getCnomcurso(),cursos.get(i).getNnumexa()});
        }
    }

    private void actualizarMatriculados() {
        //Eliminaremos las columnas de las tabla matriculas con su modelo
        modeloMatriculas.setRowCount(0);
        matriculas = CntrlMatriculas.getMatriculas();
        for (int i = 0; i < matriculas.size(); i++) {
            modeloMatriculas.addRow(new Object[]{matriculas.get(i).getAlumnos().getCcodalu()
                    ,matriculas.get(i).getAlumnos().getCnomalu()
                    ,matriculas.get(i).getCursos().getCcodcurso()
                    ,matriculas.get(i).getCursos().getCnomcurso()
                    ,matriculas.get(i).getNnotamedia()
            });
        }     
    }
    private void actualizarExamenes() {
        //Eliminaremos las columnas de las tabla examenes con su modelo
        modeloExamenes.setRowCount(0);
        for (int i = 0; i < examenes.size(); i++) {
            if (examenes.get(i).getDfecexam() != null) {
                modeloExamenes.addRow(new Object[]{i+1
                    ,formatoDate.format(examenes.get(i).getDfecexam())
                    ,examenes.get(i).getNnotaexam()});
            }else{
                modeloExamenes.addRow(new Object[]{i+1
                    ,examenes.get(i).getDfecexam()
                    ,examenes.get(i).getNnotaexam()});
            } 
        }
    }
    private void calcNotaMedia(){
        int numNotas = 0;
        int sumNotas = 0;
        for (int i = 0; i < examenes.size(); i++) {
            if (!examenes.get(i).getNnotaexam().toString().equals("0")) {
                numNotas++;
                sumNotas += Integer.parseInt(examenes.get(i).getNnotaexam().toString());
            }
        }
        if (!(numNotas == 0 || sumNotas == 0)) {
            matriculas.get(rowTableMatriculas).setNnotamedia((short) (sumNotas/numNotas));
            CntrlMatriculas.updateMatriculas(matriculas.get(rowTableMatriculas));
        }
    }
}