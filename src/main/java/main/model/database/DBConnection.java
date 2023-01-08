package main.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String HOST = "103.171.85.233:3306";
    static final String USER = "strukdat";
    static final String PASS = "Passwordegan**1234";
    static final String DB_NAME = "PboDB";
    static final String DB_URL = "jdbc:mysql://" + HOST + "/" + DB_NAME + "?serverTimezone=UTC";

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
