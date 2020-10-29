package com.example.mycarad.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.data.DriverUserInfo;
import com.example.mycarad.databinding.ActivityWriteDriverBinding;
import com.example.mycarad.server.ApiClient;
import com.example.mycarad.server.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DriverWriteActivity extends AppCompatActivity {

    private ActivityWriteDriverBinding binding;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        userName = intent.getExtras().getString("userName");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_driver);

        getDriverWriteResponse();
        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //타이틀 에딧
        binding.writeDriverTitleEdit.addTextChangedListener(new TextWatcher() {
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
        //튜닝여부체크
        binding.writeDriverTuningCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.writeDriverTuningEdit.setVisibility(View.VISIBLE);
                } else {
                    binding.writeDriverTuningEdit.setVisibility(View.GONE);
                }
            }
        });
        //튜닝 에딧
        binding.writeDriverTuningEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //커넥팅 제시
        binding.writeDriverConnect.addTextChangedListener(new TextWatcher() {
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
        //게시글 상세정보
        binding.writeDriverWriteEdit.addTextChangedListener(new TextWatcher() {
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
        //작성완료 버튼
        binding.writeDriverClearButton.setOnClickListener(view -> requestWriteDriver());
    }


    // title, write, connect 값이 있을 때 로그인 버튼 활성화 처리
    private void checkWriteClearBtnEnabled() {
        boolean isEnabled = !(binding.writeDriverTitleEdit.getText().toString().isEmpty())
                && !(binding.writeDriverWriteEdit.getText().toString().isEmpty())
                && !(binding.writeDriverConnect.getText().toString().isEmpty());
        binding.writeDriverClearButton.setEnabled(isEnabled);

    }

    //게시글 작성완료 체크
    @SuppressLint("CheckResult")
    private void requestWriteDriver() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);

        retrofitInterface.requestWriteDriver(binding.writeDriverTitleEdit.getText().toString(),
                userName,
                binding.writeDriverCarKindEdit.getText().toString(),
                binding.writeDriverCarNameEdit.getText().toString(),
                binding.writeDriverTuningEdit.getText().toString(),
                binding.writeDriverConnect.getText().toString(),
                binding.writeDriverWriteEdit.getText().toString())
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
    private void getDriverWriteResponse() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getDriverWriteResponse(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    setUpView(response.getResponse().get(0));
                });

    }

    private void setUpView(DriverUserInfo driverUserInfo) {
        binding.writeDriverCarKindEdit.setText(driverUserInfo.getCarKind());
        binding.writeDriverCarNameEdit.setText(driverUserInfo.getCarName());
    }

    //앱바
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}


