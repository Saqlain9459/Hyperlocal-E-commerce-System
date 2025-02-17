package com.eazydeals.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish the connection
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eazydeals", "root", "12345");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Logging or handling this exception
        } catch (SQLException e) {
            e.printStackTrace(); // Logging or handling this exception
        }
        return con;
    }
}
