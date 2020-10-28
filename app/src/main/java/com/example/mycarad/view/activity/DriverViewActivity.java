package com.example.mycarad.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.data.AdvisorReadInfo;
import com.example.mycarad.data.DriverReadInfo;
import com.example.mycarad.databinding.ActivityViewDriverBinding;
import com.example.mycarad.server.ApiClient;
import com.example.mycarad.server.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DriverViewActivity extends AppCompatActivity {

    private ActivityViewDriverBinding binding;
    private String writeId;
    private String userName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        userName = intent.getExtras().getString("test");
        writeId = intent.getExtras().getString("idx");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_driver);
        getDriverRead();

        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    private void getDriverRead() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getDriverRead(writeId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setUpView(response.getResponse().get(0));
                });

    }

    private void setUpView(DriverReadInfo info) {
        binding.viewDriverTitleEdit.setText(info.getTitle());
        binding.driverUserName.setText(info.getUserName());
        binding.viewDriverCarKindEdit.setText(info.getCarKind());
        binding.viewDriverCarNameEdit.setText(info.getCarName());
        binding.viewDriverTuningEdit.setText(info.getTuneContent());
        binding.viewDriverConnect.setText(info.getConnect());
        binding.viewDriverViewEdit.setText(info.getDetail());
        if (userName == info.getUserName()) {
            binding.viewDriverChangeButton.setVisibility(View.VISIBLE);
        } else {
            binding.viewDriverChangeButton.setVisibility(View.GONE);
        }
    }
}
