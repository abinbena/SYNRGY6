package org.example.models;

public class Menu {
    private String name;
    private int price;
    public Menu(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void display(){
        System.out.println(name + "\t| " + price);
    }
}
