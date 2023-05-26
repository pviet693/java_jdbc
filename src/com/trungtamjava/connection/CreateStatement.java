package com.trungtamjava.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement {
    public static void createTable() {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            Statement statement = connection.createStatement();

            final String sql = "CREATE TABLE hello(id INT, name VARCHAR(45), PRIMARY KEY(id))";

            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dropTable() {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            Statement statement = connection.createStatement();

            final String sql = "DROP TABLE Person";

            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        createTable();
//        dropTable();
    }
}
