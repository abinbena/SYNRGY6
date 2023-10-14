package org.example;

import org.example.util.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class StatementTest {
    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
            INSERT INTO menu(name,price)
            VALUES ('Ayam Goreng','10000')
            """;
        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();
        connection.close();
    }
    @Test
    void testResult() throws SQLException {
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
    @Test
    void testJoinResult() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
        SELECT orders.OrderID, orderItems.Name, OrderItems.Qty, OrderItems.Price
        FROM orders
        JOIN orderItems ON orders.OrderID = orderItems.OrderID
        """;
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String itemName = resultSet.getString("Name");
            int itemQty = resultSet.getInt("Qty");
            int itemPrice = resultSet.getInt("Price");

            System.out.println("ItemName: " + itemName);
            System.out.println("ItemQty: " + itemQty);
            System.out.println("ItemPrice: " + itemPrice);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    void testAutoIncrement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO orderitems(OrderID,Name, Qty, Price) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, 1);
        preparedStatement.setString(2, "Mie Goreng");
        preparedStatement.setInt(3, 2);
        preparedStatement.setInt(4, 15000);

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            System.out.println("Id Comment : " + resultSet.getInt(1));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    @Test
    void testAutoIncrementID() throws SQLException {
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
        if (resultSet.next()) {
            System.out.println("New OrderID : " + resultSet.getInt(1));
        }

        resultSet.close();
        insertStatement.close();
        connection.close();
    }

}
