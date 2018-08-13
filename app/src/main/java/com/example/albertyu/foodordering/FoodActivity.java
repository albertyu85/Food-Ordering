package com.example.albertyu.foodordering;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.albertyu.foodordering.Interface.ItemClickListener;
import com.example.albertyu.foodordering.ViewHolder.CategoryViewHolder;
import com.example.albertyu.foodordering.ViewHolder.ItemViewHolder;
import com.example.albertyu.foodordering.model.Category;
import com.example.albertyu.foodordering.model.ShoppingItem;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class FoodActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference foodList;
    FirebaseRecyclerAdapter adapter;

    String categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Mo Items");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        database = FirebaseDatabase.getInstance();
        foodList = database.getReference().child("Item");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        int spanCount = 2;
        int spacing = 20;
        boolean includeEdge = true;
        recyclerView = (RecyclerView) findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent() != null) {
            categoryId = getIntent().getStringExtra("CategoryId");
            if (!categoryId.isEmpty() && categoryId != null) {
                loadMenu();
            }
        }

    }

    private void loadMenu() {
        Query query = FirebaseDatabase.getInstance().getReference().child("Item");
        FirebaseRecyclerOptions<ShoppingItem> options = new FirebaseRecyclerOptions.Builder<ShoppingItem>()
                .setQuery(query.orderByChild("Id").equalTo(categoryId), ShoppingItem.class)
                .build();
        adapter = new FirebaseRecyclerAdapter<ShoppingItem, ItemViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ItemViewHolder holder, int position, @NonNull ShoppingItem model) {
                holder.itemName.setText(model.getName());
                holder.itemPrice.setText(model.getPrice());
                Picasso.get().load(model.getImage()).into(holder.itemImageView);
                final ShoppingItem itemClick = model;
                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Intent intent = new Intent(FoodActivity.this, FoodActivity.class);
                        //startActivity(intent);
                        Toast.makeText(FoodActivity.this, "" + itemClick.getName(), Toast.LENGTH_SHORT).show();

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
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
