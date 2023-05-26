package com.trungtamjava.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:mysql://localhost:3306/hello";
        final String user = "viet";
        final String password = "Phamviet693";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // tải mssql driver vào

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Connection connection = JDBCConnection.getJDBCConnection();

        if (connection != null) {
            System.out.println("Success");
        } else {
            System.out.println("Failed!!");
        }
    }
}
