package com.example.albertyu.foodordering.model;

public class Category {

    private String Name;
    private String Image;

    public Category(String name, String image) {
        this.Name = name;
        this.Image = image;
    }
    public Category() { }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getImage() {
        return this.Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }
}
