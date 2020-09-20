package com.example.mycarad.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mycarad.view.fragment.AdvisorFragment;
import com.example.mycarad.view.fragment.CaruserFragment;
import com.example.mycarad.view.fragment.HomeFragment;

import java.util.ArrayList;

public class ContentsPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;

    public ContentsPagerAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<Fragment>();
        items.add(new HomeFragment());
        items.add(new AdvisorFragment());
        items.add(new CaruserFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
