/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ta.johan.layout;

import com.ta.johan.control.control_alternatif;
import com.ta.johan.control.control_kriteria;
import com.ta.johan.control.control_subkriteria;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.applet.Main;

/**
 *
 * @author Irawan Papang S
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    control_kriteria controlkriteria;
    control_subkriteria controlsubkriteria;
    control_alternatif controlalternatif;

    kriteria k;
    subkriteria s;
    alternatif a;
    home h;

    public main() {
        initComponents();
//        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); // Already there
//        this.setUndecorated(true); // <-- the title bar is removed here
        this.setExtendedState(MAXIMIZED_BOTH);

        controlkriteria = new control_kriteria();
        controlsubkriteria = new control_subkriteria();
        controlalternatif = new control_alternatif();

        a = new alternatif();
        s = new subkriteria();
        k = new kriteria();
        h = new home();

        if (!h.isVisible()) {
            try {
                jDesktopPanetransparan1.add(h);
                h.show();
//                h.setClosable(false);
//                h.setMaximum(true);
                h.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                h.show();
//                h.setClosable(false);
//                h.setMaximum(true);
                h.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    public void panggil(String userlogin) {
//        switch (userlogin) {
//            case "Head of Institution":
//                enable(true);
//                
//                if (!h.isVisible()) {
//                    try {
//                        jDesktopPanetransparan1.add(h);
//                        h.show();
//                        h.setClosable(false);
//                        h.setMaximum(true);
//                        h.setSelected(true);
//                    } catch (PropertyVetoException ex) {
//                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                } else {
//                    try {
//                        h.show();
//                        h.setClosable(false);
//                        h.setMaximum(true);
//                        h.setSelected(true);
//                    } catch (PropertyVetoException ex) {
//                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                
//                break;
//            case "Admin":
//                enable(false);
//                break;
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

        jDesktopPaneGambarHome1 = new com.ta.johan.background.JDesktopPaneGambarHome();
        buttonImageReflection2 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection4 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection5 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection3 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection1 = new usu.widget.glass.ButtonImageReflection();
        jDesktopPanetransparan1 = new com.ta.johan.background.JDesktopPanetransparan();
        jSeparator1 = new javax.swing.JSeparator();
        buttonImageReflection6 = new usu.widget.glass.ButtonImageReflection();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SISTEM PENDUKUNG KEPUTUSAN PEMILIHAN MARKETPLACE BERDASARKAN KEBUTUHAN PENGGUNA MENGGUNAKAN METODE ANALYTICAL HIERARCHY PROCESS (AHP)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close(evt);
            }
        });

        buttonImageReflection2.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_118770_home_icon_512px.png"))); // NOI18N
        buttonImageReflection2.setText("HOME");
        buttonImageReflection2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection2ActionPerformed(evt);
            }
        });

        buttonImageReflection4.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clipboard.png"))); // NOI18N
        buttonImageReflection4.setText("KRITERIA");
        buttonImageReflection4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection4ActionPerformed(evt);
            }
        });

        buttonImageReflection5.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list.png"))); // NOI18N
        buttonImageReflection5.setText("SUBKRITERIA");
        buttonImageReflection5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection5ActionPerformed(evt);
            }
        });

        buttonImageReflection3.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1461876790_stock_task-assigned-to copy.png"))); // NOI18N
        buttonImageReflection3.setText("MARKETPLACE");
        buttonImageReflection3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageReflection3ActionPerformed(evt);
            }
        });

        buttonImageReflection1.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/question.png"))); // NOI18N
        buttonImageReflection1.setText("USER");

        jDesktopPanetransparan1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jDesktopPanetransparan1.setForeground(new java.awt.Color(0, 0, 0));
        jDesktopPanetransparan1.setOpaque(false);
        jDesktopPanetransparan1.setLayout(new java.awt.BorderLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        buttonImageReflection6.setForeground(new java.awt.Color(0, 0, 0));
        buttonImageReflection6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1493393979_Finance_finance_caaslculator.png"))); // NOI18N
        buttonImageReflection6.setText("PERHITUNGAN");

        jDesktopPaneGambarHome1.setLayer(buttonImageReflection2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambarHome1.setLayer(buttonImageReflection4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambarHome1.setLayer(buttonImageReflection5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambarHome1.setLayer(buttonImageReflection3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambarHome1.setLayer(buttonImageReflection1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambarHome1.setLayer(jDesktopPanetransparan1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambarHome1.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambarHome1.setLayer(buttonImageReflection6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneGambarHome1Layout = new javax.swing.GroupLayout(jDesktopPaneGambarHome1);
        jDesktopPaneGambarHome1.setLayout(jDesktopPaneGambarHome1Layout);
        jDesktopPaneGambarHome1Layout.setHorizontalGroup(
            jDesktopPaneGambarHome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneGambarHome1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneGambarHome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDesktopPanetransparan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPaneGambarHome1Layout.createSequentialGroup()
                        .addComponent(buttonImageReflection2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(buttonImageReflection4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(buttonImageReflection5, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonImageReflection3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(buttonImageReflection1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonImageReflection6, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDesktopPaneGambarHome1Layout.setVerticalGroup(
            jDesktopPaneGambarHome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneGambarHome1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneGambarHome1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonImageReflection5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonImageReflection6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonImageReflection2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonImageReflection4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonImageReflection3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonImageReflection1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPanetransparan1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jDesktopPaneGambarHome1, java.awt.BorderLayout.CENTER);

        jMenuBar1.setOpaque(false);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1496415864_gnome-session-logout.png"))); // NOI18N
        jMenuItem1.setText("Login");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1493449455_Log Out.png"))); // NOI18N
        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Data");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem3.setText("Kriteria");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem4.setText("Subkriteria");
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem5.setText("Alternatif");
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonImageReflection2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection2ActionPerformed
        // TODO add your handling code here:
        if (!h.isVisible()) {
            try {
                jDesktopPanetransparan1.add(h);
                h.show();
//                h.setClosable(false);
//                h.setMaximum(true);
                h.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                h.show();
//                h.setClosable(false);
//                h.setMaximum(true);
                h.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection2ActionPerformed

    private void buttonImageReflection4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection4ActionPerformed
        // TODO add your handling code here:
        if (!k.isVisible()) {
            try {
                jDesktopPanetransparan1.add(k);
                k.show();
                controlkriteria.getData(k);
                controlkriteria.getDataGlobal(k);
                k.jTabbedPane1.setSelectedIndex(0);
                k.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                k.show();
                controlkriteria.getData(k);
                controlkriteria.getDataGlobal(k);
                k.jTabbedPane1.setSelectedIndex(0);
                k.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
//        close();
        int yakin = JOptionPane.showConfirmDialog(this, "Are you Sure Log Out Application ?", "Confirm", JOptionPane.YES_NO_OPTION);
        login o = new login();
        if (yakin == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            o.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void close(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_close
        // TODO add your handling code here:
        int yakin = JOptionPane.showConfirmDialog(this, "Are you Sure Exit Application ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (yakin == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_close

    private void buttonImageReflection5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection5ActionPerformed
        // TODO add your handling code here:
        if (!s.isVisible()) {
            try {
                jDesktopPanetransparan1.add(s);
                s.show();
                controlsubkriteria.getDataGlobal(s);
                controlsubkriteria.getData(s);
                s.jTabbedPane1.setSelectedIndex(0);
                s.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                s.show();
                controlsubkriteria.getDataGlobal(s);
                controlsubkriteria.getData(s);
                s.jTabbedPane1.setSelectedIndex(0);
                s.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection5ActionPerformed

    private void buttonImageReflection3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageReflection3ActionPerformed
        // TODO add your handling code here:
        if (!a.isVisible()) {
            try {
                jDesktopPanetransparan1.add(a);
                a.show();
//                controlalternatif.getData(a);
                controlalternatif.getDataSubkriteria(a);
                controlalternatif.getDataAlternatifSubkriteria(a);
                a.jTabbedPane1.setSelectedIndex(0);
                a.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                a.show();
//                controlalternatif.getData(a);
                controlalternatif.getDataSubkriteria(a);
                controlalternatif.getDataAlternatifSubkriteria(a);
                a.jTabbedPane1.setSelectedIndex(0);
                a.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buttonImageReflection3ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.glass.ButtonImageReflection buttonImageReflection1;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection2;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection3;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection4;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection5;
    private usu.widget.glass.ButtonImageReflection buttonImageReflection6;
    private com.ta.johan.background.JDesktopPaneGambarHome jDesktopPaneGambarHome1;
    private com.ta.johan.background.JDesktopPanetransparan jDesktopPanetransparan1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
