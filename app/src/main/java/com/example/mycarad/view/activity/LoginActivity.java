package com.example.mycarad.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycarad.R;
import com.example.mycarad.data.Preference;
import com.example.mycarad.server.ApiClient;
import com.example.mycarad.server.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

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

        loginBtn.setOnClickListener(v -> {
            String id = idEditView.getText().toString();
            String pass = passEditView.getText().toString();
            loginRequest(id, pass);
        });
        signupBtn.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(intent);
        });

        idEditView.addTextChangedListener(new TextWatcher() {
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


    // ID,PW 값이 있을 때 로그인 버튼 활성화 처리
    private void checkLoginButtonEnabled() {
        boolean isEnabled = !(idEditView.getText().toString().isEmpty()) && !(passEditView.getText().toString().isEmpty());
        loginBtn.setEnabled(isEnabled);
    }

    @SuppressLint("CheckResult")
    private void loginRequest(String id, String password) {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.loginRequest(id, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    if (response.getSuccesss()) {
                        Intent intent = new Intent(this, HomeActivity.class);
                        Bundle extras = new Bundle();
                        String userName = response.getUserName();
                        String userType = response.getUserType();
                        extras.putString("userName", userName);
                        extras.putString("userType", userType);
                        intent.putExtras(extras);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "로그인에 실패 하였습니다.", Toast.LENGTH_SHORT).show();

                    }
                });
/*      Preference preference = new Preference();
        preference.setId(this, idEditView.getText().toString());
        preference.setPw(this, passEditView.getText().toString());


        // 스플래시에서 해야하는 일
        String id = preference.getId(this);
        String pw = preference.getPw(this);
        if(id.isEmpty() || pw.isEmpty()) {
             // 로그인 페이지로
        } else {
            // 로그인 api 호출
        }*/
    }
}


