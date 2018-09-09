package com.example.albertyu.foodordering.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.example.albertyu.foodordering.Controller;
import com.example.albertyu.foodordering.R;
import com.example.albertyu.foodordering.ViewHolder.CartListAdapter;
import com.example.albertyu.foodordering.model.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ListView list;
    ArrayList<Order> orderList;
    String[] name;
    String[] price;
    int[] image;
    Controller c;
    CartListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mo Jamaican LLC");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        orderList = new ArrayList<>();
        list = findViewById(R.id.listViewCart);
        c = new Controller(this);
        //TODO: Read cart data into arraylist
        DatabaseReference ref = c.getDatabase().getReference().child("User").child(c.getUser().getUid()).child("Food");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("Count", "" + dataSnapshot.getChildrenCount());
                for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                    Order order = orderSnapshot.getValue(Order.class);
                    orderList.add(order);
                }
               adapter = new CartListAdapter(getApplicationContext(), orderList);
                list.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Snap", "not working");
            }
        });
        /*orderArray = new Order[c.getCart().size()];
        for (int i = 0; i < orderArray.length; i++) {
            orderArray[i] = c.getCart().get(i);
        }*/

        /*for (int i = 0; i < orderArray.length;i++) {
            name[i] = orderArray[i].getProductName();
            price[i] = orderArray[i].getPrice();
        }
*/






    }
}
