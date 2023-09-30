package org.example.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.example.models.Invoice;
import java.util.ArrayList;
public class InvoiceService {
    public static ArrayList<Invoice> list = new ArrayList<>();
    private static String total;
    public static void add(String name, int qty, int price){
        list.add(new Invoice(name,qty, price * qty));
    }
    public static void show(){
        for(Invoice invoice: list){
            invoice.display();
        }
    }
    public static void addTotal(){
        int sumQty = 0;
        int sumPrice = 0;
        for(Invoice invoice: list){
            sumQty += invoice.getQty();
            sumPrice += invoice.getPrice();
        }
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
            for (Invoice line : list) {
                String lineString = line.toString();
                writer.write(lineString);
                writer.newLine();
            }
            writer.write("--------------------------+");
            writer.newLine();
            writer.write(total);
            writer.newLine();
            writer.write("\n\n\n===========================\n" +
                    "Simpan struk ini sebagai\n" +
                    "bukti pembayaran\n" +
                    "===========================");

            writer.close();
            System.out.println("Struk telah disimpan ke " + " invoices.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
