/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.johan.layout;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author Irawan Papang S
 */
public class login extends javax.swing.JFrame {

//    Connection c = DBConnect.getKoneksi();
//    ResultSet r;
//    Statement s;
//
    main op;

    public login() {
        initComponents();

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); // Already there
//        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setUndecorated(true); // <-- the title bar is removed here[1186, 553]
//        setShape(new RoundRectangle2D.Double(30, 30, 2000, 1000, 30, 30));
        op = new main();
        
        op.buttonImageReflection2.doClick();
    }

//    public void aksi_login() {
//        try {
//            
//            String password = Base64.getEncoder().encodeToString(jPasswordField1.getText().getBytes());
//            String akses = "";
//            String userakses = "";
//            String sql = "SELECT user.user_seq, user.username, user.password, user.akses FROM user "
//                    + "WHERE username='" + jTextField1.getText().replaceAll("'", "") + "' "
//                    + "AND password = '" + password + "'";
//
//            s = c.createStatement();
//            r = s.executeQuery(sql);
//            String level = "";
//
//            while (r.next()) {
//                userakses = r.getString("akses");
//                akses = "-";
//
//                this.setVisible(false);
//                op.setVisible(true);
//                op.panggil(userakses);
//            }
//
//            if (akses.equals("")) {
//                JOptionPane.showMessageDialog(this, "Please Check Back", "ERROR", JOptionPane.ERROR_MESSAGE);
//                jTextField1.requestFocus();
//                jTextField1.setText("");
//                jPasswordField1.setText("");
//            }
//        } catch (Exception ex) {
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneGambar2 = new com.ta.johan.background.JDesktopPaneGambar();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        buttonImageReflection3 = new usu.widget.glass.ButtonImageReflection();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonImageReflection2 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection1 = new usu.widget.glass.ButtonImageReflection();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                open(evt);
            }
        });

        jDesktopPaneGambar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Username : ");

        jTextField2.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Password : ");

        buttonImageReflection3.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1496415864_gnome-session-logout.png"))); // NOI18N
        buttonImageReflection3.setText("Enter");
        buttonImageReflection3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonImageReflection3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection3ActionPerformed(evt);
            }
        });

        jPasswordField2.setFont(new java.awt.Font("Georgia", 0, 15)); // NOI18N
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 35)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELAMAT DATANG");

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DI");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 17)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SISTEM PENDUKUNG KEPUTUSAN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Johan Pratama");

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 17)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PEMILIHAN MARKETPLACE BERDASARKAN KEBUTUHAN PENGGUNA");

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 17)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MENGGUNAKAN ANALYTICAL HIERARCHY PROCESS (AHP)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("1514311028");

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 25)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("UNIVERSITAS BHAYANGKARA SURABAYA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(22, 22, 22))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        buttonImageReflection2.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1496315888_button_cancel.png"))); // NOI18N
        buttonImageReflection2.setText("CLOSE");
        buttonImageReflection2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection2ActionPerformed(evt);
            }
        });

        buttonImageReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/154237-blue-green-and-white-background-vector-image4.png"))); // NOI18N
        buttonImageReflection1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jDesktopPaneGambar2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar2.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar2.setLayer(buttonImageReflection3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar2.setLayer(jPasswordField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar2.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar2.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar2.setLayer(buttonImageReflection2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar2.setLayer(buttonImageReflection1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneGambar2Layout = new javax.swing.GroupLayout(jDesktopPaneGambar2);
        jDesktopPaneGambar2.setLayout(jDesktopPaneGambar2Layout);
        jDesktopPaneGambar2Layout.setHorizontalGroup(
            jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneGambar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonImageReflection2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonImageReflection1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneGambar2Layout.createSequentialGroup()
                        .addGroup(jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneGambar2Layout.createSequentialGroup()
                        .addGroup(jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonImageReflection3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(177, 177, 177))))
        );
        jDesktopPaneGambar2Layout.setVerticalGroup(
            jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneGambar2Layout.createSequentialGroup()
                .addGroup(jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneGambar2Layout.createSequentialGroup()
                        .addGroup(jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneGambar2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPaneGambar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonImageReflection3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPaneGambar2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buttonImageReflection2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jDesktopPaneGambar2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonImageReflection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jDesktopPaneGambar2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1202, 592));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void open(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_open
        // TODO add your handling code here:
//        jTextField1.requestFocus();
    }//GEN-LAST:event_open

    private void buttonImageReflection3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        op.setVisible(true);
    }//GEN-LAST:event_buttonImageReflection3ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void buttonImageReflection2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection2ActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_buttonImageReflection2ActionPerformed

    public void close() {
        WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(event);
    }

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.glass.ButtonImageReflection buttonImageReflection1;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection2;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection3;
    private com.ta.johan.background.JDesktopPaneGambar jDesktopPaneGambar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
