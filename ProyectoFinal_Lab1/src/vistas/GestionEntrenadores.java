/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import AccesoADatos.EntrenadorData;
import Entidades.Entrenador;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zully
 */
public class GestionEntrenadores extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    
    private DefaultTableModel modeloEntrenador;
    private EntrenadorData entrenadorData = new EntrenadorData();
    private Entrenador entrenadorActual = null;
    
    public GestionEntrenadores() {
        initComponents();
        modeloEntrenador = (DefaultTableModel) jtEntrenador.getModel();
        llenarTabla();
        cargarEntrenadores();
        jrbEstado.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlDNI = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jlApellido = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jlEspecialidad = new javax.swing.JLabel();
        jtfEspecialidad = new javax.swing.JTextField();
        jlEstado = new javax.swing.JLabel();
        jtfEstado = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jlEntrenador = new javax.swing.JLabel();
        jbDeshabilitar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEntrenador = new javax.swing.JTable();
        jbBuscarPorNombre = new javax.swing.JButton();
        jcbEntrenador = new javax.swing.JComboBox<>();
        jtfCaracteres = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(181, 181, 181));

        jlNombre.setText("Nombre");

        jtfNombre.setEditable(false);

        jlDNI.setText("DNI");

        jtfDNI.setEditable(false);

        jlApellido.setText("Apellido");

        jtfApellido.setEditable(false);

        jlEspecialidad.setText("Especialidad");

        jtfEspecialidad.setEditable(false);

        jlEstado.setText("Estado");

        jtfEstado.setEditable(false);

        jrbEstado.setText("Empezar como activo");
        jrbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEstadoActionPerformed(evt);
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
                        .addComponent(jlEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlDNI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEspecialidad)
                            .addComponent(jlApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jrbEstado))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDNI)
                    .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEspecialidad)
                    .addComponent(jtfEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlApellido)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstado)
                    .addComponent(jtfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlEntrenador.setText("ENTRENADOR:");

        jbDeshabilitar.setText("DESHABILITAR");
        jbDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeshabilitarActionPerformed(evt);
            }
        });

        jbAgregar.setText("AGREGAR");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbBuscar.setText("BUSCAR");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbModificar.setText("MODIFICAR");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jtEntrenador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Nombre", "Apellido", "Especialidad", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
        jtEntrenador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtEntrenadorMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtEntrenador);

        jScrollPane2.setViewportView(jScrollPane1);

        jbBuscarPorNombre.setText("Buscar Por Nombre");
        jbBuscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarPorNombreActionPerformed(evt);
            }
        });

        jcbEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEntrenadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlEntrenador, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbDeshabilitar, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jbAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jcbEntrenador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlEntrenador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAgregar)
                        .addGap(4, 4, 4)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeshabilitar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jcbEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarPorNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarEntrenadores() {
        jcbEntrenador.addItem("Listar Todos Los Entrenadores");
        jcbEntrenador.addItem("Listar Entrenadores Activos");
        jcbEntrenador.addItem("Listar Entrenadores Inactivos");
    }
  
    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        if (jtEntrenador.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar o buscar un entrenador "
                    + "antes de modificarlo");
            return;
        }
        
        if (jbModificar.getText().equals("MODIFICAR")) {
            reestablecerControles();
            camposEditables();
            jtfEstado.setEnabled(false);
            entrenadorActual = entrenadorData.buscarEntrenadorPorDni(entrenadorActual.getDni());
            String id = String.valueOf(entrenadorActual.getIdEntrenador());
  
            jlEntrenador.setText("Llene los campos con los nuevos datos del entrenador "
                    + "(ID:" + id + ")");
            jlEntrenador.setForeground(Color.BLUE);
            jtfDNI.requestFocusInWindow();
            jbModificar.setText("GUARDAR CAMBIOS");
        }
        else if (validacionFormulario()) {
            int id = entrenadorActual.getIdEntrenador();
            setearEntrenadorConDatosDelFormulario();
            entrenadorActual.setIdEntrenador(id);
            entrenadorData.modificarEntrenador(entrenadorActual);
            llenarTabla();
            reestablecerControles();
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeshabilitarActionPerformed
        if (jtEntrenador.getSelectedRow() == -1 || !jbModificar.getText().equals("MODIFICAR")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar o buscar un entrenador "
                    + "antes de modificarlo");
            return;
        }
        
        if (jbDeshabilitar.getText().equals("DESHABILITAR")) {
            entrenadorData.deshabilitarEntrenador(entrenadorActual.getDni());
            entrenadorActual = entrenadorData.buscarEntrenadorPorDni(entrenadorActual.getDni());
            llenarCampos();
            llenarTabla();
        }
        else {
            entrenadorData.habilitarEntrenador(entrenadorActual.getDni());
            entrenadorActual = entrenadorData.buscarEntrenadorPorDni(entrenadorActual.getDni());
            llenarCampos();
            llenarTabla();
        }
    }//GEN-LAST:event_jbDeshabilitarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        if (jbAgregar.getText().equals("AGREGAR")) {
            jtEntrenador.clearSelection();
            reestablecerControles();
            camposEditables();
           
            jlEntrenador.setText("Llene los campos con los datos del entrenador a ingresar");
            jlEntrenador.setForeground(Color.BLUE);
            jtfDNI.requestFocusInWindow();
            jbAgregar.setText("GUARDAR CAMBIOS");
            jtfEstado.setText("Inactivo");
            jrbEstado.setVisible(true);
        }
        else if (validacionFormulario()) {
            setearEntrenadorConDatosDelFormulario();  
            if(entrenadorData.buscarEntrenadorPorDni(entrenadorActual.getDni()) == null){    
                entrenadorData.guardarEntrenador(entrenadorActual);        
                reestablecerControles();
                llenarTabla();
            }
            else {
                JOptionPane.showMessageDialog(this, "Este entrenador ya existe");
            }    
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jrbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoActionPerformed
        if (!jrbEstado.isSelected()) {
            jtfEstado.setText("Inactivo");
        }
        else jtfEstado.setText("Activo");
    }//GEN-LAST:event_jrbEstadoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (jbBuscar.getText().equals("BUSCAR")){
            jtEntrenador.clearSelection();
            
            reestablecerControles();
            camposDeshabilitados();
            jtfDNI.setEditable(true);
            jtfDNI.setEnabled(true);
            
            jlEntrenador.setText("Escriba el DNI del entrenador que busca");
            jlEntrenador.setForeground(Color.BLUE);
            jtfDNI.requestFocusInWindow();
            jbBuscar.setText("CONFIRMAR BÚSQUEDA");
        }
        else if (validacionDNI()) {
            int dni = Integer.parseInt(jtfDNI.getText());
            entrenadorActual = entrenadorData.buscarEntrenadorPorDni(dni);
            reestablecerControles(); 
            
            if (entrenadorActual != null) {
                llenarCampos();
                jcbEntrenador.setSelectedIndex(0);
                llenarTabla();
                
                int fila = 0;
                
                for (int i = 0; i < modeloEntrenador.getRowCount(); i++) {
                    if(modeloEntrenador.getValueAt(i, 1).equals(dni)){
                        fila = i;
                    }
                    jtEntrenador.setRowSelectionInterval(fila, fila);
                }
                
                setearEntrenadorConDatosDelFormulario();
            }
            else {
                JOptionPane.showMessageDialog(this, "Entrenador no encontrado");
            }
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jcbEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEntrenadorActionPerformed
        int eleccion = jcbEntrenador.getSelectedIndex();
        
        switch (eleccion) {
            case 0: llenarTabla();
            return;
            case 1: llenarTablaActivos();
            return;
            case 2: llenarTablaInactivos();
        }
    }//GEN-LAST:event_jcbEntrenadorActionPerformed

    private void jbBuscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarPorNombreActionPerformed
        int eleccion = jcbEntrenador.getSelectedIndex();
        
        switch (eleccion) {
            case 0: llenarTablaPorNombre(entrenadorData.listarEntrenadores());
            return;
            case 1: llenarTablaPorNombre(entrenadorData.listarEntrenadoresActivos());
            return;
            case 2: llenarTablaPorNombre(entrenadorData.listarEntrenadoresInactivos());
        }
    }//GEN-LAST:event_jbBuscarPorNombreActionPerformed

    private void jtEntrenadorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEntrenadorMouseReleased

        if (jtEntrenador.getSelectedRowCount() > 1) {
            jtEntrenador.clearSelection();
        }
        
        if(jtEntrenador.getSelectedRow() != -1) {
            reestablecerControles();
            int fila = jtEntrenador.getSelectedRow();
            jtfDNI.setText(String.valueOf(modeloEntrenador.getValueAt(fila, 1)));
            jtfNombre.setText(String.valueOf(modeloEntrenador.getValueAt(fila, 2)));
            jtfApellido.setText(String.valueOf(modeloEntrenador.getValueAt(fila, 3)));
            jtfEspecialidad.setText(String.valueOf(modeloEntrenador.getValueAt(fila, 4)));
      
            if (String.valueOf(modeloEntrenador.getValueAt(fila, 5)).equals("true")) {
                jtfEstado.setText("Activo");
                jbDeshabilitar.setText("DESHABILITAR");
            }
            else {
                jtfEstado.setText("Inactivo");
                jbDeshabilitar.setText("HABILITAR");
            }
           
            setearEntrenadorConDatosDelFormulario();
        }
    }//GEN-LAST:event_jtEntrenadorMouseReleased

    private void setearEntrenadorConDatosDelFormulario() {
        int dni = Integer.parseInt(jtfDNI.getText());
        String nombre = jtfNombre.getText();
        String apellido = jtfApellido.getText();
        String especialidad = jtfEspecialidad.getText();
        boolean estado = jtfEstado.getText().equals("Activo");
        
        entrenadorActual = new Entrenador(dni, nombre, apellido, especialidad, estado);
    }
    
    private void limpiarCampos() {
        jtfDNI.setText("");
        jtfNombre.setText("");
        jtfApellido.setText("");
        jtfEspecialidad.setText("");
        jtfEstado.setText("");
    }
    
    private void llenarCampos() {
        jtfDNI.setText(String.valueOf(entrenadorActual.getDni()));
        jtfNombre.setText(entrenadorActual.getNombre());
        jtfApellido.setText(entrenadorActual.getApellido());
        jtfEspecialidad.setText(entrenadorActual.getEspecialidad());
                
        if(entrenadorActual.isEstado()) {
            jtfEstado.setText("Activo");
            jbDeshabilitar.setText("DESHABILITAR");
        }
        else {
            jtfEstado.setText("Inactivo");
            jbDeshabilitar.setText("HABILITAR");
        }
    }
    
    private void camposEditables() {
        jtfDNI.setEditable(true);
        jtfNombre.setEditable(true);
        jtfApellido.setEditable(true);
        jtfEspecialidad.setEditable(true);
    }
    
    private void camposNoEditables() {
        jtfDNI.setEditable(false);
        jtfNombre.setEditable(false);
        jtfApellido.setEditable(false);
        jtfEspecialidad.setEditable(false);
    }
    
    private void camposHabilitados() {
        jtfDNI.setEnabled(true);
        jtfNombre.setEnabled(true);
        jtfApellido.setEnabled(true);
        jtfEspecialidad.setEnabled(true);
        jtfEstado.setEnabled(true);
    }
    
    private void camposDeshabilitados() {
       jtfDNI.setEnabled(false);
        jtfNombre.setEnabled(false);
        jtfApellido.setEnabled(false);
        jtfEspecialidad.setEnabled(false);
        jtfEstado.setEnabled(false); 
    }
    
    private void reestablecerControles() {
        jlEntrenador.setText("ENTRENADOR:");
        jlEntrenador.setForeground(Color.BLACK);
        jbAgregar.setText("AGREGAR");
        jbModificar.setText("MODIFICAR");
        jbBuscar.setText("BUSCAR");
        jrbEstado.setSelected(false);
        jrbEstado.setVisible(false);
        limpiarCampos();
        camposNoEditables();
        camposHabilitados();
    }
    
    private void limpiarTabla(){
        for (int i = modeloEntrenador.getRowCount(); i>0; i--)
            modeloEntrenador.removeRow(0);
    }
    
    private void llenarTabla() {
        limpiarTabla();
        List<Entrenador> entrenadores;
        entrenadores = entrenadorData.listarEntrenadores();
        
        for (Entrenador e : entrenadores) {
            modeloEntrenador.addRow(new Object[]{
                e.getIdEntrenador(),
                e.getDni(),
                e.getNombre(),
                e.getApellido(),
                e.getEspecialidad(),
                e.isEstado()
            });
        }
    }
    
    private void llenarTablaActivos() {
        limpiarTabla();
        List<Entrenador> entrenadores;
        entrenadores = entrenadorData.listarEntrenadoresActivos();
        
        for (Entrenador e : entrenadores) {
            modeloEntrenador.addRow(new Object[]{
                e.getIdEntrenador(),
                e.getDni(),
                e.getNombre(),
                e.getApellido(),
                e.getEspecialidad(),
                e.isEstado()
            });
        }
    }
    
    private void llenarTablaInactivos() {
        limpiarTabla();
        List<Entrenador> entrenadores;
        entrenadores = entrenadorData.listarEntrenadoresInactivos();
        
        for (Entrenador e : entrenadores) {
            modeloEntrenador.addRow(new Object[]{
                e.getIdEntrenador(),
                e.getDni(),
                e.getNombre(),
                e.getApellido(),
                e.getEspecialidad(),
                e.isEstado()
            });
        }
    }
    
    private void llenarTablaPorNombre(List<Entrenador> listaEntrenadores) {
        limpiarTabla();
        String tx = jtfCaracteres.getText().toLowerCase();
        listaEntrenadores.removeIf(entrenador -> !entrenador.getNombre().toLowerCase().startsWith(tx));
        
        for (Entrenador e : listaEntrenadores) {
            modeloEntrenador.addRow(new Object[]{
                e.getIdEntrenador(),
                e.getDni(),
                e.getNombre(),
                e.getApellido(),
                e.getEspecialidad(),
                e.isEstado()
            });
        }
    }
    
    private boolean validacionFormulario() {
        if (!validacionDNI()) {
            return false;
        }
        if (!validacionNombre()) {
            return false;
        }
        if (!validacionApellido()) {
            return false;
        }
        if (!validacionEspecialidad()) {
            return false;
        }
        return true;
    }
    
    private boolean validacionDNI() {
        if (jtfDNI.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo DNI vacío.");
            jtfDNI.requestFocusInWindow();
            return false;
        }
        
        try{        
            Integer.parseInt(jtfDNI.getText());
        }catch(Exception nfe){
            JOptionPane.showMessageDialog(this, "El DNI debe ser un nro.");
            jtfDNI.requestFocusInWindow();
            return false;
        }
        
        if (Integer.parseInt(jtfDNI.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "El DNI debe ser un nro positivo.");
            jtfDNI.requestFocusInWindow();
            return false;
        }
        
        return true;
    }
    
    private boolean validacionApellido(){
        if (jtfApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Apellido vacío.");
            jtfApellido.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    private boolean validacionNombre(){
        if (jtfNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Nombre vacío.");
            jtfNombre.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    private boolean validacionEspecialidad() {
        if (jtfEspecialidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo Especialidad vacío.");
            jtfEspecialidad.requestFocusInWindow();
            return false;
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscarPorNombre;
    private javax.swing.JButton jbDeshabilitar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<String> jcbEntrenador;
    private javax.swing.JLabel jlApellido;
    private javax.swing.JLabel jlDNI;
    private javax.swing.JLabel jlEntrenador;
    private javax.swing.JLabel jlEspecialidad;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTable jtEntrenador;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfCaracteres;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfEspecialidad;
    private javax.swing.JTextField jtfEstado;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
