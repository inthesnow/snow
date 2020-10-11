package com.example.mycarad.view.activity;

import android.content.Intent;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        //툴바
        setSupportActionBar(binding.includeAppBar.toolBarHome);

        binding.includeAppBar.appBarSetBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyActivity.class);
            startActivity(intent);
        });

        //뷰페이저
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

        binding.writeFloatingBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DriverWriteActivity.class);
            startActivity(intent);
        });
    }
}
