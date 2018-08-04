package com.example.albertyu.foodordering;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PackageFragment extends Fragment{

  List<ShoppingItem> shoppingItemList2;
  ListView listView2;


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

    shoppingItemList2 = new ArrayList<>();
    listView2 = (ListView) view.findViewById(R.id.listview_package);

    shoppingItemList2.add(new ShoppingItem(R.drawable.mackeral, "Mackerel In Tomato Sauce", "Brand: Excelsior \n Net Weight: 5.5 Oz (155g)"));
    shoppingItemList2.add(new ShoppingItem(R.drawable.sardinesinoil, "Sardines In Oil", "Brand: Excelsior \n Net Weight: 3.75 Oz (106g)"));
    shoppingItemList2.add(new ShoppingItem(R.drawable.vienna, "Vienna Sausages", "Made with Chicken, Beef, And Pork. Added in Chicken Broth. Hot &amp Spicy \n Brand: Excelsior \n Net Weight: 4.8 Oz"));
    shoppingItemList2.add(new ShoppingItem(R.drawable.watercrackers, "Water Crackers", "Cinnamon and Fat Free \n Brand: Excelsior"));
    shoppingItemList2.add(new ShoppingItem(R.drawable.porkszn, "Jamaican Pork Seasoning", "Brand: EASISPICE \n Net Weight: 3.6 Oz (130g)"));

    MyListAdapter adapter = new MyListAdapter(getActivity(), R.layout.list_layout, shoppingItemList2);

    listView2.setAdapter(adapter);

    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_package, container, false);
  }

}