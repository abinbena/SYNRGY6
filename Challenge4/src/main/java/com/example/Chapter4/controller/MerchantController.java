package com.example.Chapter4.controller;

import com.example.Chapter4.model.Merchant;

import com.example.Chapter4.service.MerchantService;
import com.example.Chapter4.service.ProductService;
import com.example.Chapter4.service.UserService;
import com.example.Chapter4.view.MerchantView;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class MerchantController {
    private final MerchantService merchantService;
    public MerchantController(MerchantService merchantService, ProductService productService,UserService userService) {
        this.merchantService = merchantService;
    }
    public List<Merchant> index(){
        List<Merchant> merchants = merchantService.getAll();
        return merchants;
    }
    public void merchantMenu(){
        List<Merchant> merchants = merchantService.getAll();

        MerchantView.showAll(merchants);
        MerchantView.merchantMenuOption();

        int option = getOption();
        if(option == 1){
            System.out.println("MenuTambah");
            addMerchant();
        } else if (option == 2) {
            System.out.println("Masukan nama yang ingin di edit:");
            String merchantName = getString();
            System.out.println("Masukan status:\n" +
                    "0. Tutup\n" +
                    "1. Buka");
            int status = getOption();
            merchantService.editMerchant(merchantName, status);
        } else if (option == 3) {
            System.out.println("Masukan nama Merchant yang ingin dihapus:");
            String merchantName = getString();
            merchantService.deleteMerchant(merchantName);
        } else{}
    }
    public int getOption(){
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return option;
    }
    public String getString(){
        Scanner scanner = new Scanner(System.in);
        String option= scanner.nextLine();
        return option;
    }
    //Data Communication
    public void addMerchant(){
        Merchant merchant = new Merchant();
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String address = scanner.nextLine();

        merchant.setName(name);
        merchant.setAddress(address);
        merchant.setIsOpen(1);
        merchantService.create(merchant);
    }
//    public void initiateDate(){
//        List<Merchant> merchants = Stream.of(
//                new Merchant("Toko Arak","Jl. SukaBapak"),
//                new Merchant("Toko Tuak","Jl. SukaPura"),
//                new Merchant("Toko Anggur","Jl. SukaBirus"),
//                new Merchant("Toko Beer","Jl.SukaLaka")
//        ).toList();
//
//        merchants.forEach(merchantService::create);
//    }
//    public void initiateProduct(){
//        List<Product> products = Stream.of(
//                new Product("ayam"),
//                new Product("mie")
//        ).toList();
//
//        products.forEach(productService::create);
//    }
//
//    public void show(UUID id){
//        Merchant merchant = merchantService.getById(id);
//        System.out.println("Nama: " + merchant.getName());
//    }
}
