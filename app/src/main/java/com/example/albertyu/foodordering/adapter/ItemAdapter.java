package com.example.albertyu.foodordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertyu.foodordering.R;
import com.example.albertyu.foodordering.model.ShoppingItem;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends BaseAdapter{

    List<ShoppingItem> shoppingList;
    Context context;
    int resource;

    public ItemAdapter(Context context,int resource, List<ShoppingItem> shoppingList) {
        this.resource = resource;
        this.context = context;
        this.shoppingList = shoppingList;
    }
    @Override
    public int getCount() {
        return shoppingList.size();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return shoppingList.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(resource, null, false);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview_cover_art);
        TextView name = (TextView) view.findViewById(R.id.textview_book_name);

        ShoppingItem item = shoppingList.get(i);
        imageView.setImageDrawable(context.getResources().getDrawable(item.getImage()));
        name.setText(item.getName());

        return view;

    }
}
