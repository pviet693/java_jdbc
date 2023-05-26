package com.trungtamjava.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatement {
    public static void main(String[] args) {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            Statement statement = connection.createStatement();

            final String sql = "select * from demo where id = 2";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println(id + " " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
