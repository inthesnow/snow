package com.example.mycarad.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivityHomeBinding;
import com.example.mycarad.view.adapter.ContentsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private String userType;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        Intent intent = getIntent();
        userName = intent.getExtras().getString("userName");
        userType = intent.getExtras().getString("userType");

        //툴바
        setSupportActionBar(binding.includeAppBar.toolBarHome);

        binding.includeAppBar.appBarSetBtn.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MyActivity.class);
            Bundle extras = new Bundle();
            extras.putString("userName", userName);
            extras.putString("userType", userType);
            intent1.putExtras(extras);
            startActivity(intent1);
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
            if(userType.equals("Driver") ) {
                Intent intent2 = new Intent(getApplicationContext(), DriverWriteActivity.class);
                Bundle extras = new Bundle();
                extras.putString("userName", userName);
                intent2.putExtras(extras);
                startActivity(intent2);
            } else {
                Intent intent2 = new Intent(getApplicationContext(), AdvisorWriteActivity.class);
                Bundle extras = new Bundle();
                extras.putString("userName", userName);
                intent2.putExtras(extras);
                startActivity(intent2);
            }
        });
    }

}
