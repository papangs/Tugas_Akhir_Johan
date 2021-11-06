/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.johan.control;

import com.ta.johan.connect.dbconnect;
import com.ta.johan.layout.home;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Irawan Papang S
 */
public class control_home {

    Connection c = dbconnect.getKoneksi();

    public void getData(home view) {
        grafikbar(view);
        getDataRangking(view);
    }

    public void grafikbar(home view) {
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
            view.jPanel1.setVisible(true);
            view.jPanel1.removeAll();
            view.jPanel1.add(barpanel, BorderLayout.CENTER);
            view.jPanel1.validate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void getDataRangking(home view) {

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
            view.jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            buatKolomSesuai(view.jTable1);
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
}