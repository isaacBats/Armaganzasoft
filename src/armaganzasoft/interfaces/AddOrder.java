/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armaganzasoft.interfaces;

import armaganzasoft.models.Customer;
import armaganzasoft.models.HiloReloj;
import armaganzasoft.repositorys.CustomerRepository;
import armaganzasoft.services.CustomerController;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AddOrder extends javax.swing.JFrame {
    HiloReloj hilor;

    /**
     * Creates new form Ordenes
     */
    public AddOrder() {
        initComponents();
        hilor = new HiloReloj(lbhora);
        hilor.start();
        String ordenproduccion = String.format("%08d", 1);
        this.jTextField2.setText("MX-" + ordenproduccion);
        this.jTextField31.setText( "RM-" + String.format( "%08d", 2) );
        completaCliente();
    }
    
    private void completaCliente(){
        
        CustomerRepository cr = new CustomerRepository();
        TextAutoCompleter textAutoCompleter = new TextAutoCompleter(jTextFieldCliente);
        //CustomerController cc = new CustomerController();
        
        //List<Customer> listCustomers = cc.getCustomers( cr.getallCostumers() );
        
        ResultSet rs = cr.getallCostumers();
        try {
            while(rs.next()){                
                textAutoCompleter.addItem(rs.getString("name") + " " + rs.getString("last_name"));                
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al traer los datos: " + ex);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jTextField2 = new javax.swing.JTextField();
        jTextFieldDirEntrega = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelRFC = new javax.swing.JLabel();
        jLabelContacto = new javax.swing.JLabel();
        jTextFieldOrden = new javax.swing.JTextField();
        jTextFieldPedido = new javax.swing.JTextField();
        jTextFieldProducto = new javax.swing.JTextField();
        jLabelKGSOrden = new javax.swing.JLabel();
        jLabelKGSPedido = new javax.swing.JLabel();
        jLabelProducto = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        titulo2Soluciones = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();
        jTextFieldPVSR = new javax.swing.JTextField();
        jTextFieldPedidos = new javax.swing.JTextField();
        jLabelPVSR = new javax.swing.JLabel();
        jLabelPedidos = new javax.swing.JLabel();
        jTextFieldCliente = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelTelefono2 = new javax.swing.JLabel();
        jLabelDirEntrega = new javax.swing.JLabel();
        jTextFieldContacto = new javax.swing.JTextField();
        jTextFieldRFC = new javax.swing.JTextField();
        jTextFieldTelefono1 = new javax.swing.JTextField();
        jTextFieldDirFiscal = new javax.swing.JTextField();
        jLabelCliente = new javax.swing.JLabel();
        jLabelDirFiscal = new javax.swing.JLabel();
        jLabelTelefono1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 120, -1));
        getContentPane().add(jTextFieldDirEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 345, 350, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ORDEN DE PRODUCCION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, 20));

        jLabelRFC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelRFC.setText("RFC");
        getContentPane().add(jLabelRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 30, 20));

        jLabelContacto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelContacto.setText("CONTACTO");
        getContentPane().add(jLabelContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 320, 80, 30));
        getContentPane().add(jTextFieldOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 100, -1));
        getContentPane().add(jTextFieldPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 445, 100, -1));
        getContentPane().add(jTextFieldProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 100, -1));

        jLabelKGSOrden.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelKGSOrden.setText("KGS/ORDEN");
        getContentPane().add(jLabelKGSOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 430, -1, -1));

        jLabelKGSPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelKGSPedido.setText("KGS PEDIDO");
        getContentPane().add(jLabelKGSPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 455, -1, -1));

        jLabelProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelProducto.setText("PRODUCTO");
        getContentPane().add(jLabelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 480, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("FORMULA");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("REMISION");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));
        getContentPane().add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 110, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/button_logout.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        titulo2Soluciones.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        titulo2Soluciones.setText("SOLUCIONES EN INGENIERIA ZARATE");
        titulo2Soluciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(titulo2Soluciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 80, 310, 40));

        lbhora.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        getContentPane().add(lbhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, 80, 20));
        getContentPane().add(jTextFieldPVSR, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 100, -1));
        getContentPane().add(jTextFieldPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 445, 100, -1));

        jLabelPVSR.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPVSR.setText("P vs R");
        getContentPane().add(jLabelPVSR, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, -1));

        jLabelPedidos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelPedidos.setText("PEDIDOS");
        getContentPane().add(jLabelPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 455, -1, -1));
        getContentPane().add(jTextFieldCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 195, 350, -1));
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 350, -1));

        jLabelTelefono2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTelefono2.setText("TELEFONO");
        getContentPane().add(jLabelTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 70, 30));

        jLabelDirEntrega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDirEntrega.setText("DIRECCION ENTREGA");
        getContentPane().add(jLabelDirEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 345, 140, 30));
        getContentPane().add(jTextFieldContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 350, -1));
        getContentPane().add(jTextFieldRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 350, -1));
        getContentPane().add(jTextFieldTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 245, 350, -1));
        getContentPane().add(jTextFieldDirFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 350, -1));

        jLabelCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCliente.setText("CLIENTE");
        getContentPane().add(jLabelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 200, 60, 20));

        jLabelDirFiscal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelDirFiscal.setText("DIRECCION FISCAL");
        getContentPane().add(jLabelDirFiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 130, 20));

        jLabelTelefono1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTelefono1.setText("TELEFONO");
        getContentPane().add(jLabelTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 245, 70, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/giphy.gif"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, -1, 90));

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AGREGAR.png"))); // NOI18N
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 630, 50, 40));

        jButton4.setBackground(new java.awt.Color(153, 153, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 630, 50, 40));

        jButton5.setBackground(new java.awt.Color(153, 153, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 630, 50, 40));

        jMenuBar1.setBorder(null);

        jMenu1.setText("CAPTURA DE DATOS");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem4.setText("PLANTAS");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem5.setText("CLIENTES");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem6.setText("USUARIOS");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem1.setText("COMPONENTES");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem7.setText("FORMULAS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem2.setText("MATERIALES");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("PRODUCTOS");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem10.setText("OPB");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem8.setText("PROCESO");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("PRODUCCION");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem9.setText("OPERACION");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jCheckBoxMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("DATOS DESPUES DE LA OPERACION");
        jMenu4.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("REPORTES");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
Componentes inicio = new Componentes();
        inicio.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
Materiales inicio = new Materiales();
        inicio.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
Plantas inicio = new Plantas();
        inicio.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
Cliente inicio = new Cliente();
        inicio.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
Usuarios inicio = new Usuarios();
        inicio.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
Formulas inicio = new Formulas();
        inicio.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
Proceso inicio = new Proceso();
        inicio.setVisible(true);
      dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
  Opb inicio = new Opb();
        inicio.setVisible(true);
         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   Login inicio = new Login();
        inicio.setVisible(true);
      dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelContacto;
    private javax.swing.JLabel jLabelDirEntrega;
    private javax.swing.JLabel jLabelDirFiscal;
    private javax.swing.JLabel jLabelKGSOrden;
    private javax.swing.JLabel jLabelKGSPedido;
    private javax.swing.JLabel jLabelPVSR;
    private javax.swing.JLabel jLabelPedidos;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelRFC;
    private javax.swing.JLabel jLabelTelefono1;
    private javax.swing.JLabel jLabelTelefono2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextFieldCliente;
    private javax.swing.JTextField jTextFieldContacto;
    private javax.swing.JTextField jTextFieldDirEntrega;
    private javax.swing.JTextField jTextFieldDirFiscal;
    private javax.swing.JTextField jTextFieldOrden;
    private javax.swing.JTextField jTextFieldPVSR;
    private javax.swing.JTextField jTextFieldPedido;
    private javax.swing.JTextField jTextFieldPedidos;
    private javax.swing.JTextField jTextFieldProducto;
    private javax.swing.JTextField jTextFieldRFC;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldTelefono1;
    private javax.swing.JLabel lbhora;
    private javax.swing.JLabel titulo2Soluciones;
    // End of variables declaration//GEN-END:variables
private javax.swing.JOptionPane mensaje;
}
