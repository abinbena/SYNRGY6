package com.example.Chapter4.controller;

import com.example.Chapter4.view.HomeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class HomeController {
    private final MerchantController merchantController;
    private final UserController userController;

    public HomeController(MerchantController merchantController, UserController userController) {
        this.merchantController = merchantController;
        this.userController = userController;
    }

    public void home(){
        HomeView.wellcomeMessage();
        int option = getOption();
        if(option == 1){
            userController.userMenu();

        }else if(option ==2){
            merchantController.merchantMenu();
        }
        else {}
    }

    public int getOption(){
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return option;
    }
}
