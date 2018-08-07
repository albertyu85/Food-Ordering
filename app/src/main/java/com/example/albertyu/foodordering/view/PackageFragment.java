package com.example.albertyu.foodordering.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.albertyu.foodordering.adapter.MyListAdapter;
import com.example.albertyu.foodordering.model.ShoppingItem;
import com.example.albertyu.foodordering.R;
import java.util.ArrayList;
import java.util.List;

public class PackageFragment extends Fragment{

  List<ShoppingItem> shoppingItemList;
  ListView listView;


  public PackageFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_package, container, false);

    shoppingItemList = new ArrayList<>();
    listView = (ListView) view.findViewById(R.id.listview_package);

    shoppingItemList.add(new ShoppingItem(R.drawable.basket, "Basket", "Basket of goodies"));

    MyListAdapter adapter = new MyListAdapter(getActivity(), R.layout.list_layout, shoppingItemList);

    listView.setAdapter(adapter);

    // Inflate the layout for this fragment
    return view;
  }

}