package com.example.albertyu.foodordering.ViewHolder;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.albertyu.foodordering.Interface.ItemClickListener;
import com.example.albertyu.foodordering.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public MenuViewHolder(View view) {
        super(view);
        mName = (TextView) view.findViewById(R.id.menu_name);
        imageView = (ImageView) view.findViewById(R.id.menu_imageView);

        view.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }


}
