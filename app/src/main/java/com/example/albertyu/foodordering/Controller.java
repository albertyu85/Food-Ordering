package com.example.albertyu.foodordering;

import android.content.Context;

import com.example.albertyu.foodordering.model.Order;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Controller {

    private FirebaseDatabase database;
    private DatabaseReference category;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private ArrayList<Order> cart;

    public Controller(Context c) {
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        category = database.getReference().child("Category");
        user = mAuth.getCurrentUser();
        cart = new ArrayList<>();
    }

    public FirebaseUser getUser() {
        return user;
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }
    public DatabaseReference getCategory() {
        return category;
    }

    public FirebaseDatabase getDatabase() {
        return database;
    }

    public void addToCart(Order order) {
        cart.add(order);
    }
    public ArrayList<Order> getCart() {
        return cart;
    }
}
