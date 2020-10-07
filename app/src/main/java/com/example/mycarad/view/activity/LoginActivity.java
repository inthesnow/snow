package com.example.mycarad.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycarad.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn;
    Button signupBtn;
    EditText idEditView;
    EditText passEditView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.loginButton);
        signupBtn = findViewById(R.id.signupButton);
        idEditView = findViewById(R.id.idEditView);
        passEditView = findViewById(R.id.passEditView);

        loginBtn.setOnClickListener((View.OnClickListener) this);
        signupBtn.setOnClickListener((View.OnClickListener) this);

        idEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             //   Log.e("snow", "beforeTextChanged " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkLoginButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkLoginButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == loginBtn) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else if (v == signupBtn) {
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
        }
    }

    // ID,PW 값이 있을 때 로그인 버튼 활성화 처리
    private void checkLoginButtonEnabled() {
        boolean isEnabled = !(idEditView.getText().toString().isEmpty()) && !(passEditView.getText().toString().isEmpty());
        loginBtn.setEnabled(isEnabled);

    }
}

