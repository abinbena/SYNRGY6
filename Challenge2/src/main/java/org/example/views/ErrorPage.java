package org.example.views;

public class ErrorPage {
    public static void errorInput(){
        System.out.println("=====================\n" +
                "Mohon masukan inputan\n" +
                "yang sesuai pilihan\n" +
                "=====================\n");
        System.out.println("1). Lanjut\n" +
                "2). Keluar");
        System.out.print("=>");
    }
    public static void errorQuantity(){
        System.out.println("=====================\n" +
                "Mohon masukan pesanan \n" +
                "anda terlebih dahulu\n" +
                "\n" +
                "Minimal 1 pesanan\n" +
                "=====================");
        System.out.println("1). Lanjut\n" +
                "2). Keluar");
        System.out.print("=>");
    }
}
