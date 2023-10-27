package com.example.Chapter4.controller;

import com.example.Chapter4.model.User;
import com.example.Chapter4.service.UserService;
import com.example.Chapter4.view.UserView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public void userMenu(){
        boolean loggedIn = false;
        List<User> users = userService.getAll();
        System.out.println("1. Login\n" +
                "2. Daftar");
        int option = getOption();
        if(option == 1){
            UserView.showAll(users);
            String userName = getString();
            String password = getString();
            for(User user: users) {
                if(userName.equals(user.getName()) && password.equals(user.getPassword())){
                    System.out.println("Login");
                    loggedIn = true;
                }
                if (loggedIn) {
                    // Menu setelah login berhasil
                    while (true) {
                        System.out.println("Pilihan Menu:");
                        //List//
                        System.out.println("1. Beli");
                        System.out.println("0. Keluar");

                        int choice = getOption();

                        switch (choice) {
                            case 1:
                                
                                break;
                            case 0:
                                System.out.println("Keluar");
                                return; // Keluar dari loop dan program
                            default:
                                System.out.println("Pilihan tidak valid");
                        }
                    }
                }
            }
        } else if (option == 2) {
            addUser();
        }
    }

    public void addUser(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String password = scanner.nextLine();

        user.setName(name);
        user.setPassword(password);

        userService.create(user);
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
}
