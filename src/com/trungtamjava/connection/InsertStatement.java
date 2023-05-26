package com.trungtamjava.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {
    public static void insertRecords(int id, String name) {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            Statement statement = connection.createStatement();

            final String sql = String.format("insert into person(id, name) values(%d, '%s')", id, name);

            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateRecords(int id, String newName) {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            Statement statement = connection.createStatement();

            final String sql = String.format("update person set name = '%s' where id = %d", newName, id);

            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteRecords(int id) {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            Statement statement = connection.createStatement();

            final String sql = String.format("delete from person where id = %d", id);

            int rs = statement.executeUpdate(sql);
            System.out.println(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        insertRecords(1, "A");
        insertRecords(2, "B");
        insertRecords(3, "C");
//        updateRecords(1, "B");
//        deleteRecords(1);
    }
}
