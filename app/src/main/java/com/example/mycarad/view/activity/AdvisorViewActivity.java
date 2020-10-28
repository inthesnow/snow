package com.example.mycarad.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.data.AdvisorReadInfo;
import com.example.mycarad.databinding.ActivityViewAdvisorBinding;
import com.example.mycarad.databinding.ActivityViewDriverBinding;
import com.example.mycarad.server.ApiClient;
import com.example.mycarad.server.RetrofitInterface;
import com.example.mycarad.view.adapter.DriverRecyclerViewAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AdvisorViewActivity extends AppCompatActivity {

    private ActivityViewAdvisorBinding binding;
    private String writeId;
    private String userName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        userName = intent.getExtras().getString("test");
        writeId = intent.getExtras().getString("idx");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_advisor);

        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getAdvisorRead();
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

    @SuppressLint("CheckResult")
    private void getAdvisorRead() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getAdvisorRead(writeId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setUpView(response.getResponse().get(0));

                });

    }

    private void setUpView(AdvisorReadInfo info) {
        binding.viewAdvTitleEdit.setText(info.getTitle());
        binding.advUserName.setText(info.getUserName());
        binding.viewAdvNameEdit.setText(info.getUserName());
        binding.viewAdvAreaEdit.setText(info.getUserName());
        binding.viewAdvMoneyEdit.setText(info.getUserName());
        binding.viewAdvConnectEdit.setText(info.getUserName());
        binding.viewAdvViewEdit.setText(info.getUserName());

    }
}
