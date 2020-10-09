package com.example.mycarad.view.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivityHomeBinding;
import com.example.mycarad.databinding.ActivitySignupBinding;
import com.example.mycarad.view.adapter.ContentsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        setSupportActionBar(binding.includeAppBar.toolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = findViewById(R.id.viewpager);
        ContentsPagerAdapter contentsPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(contentsPagerAdapter);

        //연동
        TabLayout tab = findViewById((R.id.tab));
        tab.setupWithViewPager(viewPager);
        //텝 이미지
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.home);
        images.add(R.drawable.money);
        images.add(R.drawable.car);
        //텝카운트
        int count = tab.getTabCount();
        for (int i = 0; i < count; i++) tab.getTabAt(i).setIcon(images.get(i));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
