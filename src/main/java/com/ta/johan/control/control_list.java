/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.johan.control;

import com.ta.johan.connect.dbconnect;
import com.ta.johan.layout.config_list;
import com.ta.johan.layout.kriteria;
import com.ta.johan.layout.subkriteria;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Irawan Papang S
 */
public class control_list {

    Connection c = dbconnect.getKoneksi();
//    ResultSet r;
//    Statement s;

    public void resetData(config_list view) {
        view.jLabel10.setVisible(false);
        view.jLabel11.setVisible(false);
        view.jLabel11.setText("---");
        view.jLabel12.setText("---");
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

    public void getDataKriteria(config_list view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Nama");
        try {
            String sql = "SELECT\n"
                    + "kriteria.seq,\n"
                    + "kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "kriteria";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getInt("kriteria.seq"),
                    r.getString("kriteria.kriteria_name")});
            }
            view.jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
            resetData(view);
        }
    }

    public void readDataKriteria(config_list view) {
        int a = view.jTable1.getSelectedRow();
        String query = "SELECT\n"
                + "kriteria.seq,\n"
                + "kriteria.kriteria_name\n"
                + "FROM\n"
                + "kriteria\n"
                + "WHERE kriteria.seq = '" + view.jTable1.getValueAt(a, 1) + "'";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            String seq = "";
            String criteria_name = "";

            while (r.next()) {
                seq = r.getString("kriteria.seq");
                criteria_name = r.getString("kriteria.kriteria_name");
            }

            view.jLabel11.setText(seq);
            view.jLabel12.setText(criteria_name);
        } catch (SQLException e) {
        } finally {
        }
    }

    public void searchKriteria(config_list view) {
        String search = String.valueOf(view.jTextField2.getText());
        try {
            int no = 1;
            String query = "SELECT\n"
                    + "kriteria.seq,\n"
                    + "kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "kriteria\n"
                    + "where kriteria.seq like '%" + search + "%' "
                    + "OR kriteria.kriteria_name like '%" + search + "%'";

            Statement statement = (Statement) c.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                DefaultTableModel tableModel = (DefaultTableModel) view.jTable1.getModel();
                int i = 0;
                while (i < view.jTable1.getRowCount()) {
                    tableModel.removeRow(i);
                }
                rs.beforeFirst();

                int j = 1;
                while (rs.next()) {
                    Vector vector = new Vector();
                    vector.addElement(j++);
                    vector.addElement(rs.getString("kriteria.seq"));
                    vector.addElement(rs.getString("kriteria.kriteria_name"));

                    tableModel.addRow(vector);
                }
            }
        } catch (SQLException e) {
        }
    }

    public void getDataSubkriteria(config_list view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Nama Subkriteria");
        tabelKej.addColumn("Seq Kriteria");
        tabelKej.addColumn("Nama Kriteria");
        try {
            String sql = "SELECT\n"
                    + "	subkriteria.seq, \n"
                    + "	subkriteria.subkriteria_name, \n"
                    + "	kriteria.kriteria_name, \n"
                    + "	kriteria.seq\n"
                    + "FROM\n"
                    + "	subkriteria\n"
                    + "	INNER JOIN\n"
                    + "	kriteria\n"
                    + "	ON subkriteria.kriteria_seq = kriteria.seq";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++,
                    r.getInt("subkriteria.seq"),
                    r.getString("subkriteria.subkriteria_name"), r.getInt("kriteria.seq"),
                    r.getString("kriteria.kriteria_name")});
            }
            view.jTable1.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
            view.jTable1.getColumnModel().getColumn(3).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
        }
    }
}
