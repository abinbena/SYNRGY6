package org.example.controller;

import org.example.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultTest {
    public static void run() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
            SELECT * FROM menu
            """;
        ResultSet resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");

            System.out.println(String.join(", ", String.valueOf(id), name, String.valueOf(price)));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }



}
