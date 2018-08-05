package com.example.albertyu.foodordering;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView mImageView;
    TextView mDescription;
    TextView mName;
    int id;
    String name;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("Image", 0);
            name = extras.getString("Name");
            description = extras.getString("Description");
        }

        mImageView = findViewById(R.id.imageViewPicture);
        mDescription = findViewById(R.id.textViewDescription);
        mName = findViewById(R.id.textView_name);

        mImageView.setImageResource(id);
        mDescription.setText(description);
        mName.setText(name);

    }
}
