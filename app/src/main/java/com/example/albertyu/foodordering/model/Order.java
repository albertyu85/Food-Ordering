package com.example.albertyu.foodordering.model;

public class Order {

    private String productName;
    private String productId;
    private int Quantity;
    private String Price;

    public Order(String productName, String productId, int quantity, String price) {
        this.productName = productName;
        this.productId = productId;
        Quantity = quantity;
        Price = price;

    }
    public Order() {

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

}

