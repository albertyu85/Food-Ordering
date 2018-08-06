package com.example.albertyu.foodordering.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertyu.foodordering.model.ShoppingItem;
import com.example.albertyu.foodordering.R;
import java.util.List;

public class MyListAdapter extends ArrayAdapter<ShoppingItem>{

    List<ShoppingItem> shoppingList;
    Context context;
    int resource;

    public MyListAdapter(Context context, int resource, List<ShoppingItem> shoppingList) {
        super(context, resource, shoppingList);
        this.context = context;
        this.resource = resource;
        this.shoppingList = shoppingList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewTeam = view.findViewById(R.id.textViewDescription);


        //getting the hero of the specified position
        ShoppingItem item = shoppingList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(item.getImage()));
        textViewName.setText(item.getName());
        textViewTeam.setText(item.getDescription());

        //finally returning the view
        return view;
    }

}
