package com.example.Chapter4.view;

import com.example.Chapter4.model.User;

import java.util.List;

public class UserView {
    public static void showAll(List<User> users){
        System.out.println("Daftar User: ");
        users.forEach(User::print);
    }
}
