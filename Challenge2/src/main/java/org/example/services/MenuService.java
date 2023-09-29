package org.example.services;

import org.example.models.Menu;
import java.util.ArrayList;
public class MenuService {
    public static ArrayList<Menu> listMenu = new ArrayList<>();
    private Menu menu1 = new Menu("Nasi Goreng",12000);
    private Menu menu2 = new Menu("Ayam Goreng",16000);
    private Menu menu3 = new Menu("Mie Goreng",10000);
    private Menu menu4 = new Menu("Es Teh",4000);
    private Menu menu5 = new Menu("Es Jeruk",6000);
    public MenuService(){
        listMenu.add(menu1);
        listMenu.add(menu2);
        listMenu.add(menu3);
        listMenu.add(menu4);
        listMenu.add(menu5);
    }
    public static int length(){
        return listMenu.size();
    }
    public static void show(){
        int index = 1;
        for(Menu list: listMenu){
            System.out.print(index++ + ". ");
            list.display();
        }
    }
}
