package com.example.albertyu.foodordering.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.albertyu.foodordering.R;

public class DetailFragment extends Fragment{

    ImageView mImageView;
    TextView mName;
    TextView mDescription;
    int i;
    String name;
    String description;
    public DetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_detail, container, false);
        mImageView = (ImageView) view.findViewById(R.id.imageViewItem);
        mName = (TextView) view.findViewById(R.id.textViewName);
        mDescription = (TextView) view.findViewById(R.id.textViewDetailDescription);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            i = bundle.getInt("Image", 0);
            name = bundle.getString("Name");
            description = bundle.getString("Description");
        }
        mImageView.setImageResource(i);
        mDescription.setText(description);
        mName.setText(name);

        return view;
    }

}
