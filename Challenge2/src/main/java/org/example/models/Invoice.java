package org.example.models;

public class Invoice {
    private final String name;
    private final int price;
    private final int qty;
    public Invoice(String name, int qty, int price){
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public int getQty() {
        return qty;
    }
    public void display(){
        System.out.println(name + "\t\t" + qty + "\t" + price);
    }
    public String toString() {
        return name + "\t" + qty + "\t" + price;
    }
}
