package com.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/shopping_system";
    private static final String USER = "postgres";
    private static final String PASSWORD = "9999";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("CONNECTED TO: " + conn.getCatalog());
        return conn;
    }
}
