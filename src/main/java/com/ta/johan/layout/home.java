/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.ta.johan.layout;

import com.ta.johan.connect.dbconnect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Irawan Papang S
 */
public class home extends javax.swing.JInternalFrame {

    /**
     * Creates new form kriteria
     */
    Connection c = dbconnect.getKoneksi();
//    Dataset dataset;
//    JFreeChart chart;

    public home() {
        initComponents();
        grafikbar();
        getDataRangking();
    }

//    public void createDataset() {
//
//        String[] alternatif = {"Lazada", "Shopee", "Tokopedia", "Blibli", "Bukalapak"};
//
//        XYSeries ramalan = new XYSeries("Alternatif");
//        double[] tinggiMawar = {335, 1809, 320, 362, 531};
//        for (int i = 0; i < alternatif.length; i++) {
//            ramalan.setDescription(alternatif[i]);
//        }
//
//        XYSeriesCollection datasetcolection = new XYSeriesCollection();
////        datasetcolection.addSeries(tahun);
//        datasetcolection.addSeries(ramalan);
//
//        this.dataset = datasetcolection;
//
//    }
//    public void grafikbar() {
//        try {
////            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
////            String query = "SELECT\n"
////                    + "alternatif.alternatif_name,\n"
////                    + "hasil_rangking.value as Nilai\n"
////                    + "FROM\n"
////                    + "hasil_rangking\n"
////                    + "INNER JOIN alternatif ON hasil_rangking.alternatif_seq = alternatif.seq";
////
////            JDBCCategoryDataset data = new JDBCCategoryDataset("jdbc:mysql://localhost/tugas_akhir_johan", "com.mysql.jdbc.Driver", "root", "");
////            data.executeQuery(query);
//            createDataset();
//            this.chart = ChartFactory.createXYLineChart(
//                    "Grafik Marketplace Terbaik",
//                    "Marketplace",
//                    "Nilai",
//                    (XYDataset) this.dataset,
//                    PlotOrientation.VERTICAL,
//                    true,
//                    true,
//                    false);
//            XYPlot xyplot = (XYPlot) chart.getPlot();
//            XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
//            xYLineAndShapeRenderer.setBaseShapesVisible(true);
//            xYLineAndShapeRenderer.setBaseShapesFilled(true);
//
////            
////            JFreeChart chart = ChartFactory.createBarChart("Grafik", "Alternatif", "Jumlah", data, PlotOrientation.VERTICAL, true, true, false);
////            CategoryPlot bar = chart.getCategoryPlot();
////            bar.setBackgroundPaint(Color.WHITE);
////            bar.setRangeGridlinePaint(Color.BLACK);
////
////            final NumberAxis rangeAxis = (NumberAxis) bar.getRangeAxis();
////            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
////
////            BarRenderer renderer = (BarRenderer) bar.getRenderer();
////            renderer.setDrawBarOutline(false);
////
////            final GradientPaint gp0 = new GradientPaint(
////                    0.0f, 0.0f, Color.CYAN,
////                    0.0f, 0.0f, Color.DARK_GRAY
////            );
////
////            renderer.setSeriesPaint(0, gp0);
//            ChartPanel barpanel = new ChartPanel(this.chart);
////            jPanel1.setVisible(true);
////            jPanel1.removeAll();
//            jPanel1.add(barpanel, BorderLayout.CENTER);
////            jPanel1.validate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//        }
//    }
    public void grafikbar() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            String query = "SELECT\n"
                    + "alternatif.alternatif_name,\n"
                    + "hasil_rangking.value AS Nilai\n"
                    + "FROM\n"
                    + "hasil_rangking\n"
                    + "INNER JOIN alternatif ON hasil_rangking.alternatif_seq = alternatif.seq";

            JDBCCategoryDataset data = new JDBCCategoryDataset("jdbc:mysql://localhost/tugas_akhir_johan", "com.mysql.jdbc.Driver", "root", "");
            data.executeQuery(query);

            JFreeChart chart = ChartFactory.createBarChart("Grafik Marketplace Terbaik", "Marketplace", "Jumlah", data, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot bar = chart.getCategoryPlot();
            bar.setBackgroundPaint(Color.WHITE);
            bar.setRangeGridlinePaint(Color.BLACK);

            final NumberAxis rangeAxis = (NumberAxis) bar.getRangeAxis();
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

            BarRenderer renderer = (BarRenderer) bar.getRenderer();
            renderer.setDrawBarOutline(false);

            final GradientPaint gp0 = new GradientPaint(
                    0.0f, 0.0f, Color.CYAN,
                    0.0f, 0.0f, Color.DARK_GRAY
            );

            renderer.setSeriesPaint(0, gp0);

            ChartPanel barpanel = new ChartPanel(chart);
            jPanel1.setVisible(true);
            jPanel1.removeAll();
            jPanel1.add(barpanel, BorderLayout.CENTER);
            jPanel1.validate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void getDataRangking() {

        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Marketplace");
        tabelKej.addColumn("Nilai");
        tabelKej.addColumn("Rangking");
        try {
            String sql = "SELECT\n"
                    + "	hasil_rangking.`value`, \n"
                    + "	hasil_rangking.rangking, \n"
                    + "	alternatif.seq, \n"
                    + "	alternatif.alternatif_name\n"
                    + "FROM\n"
                    + "	hasil_rangking\n"
                    + "	INNER JOIN\n"
                    + "	alternatif\n"
                    + "	ON \n"
                    + "	hasil_rangking.alternatif_seq = alternatif.seq\n"
                    + "ORDER BY\n"
                    + "	hasil_rangking.rangking ASC";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getString("alternatif.alternatif_name"),
                    r.getString("hasil_rangking.value"),
                    r.getString("hasil_rangking.rangking")});
            }
            jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            buatKolomSesuai(jTable1);
        }
    }

    public void buatKolomSesuai(JTable t) {
        TableColumnModel modelKolom = t.getColumnModel();

        for (int kol = 0; kol < modelKolom.getColumnCount(); kol++) {
            int lebarKolomMax = 0;
            for (int baris = 0; baris < t.getRowCount(); baris++) {
                TableCellRenderer rend = t.getCellRenderer(baris, kol);
                Object nilaiTablel = t.getValueAt(baris, kol);
                Component comp = rend.getTableCellRendererComponent(t, nilaiTablel, false, false, baris, kol);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn kolom = modelKolom.getColumn(kol);
            kolom.setPreferredWidth(lebarKolomMax);
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

        jDesktopPaneGambarChild1 = new com.ta.johan.background.JDesktopPaneGambarChild();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "List Hasil", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jScrollPane1.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jDesktopPaneGambarChild1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneGambarChild1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneGambarChild1Layout = new javax.swing.GroupLayout(jDesktopPaneGambarChild1);
        jDesktopPaneGambarChild1.setLayout(jDesktopPaneGambarChild1Layout);
        jDesktopPaneGambarChild1Layout.setHorizontalGroup(
            jDesktopPaneGambarChild1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneGambarChild1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPaneGambarChild1Layout.setVerticalGroup(
            jDesktopPaneGambarChild1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneGambarChild1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneGambarChild1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jDesktopPaneGambarChild1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        jTable1MouseClicked(null);
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //        control.readData(this);
        //
        //        for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
        //            final DefaultCellEditor defaultEditor = (DefaultCellEditor) jTable1.getDefaultEditor(jTable1.getColumnClass(i));
        //            defaultEditor.setClickCountToStart(1000000000);
        //        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ta.johan.background.JDesktopPaneGambarChild jDesktopPaneGambarChild1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
