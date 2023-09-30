package org.example.controller;

import org.example.models.Menu;
import org.example.services.MenuService;
import org.example.views.CheckPage;
import org.example.views.ErrorPage;
import org.example.views.HomePage;
import org.example.services.InvoiceService;
import org.example.views.PaymentPage;

import java.util.Scanner;

public class Controller {
    private static int status,quantity,Option,bayarOption;
    private static Menu menuIndex;
    public static void home(){
        InvoiceService invoices = new InvoiceService();
        do{
            HomePage.show();
            Option = Controller.getOption();

            if(Option>=1 && Option<= MenuService.length()){
                CheckPage.show(Option-1);
                quantity = getOption();

                if(quantity != 0){
                    //menambahkan index menu yang dipilih kedalam invoice
                    menuIndex = MenuService.listMenu.get(Option - 1);
                    //menambahkan total ke dalam invoice
                    invoices.add(menuIndex.getName(),quantity,menuIndex.getPrice());
                }


            } else if (Option == 99) {

                if(invoices.list.isEmpty()) {
                    ErrorPage.errorQuantity();
                    errorHandle();
                }

                else {
                    invoices.addTotal();
                    PaymentPage.show();
                    bayarOption = Controller.getOption();

                    switch (bayarOption){
                        case 1 -> {
                            invoices.cetak();
                            Option = 0;
                        }
                        case 2 -> bayarOption = 0;
                        case 0 -> {
                            bayarOption= 0;
                            Option = 0;
                        }
                        default -> {
                            ErrorPage.errorInput();
                            errorHandle();
                        }
                    }
                }

            } else if (Option != 0) {
                ErrorPage.errorInput();
                errorHandle();
            }
        }while (Option!=0);
    }
    public static void errorHandle(){

        status = Controller.getOption();
        switch (status){
            case 1 -> {
            }
            case 2 -> Option = 0;
            default -> errorHandle();
        }
    }
    public static int getOption() {
        int option;
        Scanner input = new Scanner(System.in);
        return option = input.nextInt();
    }
}

