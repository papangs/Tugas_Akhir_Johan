/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.johan.control;

import com.ta.johan.connect.dbconnect;
import com.ta.johan.layout.kriteria;
import com.ta.johan.layout.perhitungan;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class control_perhitungan {

    Connection c = dbconnect.getKoneksi();
    int jum11 = 0;

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

    public void getData(perhitungan view) {
        getDataPerkalian(view);
        getJumlahSubdankrit(view);
        getDataSubdankrit(view);
        getJumlahAlternatif(view);
        getDataAlternatif(view);
    }

    public void getDataPerkalian(perhitungan view) {

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
                    df.format((Double.parseDouble(r.getString("eigen_subkriteria.nilai_eigen_subkriteria")) * Double.parseDouble(r.getString("eigen_kriteria.nilai_eigen_kriteria"))))});
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

    public int getJumlahSubdankrit(perhitungan view) {

        int jumlah = 0;

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
                    + "	ON \n"
                    + "	subkriteria.kriteria_seq = kriteria.seq";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {
                jumlah++;
            }

        } catch (Exception e) {
        }
        return jumlah;
    }

    public List<HashMap<String, Object>> getDataSubdankrit(perhitungan view) {

        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();

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
                    + "	ON \n"
                    + "	subkriteria.kriteria_seq = kriteria.seq";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("id", r.getString("subkriteria.seq"));
                map.put("nama", (r.getString("subkriteria.subkriteria_name") + "\n (" + r.getString("kriteria.kriteria_name") + ")"));

                maps.add(map);
            }

        } catch (Exception e) {
        }
        return maps;
    }

    public int getJumlahAlternatif(perhitungan view) {

        int jumlah = 0;

        try {
            String sql = "SELECT\n"
                    + "	alternatif.seq, \n"
                    + "	alternatif.alternatif_name\n"
                    + "FROM\n"
                    + "	alternatif";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {
                jumlah++;
            }

        } catch (Exception e) {
        }
        return jumlah;
    }

    public List<HashMap<String, Object>> getDataAlternatif(perhitungan view) {

        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();

        try {
            String sql = "SELECT\n"
                    + "	alternatif.seq, \n"
                    + "	alternatif.alternatif_name\n"
                    + "FROM\n"
                    + "	alternatif";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("id", r.getString("alternatif.seq"));
                map.put("nama", r.getString("alternatif.alternatif_name"));

                maps.add(map);
            }

        } catch (Exception e) {
        }
        return maps;
    }

    public void getDataHasilMatrix(perhitungan view) {

        String query = "SELECT\n"
                + "alternatif.seq, \n"
                + "alternatif.alternatif_name\n"
                + "FROM\n"
                + "alternatif";

        jum11 = 0;

        try {

            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                jum11 = jum11 + 1;
            }

            int aa = Integer.parseInt(jum11 + "");
            System.out.println("aa : " + aa);
            int aaa = getJumlahSubdankrit(view);

            List<HashMap<String, Object>> df = getDataSubdankrit(view);

            String[] c1 = new String[aaa + 1 + 1 + 1];

            for (int i1 = 0; i1 < aaa; i1++) {
                for (int i = 0; i < 1; i++) {
                    c1[i] = "NO";
                    c1[i + 1] = "Alternatif Seq";
                    c1[i + 1 + 1] = "Alternatif";
                    c1[i1 + 1 + 1 + 1] = (String) df.get(i1).get("nama").toString();
                }
            }

            setttablematrix(view.jTable2, aa, c1);

            //No
            for (int i3 = 0; i3 < aa; i3++) {
                view.jTable2.setValueAt(i3 + 1, i3, 0);
            }

            //set seq
            String seq = "";
            int e1 = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    seq = res11.getString("alternatif.seq");
                    view.jTable2.setValueAt(seq, e1++, 1);
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
                    view.jTable2.setValueAt(nama, e++, 2);
                }
            } catch (SQLException f) {
            }

//            nilai
            for (int i2 = 0; i2 < aaa; i2++) {

                String nilai = "";
                String taun = "";

                String sql = "SELECT\n"
                        + "eigen_alternatif.nilai_eigen_alternatif, \n"
                        + "eigen_alternatif.create_date, \n"
                        + "alternatif.seq, \n"
                        + "alternatif.alternatif_name, \n"
                        + "subkriteria.seq, \n"
                        + "subkriteria.subkriteria_name, \n"
                        + "kriteria.seq, \n"
                        + "kriteria.kriteria_name\n"
                        + "FROM\n"
                        + "eigen_alternatif\n"
                        + "INNER JOIN\n"
                        + "alternatif\n"
                        + "ON \n"
                        + "eigen_alternatif.alternatif_seq = alternatif.seq\n"
                        + "INNER JOIN\n"
                        + "subkriteria\n"
                        + "ON \n"
                        + "eigen_alternatif.subkriteria_seq = subkriteria.seq\n"
                        + "INNER JOIN\n"
                        + "kriteria\n"
                        + "ON \n"
                        + "eigen_alternatif.kriteria_seq = kriteria.seq AND\n"
                        + "subkriteria.kriteria_seq = kriteria.seq\n"
                        + "WHERE\n"
                        + "eigen_alternatif.subkriteria_seq = '" + df.get(i2).get("id").toString() + "'\n"
                        + "GROUP BY\n"
                        + "eigen_alternatif.seq";

                try {
                    Statement stat3 = c.createStatement();
                    ResultSet res3 = stat3.executeQuery(sql);
                    int dd = 0;
                    int baris = 0;
                    while (res3.next()) {

                        nilai = res3.getString("eigen_alternatif.nilai_eigen_alternatif");
                        dd = dd + 1;

                        view.jTable2.setValueAt(nilai, dd - 1, i2 + 3);
                    }
                } catch (SQLException g) {
                }
            }
        } catch (SQLException e) {
        } finally {
            buatKolomSesuai(view.jTable2);
            view.jTable2.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        }

    }

    public void getDataHasil(perhitungan view) {

        DecimalFormat batas = new DecimalFormat("#.###");

        String query = "SELECT\n"
                + "alternatif.seq, \n"
                + "alternatif.alternatif_name\n"
                + "FROM\n"
                + "alternatif";

        jum11 = 0;

        try {

            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                jum11 = jum11 + 1;
            }

            int aa = Integer.parseInt(jum11 + "");
            System.out.println("aa : " + aa);
            int aaa = getJumlahSubdankrit(view);

            List<HashMap<String, Object>> df = getDataSubdankrit(view);

            String[] c1 = new String[aaa + 1 + 1 + 1 + 1 + 1];

            for (int i1 = 0; i1 < aaa; i1++) {
                for (int i = 0; i < 1; i++) {
                    c1[i] = "NO";
                    c1[i + 1] = "Alternatif Seq";
                    c1[i + 1 + 1] = "Alternatif";
                    c1[i1 + 1 + 1 + 1] = (String) df.get(i1).get("nama").toString();
                    c1[i1 + 1 + 1 + 1 + 1] = "Total";
                    c1[i1 + 1 + 1 + 1 + 1 + 1] = "Rangking";
                }
            }

            setttablematrix(view.jTable5, aa, c1);

            //No
            for (int i3 = 0; i3 < aa; i3++) {
                view.jTable5.setValueAt(i3 + 1, i3, 0);
            }

            //set seq
            String seq = "";
            int e1 = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    seq = res11.getString("alternatif.seq");
                    view.jTable5.setValueAt(seq, e1++, 1);
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
                    view.jTable5.setValueAt(nama, e++, 2);
                }
            } catch (SQLException f) {
            }

            int eigen = view.jTable1.getRowCount();
            int assessment = view.jTable2.getRowCount();

            for (int h = 0; h < assessment; h++) {
                double plus = 0.0;
                double kali = 0.0;
                double geteigen = 0.0;
                double getassessment = 0.0;

                for (int i = 0; i < eigen; i++) {
                    geteigen = Double.parseDouble(view.jTable1.getValueAt(i, 7).toString());
                    getassessment = Double.parseDouble(view.jTable2.getValueAt(h, i + 3).toString());
                    kali = geteigen * getassessment;
                    plus += kali;

                    view.jTable5.setValueAt(batas.format(kali), h, i + 3);
                }
                view.jTable5.setValueAt(batas.format(plus), h, eigen + 3);
            }

            double[] Array = new double[assessment];
            int asc = 0;
            for (int i = 0; i < assessment; i++) {
                Array[i] = Double.parseDouble(view.jTable5.getValueAt(i, eigen + 3).toString());
            }

            int rank[] = getRanksArray(Array);
            for (int i = 0; i < view.jTable5.getRowCount(); i++) {
                view.jTable5.setValueAt(rank[i], i, eigen + 4);
            }

        } catch (SQLException e) {
        } finally {
            buatKolomSesuai(view.jTable5);
            view.jTable5.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable5.getColumnModel().getColumn(1).setMaxWidth(0);
            saveDataHasil(view);
            getRangking(view);
        }

    }

    public void getDataHasilUrut(perhitungan view) {

        DecimalFormat batas = new DecimalFormat("#.###");

        String query = "SELECT\n"
                + "hasil_rangking.`value`, \n"
                + "hasil_rangking.rangking, \n"
                + "alternatif.seq, \n"
                + "alternatif.alternatif_name\n"
                + "FROM\n"
                + "hasil_rangking\n"
                + "INNER JOIN\n"
                + "alternatif\n"
                + "ON \n"
                + "hasil_rangking.alternatif_seq = alternatif.seq\n"
                + "ORDER BY\n"
                + "hasil_rangking.rangking ASC";

        jum11 = 0;

        try {

            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                jum11 = jum11 + 1;
            }

            int aa = Integer.parseInt(jum11 + "");
            System.out.println("aa : " + aa);
            int aaa = getJumlahSubdankrit(view);

            List<HashMap<String, Object>> df = getDataSubdankrit(view);

            String[] c1 = new String[aaa + 1 + 1 + 1 + 1 + 1];

            for (int i1 = 0; i1 < aaa; i1++) {
                for (int i = 0; i < 1; i++) {
                    c1[i] = "NO";
                    c1[i + 1] = "Alternatif Seq";
                    c1[i + 1 + 1] = "Alternatif";
                    c1[i1 + 1 + 1 + 1] = (String) df.get(i1).get("nama").toString();
                    c1[i1 + 1 + 1 + 1 + 1] = "Total";
                    c1[i1 + 1 + 1 + 1 + 1 + 1] = "Rangking";
                }
            }

            setttablematrix(view.jTable5, aa, c1);

            //No
            for (int i3 = 0; i3 < aa; i3++) {
                view.jTable5.setValueAt(i3 + 1, i3, 0);
            }

            //set seq
            String seq = "";
            int e1 = 0;
            try {
                Statement stat11 = c.createStatement();
                ResultSet res11 = stat11.executeQuery(query);
                while (res11.next()) {
                    seq = res11.getString("alternatif.seq");
                    view.jTable5.setValueAt(seq, e1++, 1);
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
                    view.jTable5.setValueAt(nama, e++, 2);
                }
            } catch (SQLException f) {
            }

//            nilai
            for (int i2 = 0; i2 < aaa; i2++) {

                String nilai = "";
                String taun = "";

                String sql = "SELECT\n"
                        + "eigen_alternatif.nilai_eigen_alternatif, \n"
                        + "eigen_alternatif.create_date, \n"
                        + "alternatif.seq, \n"
                        + "alternatif.alternatif_name, \n"
                        + "subkriteria.seq, \n"
                        + "subkriteria.subkriteria_name, \n"
                        + "kriteria.seq, \n"
                        + "kriteria.kriteria_name\n"
                        + "FROM\n"
                        + "eigen_alternatif\n"
                        + "INNER JOIN\n"
                        + "alternatif\n"
                        + "ON \n"
                        + "eigen_alternatif.alternatif_seq = alternatif.seq\n"
                        + "INNER JOIN\n"
                        + "subkriteria\n"
                        + "ON \n"
                        + "eigen_alternatif.subkriteria_seq = subkriteria.seq\n"
                        + "INNER JOIN\n"
                        + "kriteria\n"
                        + "ON \n"
                        + "eigen_alternatif.kriteria_seq = kriteria.seq AND\n"
                        + "subkriteria.kriteria_seq = kriteria.seq\n"
                        + "INNER JOIN\n"
                        + "hasil_rangking\n"
                        + "ON \n"
                        + "alternatif.seq = hasil_rangking.alternatif_seq\n"
                        + "WHERE\n"
                        + "eigen_alternatif.subkriteria_seq = '" + df.get(i2).get("id").toString() + "'\n"
                        + "GROUP BY\n"
                        + "eigen_alternatif.seq\n"
                        + "ORDER BY\n"
                        + "hasil_rangking.rangking ASC";

                try {
                    Statement stat3 = c.createStatement();
                    ResultSet res3 = stat3.executeQuery(sql);
                    int dd = 0;
                    int baris = 0;
                    while (res3.next()) {

                        nilai = res3.getString("eigen_alternatif.nilai_eigen_alternatif");
                        dd = dd + 1;

                        view.jTable5.setValueAt(nilai, dd - 1, i2 + 3);
                    }
                } catch (SQLException g) {
                }
            }

            int eigen = view.jTable1.getRowCount();
            int assessment = view.jTable5.getRowCount();

            for (int h = 0; h < assessment; h++) {
                double plus = 0.0;
                double kali = 0.0;
                double geteigen = 0.0;
                double getassessment = 0.0;

                for (int i = 0; i < eigen; i++) {
                    geteigen = Double.parseDouble(view.jTable1.getValueAt(i, 7).toString());
                    getassessment = Double.parseDouble(view.jTable5.getValueAt(h, i + 3).toString());
                    kali = geteigen * getassessment;
                    plus += kali;

                    view.jTable5.setValueAt(batas.format(kali), h, i + 3);
                }
                view.jTable5.setValueAt(batas.format(plus), h, eigen + 3);
            }

            double[] Array = new double[assessment];
            int asc = 0;
            for (int i = 0; i < assessment; i++) {
                Array[i] = Double.parseDouble(view.jTable5.getValueAt(i, eigen + 3).toString());
            }

            int rank[] = getRanksArray(Array);
            for (int i = 0; i < view.jTable5.getRowCount(); i++) {
                view.jTable5.setValueAt(rank[i], i, eigen + 4);
            }

        } catch (SQLException e) {
        } finally {
            buatKolomSesuai(view.jTable5);
            view.jTable5.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable5.getColumnModel().getColumn(1).setMaxWidth(0);
            getRangking(view);
        }

    }

    public void saveDataHasil(perhitungan view) {

        try {
            int eigen = view.jTable1.getRowCount();

            String sqlq = "TRUNCATE hasil_rangking";
            PreparedStatement t = c.prepareStatement(sqlq);
            t.executeUpdate();
            t.close();

            for (int i = 0; i < view.jTable5.getRowCount(); i++) {

                String sql = "insert into hasil_rangking set alternatif_seq ='" + view.jTable5.getValueAt(i, 1) + "',"
                        + "value = '" + view.jTable5.getValueAt(i, eigen + 3) + "',"
                        + "rangking = '" + view.jTable5.getValueAt(i, eigen + 4) + "'";

                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Data Unsuccessful Entry", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int[] getRanksArray(double[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[i]) {
                    count++;
                }
            }
            result[i] = count + 1;
        }
        return result;
    }

    public void getRangking(perhitungan view) {

        String query = "SELECT\n"
                + "hasil_rangking.value, \n"
                + "hasil_rangking.rangking, \n"
                + "hasil_rangking.seq, \n"
                + "alternatif.alternatif_name\n"
                + "FROM\n"
                + "hasil_rangking\n"
                + "INNER JOIN\n"
                + "alternatif\n"
                + "ON \n"
                + "hasil_rangking.alternatif_seq = alternatif.seq\n"
                + "WHERE\n"
                + "hasil_rangking.rangking = 1";

        String id = "";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            while (r.next()) {
                id = r.getString("alternatif.alternatif_name") + " : " + r.getString("hasil_rangking.value");
            }
            view.buttonGlass2.setText(id + "");
        } catch (Exception e) {
        }
    }
}
