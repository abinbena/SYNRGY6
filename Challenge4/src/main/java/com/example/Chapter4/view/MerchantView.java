package com.example.Chapter4.view;

import com.example.Chapter4.model.Merchant;

import java.util.List;

public class MerchantView {
    public static void showAll(List<Merchant>merchants){
        System.out.println("Daftar Merchant:");
        merchants.forEach(Merchant::print);
    }
    public static void merchantMenuOption(){
        System.out.println("1. Tambah\n" +
                "2. Edit\n" +
                "3. Hapus");
    }
}
