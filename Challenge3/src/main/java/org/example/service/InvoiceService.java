package org.example.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.example.model.Invoice;
import org.example.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
public class InvoiceService {
    public static void add(int orderID, String name, int qty, int price) throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO orderitems(OrderID,Name, Qty, Price) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, orderID);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, qty);
        preparedStatement.setInt(4, qty*price);

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    public static void show(int orderID) throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "SELECT Name, SUM(Qty) AS TotalQty, SUM(Price) AS TotalPrice FROM orderitems WHERE OrderID = ? GROUP BY Name";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, orderID);

        ResultSet resultSet = preparedStatement.executeQuery();

        int totalQty = 0;
        int totalPrice = 0;

        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            int nameTotalQty = resultSet.getInt("TotalQty");
            int nameTotalPrice = resultSet.getInt("TotalPrice");

            totalQty += nameTotalQty;
            totalPrice += nameTotalPrice;

            System.out.println(name + " | TotalQty: " + nameTotalQty + " | TotalPrice: " + nameTotalPrice);
        }

        System.out.println("Total Qty: " + totalQty + " | Total Price: " + totalPrice);

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

}
