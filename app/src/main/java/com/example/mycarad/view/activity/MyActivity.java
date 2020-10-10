package com.example.mycarad.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivityMyBinding;

public class MyActivity extends AppCompatActivity {

    private ActivityMyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my);

        //툴바
        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.myInfoButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyInfoActivity.class);
            startActivity(intent);
        });
        binding.myWriteMoreButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyWriteViewActivity.class);
            startActivity(intent);
        });
        binding.myAppInfoButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MyAppInfoActivity.class);
            startActivity(intent);
        });
        binding.myLogOutButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

    }

    //툴바 뒤로 가기
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
