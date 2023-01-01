package main.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_NAME = "testing";
    static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME + "?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (ClassNotFoundException | SQLException e) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return conn;
    }

    public static void main(String[] args) {
        DBConnection.getConnection();
    }

}
