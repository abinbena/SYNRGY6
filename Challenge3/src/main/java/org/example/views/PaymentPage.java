package org.example.views;
import org.example.service.InvoiceService;

import java.sql.SQLException;


public class PaymentPage{

    public static void show(int userID) throws SQLException {
        System.out.println("==========================\n" +
                "Konfirmasi & Bayar\n" +
                "==========================\n");
        //invoice
        InvoiceService.show(userID);
        System.out.println("\n1. Konfirmasi dan Bayar\n" +
                "2. Kembali ke menu utama\n" +
                "0. Keluar aplikasi");
        System.out.print("=>");
    }
}
