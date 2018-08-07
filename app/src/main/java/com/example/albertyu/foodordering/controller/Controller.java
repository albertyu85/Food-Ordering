package com.example.albertyu.foodordering.controller;

import android.app.Application;
import com.example.albertyu.foodordering.model.ShoppingItem;
import java.util.ArrayList;

public class Controller extends Application{

  private ArrayList<ShoppingItem> items = new ArrayList<>();

  public ArrayList<ShoppingItem> getItems() {
    return items;
  }

  public void setItems(ArrayList<ShoppingItem> mItems) {
    this.items = mItems;
  }

  public void addItems(ShoppingItem item) {
    items.add(item);
  }
}
