/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.interfaces;

import armaganzasoft.models.HiloReloj;



/**
 *
 * @author user
 */
public class EntregasParciales extends javax.swing.JFrame {

     HiloReloj hilor;
    /**
     * Creates new form EntregasParciales
     */
    public EntregasParciales() {
        initComponents();
         hilor = new HiloReloj(lbhora);
       hilor.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        textField1 = new java.awt.TextField();
        textField2 = new java.awt.TextField();
        canvas2 = new java.awt.Canvas();
        canvas3 = new java.awt.Canvas();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button1.setLabel("Buscar Entrega");
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });
        getContentPane().add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 500, -1));

        textField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField2ActionPerformed(evt);
            }
        });
        getContentPane().add(textField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 91, -1));
        getContentPane().add(canvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, 90, -1));
        getContentPane().add(canvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 340, 340));

        button2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button2.setLabel("AGREGAR");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 640, 150, 30));

        button3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button3.setLabel("MODIFICAR");
        getContentPane().add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 640, 150, 30));

        button4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button4.setLabel("ELIMINAR");
        getContentPane().add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 640, 150, 30));

        button5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button5.setLabel("PRINCIPAL");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        getContentPane().add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 640, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NUMERO DE ORDEN");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("NOTAS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 50, -1));

        lbhora.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbhora.setForeground(new java.awt.Color(240, 240, 240));
        lbhora.setText("00:00:00");
        getContentPane().add(lbhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, -1, 44));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/planet_1920x1200.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField2ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
Menu principal=new Menu();
        principal.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_button5ActionPerformed

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
            java.util.logging.Logger.getLogger(EntregasParciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntregasParciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntregasParciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntregasParciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntregasParciales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Canvas canvas2;
    private java.awt.Canvas canvas3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbhora;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    // End of variables declaration//GEN-END:variables
}
