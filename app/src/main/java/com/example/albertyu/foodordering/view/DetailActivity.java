package com.example.albertyu.foodordering.view;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertyu.foodordering.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    String categoryId;
    String image;
    String name;
    String description;
    String price;
    ImageView mFoodImage;
    TextView mName;
    TextView mPrice;
    TextView mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        categoryId = "";
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout ctl= (CollapsingToolbarLayout) findViewById(R.id.CollapsingToolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToCart();
            }
        });

        if (getIntent() != null) {
            categoryId = getIntent().getStringExtra("CategoryId");
            image = getIntent().getStringExtra("Image");
            name = getIntent().getStringExtra("Name");
            description = getIntent().getStringExtra("Description");
            price = getIntent().getStringExtra("Price");
        }
        toolbar.setTitle(name);
        mFoodImage = (ImageView) findViewById(R.id.detailImageView);
        mName = (TextView) findViewById(R.id.textViewName);
        mPrice = (TextView) findViewById(R.id.textViewPrice);
        mDescription = (TextView) findViewById(R.id.textViewDescription);
        Picasso.get().load(image).into(mFoodImage, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });
        mName.setText(name);
        mPrice.setText(price);
        mDescription.setText(description);
    }

    public void sendToCart() {
        Intent intent = new Intent(DetailActivity.this, CartActivity.class);
        startActivity(intent);
    }
}
