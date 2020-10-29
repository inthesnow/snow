package com.example.mycarad.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.data.AdvisorUserInfo;
import com.example.mycarad.data.DriverUserInfo;
import com.example.mycarad.data.UserType;
import com.example.mycarad.databinding.ActivityMyBinding;
import com.example.mycarad.server.ApiClient;
import com.example.mycarad.server.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyActivity extends AppCompatActivity {

    private ActivityMyBinding binding;
    private UserType userType;
/*    private String userName;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my);
/*        Intent intent = getIntent();
        userName = intent.getExtras().getString("testAdvisor");*/
        userType = userType.ADVISOR;

        if (userType == UserType.DRIVER) {
            getDriverInfoResponse();
            binding.includeDriverMyInfo.myInfoDriver.setVisibility(View.VISIBLE);
            binding.includeAdvMyInfo.myInfoAdvisor.setVisibility(View.GONE);
        } else {
            getAdvisorInfoResponse();
            binding.includeDriverMyInfo.myInfoDriver.setVisibility(View.GONE);
            binding.includeAdvMyInfo.myInfoAdvisor.setVisibility(View.VISIBLE);
        }

        //툴바
        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.myInfoChangeButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MyInfoChangeActivity.class);
            startActivity(intent1);
        });
        binding.myWriteMoreButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MyWriteViewActivity.class);
            startActivity(intent1);
        });
        binding.myAppInfoButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, MyAppInfoActivity.class);
            startActivity(intent1);
        });
        binding.myLogOutButton.setOnClickListener(v -> {
            Intent intent1 = new Intent(this, LoginActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent1);
        });

    }
    @SuppressLint("CheckResult")
    private void getDriverInfoResponse() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getDriverInfoResponse("test")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setUpViewDriver(response.getResponse().get(0));
                });
    }

    private void setUpViewDriver(DriverUserInfo driverUserInfo) {
        binding.includeDriverMyInfo.myInfoDriverNameTextView.setText(driverUserInfo.getCarName());
        binding.includeDriverMyInfo.myInfoDriverCarKind.setText(driverUserInfo.getCarKind());
        binding.includeDriverMyInfo.myInfoDriverCarName.setText(driverUserInfo.getCarName());
    }
    @SuppressLint("CheckResult")
    private void getAdvisorInfoResponse() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getAdvisorInfoResponse("testAdvisor")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setUpViewAdv(response.getResponse().get(0));
                });
    }

    private void setUpViewAdv(AdvisorUserInfo advisorUserInfo) {
        binding.includeAdvMyInfo.myInfoAdUserNameTextView.setText(advisorUserInfo.getUserName());
        binding.includeAdvMyInfo.myInfoAdAdvNameTextView.setText(advisorUserInfo.getAdvName());
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
