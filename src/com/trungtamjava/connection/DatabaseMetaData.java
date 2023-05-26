package com.trungtamjava.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseMetaData {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCConnection.getJDBCConnection();

        java.sql.DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getUserName());
        System.out.println(databaseMetaData.getURL());
    }
}
