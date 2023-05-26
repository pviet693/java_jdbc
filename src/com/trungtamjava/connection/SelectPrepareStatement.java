package com.trungtamjava.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPrepareStatement {
    public static void main(String[] args) {
        Connection connection = JDBCConnection.getJDBCConnection();

        String sql = "select * from person where id = ? and name = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2); // dấu ? thứ nhất, giá trị = 2
            preparedStatement.setString(2, "B"); // dấu ? thứ 2, giá trị = 'B'

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println(String.format("%d '%s'", id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
