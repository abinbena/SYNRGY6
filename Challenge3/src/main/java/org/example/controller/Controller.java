package org.example.controller;

import org.example.model.Menu;
import org.example.service.AppService;
import org.example.service.MenuService;
import org.example.service.UserService;
import org.example.views.CheckPage;
import org.example.views.ErrorPage;
import org.example.views.HomePage;
import org.example.service.InvoiceService;
import org.example.views.PaymentPage;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
    private static int status,quantity,mainOption,bayarOption;
    private static Menu menuIndex;
    private static int UserID;
    public static void home() throws SQLException {
        InvoiceService invoices = new InvoiceService();
        //inisialisasi UserID
        UserID = UserService.AutoIncrementID();
        do{

            HomePage.show();
            mainOption = Controller.getOption();

            if(mainOption>=1 && mainOption<= MenuService.length()){
                CheckPage.show(mainOption-1);
                quantity = getOption();
                menuIndex = MenuService.listMenu.get(mainOption - 1);
                //menambahkan kedalam invoice
                invoices.add(UserID ,menuIndex.getName(),quantity,menuIndex.getPrice());
                //menambahkan total ke dalam invoice

            } else if (mainOption == 99) {
                invoices.addTotal();
                do{
                    PaymentPage.show();
                    bayarOption = Controller.getOption();
                    if(bayarOption == 1){
                        invoices.cetak();
                        bayarOption = 0;
                        mainOption = 0;
                    } else if (bayarOption == 2){
                        bayarOption = 0;
                    } else if (bayarOption == 0) {
                        bayarOption = 0;
                        mainOption = 0;
                    }
                }while(bayarOption!=0);
            } else {
                ErrorPage.show();
                status = Controller.getOption();
                if(status == 2){
                    mainOption = 0;
                }
            }
        }while (mainOption!=0);
    }

    public static int getOption() {
        int option;
        Scanner input = new Scanner(System.in);
        return option = input.nextInt();
    }

}
