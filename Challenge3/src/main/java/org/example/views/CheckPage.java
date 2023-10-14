package org.example.views;

public class CheckPage extends HomePage{

    public static void show(int option){
        System.out.println("===================\n" +
                "Berapa pesanan anda\n" +
                "===================");
        System.out.println("(input 0 untuk kembali)");
        System.out.print("qty => | ");
    }
}
