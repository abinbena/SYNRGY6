package org.example.views;

public class ErrorPage {
    public static void show(){
        System.out.println("====================\t================\n" +
                "Mohon masukkan input\tMinimal 1 jumlah\n" +
                "pilihan anda\t\t\tpesanan!\n" +
                "====================\t================\n");
        System.out.println("1). Lanjut\n" +
                "2). Keluar");
        System.out.print("=>");
    }
}
