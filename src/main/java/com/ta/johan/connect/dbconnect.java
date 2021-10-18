package com.ta.johan.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author abuyusuf
 */
public class dbconnect {

    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                String url;
                url = "jdbc:mysql://localhost/tugas_akhir_johan";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());

                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                JOptionPane.showMessageDialog(null, "Error Creating a Connection");
            }
        }

        return koneksi;
    }

    static Object getConnection() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
