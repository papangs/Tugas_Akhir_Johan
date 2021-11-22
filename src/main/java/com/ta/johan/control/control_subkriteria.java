/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.johan.control;

import com.ta.johan.connect.dbconnect;
import com.ta.johan.layout.kriteria;
import com.ta.johan.layout.subkriteria;
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
import java.util.Hashtable;
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
public class control_subkriteria {

    Connection c = dbconnect.getKoneksi();

    public void resetData(subkriteria view) {
        view.jTextField2.setText("");
        view.jTextField3.setText("");
        view.jButton2.setText("Save");
        view.jLabel11.setVisible(false);
        view.jLabel13.setVisible(false);
        view.jButton3.setVisible(false);
        view.jLabel13.setText("-");
        view.jLabel11.setText("-");
        view.jTextField4.setText("");
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

    public void getData(subkriteria view) {
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
            resetData(view);
        }
    }

    public void saveData(subkriteria view) {
        try {
            if (view.jButton2.getText().equals("Save")) {

                if (view.jTextField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    String sql = "insert into subkriteria set \n"
                            + "subkriteria_name='" + view.jTextField2.getText() + "',"
                            + "kriteria_seq='" + view.jLabel13.getText() + "'";

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
                    String sql = "update subkriteria set \n"
                            + "subkriteria_name='" + view.jTextField2.getText() + "',"
                            + "kriteria_seq='" + view.jLabel13.getText() + "'"
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

    public void readData(subkriteria view) {
        int a = view.jTable1.getSelectedRow();
        String query = "SELECT\n"
                + "subkriteria.seq, \n"
                + "subkriteria.subkriteria_name, \n"
                + "kriteria.kriteria_name, \n"
                + "kriteria.seq\n"
                + "FROM\n"
                + "subkriteria\n"
                + "INNER JOIN\n"
                + "kriteria\n"
                + "ON subkriteria.kriteria_seq = kriteria.seq\n"
                + "WHERE subkriteria.seq = '" + view.jTable1.getValueAt(a, 1) + "'";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            String seq = "";
            String subcriteria_name = "";
            String seq_kriteria = "";
            String criteria_name = "";

            while (r.next()) {
                seq = r.getString("subkriteria.seq");
                subcriteria_name = r.getString("subkriteria.subkriteria_name");
                seq_kriteria = r.getString("kriteria.seq");
                criteria_name = r.getString("kriteria.kriteria_name");
            }

            view.jLabel11.setText(seq);
            view.jTextField2.setText(subcriteria_name);
            view.jLabel13.setText(seq_kriteria);
            view.jTextField4.setText(criteria_name);
        } catch (SQLException e) {
        } finally {
            view.jButton2.setText("Update");
            view.jButton3.setVisible(true);
        }
    }

    public void deleteData(subkriteria view) {
        int yakin = JOptionPane.showConfirmDialog(view, "Are You Sure Want To Delete This data", "Delete", JOptionPane.YES_NO_OPTION);
        if (yakin == JOptionPane.YES_OPTION) {
            String sql = "delete from subkriteria where seq='" + view.jLabel11.getText() + "'";
            try {
                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();

                getData(view);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Data Not Succeed in Delete", "ERROR", JOptionPane.ERROR_MESSAGE);

            } finally {
            }
        } else {
            getData(view);
        }
    }

    public void searchData(subkriteria view) {
        String search = String.valueOf(view.jTextField3.getText());
        try {
            int no = 1;
            String query = "SELECT\n"
                    + "subkriteria.seq, \n"
                    + "subkriteria.subkriteria_name, \n"
                    + "kriteria.kriteria_name, \n"
                    + "kriteria.seq\n"
                    + "FROM\n"
                    + "subkriteria\n"
                    + "INNER JOIN\n"
                    + "kriteria\n"
                    + "ON subkriteria.kriteria_seq = kriteria.seq\n"
                    + "where subkriteria.subkriteria_name like '%" + search + "%' "
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

    //================================================================== PEMBOBOTAN =======================================================
    public void getDataGlobal(subkriteria view) {
        view.jScrollPane3.setVisible(false);
        view.buttonGroup1.clearSelection();
        view.jRadioButton1.setText("-");
        view.jRadioButton2.setText("-");
        view.jLabel7.setVisible(false);
        view.jLabel8.setVisible(false);
        view.jLabel14.setVisible(false);
        view.jLabel3.setVisible(false);
        view.jLabel3.setText("---");
        view.jLabel2.setText("---");
        view.jTextField5.setText("");
        view.jButton6.setVisible(false);
        view.jButton8.setVisible(false);
        view.jButton9.setVisible(false);
        view.panelGlass2.setVisible(false);
        view.panelGlass3.setVisible(false);
        view.panelGlass4.setVisible(false);
        view.jButton5.setVisible(false);
        getDataKriteria(view);
        getDataSubkriteria(view);
        Matrix(view);
        getPerbandinganSubkriteria(view);
        label(view);
        view.jSlider1.setValue(8);
        comboSubkriteria(view);
        comboSubkriteria1(view);
    }

    public void getDataRefresh(subkriteria view) {
        view.buttonGroup1.clearSelection();
        view.jRadioButton1.setText("-");
        view.jRadioButton2.setText("-");
        view.jLabel7.setText("");
        view.jLabel8.setText("");
        view.jLabel14.setText("");
        view.jTextField5.setText("");
        comboSubkriteria(view);
        comboSubkriteria1(view);
        view.jSlider1.setValue(8);
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

    private DefaultTableModel model;
    private JTable headerTable;

    public void tablematrik(subkriteria view) {

        model = new DefaultTableModel() {
            @Override
            public int getColumnCount() {
                return 1;
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }

            @Override
            public int getRowCount() {
                return view.jTable2.getRowCount();
            }

            @Override
            public Class<?> getColumnClass(int colNum) {
                switch (colNum) {
                    case 0:
                        return String.class;
                    default:
                        return super.getColumnClass(colNum);
                }
            }
        };
        headerTable = new JTable(model);
        List<HashMap<String, Object>> df = getDataSubkriteria(view);
        for (int i = 0; i < getJumlah(view); i++) {
            String aa = df.get(i).get("nama").toString();
            headerTable.setValueAt(aa, i, 0);
            headerTable.setValueAt("Jumlah", i + 1, 0);
        }
        headerTable.setPreferredScrollableViewportSize(new Dimension(100, 0));
        headerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                boolean selected = view.jTable2.getSelectionModel().isSelectedIndex(row);
                Component component = view.jTable2.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(view.jTable2, value, false, false, -1, -2);
                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
                if (selected) {
                    component.setFont(component.getFont().deriveFont(Font.BOLD));
                    component.setForeground(Color.black);
                } else {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                }
                return component;
            }
        });
        view.jScrollPane2.setRowHeaderView(headerTable);
        view.jTable2.setPreferredScrollableViewportSize(view.jTable2.getPreferredSize());
    }

    public void tablematrik2(subkriteria view) {
        model = new DefaultTableModel() {
            @Override
            public int getColumnCount() {
                return 1;
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }

            @Override
            public int getRowCount() {
                return view.jTable6.getRowCount();
            }

            @Override
            public Class<?> getColumnClass(int colNum) {
                switch (colNum) {
                    case 0:
                        return String.class;
                    default:
                        return super.getColumnClass(colNum);
                }
            }
        };
        headerTable = new JTable(model);
        List<HashMap<String, Object>> df = getDataSubkriteria(view);
        for (int i = 0; i < getJumlah(view); i++) {
            String aa = df.get(i).get("nama").toString();
            headerTable.setValueAt(aa, i, 0);
        }
        headerTable.setPreferredScrollableViewportSize(new Dimension(100, 0));
        headerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        headerTable.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable x, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                boolean selected = view.jTable6.getSelectionModel().isSelectedIndex(row);
                Component component = view.jTable6.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(view.jTable6, value, false, false, -1, -2);
                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
                if (selected) {
                    component.setFont(component.getFont().deriveFont(Font.BOLD));
                    component.setForeground(Color.black);
                } else {
                    component.setFont(component.getFont().deriveFont(Font.PLAIN));
                }
                return component;
            }
        });
        view.jScrollPane6.setRowHeaderView(headerTable);
        view.jTable6.setPreferredScrollableViewportSize(view.jTable6.getPreferredSize());
    }

    public void openKriteria(subkriteria view) {
        int row = view.jTable5.getSelectedRow();
        view.jLabel3.setText(view.jTable5.getValueAt(row, 1) + "");
        view.jLabel2.setText(view.jTable5.getValueAt(row, 2) + "");

        view.jButton6.setVisible(true);
        view.jButton7.setVisible(true);
        view.jButton8.setVisible(true);

        getDataRefresh(view);
        getDataSubkriteria(view);
        Matrix(view);
        getPerbandinganSubkriteria(view);
        comboSubkriteria(view);
        comboSubkriteria1(view);
    }

    public void getDataKriteria(subkriteria view) {
        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Nama Kriteria");
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
            view.jTable5.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable5.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable5.getColumnModel().getColumn(1).setMaxWidth(0);
        }
    }

    public int getJumlah(subkriteria view) {

        int jumlah = 0;

        try {
            String sql = "SELECT\n"
                    + "	subkriteria.seq, \n"
                    + "	subkriteria.subkriteria_name, \n"
                    + "	kriteria.seq, \n"
                    + "	kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "	subkriteria\n"
                    + "	INNER JOIN\n"
                    + "	kriteria\n"
                    + "	ON \n"
                    + "	subkriteria.kriteria_seq = kriteria.seq\n"
                    + "WHERE\n"
                    + "	kriteria.seq = '" + view.jLabel3.getText() + "'";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {
                jumlah++;
            }

        } catch (Exception e) {
        }
        return jumlah;
    }

    public List<HashMap<String, Object>> getDataSubkriteria(subkriteria view) {

        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();

        try {
            String sql = "SELECT\n"
                    + "	subkriteria.seq, \n"
                    + "	subkriteria.subkriteria_name, \n"
                    + "	kriteria.seq, \n"
                    + "	kriteria.kriteria_name\n"
                    + "FROM\n"
                    + "	subkriteria\n"
                    + "	INNER JOIN\n"
                    + "	kriteria\n"
                    + "	ON \n"
                    + "	subkriteria.kriteria_seq = kriteria.seq\n"
                    + "WHERE\n"
                    + "	kriteria.seq = '" + view.jLabel3.getText() + "'";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            while (r.next()) {

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("id", r.getString("subkriteria.seq"));
                map.put("nama", r.getString("subkriteria.subkriteria_name"));
                map.put("idKriteria", r.getString("kriteria.seq"));

                maps.add(map);
            }

        } catch (Exception e) {
        }
        return maps;
    }

    public void Matrix(subkriteria view) {

        int a = getJumlah(view);

        String[] cs = new String[a];

        List<HashMap<String, Object>> df = getDataSubkriteria(view);

        for (int i = 0; i < a; i++) {
            cs[i] = df.get(i).get("nama").toString();
        }

        setttablematrix(view.jTable2, a + 1, cs);
        tablematrik(view);

        for (int y1 = 0; y1 < a; y1++) {
            view.jTable2.setValueAt(1, y1, y1);
        }

        String[] c2 = new String[a + 1];
        String[] c1 = new String[a + 1 + 1];
        for (int i = 0; i < a; i++) {
            c2[i] = df.get(i).get("nama").toString();
            c2[i + 1] = "Eigen Vector Normalisasi";
            c1[i] = "";
            c1[i + 1] = "Jumlah";
            c1[i + 2] = "Lamda Max Tiap Baris";
        }

        setttablematrix(view.jTable6, a, c2);
        tablematrik2(view);
        setttablematrix(view.jTable3, a, c1);

        int rCon = view.jTable2.getRowCount() - 1;
        for (int i = 0; i < rCon; i++) {
            for (int j = i + 1; j < rCon; j++) {
                try {

                    String sql = "SELECT\n"
                            + "	perbandingan_subkriteria.seq, \n"
                            + "	perbandingan_subkriteria.subkriteria1_seq, \n"
                            + "	perbandingan_subkriteria.subkriteria2_seq, \n"
                            + "	perbandingan_subkriteria.pilihan_subkriteria_seq, \n"
                            + "	perbandingan_subkriteria.kriteria_seq, \n"
                            + "	perbandingan_subkriteria.nilai, \n"
                            + "	subkriteria.subkriteria_name\n"
                            + "FROM\n"
                            + "	perbandingan_subkriteria\n"
                            + "	INNER JOIN subkriteria ON perbandingan_subkriteria.pilihan_subkriteria_seq = subkriteria.seq\n"
                            + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria1_seq = '" + df.get(i).get("id").toString() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria2_seq ='" + df.get(j).get("id").toString() + "'";

                    Statement st = c.createStatement();
                    ResultSet r = st.executeQuery(sql);

                    BigDecimal nilai = BigDecimal.ONE;
                    int alternatif1_seq = 0;
                    int alternatif2_seq = 0;
                    int pilihan_alternatif_seq = 0;

                    while (r.next()) {

                        nilai = new BigDecimal(r.getString("perbandingan_subkriteria.nilai"));
                        alternatif1_seq = r.getInt("perbandingan_subkriteria.subkriteria1_seq");
                        alternatif2_seq = r.getInt("perbandingan_subkriteria.subkriteria2_seq");
                        pilihan_alternatif_seq = r.getInt("perbandingan_subkriteria.pilihan_subkriteria_seq");

                    }

                    System.out.println("kriteria1_seq : " + alternatif1_seq);
                    System.out.println("kriteria2_seq : " + alternatif2_seq);
                    System.out.println("pilihan_kriteria_seq : " + pilihan_alternatif_seq);
                    System.out.println("nilai : " + nilai);

                    DecimalFormat format = new DecimalFormat("#.###");

                    BigDecimal hasilnilai = BigDecimal.ZERO;

                    if (alternatif1_seq == pilihan_alternatif_seq) {
                        hasilnilai = nilai.divide(new BigDecimal(BigInteger.ONE), 15, RoundingMode.HALF_EVEN);
                        hasilnilai.setScale(6, RoundingMode.HALF_EVEN);
                    } else if (alternatif2_seq == pilihan_alternatif_seq) {
                        hasilnilai = new BigDecimal(BigInteger.ONE).divide(nilai, 15, RoundingMode.HALF_EVEN);
                        hasilnilai.setScale(6, RoundingMode.HALF_EVEN);
                    }

                    System.out.println("hasilnilai : " + format.format(hasilnilai));

                    view.jTable2.setValueAt(format.format(hasilnilai), i, j);
                } catch (SQLException ex) {
                    Logger.getLogger(control_subkriteria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        view.buttonGlass1.setText("...");
        view.buttonGlass2.setText("...");
        view.buttonGlass3.setText("...");
    }

    public void getPerbandinganSubkriteria(subkriteria view) {

        try {

            DefaultTableModel tabelKej = new DefaultTableModel();
            tabelKej.addColumn("No");
            tabelKej.addColumn("Seq 1");
            tabelKej.addColumn("Nama Subkriteria");
            tabelKej.addColumn("Seq 2");
            tabelKej.addColumn("Nama Subkriteria");
            tabelKej.addColumn("Seq Pilihan");
            tabelKej.addColumn("Subkriteria Pilihan");
            tabelKej.addColumn("Nilai");

            int a = getJumlah(view);

            List<HashMap<String, Object>> df = getDataSubkriteria(view);

            int no = 0;

            for (int j = 0; j < a; j++) {
                for (int i = j + 1; i < a; i++) {

                    Vector vector = new Vector();

                    System.out.println("df.get(j).get(\"id\").toString() " + df.get(j).get("id").toString());
                    System.out.println("df.get(j).get(\"id\").toString() " + df.get(i).get("id").toString());

                    no++;
                    vector.addElement(no);
                    vector.addElement(df.get(j).get("id").toString());
                    vector.addElement(df.get(j).get("nama").toString());
                    vector.addElement(df.get(i).get("id").toString());
                    vector.addElement(df.get(i).get("nama").toString());

                    String sql = "SELECT\n"
                            + "perbandingan_subkriteria.seq, \n"
                            + "perbandingan_subkriteria.subkriteria1_seq, \n"
                            + "perbandingan_subkriteria.subkriteria2_seq, \n"
                            + "perbandingan_subkriteria.pilihan_subkriteria_seq, \n"
                            + "perbandingan_subkriteria.kriteria_seq, \n"
                            + "perbandingan_subkriteria.nilai, \n"
                            + "subkriteria.subkriteria_name\n"
                            + "FROM\n"
                            + "perbandingan_subkriteria\n"
                            + "INNER JOIN subkriteria ON perbandingan_subkriteria.pilihan_subkriteria_seq = subkriteria.seq\n"
                            + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria1_seq = '" + df.get(j).get("id").toString() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria2_seq ='" + df.get(i).get("id").toString() + "'";

                    Statement st = c.createStatement();
                    ResultSet r = st.executeQuery(sql);

                    int idPilihan = 0;
                    String namaPilihan = "";
                    BigDecimal nilai = BigDecimal.ONE;

                    while (r.next()) {

                        idPilihan = r.getInt("perbandingan_subkriteria.pilihan_subkriteria_seq");
                        namaPilihan = r.getString("subkriteria.subkriteria_name");
                        nilai = new BigDecimal(r.getString("perbandingan_subkriteria.nilai"));

                    }

                    vector.addElement(idPilihan);
                    vector.addElement(namaPilihan);
                    vector.addElement(nilai);

                    tabelKej.addRow(vector);
                }
            }

            view.jTable4.setModel(tabelKej);

        } catch (Exception e) {
        } finally {
            view.jTable4.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable4.getColumnModel().getColumn(1).setMaxWidth(0);
            view.jTable4.getColumnModel().getColumn(3).setMinWidth(0);
            view.jTable4.getColumnModel().getColumn(3).setMaxWidth(0);
            view.jTable4.getColumnModel().getColumn(5).setMinWidth(0);
            view.jTable4.getColumnModel().getColumn(5).setMaxWidth(0);
            buatKolomSesuai(view.jTable4);
        }
    }

    public void openForm(subkriteria view) {
        int row = view.jTable4.getSelectedRow();
        view.jLabel7.setText(view.jTable4.getValueAt(row, 1) + "");
        view.jLabel8.setText(view.jTable4.getValueAt(row, 3) + "");
        view.jTextField5.setText(view.jTable4.getValueAt(row, 7) + "");
        view.jRadioButton1.setText(view.jTable4.getValueAt(row, 2).toString());
        view.jRadioButton2.setText(view.jTable4.getValueAt(row, 4).toString());

        if (view.jTable4.getValueAt(row, 2).toString().equals(view.jTable4.getValueAt(row, 6).toString())) {
            view.jRadioButton1.setSelected(true);
        } else if (view.jTable4.getValueAt(row, 4).toString().equals(view.jTable4.getValueAt(row, 6).toString())) {
            view.jRadioButton2.setSelected(true);
        } else {
            view.buttonGroup1.clearSelection();
        }
        view.panelGlass2.setVisible(true);
    }

    public void openForm1(subkriteria view) {
        int row = view.jTable4.getSelectedRow();
        view.jLabel7.setText(view.jTable4.getValueAt(row, 1) + "");
        view.jLabel8.setText(view.jTable4.getValueAt(row, 3) + "");

        if (view.jTable4.getValueAt(row, 2).toString().equals(view.jTable4.getValueAt(row, 6).toString())) {

            view.jSlider1.setValue(8 - Integer.parseInt(view.jTable4.getValueAt(row, 7).toString()) + 1);

        } else if (view.jTable4.getValueAt(row, 4).toString().equals(view.jTable4.getValueAt(row, 6).toString())) {

            view.jSlider1.setValue(8 + Integer.parseInt(view.jTable4.getValueAt(row, 7).toString()) - 1);

        } else {

            view.jSlider1.setValue(8);

        }

        view.jComboBox2.setSelectedItem(view.jTable4.getValueAt(row, 2) + "");
        view.jComboBox1.setSelectedItem(view.jTable4.getValueAt(row, 4) + "");
    }

    public void saveProccessMatrix(subkriteria view) {

        try {

            String idTerpilih = null;

            if (view.jRadioButton1.isSelected() == false && view.jRadioButton2.isSelected() == false) {
                JOptionPane.showMessageDialog(view, "Please your choice", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (view.jTextField5.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Can not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (view.jRadioButton1.isSelected() == true) {
                    idTerpilih = view.jLabel7.getText();
                } else {
                    idTerpilih = view.jLabel8.getText();
                }
            }

            String sqls = "SELECT\n"
                    + "	perbandingan_subkriteria.seq, \n"
                    + "	perbandingan_subkriteria.subkriteria1_seq, \n"
                    + "	perbandingan_subkriteria.subkriteria2_seq, \n"
                    + "	perbandingan_subkriteria.pilihan_subkriteria_seq, \n"
                    + "	perbandingan_subkriteria.kriteria_seq, \n"
                    + "	perbandingan_subkriteria.nilai, \n"
                    + "	subkriteria.subkriteria_name\n"
                    + "FROM\n"
                    + "	perbandingan_subkriteria\n"
                    + "	INNER JOIN subkriteria ON perbandingan_subkriteria.pilihan_subkriteria_seq = subkriteria.seq\n"
                    + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                    + "AND perbandingan_subkriteria.subkriteria1_seq = '" + view.jLabel7.getText() + "'\n"
                    + "AND perbandingan_subkriteria.subkriteria2_seq ='" + view.jLabel8.getText() + "'";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sqls);

            int idPilihan = 0;

            while (r.next()) {
                idPilihan = r.getInt("perbandingan_subkriteria.pilihan_subkriteria_seq");
            }

            if (idPilihan == 0) {

                String sql = "insert into perbandingan_subkriteria set \n"
                        + "subkriteria1_seq ='" + view.jLabel7.getText() + "',\n"
                        + "subkriteria2_seq = '" + view.jLabel8.getText() + "',"
                        + "kriteria_seq = '" + view.jLabel3.getText() + "',"
                        + "pilihan_subkriteria_seq = '" + idTerpilih + "',"
                        + "nilai ='" + view.jTextField5.getText() + "'";

                PreparedStatement p221 = c.prepareStatement(sql);
                p221.executeUpdate();
                p221.close();

                JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                getDataRefresh(view);
                getDataSubkriteria(view);
                Matrix(view);
                getPerbandinganSubkriteria(view);

            } else {

                String sql = "update perbandingan_subkriteria \n"
                        + "set pilihan_subkriteria_seq='" + idTerpilih + "', \n"
                        + "kriteria_seq='" + view.jLabel3.getText() + "',\n"
                        + "nilai='" + view.jTextField5.getText() + "'\n"
                        + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                        + "AND perbandingan_subkriteria.subkriteria1_seq = '" + view.jLabel7.getText() + "'\n"
                        + "AND perbandingan_subkriteria.subkriteria2_seq ='" + view.jLabel8.getText() + "'";

                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();

                JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                getDataRefresh(view);
                getDataSubkriteria(view);
                Matrix(view);
                getPerbandinganSubkriteria(view);
            }

        } catch (SQLException e) {
        }
    }

    public void saveProccessMatrixAll(subkriteria view) {

        try {

            String sqsl = "DELETE FROM perbandingan_subkriteria WHERE kriteria_seq = '" + view.jLabel3.getText() + "'";

            PreparedStatement p221s = c.prepareStatement(sqsl);
            p221s.executeUpdate();
            p221s.close();

            for (int i = 0; i < view.jTable4.getRowCount(); i++) {

                String sql = "insert into perbandingan_subkriteria set \n"
                        + "subkriteria1_seq ='" + view.jTable4.getValueAt(i, 1) + "',\n"
                        + "subkriteria2_seq = '" + view.jTable4.getValueAt(i, 3) + "',\n"
                        + "kriteria_seq = '" + view.jLabel3.getText() + "',\n"
                        + "pilihan_subkriteria_seq = '" + view.jTable4.getValueAt(i, 5) + "',\n"
                        + "nilai ='" + view.jTable4.getValueAt(i, 7) + "'";

                PreparedStatement p221 = c.prepareStatement(sql);
                p221.executeUpdate();
                p221.close();

            }

        } catch (SQLException e) {
        } finally {
            getDataSubkriteria(view);
            Matrix(view);
            getPerbandinganSubkriteria(view);
        }
    }

    public void processData(subkriteria view) {

        DecimalFormat batas = new DecimalFormat("#.###");

        List<HashMap<String, Object>> df = getDataSubkriteria(view);

        view.jScrollPane6.setRowHeader(null);
        int a1 = getJumlah(view);

        String[] c2 = new String[a1 + 1];
        String[] c1 = new String[a1 + 1 + 1];
        for (int i = 0; i < a1; i++) {
            c2[i] = df.get(i).get("nama").toString();
            c2[i + 1] = "Eigen Vector Normalisasi";
            c1[i] = "";
            c1[i + 1] = "Jumlah";
            c1[i + 2] = "Lamda Max Tiap Baris";
        }

        setttablematrix(view.jTable6, a1, c2);
        tablematrik2(view);

        if (view.jTable2.getRowCount() == 2) {
            JOptionPane.showMessageDialog(view, "Data Can Not Be Calculated", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            int rCon = view.jTable2.getRowCount() - 1;
            for (int i = 0; i < rCon; i++) {
                double x = Double.parseDouble(view.jTable2.getValueAt(i, i).toString());
                for (int j = i + 1; j < rCon; j++) {
                    double s = Double.parseDouble(view.jTable2.getValueAt(i, j).toString());
                    double hasil = 0.0;
                    hasil = x / s;
                    view.jTable2.setValueAt(batas.format(hasil), j, i);
                }
            }

            double hs = 0;
            int t = 0;
            double q = 0;
            double s = 0;
            double hasil = 0.0;
            int rCon1 = view.jTable2.getRowCount() - 1;
            for (int xx = 0; xx < rCon1; xx++) {
                for (t = 0; t < rCon1; t++) {
                    q = Double.parseDouble(view.jTable2.getValueAt(t, xx).toString());
                    hs = hs + q;
                }
                view.jTable2.setValueAt(batas.format(hs) + "", t, xx);
                hs = 0;
            }

            int p = 0;
            int rcount = view.jTable2.getRowCount() - 1;
            for (int r = 0; r < rcount; r++) {
                for (p = 0; p < rcount; p++) {
                    double hitung = 0.0;
                    double hasilBagi = 0.0;
                    double pembagi = Double.parseDouble(view.jTable2.getValueAt(rcount, r).toString());
                    hitung = Double.parseDouble(view.jTable2.getValueAt(p, r).toString());
                    hasilBagi = hitung / pembagi;
                    view.jTable6.setValueAt(batas.format(hasilBagi), p, r);
                }
            }

            int a = getJumlah(view);
            double baris = 0.0;
            double eigen = 0.0;
            double q1 = 0.0;
            int t1 = 0;
            int xx = 0;
            int row = view.jTable6.getRowCount();
            for (xx = 0; xx < row; xx++) {
                for (t1 = 0; t1 < row; t1++) {
                    q1 = Double.parseDouble(view.jTable6.getValueAt(xx, t1).toString());
                    baris = baris + q1;
                    eigen = baris / a;
                }
                view.jTable6.setValueAt(batas.format(eigen), xx, t1);
                baris = 0;
            }

            double jumlah = 0.0;
            double hitung2 = 0.0;
            double hitung3 = 0.0;
            double hasilkali = 0.0;
            double hasiljumlah = 0.0;
            int rcount2 = view.jTable2.getRowCount() - 1;
            for (int r2 = 0; r2 < rcount2; r2++) {
                jumlah = Double.parseDouble(view.jTable6.getValueAt(r2, rcount2).toString());
                for (int p2 = 0; p2 < rcount2; p2++) {
                    hitung2 = Double.parseDouble(view.jTable2.getValueAt(p2, r2).toString());
                    hasilkali = hitung2 * jumlah;
                    view.jTable3.setValueAt(batas.format(hasilkali), p2, r2);
                }
            }

            double baris5 = 0.0;
            double eigen5 = 0.0;
            double q15 = 0.0;
            int t15 = 0;
            int row5 = view.jTable3.getRowCount();
            for (int xx5 = 0; xx5 < row5; xx5++) {
                for (t15 = 0; t15 < row5; t15++) {
                    q15 = Double.parseDouble(view.jTable3.getValueAt(xx5, t15).toString());
                    baris5 = baris5 + q15;
                }
                view.jTable3.setValueAt(batas.format(baris5), xx5, t15);
                baris5 = 0;
            }

            double q155 = 0.0;
            double baris55 = 0.0;
            double eigen55 = 0.0;
            int xx55 = 0;
            int t155 = 0;
            int row55 = view.jTable3.getRowCount();
            for (xx55 = 0; xx55 < row55; xx55++) {
                for (t155 = 0; t155 < row55; t155++) {
                    q155 = Double.parseDouble(view.jTable3.getValueAt(xx55, t155 + 1).toString());
                    eigen55 = Double.parseDouble(view.jTable6.getValueAt(xx55, t155 + 1).toString());
                    baris5 = q155 / eigen55;
                }
                view.jTable3.setValueAt(batas.format(baris5), xx55, t155 + 1);
            }

            double baris7 = 0.0;
            double baris8 = 0.0;
            double q17 = 0.0;
            int row7 = view.jTable3.getRowCount();
            for (int xx7 = 0; xx7 < row7; xx7++) {
                q17 = Double.parseDouble(view.jTable3.getValueAt(xx7, row7 + 1).toString());
                baris7 = baris7 + q17;
                baris8 = baris7 / a;
                view.buttonGlass1.setText("Lamda Max : " + batas.format(baris8));

                double CI = (Double.parseDouble(view.buttonGlass1.getText().replaceAll("Lamda Max : ", "")) - a) / (a - 1);
                view.buttonGlass2.setText("Consistency Index : " + batas.format(CI));
            }
            CR(view);
        }
    }

    public void CR(subkriteria view) {

        DecimalFormat batas = new DecimalFormat("#.###");

        double hasilCI = 0.0;
        int elemen = getJumlah(view);
        double CR = Double.parseDouble(view.buttonGlass2.getText().replaceAll("Consistency Index : ", ""));
        String query = "select random_consistency from random_index where size_matrics = '" + elemen + "'";
        try {
            PreparedStatement prepare = c.prepareStatement(query);
            ResultSet rs = prepare.executeQuery();
            String Random_Consistency = "";
            while (rs.next()) {
                Random_Consistency = rs.getString("random_consistency");
            }
            hasilCI = CR / Double.parseDouble(Random_Consistency);
            view.buttonGlass3.setText("Consistency Rasio : " + batas.format(hasilCI) + " < 0.1");
        } catch (SQLException ex) {
        } finally {
            int jum = getJumlah(view);
            if (jum == 2) {
                view.buttonGlass3.setForeground(Color.BLUE);
                JOptionPane.showMessageDialog(view, "CR value is Consistent!\nThat is : " + view.buttonGlass3.getText() + "", "Correct", JOptionPane.INFORMATION_MESSAGE);
                saveProccess(view);
            } else if (jum == 1) {
                view.buttonGlass3.setForeground(Color.BLUE);
                JOptionPane.showMessageDialog(view, "CR value is Consistent!\nThat is : " + view.buttonGlass3.getText() + "", "Correct", JOptionPane.INFORMATION_MESSAGE);
                saveProccess(view);
            } else if (hasilCI < 0.1) {
                view.buttonGlass3.setForeground(Color.BLUE);
                JOptionPane.showMessageDialog(view, "CR value is Consistent!\nThat is : " + view.buttonGlass3.getText() + "", "Correct", JOptionPane.INFORMATION_MESSAGE);
                saveProccess(view);
            } else {
                JOptionPane.showMessageDialog(view, "CR value not consistent!", "Wrong", JOptionPane.ERROR_MESSAGE);

                view.jTabbedPane1.setEnabledAt(2, false);
                view.jTabbedPane1.setSelectedIndex(1);
                view.jTabbedPane1.setEnabledAt(0, true);
                view.jTabbedPane1.setEnabledAt(1, true);
//                getDataGlobal(view);
            }
        }
    }

    public void saveProccess(subkriteria view) {

        try {
            double eigen551 = 0.0;
            int xx551 = 0;
            int t1551 = 0;
            int row551 = view.jTable6.getRowCount();

            String sqlq = "DELETE FROM eigen_subkriteria\n"
                    + "WHERE kriteria_seq = '" + view.jLabel3.getText() + "'";

            PreparedStatement p22 = c.prepareStatement(sqlq);
            p22.executeUpdate();
            p22.close();

            List<HashMap<String, Object>> df = getDataSubkriteria(view);

            for (xx551 = 0; xx551 < row551; xx551++) {

                int id = Integer.parseInt(df.get(xx551).get("id").toString());

                for (t1551 = 0; t1551 < row551; t1551++) {
                    eigen551 = Double.parseDouble(view.jTable6.getValueAt(xx551, t1551 + 1).toString());
                }

                String sql = "insert into eigen_subkriteria set \n"
                        + "nilai_eigen_subkriteria ='" + eigen551 + "',\n"
                        + "create_date = CURDATE(),"
                        + "subkriteria_seq = '" + id + "',"
                        + "kriteria_seq = '" + view.jLabel3.getText() + "'";

                PreparedStatement p221 = c.prepareStatement(sql);
                p221.executeUpdate();
                p221.close();

            }

        } catch (SQLException e) {
        }
    }

    //====================================================== REVISI PEMBIMBING ===================================================
    public Hashtable label(subkriteria view) {

        view.jSlider1.setMajorTickSpacing(1);
        view.jSlider1.setMinorTickSpacing(0);
        view.jSlider1.setPaintTicks(true);
        view.jSlider1.setPaintLabels(true);
        view.jSlider1.setSnapToTicks(true);
        view.jSlider1.setMaximum(16);

        Hashtable labels = new Hashtable();

        labels.put(0, setLabel("9"));
        labels.put(1, setLabel("8"));
        labels.put(2, setLabel("7"));
        labels.put(3, setLabel("6"));
        labels.put(4, setLabel("5"));
        labels.put(5, setLabel("4"));
        labels.put(6, setLabel("3"));
        labels.put(7, setLabel("2"));
        labels.put(8, setLabel("1"));
        labels.put(9, setLabel("2"));
        labels.put(10, setLabel("3"));
        labels.put(11, setLabel("4"));
        labels.put(12, setLabel("5"));
        labels.put(13, setLabel("6"));
        labels.put(14, setLabel("7"));
        labels.put(15, setLabel("8"));
        labels.put(16, setLabel("9"));

        view.jSlider1.setLabelTable(labels);
        view.jSlider1.setValue(8);

        return labels;

    }

    public String value(String nilai) {

        String data = "";

        if (nilai.equals("0")) {
            data = "9";
        } else if (nilai.equals("1")) {
            data = "8";
        } else if (nilai.equals("2")) {
            data = "7";
        } else if (nilai.equals("3")) {
            data = "6";
        } else if (nilai.equals("4")) {
            data = "5";
        } else if (nilai.equals("5")) {
            data = "4";
        } else if (nilai.equals("6")) {
            data = "3";
        } else if (nilai.equals("7")) {
            data = "2";
        } else if (nilai.equals("8")) {
            data = "1";
        } else if (nilai.equals("9")) {
            data = "2";
        } else if (nilai.equals("10")) {
            data = "3";
        } else if (nilai.equals("11")) {
            data = "4";
        } else if (nilai.equals("12")) {
            data = "5";
        } else if (nilai.equals("13")) {
            data = "6";
        } else if (nilai.equals("14")) {
            data = "7";
        } else if (nilai.equals("15")) {
            data = "8";
        } else if (nilai.equals("16")) {
            data = "9";
        }

        return data;
    }

    public JLabel setLabel(String x) {
        JLabel labels = new JLabel();

        labels = new JLabel(x);
        labels.setFont(new java.awt.Font("Tahoma", 1, 17));
        labels.setForeground(Color.RED);

        return labels;
    }

    public void comboSubkriteria(subkriteria view) {
        String query2 = "SELECT\n"
                + "subkriteria.subkriteria_name, \n"
                + "subkriteria.seq, \n"
                + "kriteria.seq, \n"
                + "kriteria.kriteria_name\n"
                + "FROM\n"
                + "subkriteria\n"
                + "INNER JOIN\n"
                + "kriteria\n"
                + "ON \n"
                + "subkriteria.kriteria_seq = kriteria.seq\n"
                + "WHERE\n"
                + "kriteria.seq = '" + view.jLabel3.getText() + "'";

        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query2);

            for (int i = view.jComboBox2.getItemCount() - 1; i >= 1; i--) {
                view.jComboBox2.removeItemAt(i);
            }

            while (r.next()) {
                view.jComboBox2.addItem(r.getString("subkriteria.subkriteria_name"));
            }
        } catch (Exception e) {
        }
    }

    public void SubkriteriaCode(subkriteria view) {
        String sub = (String) view.jComboBox2.getSelectedItem();
        String query = "SELECT\n"
                + "subkriteria.subkriteria_name, \n"
                + "subkriteria.seq, \n"
                + "kriteria.seq, \n"
                + "kriteria.kriteria_name\n"
                + "FROM\n"
                + "subkriteria\n"
                + "INNER JOIN\n"
                + "kriteria\n"
                + "ON \n"
                + "subkriteria.kriteria_seq = kriteria.seq where subkriteria.subkriteria_name = '" + sub + "'";
        String id = "";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            while (r.next()) {
                id = r.getString("subkriteria.seq");
            }
            view.jLabel7.setText(id + "");
        } catch (Exception e) {
        }
    }

    public void comboSubkriteria1(subkriteria view) {
        String query2 = "SELECT\n"
                + "subkriteria.subkriteria_name, \n"
                + "subkriteria.seq, \n"
                + "kriteria.seq, \n"
                + "kriteria.kriteria_name\n"
                + "FROM\n"
                + "subkriteria\n"
                + "INNER JOIN\n"
                + "kriteria\n"
                + "ON \n"
                + "subkriteria.kriteria_seq = kriteria.seq\n"
                + "WHERE\n"
                + "kriteria.seq = '" + view.jLabel3.getText() + "'";

        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query2);

            for (int i = view.jComboBox1.getItemCount() - 1; i >= 1; i--) {
                view.jComboBox1.removeItemAt(i);
            }

            while (r.next()) {
                view.jComboBox1.addItem(r.getString("subkriteria.subkriteria_name"));
            }
        } catch (Exception e) {
        }
    }

    public void SubkriteriaCode1(subkriteria view) {
        String sub = (String) view.jComboBox1.getSelectedItem();
        String query = "SELECT\n"
                + "subkriteria.subkriteria_name, \n"
                + "subkriteria.seq, \n"
                + "kriteria.seq, \n"
                + "kriteria.kriteria_name\n"
                + "FROM\n"
                + "subkriteria\n"
                + "INNER JOIN\n"
                + "kriteria\n"
                + "ON \n"
                + "subkriteria.kriteria_seq = kriteria.seq where subkriteria.subkriteria_name = '" + sub + "'";
        String id = "";
        try {
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);
            while (r.next()) {
                id = r.getString("subkriteria.seq");
            }
            view.jLabel8.setText(id + "");
        } catch (Exception e) {
        }
    }

    public void saveProccessMatrix1(subkriteria view) {

        try {

            String idTerpilih = null;

            if (view.jSlider1.getValue() < 8) {
                idTerpilih = view.jLabel7.getText();
            } else if (view.jSlider1.getValue() > 8) {
                idTerpilih = view.jLabel8.getText();
            } else {
                idTerpilih = "0";
            }

            if (view.jComboBox1.getSelectedItem().equals("-PILIH-") || view.jComboBox2.getSelectedItem().equals("-PILIH-")) {
                JOptionPane.showMessageDialog(view, "Pilih subkriteria dulu", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (view.jComboBox1.getSelectedItem().equals(view.jComboBox2.getSelectedItem())) {
                JOptionPane.showMessageDialog(view, "Subkriterianya sama pasti nilainya 1,\njadi tidak di simpan tidak masalah", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (view.jSlider1.getValue() == 8) {

                String sqls = "SELECT COUNT(*) AS Jumlah\n"
                        + "FROM perbandingan_subkriteria\n"
                        + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                        + "AND perbandingan_subkriteria.subkriteria1_seq = '" + view.jLabel7.getText() + "'\n"
                        + "AND perbandingan_subkriteria.subkriteria2_seq ='" + view.jLabel8.getText() + "'";

                Statement st = c.createStatement();
                ResultSet r = st.executeQuery(sqls);

                int idPilihan = 0;

                while (r.next()) {
                    idPilihan = r.getInt("Jumlah");
                }

                if (idPilihan == 0) {

                    String sql = "SELECT COUNT(*) AS Jumlah\n"
                            + "FROM perbandingan_subkriteria\n"
                            + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria2_seq = '" + view.jLabel7.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria1_seq ='" + view.jLabel8.getText() + "'";

                    Statement st1 = c.createStatement();
                    ResultSet r1 = st1.executeQuery(sql);

                    int idPilihan1 = 0;

                    while (r1.next()) {
                        idPilihan1 = r1.getInt("Jumlah");
                    }

                    if (idPilihan1 == 0) {

                        if (list1(view).equals("1")) {

                            String sql2 = "insert into perbandingan_subkriteria set \n"
                                    + "subkriteria1_seq ='" + view.jLabel7.getText() + "',\n"
                                    + "subkriteria2_seq = '" + view.jLabel8.getText() + "',"
                                    + "kriteria_seq = '" + view.jLabel3.getText() + "',"
                                    + "pilihan_subkriteria_seq = '" + idTerpilih + "',"
                                    + "nilai ='" + value(String.valueOf(view.jSlider1.getValue())) + "'";

                            PreparedStatement p221 = c.prepareStatement(sql2);
                            p221.executeUpdate();
                            p221.close();

                            JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                            getDataRefresh(view);
                            getDataSubkriteria(view);
                            Matrix(view);
                            getPerbandinganSubkriteria(view);

                        } else {

                            String sql2 = "insert into perbandingan_subkriteria set \n"
                                    + "subkriteria2_seq ='" + view.jLabel7.getText() + "',\n"
                                    + "subkriteria1_seq = '" + view.jLabel8.getText() + "',"
                                    + "kriteria_seq = '" + view.jLabel3.getText() + "',"
                                    + "pilihan_subkriteria_seq = '" + idTerpilih + "',"
                                    + "nilai ='" + value(String.valueOf(view.jSlider1.getValue())) + "'";

                            PreparedStatement p221 = c.prepareStatement(sql2);
                            p221.executeUpdate();
                            p221.close();

                            JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                            getDataRefresh(view);
                            getDataSubkriteria(view);
                            Matrix(view);
                            getPerbandinganSubkriteria(view);

                        }
                        
//                        String sql3 = "update perbandingan_subkriteria \n"
//                                + "set pilihan_subkriteria_seq='" + idTerpilih + "', \n"
//                                + "kriteria_seq='" + view.jLabel3.getText() + "',\n"
//                                + "nilai='" + value(String.valueOf(view.jSlider1.getValue())) + "'\n"
//                                + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
//                                + "AND perbandingan_subkriteria.subkriteria2_seq = '" + view.jLabel7.getText() + "'\n"
//                                + "AND perbandingan_subkriteria.subkriteria1_seq ='" + view.jLabel8.getText() + "'";
//
//                        PreparedStatement p22 = c.prepareStatement(sql3);
//                        p22.executeUpdate();
//                        p22.close();
//
//                        JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
//                        getDataRefresh(view);
//                        getDataSubkriteria(view);
//                        Matrix(view);
//                        getPerbandinganSubkriteria(view);

                    } else {

                        String sql3 = "update perbandingan_subkriteria \n"
                                + "set pilihan_subkriteria_seq='" + idTerpilih + "', \n"
                                + "kriteria_seq='" + view.jLabel3.getText() + "',\n"
                                + "nilai='" + value(String.valueOf(view.jSlider1.getValue())) + "'\n"
                                + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                                + "AND perbandingan_subkriteria.subkriteria2_seq = '" + view.jLabel7.getText() + "'\n"
                                + "AND perbandingan_subkriteria.subkriteria1_seq ='" + view.jLabel8.getText() + "'";

                        PreparedStatement p22 = c.prepareStatement(sql3);
                        p22.executeUpdate();
                        p22.close();

                        JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                        getDataRefresh(view);
                        getDataSubkriteria(view);
                        Matrix(view);
                        getPerbandinganSubkriteria(view);

                    }

                } else {

                    String sql = "update perbandingan_subkriteria \n"
                            + "set pilihan_subkriteria_seq='" + idTerpilih + "', \n"
                            + "kriteria_seq='" + view.jLabel3.getText() + "',\n"
                            + "nilai='" + value(String.valueOf(view.jSlider1.getValue())) + "'\n"
                            + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria1_seq = '" + view.jLabel7.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria2_seq ='" + view.jLabel8.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                    getDataRefresh(view);
                    getDataSubkriteria(view);
                    Matrix(view);
                    getPerbandinganSubkriteria(view);
                }

            } else {

                String sqls = "SELECT COUNT(*) AS Jumlah\n"
                        + "FROM perbandingan_subkriteria\n"
                        + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                        + "AND perbandingan_subkriteria.subkriteria1_seq = '" + view.jLabel7.getText() + "'\n"
                        + "AND perbandingan_subkriteria.subkriteria2_seq ='" + view.jLabel8.getText() + "'";

                Statement st = c.createStatement();
                ResultSet r = st.executeQuery(sqls);

                int idPilihan = 0;

                while (r.next()) {
                    idPilihan = r.getInt("Jumlah");
                }

                if (idPilihan == 0) {

                    String sql = "SELECT COUNT(*) AS Jumlah\n"
                            + "FROM perbandingan_subkriteria\n"
                            + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria2_seq = '" + view.jLabel7.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria1_seq ='" + view.jLabel8.getText() + "'";

                    Statement st1 = c.createStatement();
                    ResultSet r1 = st1.executeQuery(sql);

                    int idPilihan1 = 0;

                    while (r1.next()) {
                        idPilihan1 = r1.getInt("Jumlah");
                    }

                    if (idPilihan1 == 0) {

                        if (list1(view).equals("1")) {

                            String sql2 = "insert into perbandingan_subkriteria set \n"
                                    + "subkriteria1_seq ='" + view.jLabel7.getText() + "',\n"
                                    + "subkriteria2_seq = '" + view.jLabel8.getText() + "',"
                                    + "kriteria_seq = '" + view.jLabel3.getText() + "',"
                                    + "pilihan_subkriteria_seq = '" + idTerpilih + "',"
                                    + "nilai ='" + value(String.valueOf(view.jSlider1.getValue())) + "'";

                            PreparedStatement p221 = c.prepareStatement(sql2);
                            p221.executeUpdate();
                            p221.close();

                            JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                            getDataRefresh(view);
                            getDataSubkriteria(view);
                            Matrix(view);
                            getPerbandinganSubkriteria(view);

                        } else {

                            String sql2 = "insert into perbandingan_subkriteria set \n"
                                    + "subkriteria2_seq ='" + view.jLabel7.getText() + "',\n"
                                    + "subkriteria1_seq = '" + view.jLabel8.getText() + "',"
                                    + "kriteria_seq = '" + view.jLabel3.getText() + "',"
                                    + "pilihan_subkriteria_seq = '" + idTerpilih + "',"
                                    + "nilai ='" + value(String.valueOf(view.jSlider1.getValue())) + "'";

                            PreparedStatement p221 = c.prepareStatement(sql2);
                            p221.executeUpdate();
                            p221.close();

                            JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                            getDataRefresh(view);
                            getDataSubkriteria(view);
                            Matrix(view);
                            getPerbandinganSubkriteria(view);

                        }

                    } else {

                        String sql3 = "update perbandingan_subkriteria \n"
                                + "set pilihan_subkriteria_seq='" + idTerpilih + "', \n"
                                + "kriteria_seq='" + view.jLabel3.getText() + "',\n"
                                + "nilai='" + value(String.valueOf(view.jSlider1.getValue())) + "'\n"
                                + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                                + "AND perbandingan_subkriteria.subkriteria2_seq = '" + view.jLabel7.getText() + "'\n"
                                + "AND perbandingan_subkriteria.subkriteria1_seq ='" + view.jLabel8.getText() + "'";

                        PreparedStatement p22 = c.prepareStatement(sql3);
                        p22.executeUpdate();
                        p22.close();

                        JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                        getDataRefresh(view);
                        getDataSubkriteria(view);
                        Matrix(view);
                        getPerbandinganSubkriteria(view);

                    }

                } else {

                    String sql = "update perbandingan_subkriteria \n"
                            + "set pilihan_subkriteria_seq='" + idTerpilih + "', \n"
                            + "kriteria_seq='" + view.jLabel3.getText() + "',\n"
                            + "nilai='" + value(String.valueOf(view.jSlider1.getValue())) + "'\n"
                            + "WHERE perbandingan_subkriteria.kriteria_seq = '" + view.jLabel3.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria1_seq = '" + view.jLabel7.getText() + "'\n"
                            + "AND perbandingan_subkriteria.subkriteria2_seq ='" + view.jLabel8.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data successfully save", "Message", JOptionPane.INFORMATION_MESSAGE);
                    getDataRefresh(view);
                    getDataSubkriteria(view);
                    Matrix(view);
                    getPerbandinganSubkriteria(view);
                }
            }
        } catch (SQLException e) {
        }
    }
    
    public String list1(subkriteria view) {

        String hasil = "";

        int row = view.jTable4.getRowCount();

        List<HashMap<String, Object>> list1 = new ArrayList<>();

        for (int i = 0; i < row; i++) {

            String seq1 = view.jTable4.getValueAt(i, 1).toString();
            String seq2 = view.jTable4.getValueAt(i, 3).toString();

            HashMap<String, Object> has = new HashMap<String, Object>();

            has.put("seq1", seq1);
            has.put("seq2", seq2);

            list1.add(has);

        }

        for (HashMap<String, Object> string : list1) {

            if (view.jLabel7.getText().equals(string.get("seq1")) && view.jLabel8.getText().equals(string.get("seq2"))) {
                hasil = "1";
                return hasil;
            } else {
                hasil = "0";
                return hasil;
            }
        }

        return hasil;
    }
}
