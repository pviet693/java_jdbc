package com.trungtamjava.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransaction {
    public static void main(String[] args) {
        Connection connection = JDBCConnection.getJDBCConnection();

        try {
            Statement statement1 = connection.createStatement();
//            Statement statement2 = connection.createStatement();

            connection.setAutoCommit(false);

            String sql1 = "insert into person(id, name) values(2, 'A')";
            String sql2 = "delete from person where id = 4";

            statement1.executeUpdate(sql2);
            statement1.executeUpdate(sql1);

            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
