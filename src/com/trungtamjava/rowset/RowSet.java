package com.trungtamjava.rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // tải mssql driver vào

        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();

        jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/hello");
        jdbcRowSet.setUsername("viet");
        jdbcRowSet.setPassword("Phamviet693");

        final String sql = "select * from person";

        jdbcRowSet.setCommand(sql);

        jdbcRowSet.execute();

        while (jdbcRowSet.next()) {
            System.out.println(jdbcRowSet.getInt("id") + " " + jdbcRowSet.getString("name"));
        }
    }
}