package org.example.views;

import org.example.services.MenuService;


public class HomePage {
    static MenuService menuService = new MenuService();
    public static void show(){
        System.out.println("==========================\n"+
                "Selamat Datang di BinarFud\n" +
                "==========================");
        menuService.show();
        System.out.println("\n99. Pesan dan Bayar\n" +
                "0. Keluar aplikasi");
        System.out.print("=> ");
    }
}
