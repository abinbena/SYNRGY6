package org.example.views;
import org.example.services.InvoiceService;

public class PaymentPage extends HomePage{

    public static void show(){
        System.out.println("==========================\n" +
                "Konfirmasi & Bayar\n" +
                "==========================\n");
        //invoice
        InvoiceService.show();
        System.out.println("-------------------------+");
        //total
        InvoiceService.showTotal();
        System.out.println("\n1. Konfirmasi dan Bayar\n" +
                "2. Kembali ke menu utama\n" +
                "0. Keluar aplikasi");
        System.out.print("=>");
    }
}
