/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ta.johan.layout;

/**
 *
 * @author Irawan Papang S
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
//        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); // Already there
//        this.setUndecorated(true); // <-- the title bar is removed here
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneGambar1 = new com.ta.johan.background.JDesktopPaneGambar();
        buttonImageReflection1 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection2 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection3 = new usu.widget.glass.ButtonImageReflection();
        jSeparator1 = new javax.swing.JSeparator();
        jDesktopPanetransparan1 = new com.ta.johan.background.JDesktopPanetransparan();
        buttonImageReflection4 = new usu.widget.glass.ButtonImageReflection();
        buttonImageReflection5 = new usu.widget.glass.ButtonImageReflection();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEM PENDUKUNG KEPUTUSAN PEMILIHAN MARKETPLACE BERDASARKAN KEBUTUHAN PENGGUNA MENGGUNAKAN METODE ANALYTICAL HIERARCHY PROCESS (AHP)");

        buttonImageReflection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1493405495_29.png"))); // NOI18N
        buttonImageReflection1.setText("PERHITUNGAN");

        buttonImageReflection2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1493405495_29.png"))); // NOI18N
        buttonImageReflection2.setText("KRITERIA");

        buttonImageReflection3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1493405495_29.png"))); // NOI18N
        buttonImageReflection3.setText("USER");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jDesktopPanetransparan1.setOpaque(false);

        buttonImageReflection4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1493405495_29.png"))); // NOI18N
        buttonImageReflection4.setText("SUBKRITERIA");

        buttonImageReflection5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1493405495_29.png"))); // NOI18N
        buttonImageReflection5.setText("ALTERNATIF");

        jDesktopPaneGambar1.setLayer(buttonImageReflection1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(buttonImageReflection2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(buttonImageReflection3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(jDesktopPanetransparan1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(buttonImageReflection4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambar1.setLayer(buttonImageReflection5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneGambar1Layout = new javax.swing.GroupLayout(jDesktopPaneGambar1);
        jDesktopPaneGambar1.setLayout(jDesktopPaneGambar1Layout);
        jDesktopPaneGambar1Layout.setHorizontalGroup(
            jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneGambar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDesktopPanetransparan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDesktopPaneGambar1Layout.createSequentialGroup()
                        .addComponent(buttonImageReflection2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonImageReflection4, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonImageReflection5, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonImageReflection3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonImageReflection1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDesktopPaneGambar1Layout.setVerticalGroup(
            jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneGambar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneGambar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonImageReflection2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonImageReflection3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonImageReflection1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonImageReflection4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonImageReflection5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPanetransparan1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jDesktopPaneGambar1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1496415864_gnome-session-logout.png"))); // NOI18N
        jMenuItem1.setText("Login");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1493449455_Log Out.png"))); // NOI18N
        jMenuItem2.setText("Logout");
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
    private com.ta.johan.background.JDesktopPaneGambar jDesktopPaneGambar1;
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
