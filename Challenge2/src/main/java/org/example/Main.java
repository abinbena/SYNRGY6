package org.example;

import org.example.services.AppService;

public class Main {
    public static void main(String[] args) {
        AppService appService = new AppService();
        appService.start();
    }
}
