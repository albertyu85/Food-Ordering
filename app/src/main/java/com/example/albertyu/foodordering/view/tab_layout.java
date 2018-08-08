package com.example.albertyu.foodordering.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.albertyu.foodordering.R;


public class tab_layout extends Fragment {

  public static TabLayout tabLayout;
  public static ViewPager viewPager;
  public static int int_items = 3;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    //this inflates out tab layout file.
    View x = inflater.inflate(R.layout.fragment_tab_layout, null);
    // set up stuff.
    tabLayout = (TabLayout) x.findViewById(R.id.tabs);
    viewPager = (ViewPager) x.findViewById(R.id.viewpager);

    // create a new adapter for our pageViewer. This adapters returns child fragments as per the positon of the page Viewer.
    viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

    // this is a workaround
    tabLayout.post(new Runnable() {
      @Override
      public void run() {
        //provide the viewPager to TabLayout.
        tabLayout.setupWithViewPager(viewPager);
      }
    });
    //to preload the adjacent tabs. This makes transition smooth.
    viewPager.setOffscreenPageLimit(2);

    return x;
  }

  class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
      super(fm);
    }

    //return the fragment with respect to page position.
    @Override
    public Fragment getItem(int position) {
      switch (position) {
        case 0:
          return new IndividualFragment();
        case 1:
          return new PackageFragment();
        case 2:
          return new RecipeFragment();
      }
      return null;
    }

    @Override
    public int getCount() {

      return int_items;

    }

    //This method returns the title of the tab according to the position.
    @Override
    public CharSequence getPageTitle(int position) {

      switch (position) {
        case 0:
          return "Individual";
        case 1:
          return "Package";
        case 2:
          return "Recipe";

      }
      return null;
    }
  }
}