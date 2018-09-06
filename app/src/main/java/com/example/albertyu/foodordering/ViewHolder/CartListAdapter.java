package com.example.albertyu.foodordering.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.albertyu.foodordering.R;
import com.example.albertyu.foodordering.model.Order;


import java.util.ArrayList;

public class CartListAdapter extends ArrayAdapter<Order> {

    private ArrayList<Order> order;
    Context context;

    public CartListAdapter(Context context, ArrayList<Order> order) {
        super(context, R.layout.cart_layout, order);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.order = order;

    }
    private static class ViewHolder {
        TextView name;
        TextView price;
        ImageView image;
    }

    public View getView(int position,View view,ViewGroup parent) {

        Order orderItem = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater= LayoutInflater.from(context);
            view = inflater.inflate(R.layout.cart_layout, parent, false);
            viewHolder.name = (TextView) view.findViewById(R.id.textViewTitle);
            viewHolder.price = (TextView) view.findViewById(R.id.textViewSubtitle);
            viewHolder.image = (ImageView) view.findViewById(R.id.imageViewIcon);

            result = view;
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            result = view;
        }

        viewHolder.name.setText(orderItem.getProductName());
        viewHolder.price.setText(orderItem.getPrice());


        return view;
    };
}