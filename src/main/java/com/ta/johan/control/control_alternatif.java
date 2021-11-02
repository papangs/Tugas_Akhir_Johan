/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.johan.control;

import com.ta.johan.connect.dbconnect;
import com.ta.johan.layout.alternatif;
import com.ta.johan.layout.subkriteria;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class control_alternatif {

    Connection c = dbconnect.getKoneksi();
//    ResultSet r;
//    Statement s;
    int jum11 = 0;

    public void resetData(alternatif view) {
        view.jTextField2.setText("");
        view.jTextField3.setText("");
        view.jButton2.setText("Save");
        view.jLabel11.setVisible(false);
        view.jLabel13.setVisible(false);
        view.jButton3.setVisible(false);
        view.jLabel13.setText("-");
        view.jLabel11.setText("-");
        view.jTextField4.setText("");
        view.jButton4.setVisible(false);
        view.jTextField4.setVisible(false);
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

    public void getData(alternatif view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Nama Alternatif");
        tabelKej.addColumn("Subkriteria Seq");
        tabelKej.addColumn("Nama Subkriteria");
        tabelKej.addColumn("Kriteria Seq");
        tabelKej.addColumn("Nama Kriteria");
        try {
            String sql = "SELECT\n"
                    + "	alternatif.seq, \n"
                    + "	alternatif.alternatif_name, \n"
                    + "	subkriteria.seq, \n"
                    + "	subkriteria.subkriteria_name, \n"
                    + "	kriteria.seq, \n"
                    + "	kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "	alternatif\n"
                    + "	INNER JOIN\n"
                    + "	subkriteria\n"
                    + "	ON \n"
                    + "	alternatif.subkriteria_seq = subkriteria.seq\n"
                    + "	INNER JOIN\n"
                    + "	kriteria\n"
                    + "	ON \n"
                    + "	subkriteria.kriteria_seq = kriteria.seq";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {
                tabelKej.addRow(new Object[]{n++, r.getInt("alternatif.seq"),
                    r.getString("alternatif.alternatif_name"), r.getInt("subkriteria.seq"),
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
            view.jTable1.getColumnModel().getColumn(5).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(5).setMaxWidth(0);
            resetData(view);
        }
    }

    public void saveData(alternatif view) {
        try {
            if (view.jButton2.getText().equals("Save")) {

                if (view.jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    String sql = "insert into alternatif set \n"
                            + "alternatif_name='" + view.jTextField2.getText() + "',"
                            + "subkriteria_seq='" + view.jLabel13.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                }

            } else {

                if (view.jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    String sql = "update alternatif set \n"
                            + "alternatif_name='" + view.jTextField2.getText() + "',"
                            + "subkriteria_seq='" + view.jLabel13.getText() + "'"
                            + "where seq ='" + view.jLabel11.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Data Unsuccessful Entry", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readData(alternatif view) {
        int a = view.jTable1.getSelectedRow();
        String query = "SELECT\n"
                + "alternatif.seq, \n"
                + "alternatif.alternatif_name\n"
                + "FROM\n"
                + "alternatif\n"
                + "WHERE\n"
                + "alternatif.seq = '" + view.jTable1.getValueAt(a, 1) + "'";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            String seq = "";
            String subcriteria_name = "";

            while (r.next()) {
                seq = r.getString("alternatif.seq");
                subcriteria_name = r.getString("alternatif.alternatif_name");
            }

            view.jLabel11.setText(seq);
            view.jTextField2.setText(subcriteria_name);
        } catch (SQLException e) {
        } finally {
            view.jButton2.setText("Update");
            view.jButton3.setVisible(true);
        }
    }

    public void deleteData(alternatif view) {
        int yakin = JOptionPane.showConfirmDialog(view, "Are You Sure Want To Delete This data", "Delete", JOptionPane.YES_NO_OPTION);
        if (yakin == JOptionPane.YES_OPTION) {
            String sql = "delete from alternatif where seq='" + view.jLabel11.getText() + "'";
            try {
                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();

                getData(view);
                getDataSubkriteria(view);
                getDataAlternatifSubkriteria(view);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Data Not Succeed in Delete", "ERROR", JOptionPane.ERROR_MESSAGE);

            } finally {
            }
        } else {
            getData(view);
            getDataSubkriteria(view);
            getDataAlternatifSubkriteria(view);
        }
    }

    public void searchData(alternatif view) {
        String search = String.valueOf(view.jTextField3.getText());
        try {
            int no = 1;
            String query = "SELECT\n"
                    + "alternatif.seq, \n"
                    + "alternatif.alternatif_name, \n"
                    + "subkriteria.seq, \n"
                    + "subkriteria.subkriteria_name, \n"
                    + "kriteria.seq, \n"
                    + "kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "alternatif\n"
                    + "INNER JOIN\n"
                    + "subkriteria\n"
                    + "ON \n"
                    + "alternatif.subkriteria_seq = subkriteria.seq\n"
                    + "INNER JOIN\n"
                    + "kriteria\n"
                    + "ON \n"
                    + "subkriteria.kriteria_seq = kriteria.seq\n"
                    + "where alternatif.alternatif_name like '%" + search + "%' "
                    + "OR subkriteria.subkriteria_name like '%" + search + "%'"
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
                    vector.addElement(rs.getString("alternatif.seq"));
                    vector.addElement(rs.getString("alternatif.alternatif_name"));
                    vector.addElement(rs.getString("subkriteria.seq"));
                    vector.addElement(rs.getString("subkriteria.subkriteria_name"));
                    vector.addElement(rs.getString("kriteria.seq"));
                    vector.addElement(rs.getString("kriteria.kriteria_name"));

                    tableModel.addRow(vector);
                }
            }
        } catch (SQLException e) {
        }
    }

    public void getDataSubkriteria(alternatif view) {
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
            view.jTable2.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable2.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
            view.jTable2.getColumnModel().getColumn(3).setMinWidth(0);
            view.jTable2.getColumnModel().getColumn(3).setMaxWidth(0);
            view.jTable2.getColumnModel().getColumn(4).setMinWidth(0);
            view.jTable2.getColumnModel().getColumn(4).setMaxWidth(0);
            resetData(view);
        }
    }

    public void saveDataAlternatif(alternatif view) {
        try {

            String query = "SELECT\n"
                    + "	alternatif.seq, \n"
                    + "	alternatif.alternatif_name \n"
                    + "FROM\n"
                    + "	alternatif\n"
                    + "GROUP BY\n"
                    + "	alternatif.seq\n"
                    + "ORDER BY\n"
                    + "	alternatif.seq DESC\n"
                    + "LIMIT 1";

            int id = 0;

            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                id = rs.getInt("alternatif.seq");
            }

            id = id + 1;

            if (view.jButton2.getText().equals("Save")) {

                if (view.jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {

                    String sql1 = "insert into alternatif set \n"
                            + "seq='" + id + "',"
                            + "alternatif_name='" + view.jTextField2.getText() + "'";

                    PreparedStatement p221 = c.prepareStatement(sql1);
                    p221.executeUpdate();
                    p221.close();

                    for (int i = 0; i < view.jTable2.getRowCount(); i++) {
                        String sql = "insert into alternatif_subkriteria set \n"
                                + "alternatif_seq='" + id + "',"
                                + "subkriteria_seq='" + view.jTable2.getValueAt(i, 1) + "'";

                        PreparedStatement p22 = c.prepareStatement(sql);
                        p22.executeUpdate();
                        p22.close();
                    }

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                    getDataAlternatifSubkriteria(view);
                }

            } else {

                if (view.jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {

                    String sql1 = "delete from alternatif where seq='" + view.jLabel11.getText() + "'";

                    PreparedStatement p221 = c.prepareStatement(sql1);
                    p221.executeUpdate();
                    p221.close();

                    String sql2 = "insert into alternatif set \n"
                            + "seq='" + id + "',"
                            + "alternatif_name='" + view.jTextField2.getText() + "'";

                    PreparedStatement p2212 = c.prepareStatement(sql2);
                    p2212.executeUpdate();
                    p2212.close();

                    for (int i = 0; i < view.jTable2.getRowCount(); i++) {
                        String sql = "insert into alternatif_subkriteria set \n"
                                + "alternatif_seq='" + id + "',"
                                + "subkriteria_seq='" + view.jTable2.getValueAt(i, 1) + "'";

                        PreparedStatement p22 = c.prepareStatement(sql);
                        p22.executeUpdate();
                        p22.close();
                    }

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);
                    getDataAlternatifSubkriteria(view);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Data Unsuccessful Entry", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setttablematrix(JTable table, int row, String[] namakolom) {
        int lenghtnamakolom = namakolom.length;
        String[] data = new String[lenghtnamakolom];

        for (int j = 0; j < data.length; j++) {
        }
        DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(new Object[][]{data}, namakolom);
        table.setModel(tableModel);

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < data.length; j++) {
            }
            ((DefaultTableModel) table.getModel()).addRow(data);
        }
    }

    public void getDataAlternatifSubkriteria(alternatif view) {

        String query = "SELECT\n"
                + "alternatif.seq, \n"
                + "alternatif.alternatif_name \n"
                + "FROM\n"
                + "alternatif\n"
                + "GROUP BY\n"
                + "alternatif.alternatif_name";

        jum11 = 0;

        try {

            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                jum11 = jum11 + 1;
            }

            int aa = Integer.parseInt(jum11 + "");
            int aaa = view.jTable2.getRowCount();

            String[] c1 = new String[aaa + 1 + 1 + 1];

            for (int i1 = 0; i1 < aaa; i1++) {
                for (int i = 0; i < 1; i++) {
                    c1[i] = "NO";
                    c1[i + 1] = "Alternatif Seq";
                    c1[i + 1 + 1] = "Alternatif Name";
                    c1[i1 + 1 + 1 + 1] = (String) view.jTable2.getValueAt(i1, 2);
                }
            }

            setttablematrix(view.jTable1, aa, c1);

            //No
            for (int i3 = 0; i3 < aa; i3++) {
                view.jTable1.setValueAt(i3 + 1, i3, 0);
            }

            //set seq
            String seq = "";
            int e1 = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    seq = res11.getString("alternatif.seq");
                    view.jTable1.setValueAt(seq, e1++, 1);
                }
            } catch (SQLException f) {
            }

            //set nama
            String nama = "";
            int e = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    nama = res11.getString("alternatif.alternatif_name");
                    view.jTable1.setValueAt(nama, e++, 2);
                }
            } catch (SQLException f) {
            }

            //nilai
            for (int i2 = 0; i2 < aaa; i2++) {

                String nilai = "";
                String taun = "";

                String sql3 = "SELECT\n"
                        + "alternatif_subkriteria.seq, \n"
                        + "alternatif.alternatif_name, \n"
                        + "alternatif.seq, \n"
                        + "subkriteria.subkriteria_name, \n"
                        + "subkriteria.seq\n"
                        + "FROM\n"
                        + "alternatif_subkriteria\n"
                        + "INNER JOIN\n"
                        + "alternatif\n"
                        + "ON \n"
                        + "alternatif_subkriteria.alternatif_seq = alternatif.seq\n"
                        + "INNER JOIN\n"
                        + "subkriteria\n"
                        + "ON \n"
                        + "alternatif_subkriteria.subkriteria_seq = subkriteria.seq\n"
                        + "WHERE\n"
                        + "subkriteria.seq = '" + view.jTable2.getValueAt(i2, 1) + "'\n"
                        + "GROUP BY\n"
                        + "alternatif.seq";

                try {
                    Statement stat3 = c.createStatement();
                    ResultSet res3 = stat3.executeQuery(sql3);
                    int dd = 0;
                    int baris = 0;
                    while (res3.next()) {

                        nilai = res3.getString("subkriteria.subkriteria_name");
                        dd = dd + 1;

                        view.jTable1.setValueAt(nilai, dd - 1, i2 + 3);
                    }
                } catch (SQLException g) {
                }
            }
        } catch (SQLException e) {
        } finally {
            view.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        }

    }

//    public int getJumlah(Matrix_Alternatif view) {
//
//        int jumlah = 0;
//        
//        try {
//            String sql = "SELECT\n"
//                    + "alternatif.seq, \n"
//                    + "alternatif.alternatif_name, \n"
//                    + "alternatif.kategori_seq, \n"
//                    + "kategori_alternatif.kategori_name\n"
//                    + "FROM\n"
//                    + "alternatif\n"
//                    + "INNER JOIN\n"
//                    + "kategori_alternatif\n"
//                    + "ON \n"
//                    + "alternatif.kategori_seq = kategori_alternatif.seq\n"
//                    + "WHERE alternatif.kategori_seq = '"+view.jLabel10.getText()+"'";
//
//            Statement st = c.createStatement();
//            ResultSet r = st.executeQuery(sql);
//
//            while (r.next()) {
//                jumlah++;
//            }
//
//        } catch (Exception e) {
//        }
//        return jumlah;
//    }
//
//    public List<HashMap<String, Object>> getDataAlternatif(Matrix_Alternatif view) {
//
//        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
//
//        try {
//            String sql = "SELECT\n"
//                    + "alternatif.seq, \n"
//                    + "alternatif.alternatif_name, \n"
//                    + "alternatif.kategori_seq, \n"
//                    + "kategori_alternatif.kategori_name\n"
//                    + "FROM\n"
//                    + "alternatif\n"
//                    + "INNER JOIN\n"
//                    + "kategori_alternatif\n"
//                    + "ON \n"
//                    + "alternatif.kategori_seq = kategori_alternatif.seq\n"
//                    + "WHERE alternatif.kategori_seq = '"+view.jLabel10.getText()+"'";
//
//            Statement st = c.createStatement();
//            ResultSet r = st.executeQuery(sql);
//
//            while (r.next()) {
//                
//                HashMap<String, Object> map = new HashMap<String, Object>();
//                map.put("id", r.getString("alternatif.seq"));
//                map.put("nama", r.getString("alternatif.alternatif_name"));
//                map.put("idKategori", r.getString("alternatif.kategori_seq"));
//
//                maps.add(map);
//            }
//
//        } catch (Exception e) {
//        }
//        return maps;
//    }
}
