package com.example.albertyu.foodordering.adapter;

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
        ViewHolderItem viewHolderItem;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);

            //getting the view
            convertView = layoutInflater.inflate(resource, null, false);

            viewHolderItem= new ViewHolderItem();
            viewHolderItem.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolderItem.name = (TextView) convertView.findViewById(R.id.textViewName);
            viewHolderItem.description = (TextView) convertView.findViewById(R.id.textViewDescription);
            convertView.setTag(viewHolderItem);
        }
        else {
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }


        //getting the hero of the specified position
        ShoppingItem item = shoppingList.get(position);

        //adding values to the list item
        if (item != null) {
            viewHolderItem.name.setText(item.getName());
            viewHolderItem.description.setText(item.getDescription());
            viewHolderItem.imageView.setImageResource(item.getImage());
        }

        //finally returning the view
        return convertView;
    }

    static class ViewHolderItem {
        TextView name;
        TextView description;
        ImageView imageView;

    }
}
