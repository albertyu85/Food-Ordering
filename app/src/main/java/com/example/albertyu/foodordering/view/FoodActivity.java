package com.example.albertyu.foodordering.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.albertyu.foodordering.Controller;
import com.example.albertyu.foodordering.GridSpacingItemDecoration;
import com.example.albertyu.foodordering.Interface.ItemClickListener;
import com.example.albertyu.foodordering.R;
import com.example.albertyu.foodordering.ViewHolder.ItemViewHolder;
import com.example.albertyu.foodordering.model.Order;
import com.example.albertyu.foodordering.model.ShoppingItem;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference foodList;
    FirebaseRecyclerAdapter adapter;
    ProgressBar simpleProgressBar;
    String categoryId;
    Controller c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mo Jamaican LLC");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        c = new Controller(this);
       /* DatabaseReference ref = c.getDatabase().getReference().child("User").child(c.getUser().getUid()).child("Food");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.e("Count", "" + dataSnapshot.getChildrenCount());
                if (c.getCart().size() < 1) {
                    for (DataSnapshot orderSnapshot : dataSnapshot.getChildren()) {
                        Order order = orderSnapshot.getValue(Order.class);
                        c.addToCart(order);
                    }
                } else {

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Snap", "not working");
            }
        });*/
        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToCart();
            }
        });
        setUp();
        if (getIntent() != null) {
            categoryId = getIntent().getStringExtra("CategoryId");
            if (categoryId != null && !categoryId.isEmpty()) {
                setUp();
                loadMenu();
            }
        }
    }

    private void setUp() {
        database = FirebaseDatabase.getInstance();
        foodList = database.getReference().child("Item");
        int spanCount = 2;
        int spacing = 20;
        boolean includeEdge = true;
        recyclerView = (RecyclerView) findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        recyclerView.setLayoutManager(layoutManager);
    }
    private void loadMenu() {
        //TODO:Make sure OnActivityResult is called. When back button is clicked categoryid is not getting set resulting in loading bar
        //categoryId = "02";
        Query query = FirebaseDatabase.getInstance().getReference().child("Item");
        FirebaseRecyclerOptions<ShoppingItem> options = new FirebaseRecyclerOptions.Builder<ShoppingItem>()
                .setQuery(query.orderByChild("Id").equalTo(categoryId), ShoppingItem.class)
                .build();
        adapter = new FirebaseRecyclerAdapter<ShoppingItem, ItemViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ItemViewHolder holder, int position, @NonNull ShoppingItem model) {
                holder.itemName.setText(model.getName());
                holder.itemPrice.setText(model.getPrice());
                Picasso.get().load(model.getImage()).into(holder.itemImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        simpleProgressBar.setVisibility(View.GONE);
                    }
                    @Override
                    public void onError(Exception e) {
                    }
                });
                final ShoppingItem itemClick = model;
                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(FoodActivity.this, "" + itemClick.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FoodActivity.this, DetailActivity.class);
                        intent.putExtra("CategoryId", categoryId);
                        intent.putExtra("Name", itemClick.getName());
                        intent.putExtra("Description", itemClick.getDescription());
                        intent.putExtra("Image", itemClick.getImage());
                        intent.putExtra("Price", itemClick.getPrice());
                        startActivityForResult(intent, 999);
                    }
                });
                holder.addToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Order order = new Order(holder.itemName.getText().toString(), categoryId, 1, holder.itemPrice.getText().toString());
                        //c.addToCart(order);
                        //TODO: Write to database /User/UID/food
                        DatabaseReference user = c.getDatabase().getReference().child("User");
                        user.child(c.getUser().getUid()).child("Food").child("" + (c.getCounter())).setValue(order);
                        Toast.makeText(FoodActivity.this, c.getCounter() +"", Toast.LENGTH_SHORT).show();
                        c.increment();
                    }
                });
            }
            @NonNull
            @Override
            public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_layout, parent, false);
                return new ItemViewHolder(view);
            }
        };
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
            categoryId = data.getStringExtra("CategoryId");
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
    public void sendToCart() {
        Intent intent = new Intent(FoodActivity.this, CartActivity.class);
        startActivity(intent);
    }
}
