package com.example.mycarad.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mycarad.R;
import com.example.mycarad.view.adapter.ContentsPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = findViewById(R.id.viewpager);
        ContentsPagerAdapter contentsPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(contentsPagerAdapter);

        //연동
        TabLayout tab = findViewById((R.id.tab));
        tab.setupWithViewPager(viewPager);

    }


}
