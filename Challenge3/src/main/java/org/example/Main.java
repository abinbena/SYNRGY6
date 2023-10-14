package org.example;

import org.example.service.AppService;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        AppService appService = new AppService();
        appService.start();
    }
}
