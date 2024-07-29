/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author N
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmSocios = new javax.swing.JMenu();
        jmMembresias = new javax.swing.JMenu();
        jmEntrenadores = new javax.swing.JMenu();
        jmiGestionEntrenadores = new javax.swing.JMenuItem();
        jmClases = new javax.swing.JMenu();
        jmiGestionClases = new javax.swing.JMenuItem();
        jmAsistencia = new javax.swing.JMenu();
        jmiTomarAsistencia = new javax.swing.JMenuItem();
        jmiAsistenciaPorSocio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 984, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );

        jmSocios.setText("Socios");
        jMenuBar1.add(jmSocios);

        jmMembresias.setText("Membresias");
        jMenuBar1.add(jmMembresias);

        jmEntrenadores.setText("Entrenadores");

        jmiGestionEntrenadores.setText("Gestionar Entrenadores");
        jmiGestionEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGestionEntrenadoresActionPerformed(evt);
            }
        });
        jmEntrenadores.add(jmiGestionEntrenadores);

        jMenuBar1.add(jmEntrenadores);

        jmClases.setText("Clases");

        jmiGestionClases.setText("Gestionar Clases");
        jmiGestionClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGestionClasesActionPerformed(evt);
            }
        });
        jmClases.add(jmiGestionClases);

        jMenuBar1.add(jmClases);

        jmAsistencia.setText("Asistencia");

        jmiTomarAsistencia.setText("Tomar Asistencia");
        jmiTomarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTomarAsistenciaActionPerformed(evt);
            }
        });
        jmAsistencia.add(jmiTomarAsistencia);

        jmiAsistenciaPorSocio.setText("Asistencia por Socio");
        jmiAsistenciaPorSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAsistenciaPorSocioActionPerformed(evt);
            }
        });
        jmAsistencia.add(jmiAsistenciaPorSocio);

        jMenuBar1.add(jmAsistencia);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAsistenciaPorSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAsistenciaPorSocioActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jmiAsistenciaPorSocioActionPerformed

    private void jmiTomarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTomarAsistenciaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        TomarAsistencia tomarAsistencia = new TomarAsistencia();
        tomarAsistencia.setVisible(true);
        escritorio.add(tomarAsistencia);
        escritorio.moveToFront(tomarAsistencia);
    }//GEN-LAST:event_jmiTomarAsistenciaActionPerformed

    private void jmiGestionEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGestionEntrenadoresActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        GestionEntrenadores gestionEntrenadores = new GestionEntrenadores();
        gestionEntrenadores.setVisible(true);
        escritorio.add(gestionEntrenadores);
        escritorio.moveToFront(gestionEntrenadores);
    }//GEN-LAST:event_jmiGestionEntrenadoresActionPerformed

    private void jmiGestionClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGestionClasesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        GestionClases gestionClases = new GestionClases();
        gestionClases.setVisible(true);
        escritorio.add(gestionClases);
        escritorio.moveToFront(gestionClases);
    }//GEN-LAST:event_jmiGestionClasesActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmAsistencia;
    private javax.swing.JMenu jmClases;
    private javax.swing.JMenu jmEntrenadores;
    private javax.swing.JMenu jmMembresias;
    private javax.swing.JMenu jmSocios;
    private javax.swing.JMenuItem jmiAsistenciaPorSocio;
    private javax.swing.JMenuItem jmiGestionClases;
    private javax.swing.JMenuItem jmiGestionEntrenadores;
    private javax.swing.JMenuItem jmiTomarAsistencia;
    // End of variables declaration//GEN-END:variables
}
