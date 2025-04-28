package com.stockify.platform;

public class Product {
    private final String id;
    private final String name;
    private int quantity;
    private int price;

    public Product(String id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public int getQuantity() { return quantity; }

    public int getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setPrice(int price) { this.price = price; }
}
