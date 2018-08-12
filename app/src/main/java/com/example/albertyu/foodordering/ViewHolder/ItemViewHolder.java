package com.example.albertyu.foodordering.ViewHolder;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.andanhm.quantitypicker.QuantityPicker;
import com.example.albertyu.foodordering.Interface.ItemClickListener;
import com.example.albertyu.foodordering.R;

public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView itemImageView;
    public TextView itemName;
    public TextView itemPrice;
    public QuantityPicker quantityPicker;
    public Button addToCart;

    private ItemClickListener itemClickListener;

    public ItemViewHolder(View view) {
        super(view);
        itemImageView = (ImageView) view.findViewById(R.id.item_imageView);
        itemName = (TextView) view.findViewById(R.id.item_name);
        itemPrice = (TextView) view.findViewById(R.id.item_price);
        quantityPicker = (QuantityPicker) view.findViewById(R.id.number_picker);
        addToCart = (Button) view.findViewById(R.id.addToCart);

        view.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}
