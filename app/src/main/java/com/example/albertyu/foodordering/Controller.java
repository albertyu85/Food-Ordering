package com.example.albertyu.foodordering;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Controller {

    private FirebaseDatabase database;
    private DatabaseReference category;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    public Controller(Context c) {
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        category = database.getReference().child("Category");
        user = mAuth.getCurrentUser();
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
}
