package com.example.albertyu.foodordering.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.albertyu.foodordering.adapter.ItemAdapter;
import com.example.albertyu.foodordering.adapter.MyListAdapter;
import com.example.albertyu.foodordering.controller.Controller;
import com.example.albertyu.foodordering.model.ShoppingItem;
import com.example.albertyu.foodordering.R;
import java.util.ArrayList;
import java.util.List;


public class IndividualFragment extends Fragment{

  List<ShoppingItem> shoppingItemList;
  private ListView listView;
  public IndividualFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_individual, container, false);

    final Controller controller = (Controller) getActivity().getApplicationContext();

    shoppingItemList = new ArrayList<>();
    //listView = (ListView) view.findViewById(R.id.listview_food);
    GridView gridView = (GridView) view.findViewById(R.id.gridview);

    shoppingItemList.add(new ShoppingItem(R.drawable.mackeral, "Mackerel In Tomato Sauce", "Brand: Excelsior \n Net Weight: 5.5 Oz (155g)"));
    shoppingItemList.add(new ShoppingItem(R.drawable.sardinesinoil, "Sardines In Oil", "Brand: Excelsior \n Net Weight: 3.75 Oz (106g)"));
    shoppingItemList.add(new ShoppingItem(R.drawable.vienna, "Vienna Sausages", "Made with Chicken, Beef, And Pork. Added in Chicken Broth. Hot &amp Spicy \n Brand: Excelsior \n Net Weight: 4.8 Oz"));
    shoppingItemList.add(new ShoppingItem(R.drawable.watercrackers, "Water Crackers", "Cinnamon and Fat Free \n Brand: Excelsior"));
    shoppingItemList.add(new ShoppingItem(R.drawable.porkszn, "Jamaican Pork Seasoning", "Brand: EASISPICE \n Net Weight: 3.6 Oz (130g)"));
    shoppingItemList.add(new ShoppingItem(R.drawable.ackees, "Ackees", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.bakedbeans, "Baked Beans", "Test Description"));
   /* shoppingItemList.add(new ShoppingItem(R.drawable.chickenseasoning, "Chicken Seasoning", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.coconutmilkcan, "Canned Coconut Milk", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.cocunutwater, "Coconut Water", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.creamedcocunut, "Creamed Coconut", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.crushedpeppersauce, "Crushed Pepper Sauce", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.currypowder, "Curry Powder", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.fishandmeatsauce, "Fish and Meat Sauce", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.fruitpunch, "Fruit Punch", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.irishmoss, "Irish Moss", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.jerksauce, "Jerk Sauce", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.jerkseasoning, "Jerk Seasoning", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.meatseasoning, "Meat Seasoning", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.mildjerk, "Mild Jerk", "Test Description"));
    shoppingItemList.add(new ShoppingItem(R.drawable.oxtailseasoning, "Oxtail Seasoning", "Test Description"));*/

    ItemAdapter itemAdapter = new ItemAdapter(getActivity(), R.layout.grid_layout, shoppingItemList);

    gridView.setAdapter(itemAdapter);

    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        ShoppingItem item = (ShoppingItem) adapterView.getItemAtPosition(i);
        intent.putExtra("Image", item.getImage());
        intent.putExtra("Name", item.getName());
        intent.putExtra("Description", item.getDescription());

        startActivity(intent);
      }
    });
    /*MyListAdapter adapter = new MyListAdapter(getActivity(), R.layout.list_layout, shoppingItemList);

    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        ShoppingItem item = (ShoppingItem) adapterView.getItemAtPosition(i);
        intent.putExtra("Image", item.getImage());
        intent.putExtra("Name", item.getName());
        intent.putExtra("Description", item.getDescription());

        startActivity(intent);
      }
    });*/

    return view;
  }

  public void launchDetailActivity() {

  }


}