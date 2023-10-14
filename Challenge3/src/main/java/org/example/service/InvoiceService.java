package org.example.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.example.model.Invoice;
import org.example.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
public class InvoiceService {
    public static ArrayList<Invoice> invoices = new ArrayList<>();
    private static int sumQty,sumPrice;
    private static String total;
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
        if (resultSet.next()) {
            System.out.println("Id Comment : " + resultSet.getInt(1));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    public static void show() {
        invoices.forEach(Invoice::display);
    }
    public static void addTotal(){
        sumQty = invoices.stream().mapToInt(Invoice::getQty).sum();
        sumPrice = invoices.stream().mapToInt(Invoice::getPrice).sum();
        total = "Total \t\t" + sumQty + "\t" + sumPrice;
    }
    public static void showTotal(){
        System.out.println(total);
    }
    public static void cetak(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("invoices.txt"));

            writer.write("===========================\n" +
                    "BinarFud\n" +
                    "===========================\n" +
                    "\n" +
                    "Terima kasih sudah memesan\n" +
                    "di BinarFud\n" +
                    "\n" +
                    "Berikut adalah pesanan anda\n");
            writer.newLine();
            for (Invoice line : invoices) {
                String lineString = line.toString();
                writer.write(lineString);
                writer.newLine();
            }
            writer.write("--------------------------+");
            writer.newLine();
            writer.write(total);
            writer.newLine();
            writer.write("Terima kasih");

            writer.close();
            System.out.println("Data telah disimpan ke " + " invoices.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
