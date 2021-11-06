/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.johan.control;

import com.ta.johan.connect.dbconnect;
import com.ta.johan.layout.kriteria;
import com.ta.johan.layout.perhitungan;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Irawan Papang S
 */
public class control_perhitungan {

    Connection c = dbconnect.getKoneksi();

    public void resetData(kriteria view) {
        view.jTextField2.setText("");
        view.jTextField3.setText("");
        view.jButton2.setText("Save");
        view.jLabel11.setVisible(false);
        view.jButton3.setVisible(false);
        view.panelGlass2.setVisible(false);
        buatKolomSesuai(view.jTable1);
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

    public void getData(perhitungan view) {
        
        DecimalFormat df = new DecimalFormat("#.###");
        
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Subkriteria Seq");
        tabelKej.addColumn("Nama Subkriteria");
        tabelKej.addColumn("Nilai Bobot Subkriteria");
        tabelKej.addColumn("Kriteria Seq");
        tabelKej.addColumn("Nama Kriteria");
        tabelKej.addColumn("Nilai Bobot Kriteria");
        tabelKej.addColumn("Bobot Akumulasi");
        try {
            String sql = "SELECT\n"
                    + "	subkriteria.subkriteria_name, \n"
                    + "	eigen_subkriteria.nilai_eigen_subkriteria, \n"
                    + "	subkriteria.seq,\n"
                    + "	kriteria.kriteria_name, \n"
                    + "	eigen_kriteria.nilai_eigen_kriteria, \n"
                    + "	kriteria.seq\n"
                    + "FROM\n"
                    + "	eigen_kriteria\n"
                    + "	INNER JOIN\n"
                    + "	kriteria\n"
                    + "	ON \n"
                    + "	eigen_kriteria.kriteria_seq = kriteria.seq\n"
                    + "	INNER JOIN\n"
                    + "	eigen_subkriteria\n"
                    + "	ON \n"
                    + "	eigen_subkriteria.kriteria_seq = kriteria.seq\n"
                    + "	INNER JOIN\n"
                    + "	subkriteria\n"
                    + "	ON \n"
                    + "	kriteria.seq = subkriteria.kriteria_seq AND\n"
                    + "	eigen_subkriteria.subkriteria_seq = subkriteria.seq";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getInt("subkriteria.seq"),
                    r.getString("subkriteria.subkriteria_name"),
                    r.getString("eigen_subkriteria.nilai_eigen_subkriteria"), r.getInt("kriteria.seq"),
                    r.getString("kriteria.kriteria_name"),
                    r.getString("eigen_kriteria.nilai_eigen_kriteria"),
                    df.format((Double.parseDouble(r.getString("eigen_subkriteria.nilai_eigen_subkriteria")) *  Double.parseDouble(r.getString("eigen_kriteria.nilai_eigen_kriteria"))))});
            }
            view.jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
            view.jTable1.getColumnModel().getColumn(4).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(4).setMaxWidth(0);
        }
    }

}
