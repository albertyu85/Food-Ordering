package com.example.albertyu.foodordering.model;

public class ShoppingItem {

    private String Image;
    private String Name;
    private String Price;

    public ShoppingItem(String image, String name, String price) {
        this.Image = image;
        this.Name = name;
        this.Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
