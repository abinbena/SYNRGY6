package org.example.views;

public class CheckPage extends HomePage{

    public static void show(int option){
        System.out.println("===================\n" +
                "Berapa pesanan anda\n" +
                "===================");
        System.out.print(menuService.listMenu.get(option).getName());
        System.out.println(" | " + menuService.listMenu.get(option).getPrice());
        System.out.println("(input 0 untuk kembali)");
        System.out.print("qty => | ");
    }
}
