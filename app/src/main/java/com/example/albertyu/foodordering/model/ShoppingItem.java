package com.example.albertyu.foodordering.model;

public class ShoppingItem {

    private String Image;
    private String Name;
    private String Price;
    private String Id;
    private String Description;

    public ShoppingItem(String image, String name, String price, String id, String description) {
        this.Image = image;
        this.Name = name;
        this.Price = price;
        this.Id = id;
        this.Description = description;
    }
    public ShoppingItem() { }

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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
