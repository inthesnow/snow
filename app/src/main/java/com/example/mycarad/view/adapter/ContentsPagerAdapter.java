package com.example.mycarad.view.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mycarad.view.fragment.AdvisorFragment;
import com.example.mycarad.view.fragment.DriverFragment;
import com.example.mycarad.view.fragment.HomeFragment;

import java.util.ArrayList;

public class ContentsPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> titles;

    public ContentsPagerAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        items.add(new HomeFragment());
        items.add(new AdvisorFragment());
        items.add(new DriverFragment());

        titles = new ArrayList<>();
        titles.add("홈");
        titles.add("광고해주세요");
        titles.add("광고할래요");
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
