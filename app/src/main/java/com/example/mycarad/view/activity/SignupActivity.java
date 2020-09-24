package com.example.mycarad.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mycarad.R;
import com.example.mycarad.view.adapter.ContentsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    Button caruesrBtn;
    Button advisorBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        caruesrBtn = findViewById(R.id.choiceCaruser);
        advisorBtn = findViewById(R.id.choiceAdvisor);

        caruesrBtn.setOnClickListener((View.OnClickListener) this);
        advisorBtn.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v){
        if (v == caruesrBtn) {
            setContentView(R.layout.activity_signup_caruser);
        } else if (v == advisorBtn) {
            setContentView(R.layout.activity_signup_advisor);
        }
    }
}

