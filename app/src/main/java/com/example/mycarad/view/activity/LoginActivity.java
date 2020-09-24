package com.example.mycarad.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycarad.R;
import com.example.mycarad.view.fragment.HomeActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

        Button loginBtn;
        Button signupBtn;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            loginBtn = findViewById(R.id.loginButton);
            signupBtn = findViewById(R.id.signupButton);

            loginBtn.setOnClickListener((View.OnClickListener) this);
            signupBtn.setOnClickListener((View.OnClickListener) this);

        }

        @Override
        public  void onClick(View v){
            if (v == loginBtn) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            } else if (v == signupBtn) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        }
}

