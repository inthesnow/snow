package com.example.mycarad.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        binding.carButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    binding.carUserLayout.setVisibility(View.VISIBLE);
                    binding.advisorLayout.setVisibility(View.GONE);
                } else {
                    binding.carUserLayout.setVisibility(View.GONE);
                    binding.advisorLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

  /*  @Override
    public void onClick(View v){
        if (v == caruesrBtn) {
            setContentView(R.layout.activity_signup_caruser);
        } else if (v == advisorBtn) {
            setContentView(R.layout.activity_signup_advisor);
        }
    }*/
}

