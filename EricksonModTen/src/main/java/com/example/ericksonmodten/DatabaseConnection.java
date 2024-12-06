package com.example.ericksonmodten;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// database connection class to instantiate a connection to database when needed
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
