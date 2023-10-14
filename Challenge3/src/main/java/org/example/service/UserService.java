package org.example.service;

import org.example.util.ConnectionUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        int id = 0;
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        resultSet.close();
        insertStatement.close();
        connection.close();

        return id;
    }

    public static void cetak(int orderID) throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "SELECT Name, SUM(Qty) AS TotalQty, SUM(Price) AS TotalPrice FROM orderitems WHERE OrderID = ? GROUP BY Name";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, orderID);

        ResultSet resultSet = preparedStatement.executeQuery();

        int totalQty = 0;
        int totalPrice = 0;

        StringBuilder outputText = new StringBuilder();

        while (resultSet.next()) {
            String name = resultSet.getString("Name");
            int nameTotalQty = resultSet.getInt("TotalQty");
            int nameTotalPrice = resultSet.getInt("TotalPrice");

            totalQty += nameTotalQty;
            totalPrice += nameTotalPrice;

            outputText.append(name)
                    .append(" | TotalQty: ").append(nameTotalQty)
                    .append(" | TotalPrice: ").append(nameTotalPrice)
                    .append(System.lineSeparator());
        }

        outputText.append("Total Qty: ").append(totalQty)
                .append(" | Total Price: ").append(totalPrice);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        printOut(outputText.toString(), "invoice.txt");
    }
    public static void printOut(String text, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(text);
            writer.close();
            System.out.println("===========================\n" +
                    "Simpan " + fileName + " ini sebagai\n" +
                    "bukti pembayaran\n" +
                    "===========================" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
