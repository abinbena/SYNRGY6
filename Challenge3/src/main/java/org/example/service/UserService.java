package org.example.service;

import org.example.util.ConnectionUtil;

import java.sql.*;

public class UserService {
    public static int AutoIncrementID() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sqlSelect = "SELECT MAX(OrderID) FROM orders";
        PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
        ResultSet maxIdResultSet = selectStatement.executeQuery();

        int maxOrderID = 0;
        if (maxIdResultSet.next()) {
            maxOrderID = maxIdResultSet.getInt(1);
        }
        maxIdResultSet.close();
        selectStatement.close();

        int newOrderID = maxOrderID + 1;

        String sqlInsert = "INSERT INTO orders(OrderID) VALUES (?)";
        PreparedStatement insertStatement = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
        insertStatement.setInt(1, newOrderID);
        insertStatement.executeUpdate();

        ResultSet resultSet = insertStatement.getGeneratedKeys();
        int id = resultSet.getInt(1);
        resultSet.close();
        insertStatement.close();
        connection.close();

        return id;
    }
}
