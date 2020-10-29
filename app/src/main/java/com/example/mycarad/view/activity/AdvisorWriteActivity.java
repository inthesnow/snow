package com.example.mycarad.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.data.AdvisorUserInfo;
import com.example.mycarad.data.DriverUserInfo;
import com.example.mycarad.databinding.ActivityWriteAdvisorBinding;
import com.example.mycarad.server.ApiClient;
import com.example.mycarad.server.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AdvisorWriteActivity extends AppCompatActivity {

    private ActivityWriteAdvisorBinding binding;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        userName = intent.getExtras().getString("userName");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_advisor);

        getAdvisorWriteResponse();

        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.writeAdvCarKindCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkWriteClearBtnEnabled();
            }
        });

        binding.writeAdvTitleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClearBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.writeAdvNameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClearBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.writeAdvCarKindCheck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkWriteClearBtnEnabled();
            }
        });

        binding.writeAdvCarKindCheck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkWriteClearBtnEnabled();
            }
        });

        binding.writeAdvAraeEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClearBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        binding.writeAdvConectEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClearBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        binding.writeAdvWriteEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClearBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.writeAdvClearButton.setOnClickListener(view -> requestWriteAdvisor());

    }

    // title, write 값이 있을 때 로그인 버튼 활성화 처리
    private void checkWriteClearBtnEnabled() {
        boolean isEnabled = !(binding.writeAdvTitleEdit.getText().toString().isEmpty())
                && !(binding.writeAdvNameEdit.getText().toString().isEmpty())
                && !(binding.writeAdvAraeEdit.getText().toString().isEmpty())
                && !(binding.writeAdvConectEdit.getText().toString().isEmpty())
                && !(binding.writeAdvWriteEdit.getText().toString().isEmpty())
                && ((binding.writeAdvCarKindCheck.isChecked())
                || (binding.writeAdvCarKindCheck2.isChecked())
                || (binding.writeAdvCarKindCheck3.isChecked()));
        binding.writeAdvClearButton.setEnabled(isEnabled);
    }

    //게시글 작성완료 체크
    @SuppressLint("CheckResult")
    private void requestWriteAdvisor() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);

        retrofitInterface.requestWriteAdvisor(binding.writeAdvTitleEdit.getText().toString(),
                userName,
                binding.writeAdvNameEdit.getText().toString(),
                binding.writeAdvAraeEdit.getText().toString(),
                binding.writeAdvCarKindCheck.getText().toString(),
                binding.writeAdvConectEdit.getText().toString(),
                binding.writeAdvWriteEdit.getText().toString(),
                binding.writeAdvMoneyEdit.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.getSuccesss()) {
                                Toast.makeText(this, "작성이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(this, "작성에 실패하였습니다.", Toast.LENGTH_SHORT).show();

                            }
                        }
                );

    }

    @SuppressLint("CheckResult")
    private void getAdvisorWriteResponse() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getAdvisorWriteResponse(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setUpView(response.getResponse().get(0));
                });
    }

    private void setUpView(AdvisorUserInfo advisorInfo) {
        binding.writeAdvNameEdit.setText(advisorInfo.getAdvName());
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


