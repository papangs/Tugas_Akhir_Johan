/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.johan.control;

import com.ta.johan.connect.dbconnect;
import com.ta.johan.layout.kriteria;
import com.ta.johan.layout.user;
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
import java.util.Base64;
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
public class control_user {

    Connection c = dbconnect.getKoneksi();

    public void getData(user view) {
        view.jTextField1.setText("");
        view.jPasswordField1.setText("");
        view.jComboBox1.setSelectedItem("-PILIH-");
        view.jButton13.setText("Save");
        view.jButton14.setVisible(false);
        view.jLabel1.setVisible(false);
        getDataUserAdmin(view);
    }

    public void getDataUserAdmin(user view) {

        DefaultTableModel tabelKej = new DefaultTableModel();
        tabelKej.addColumn("No");
        tabelKej.addColumn("Seq");
        tabelKej.addColumn("Username");
        tabelKej.addColumn("Password");
        tabelKej.addColumn("Akses");
        try {
            String sql = "SELECT\n"
                    + "`user`.user_seq,\n"
                    + "`user`.username,\n"
                    + "`user`.`password`,\n"
                    + "`user`.`akses`\n"
                    + "FROM\n"
                    + "`user`";

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(sql);

            int n = 1;
            while (r.next()) {

                byte[] decodedBytes = Base64.getDecoder().decode(r.getString("user.password"));
                String decodedString = new String(decodedBytes);

                if (!r.getString("user.akses").equals("Superadmin")) {

                    tabelKej.addRow(new Object[]{n++, r.getString("user.user_seq"),
                        r.getString("user.username"),
                        decodedString, r.getString("user.akses")});
                }
            }

            view.jTable6.setModel(tabelKej);
        } catch (Exception e) {
        } finally {
            view.jTable6.getColumnModel().getColumn(1).setMinWidth(0);
            view.jTable6.getColumnModel().getColumn(1).setMaxWidth(0);
        }
    }

    public void saveData(user view) {
        try {
            if (view.jTextField1.getText().equals("") || view.jPasswordField1.getText().equals("") || view.jComboBox1.getSelectedItem().equals("-PILIH-")) {
                JOptionPane.showMessageDialog(view, "Data Can Not Be Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {

                String password = Base64.getEncoder().encodeToString(view.jPasswordField1.getText().getBytes());

                if (view.jButton13.getText().equals("Save")) {

                    String sql = "insert into user set "
                            + "username='" + view.jTextField1.getText() + "',"
                            + "password='" + password + "',"
                            + "akses='" + view.jComboBox1.getSelectedItem() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Entry", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);

                } else if (view.jButton13.getText().equals("Update")) {

                    String sql = "update user set \n"
                            + "username='" + view.jTextField1.getText() + "',"
                            + "password='" + password + "',"
                            + "akses='" + view.jComboBox1.getSelectedItem() + "'"
                            + "where user_seq ='" + view.jLabel1.getText() + "'";

                    PreparedStatement p22 = c.prepareStatement(sql);
                    p22.executeUpdate();
                    p22.close();

                    JOptionPane.showMessageDialog(view, "Data Successfully Update", "Success", JOptionPane.INFORMATION_MESSAGE);
                    getData(view);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Password Not Successful in Replace", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void readDataKategori(user view) {
        int a = view.jTable6.getSelectedRow();
        String query = "SELECT\n"
                + "user.user_seq, \n"
                + "user.username, \n"
                + "user.password, \n"
                + "user.akses\n"
                + "FROM\n"
                + "user\n"
                + "WHERE user.user_seq = '" + view.jTable6.getValueAt(a, 1) + "'";
        try {

            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(query);

            int user_seq = 0;
            String username = "";
            String password = "";
            String akses = "";

            while (r.next()) {
                user_seq = r.getInt("user.user_seq");
                username = r.getString("user.username");

                byte[] decodedBytes = Base64.getDecoder().decode(r.getString("user.password"));
                String decodedString = new String(decodedBytes);

                password = decodedString;
                akses = r.getString("user.akses");
            }

            view.jLabel1.setText(user_seq + "");
            view.jTextField1.setText(username);
            view.jPasswordField1.setText(password);
            view.jComboBox1.setSelectedItem(akses);
        } catch (Exception e) {
        } finally {
            view.jButton13.setText("Update");
            view.jButton14.setVisible(true);
        }
    }

    public void deleteDataUser(user view) {
        int yakin = JOptionPane.showConfirmDialog(view, "Are You Sure Want To Delete This data", "Delete", JOptionPane.YES_NO_OPTION);
        if (yakin == JOptionPane.YES_OPTION) {
            String sql = "delete from user where user_seq='" + view.jLabel1.getText() + "'";
            try {

                PreparedStatement p22 = c.prepareStatement(sql);
                p22.executeUpdate();
                p22.close();

                getData(view);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(view, "Data Not Succeed in Delete", "ERROR", JOptionPane.ERROR_MESSAGE);

            } finally {
            }
        } else {
            getData(view);
        }
    }
    
    public void searchData(user view) {
        String search = String.valueOf(view.jTextField6.getText());
        try {
            int no = 1;
            String query = "SELECT\n"
                    + "user.user_seq,\n"
                    + "user.username,\n"
                    + "user.password,\n"
                    + "user.akses\n"
                    + "FROM\n"
                    + "user\n"
                    + "where user.username like '%" + search + "%'\n"
                    + "OR user.akses like '%" + search + "%'";

            Statement statement = (Statement) c.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                DefaultTableModel tableModel = (DefaultTableModel) view.jTable6.getModel();
                int i = 0;
                while (i < view.jTable6.getRowCount()) {
                    tableModel.removeRow(i);
                }
                rs.beforeFirst();

                int j = 1;
                while (rs.next()) {
                    Vector vector = new Vector();
                    vector.addElement(j++);
                    vector.addElement(rs.getInt("user.user_seq"));
                    vector.addElement(rs.getString("user.username"));
                    vector.addElement(rs.getString("user.password"));
                    vector.addElement(rs.getString("user.akses"));

                    tableModel.addRow(vector);
                }
            }
        } catch (SQLException e) {
        }
    }
}