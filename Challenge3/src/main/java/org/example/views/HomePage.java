package org.example.views;

import org.example.service.MenuService;

import java.sql.SQLException;


public class HomePage {
    static MenuService menuService = new MenuService();
    public static void show() throws SQLException {
        System.out.println("==========================\n"+
                "Selamat Datang di BinarFud\n" +
                "==========================");
        menuService.show();
        System.out.println("\n99. Pesan dan Bayar\n" +
                "0. Keluar aplikasi");
        System.out.print("=> ");
    }
}
