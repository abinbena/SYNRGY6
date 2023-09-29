package org.example.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.example.models.Invoice;
import java.util.ArrayList;
public class InvoiceService {
    public static ArrayList<Invoice> invoices = new ArrayList<>();
    private static int sumQty,sumPrice;
    private static String total;
    public static void add(String name, int qty, int price){
        invoices.add(new Invoice(name,qty, price * qty));
    }
    public static void show(){
        for(Invoice list: invoices){
            list.display();
        }
    }
    public static void addTotal(){
        for(Invoice list: invoices){
            sumQty += list.getQty();
            sumPrice += list.getPrice();
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
