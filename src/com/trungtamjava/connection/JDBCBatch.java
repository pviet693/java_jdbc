package com.trungtamjava.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBatch {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCConnection.getJDBCConnection();

        String sql1 = "insert into person(id, name) values(5, 'F')";
        String sql2 = "insert into person(id, name) values(6, 'G')";
        String sql3 = "insert into person(id, name) values(7, 'H')";

        Statement statement = connection.createStatement();

        statement.addBatch(sql1);
        statement.addBatch(sql2);
        statement.addBatch(sql3);

//        statement.executeBatch();

        String sql4 = "insert into person(id, name) values(?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql4);

        preparedStatement.setInt(1, 8);
        preparedStatement.setString(2, "I");
        preparedStatement.addBatch();

        preparedStatement.setInt(1, 9);
        preparedStatement.setString(2, "J");
        preparedStatement.addBatch();

//        preparedStatement.executeBatch();
    }
}
