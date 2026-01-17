package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;

    private DBConnection() {} // prevent instantiation

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Example for MySQL
                String url = "jdbc:mysql://localhost:3306/birthdaydb";
                String user = "root";
                String pass = "password";
                connection = DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}