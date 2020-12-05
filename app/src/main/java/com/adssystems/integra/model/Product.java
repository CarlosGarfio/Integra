package com.adssystems.integra.model;

public class Product {

    public String url;
    public String name;
    public double price;
    public int quantity;

    public Product(int quantity, String name, double price, String url) {
        this.url = url;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
