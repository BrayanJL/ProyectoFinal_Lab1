/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import AccesoADatos.AsistenciaData;
import AccesoADatos.ClaseData;
import AccesoADatos.MembresiaData;
import AccesoADatos.SocioData;
import Entidades.Asistencia;
import Entidades.Clase;
import Entidades.Socio;
import java.time.LocalDate;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author N
 */
public class TomarAsistencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form Asistencia
     */
    
    DefaultTableModel modeloClase;
    ClaseData claseData = new ClaseData();
    
    DefaultTableModel modeloSocio;
    SocioData socioData = new SocioData();
    
    MembresiaData membresiaData = new MembresiaData();
    AsistenciaData asistenciaData = new AsistenciaData();
    
    
    public TomarAsistencia() {
        initComponents();
        modeloClase = (DefaultTableModel)jtClases.getModel();
        jbListarClasesActivasActionPerformed(null);
        
        modeloSocio = (DefaultTableModel)jtSocios.getModel();
        jbListarSociosActivosActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenido = new javax.swing.JPanel();
        jpClases = new javax.swing.JPanel();
        jbListarClasesActivas = new javax.swing.JButton();
        jbListarCClasesInactivas = new javax.swing.JButton();
        jbListarClasesValidas = new javax.swing.JButton();
        jbListarAsistenciaAClase = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtClases = new javax.swing.JTable();
        jpSocios = new javax.swing.JPanel();
        jbListarSociosActivos = new javax.swing.JButton();
        jbListarSociosInactivos = new javax.swing.JButton();
        jbListarAsistenciaDeSocio = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtSocios = new javax.swing.JTable();
        jbAgregarAsistencia = new javax.swing.JButton();

        setResizable(true);
        setMinimumSize(new java.awt.Dimension(1063, 538));

        jpClases.setMinimumSize(new java.awt.Dimension(498, 384));

        jbListarClasesActivas.setText("Listar Clases Activas");
        jbListarClasesActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarClasesActivasActionPerformed(evt);
            }
        });

        jbListarCClasesInactivas.setText("Listar Clases Inactivas");
        jbListarCClasesInactivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarCClasesInactivasActionPerformed(evt);
            }
        });

        jbListarClasesValidas.setText("Listar Clases Validas");
        jbListarClasesValidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarClasesValidasActionPerformed(evt);
            }
        });

        jbListarAsistenciaAClase.setText("Ver asistencias a clase");
        jbListarAsistenciaAClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarAsistenciaAClaseActionPerformed(evt);
            }
        });

        jtClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Horario", "Capacidad", "Profesor", "Fecha", "Habilitado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtClases.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtClases.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtClases);
        if (jtClases.getColumnModel().getColumnCount() > 0) {
            jtClases.getColumnModel().getColumn(0).setPreferredWidth(25);
            jtClases.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jpClasesLayout = new javax.swing.GroupLayout(jpClases);
        jpClases.setLayout(jpClasesLayout);
        jpClasesLayout.setHorizontalGroup(
            jpClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClasesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpClasesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbListarClasesActivas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbListarCClasesInactivas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbListarClasesValidas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpClasesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbListarAsistenciaAClase)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jpClasesLayout.setVerticalGroup(
            jpClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClasesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpClasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbListarCClasesInactivas)
                    .addComponent(jbListarClasesActivas)
                    .addComponent(jbListarClasesValidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbListarAsistenciaAClase)
                .addContainerGap())
        );

        jpSocios.setMinimumSize(new java.awt.Dimension(498, 384));

        jbListarSociosActivos.setText("Listar Socios Activos");
        jbListarSociosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListarSociosActivosActionPerformed(evt);
            }
        });

        jbListarSociosInactivos.setText("Listar Socios Inactivos");

        jbListarAsistenciaDeSocio.setText("Ver asistencia de socio");

        jtSocios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Dni", "Nombre", "Pases", "Fecha", "Habilitado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtSocios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtSocios.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtSocios);
        if (jtSocios.getColumnModel().getColumnCount() > 0) {
            jtSocios.getColumnModel().getColumn(0).setPreferredWidth(25);
            jtSocios.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jpSociosLayout = new javax.swing.GroupLayout(jpSocios);
        jpSocios.setLayout(jpSociosLayout);
        jpSociosLayout.setHorizontalGroup(
            jpSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSociosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbListarSociosActivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbListarSociosInactivos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSociosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbListarAsistenciaDeSocio)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSociosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpSociosLayout.setVerticalGroup(
            jpSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSociosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSociosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbListarSociosActivos)
                    .addComponent(jbListarSociosInactivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbListarAsistenciaDeSocio)
                .addContainerGap())
        );

        jbAgregarAsistencia.setText("Agregar Asistencia");
        jbAgregarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarAsistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpContenidoLayout = new javax.swing.GroupLayout(jpContenido);
        jpContenido.setLayout(jpContenidoLayout);
        jpContenidoLayout.setHorizontalGroup(
            jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpClases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpSocios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpContenidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAgregarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpContenidoLayout.setVerticalGroup(
            jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpClases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpSocios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgregarAsistencia))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarTablaClase(){
        for (int i = modeloClase.getRowCount(); i>0; i--)
            modeloClase.removeRow(0);
    }
    
    private void limpiarTablaSocio(){
        for (int i = modeloSocio.getRowCount(); i>0; i--)
            modeloSocio.removeRow(0);
    }
    
    private void jbListarClasesActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarClasesActivasActionPerformed
        // TODO add your handling code here:
        limpiarTablaClase();
        List<Clase> clases;
        clases = claseData.listarClasesActivas();
        for (Clase c: clases){
            modeloClase.addRow(new Object[]{
                    c.getIdClase(),
                    c.getNombre(),
                    c.getHorario().toString(),
                    c.getCapacidad(),
                    c.getEntrenador().getNombre()+' '+c.getEntrenador().getApellido(),
                    ' ',
                    c.isEstado()
                });
        }
    }//GEN-LAST:event_jbListarClasesActivasActionPerformed

    private void jbListarAsistenciaAClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarAsistenciaAClaseActionPerformed
        // TODO add your handling code here:
        limpiarTablaSocio();

        int filaClase = jtClases.getSelectedRow();
        int idClase = (int)jtClases.getValueAt(filaClase, 0);
        
        List<Asistencia> asistencias = asistenciaData.listarAsistenciaPorClase(idClase);
        
        for (Asistencia a: asistencias){
            modeloSocio.addRow(new Object[]{
                    a.getSocio().getIdSocio(),
                    a.getSocio().getDni(),
                    a.getSocio().getNombre()+' '+a.getSocio().getApellido(),
                    membresiaData.contarPases(a.getSocio().getIdSocio()),
                    a.getFechaAsistencia(),
                    a.getSocio().isActivo()
                });
        }
    }//GEN-LAST:event_jbListarAsistenciaAClaseActionPerformed

    private void jbListarSociosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarSociosActivosActionPerformed
        // TODO add your handling code here:
        limpiarTablaSocio();
        List<Socio> socios;
        socios = socioData.listarSociosActivos();
        for (Socio s: socios){
            modeloSocio.addRow(new Object[]{
                    s.getIdSocio(),
                    s.getDni(),
                    s.getNombre()+' '+s.getApellido(),
                    membresiaData.contarPases(s.getIdSocio()),
                    ' ',
                    s.isActivo()
                });
        }
    }//GEN-LAST:event_jbListarSociosActivosActionPerformed

    private void jbAgregarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarAsistenciaActionPerformed
        // TODO add your handling code here:
        int filaClase = jtClases.getSelectedRow();
        int filaSocio = jtSocios.getSelectedRow();
        
        if (filaClase != -1 && filaSocio != -1){

            int idSocio = (int)jtSocios.getValueAt(filaSocio, 0);            
            int idClase = (int)jtClases.getValueAt(filaClase, 0);
            
            Socio socio = socioData.buscarSocioPorID(idSocio);
            Clase clase = claseData.buscarClase(idClase);
            LocalDate fecha = LocalDate.now();
            
            Asistencia asistencia = new Asistencia (socio,clase,fecha);
            
            asistenciaData.guardarAsistencia(asistencia);
        }
    }//GEN-LAST:event_jbAgregarAsistenciaActionPerformed

    private void jbListarClasesValidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarClasesValidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbListarClasesValidasActionPerformed

    private void jbListarCClasesInactivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListarCClasesInactivasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbListarCClasesInactivasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAgregarAsistencia;
    private javax.swing.JButton jbListarAsistenciaAClase;
    private javax.swing.JButton jbListarAsistenciaDeSocio;
    private javax.swing.JButton jbListarCClasesInactivas;
    private javax.swing.JButton jbListarClasesActivas;
    private javax.swing.JButton jbListarClasesValidas;
    private javax.swing.JButton jbListarSociosActivos;
    private javax.swing.JButton jbListarSociosInactivos;
    private javax.swing.JPanel jpClases;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpSocios;
    private javax.swing.JTable jtClases;
    private javax.swing.JTable jtSocios;
    // End of variables declaration//GEN-END:variables
}
