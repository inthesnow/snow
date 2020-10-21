package com.example.mycarad.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivitySignupBinding;
import com.example.mycarad.server.ApiClient;
import com.example.mycarad.server.RetrofitInterface;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    private Spinner carKind;
    private boolean validate = false;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    private boolean isDriverIdInvalidate = false;
    private boolean isDriverNameInvalidate = false;
    private boolean isAdvisorIdInvalidate = false;
    private boolean isAdvisorNameInvalidate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        //툴바
        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //차주, 광고주 선택
        binding.carButton.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                binding.driverLayout.signUpLayout.setVisibility(View.VISIBLE);
                binding.advisorLayout.signUpLayout.setVisibility(View.GONE);
            } else {
                binding.driverLayout.signUpLayout.setVisibility(View.GONE);
                binding.advisorLayout.signUpLayout.setVisibility(View.VISIBLE);
            }
        });

        //차주 아이디 입력 확인
        binding.driverLayout.signDriverIdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkDriverIdCheckBtnEnabled();
                checkDriverSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //차주 아이디 중복확인 버튼
        binding.driverLayout.signDriverIdCheck.setOnClickListener(v -> {
            String userID = binding.driverLayout.signDriverIdEditText.getText().toString();
            checkDriverValidate(userID);
        });


        binding.driverLayout.signDriverPwEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkDriverSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //차주 패스워드 재입력 확인
        binding.driverLayout.signDriverPwCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkDriverSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //차주 닉네임 입력확인
        binding.driverLayout.signDriverNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkDriverNameCheckBtnEnabled();
                checkDriverSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //차주 닉네임 중복확인버튼
        binding.driverLayout.signDriverNameCheck.setOnClickListener(v -> {
                String userName = binding.driverLayout.signDriverNameEditText.getText().toString();
                 checkDriverNameValidate(userName);
        });
        //스피너 버튼
        arrayList = new ArrayList<>();
        arrayList.add("선택");
        arrayList.add("대형");
        arrayList.add("중형");
        arrayList.add("소형");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.item_spinner,
                arrayList);

        carKind = binding.driverLayout.signCarKindSpinner;
        carKind.setAdapter(arrayAdapter);
        carKind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
                checkDriverSignUpButtonEnabled();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);
            }
        });
        //차종 입력 확인
        binding.driverLayout.signDriverCarNameEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkDriverSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        binding.driverLayout.signTuningCheck.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.driverLayout.signDriverBusinessEditText.setVisibility(View.VISIBLE);
            } else {
                binding.driverLayout.signDriverBusinessEditText.setVisibility(View.GONE);
            }
        });
        //차주 회원가입버튼
        binding.driverLayout.signDriverClearBtn.setOnClickListener(v -> {
            requestSignUpDriver();
        });

        //광고주 아이디 입력 확인
        binding.advisorLayout.signAdIdEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkAdIdCheckBtnEnabled();
                checkAdSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //광고주 아이디 중복확인 버튼
        binding.advisorLayout.signAdIdCheck.setOnClickListener (v -> {
            String userID = binding.advisorLayout.signAdIdEditText.getText().toString();
            checkAdvisorValidate(userID);
        });
        //광고주 패스워드 입력 확인
        binding.advisorLayout.signAdPwEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkAdSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //광고주 패스워드 재입력 확인
        binding.advisorLayout.signAdPwCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkAdSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //광고주 닉네임 입력확인
        binding.advisorLayout.signAdNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkAdNameCheckBtnEnabled();
                checkAdSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //광고주 닉네임 중복확인버튼
        binding.advisorLayout.signAdNameCheck.setOnClickListener(v -> {
            String userID = binding.advisorLayout.signAdNameEditText.getText().toString();
            checkAdvisorNameValidate(userID);
        });
        //광고주 업종 입력확인
        binding.advisorLayout.signAdKindEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkAdSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //광고주 업체명 입력확인
        binding.advisorLayout.signAdBusinessEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkAdSignUpButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //광고주 회원가입버튼
        binding.advisorLayout.signAdClearBtn.setOnClickListener(v -> {
            requestSignUpAdvisor();
        });
    }

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

    //차주 아이디 중복확인 버튼 활성화 비활성화
    private void checkDriverIdCheckBtnEnabled() {
        boolean isEnabled = !(binding.driverLayout.signDriverIdEditText.getText().toString().isEmpty());
        binding.driverLayout.signDriverIdCheck.setEnabled(isEnabled);

    }

    //차주 닉네임 중복확인 버튼 활성화 비활성화
    private void checkDriverNameCheckBtnEnabled() {
        boolean isEnabled = !(binding.driverLayout.signDriverNameEditText.getText().toString().isEmpty());
        binding.driverLayout.signDriverNameCheck.setEnabled(isEnabled);

    }

    //차주 회원가입버튼 버튼 활성화 처리
    private void checkDriverSignUpButtonEnabled() {
        boolean isEnabled = !(binding.driverLayout.signDriverIdEditText.getText().toString().isEmpty())//아이디
                && !(binding.driverLayout.signDriverPwEditText.getText().toString().isEmpty())//차주 패스워드
                && !(binding.driverLayout.signDriverPwCheck.getText().toString().isEmpty())//차주 패스워드 재확인
                && !(binding.driverLayout.signDriverNameEditText.getText().toString().isEmpty())//닉네임
                && !(binding.driverLayout.signDriverCarNameEditView.getText().toString().isEmpty())
                && binding.driverLayout.signCarKindSpinner.getSelectedItemPosition() != 0//차명
                && isDriverIdInvalidate
                && isDriverNameInvalidate;//차주 아이디 중복확인
        binding.driverLayout.signDriverClearBtn.setEnabled(isEnabled);
    }

    //광고주 아이디 중복확인 버튼 활성화 비활성화
    private void checkAdIdCheckBtnEnabled() {
        boolean isEnabled = !(binding.advisorLayout.signAdIdEditText.getText().toString().isEmpty());
        binding.advisorLayout.signAdIdCheck.setEnabled(isEnabled);

    }

    //광고주 닉네임 중복확인 버튼 활성화 비활성화
    private void checkAdNameCheckBtnEnabled() {
        boolean isEnabled = !(binding.advisorLayout.signAdNameEditText.getText().toString().isEmpty());
        binding.advisorLayout.signAdNameCheck.setEnabled(isEnabled);

    }

    //광고주 회원가입버튼 버튼 활성화 처리
    private void checkAdSignUpButtonEnabled() {
        boolean isEnabled = !(binding.advisorLayout.signAdIdEditText.getText().toString().isEmpty())//광고주 아이디
                && !(binding.advisorLayout.signAdPwEditText.getText().toString().isEmpty())//광고주 패스워드
                && !(binding.advisorLayout.signAdPwCheck.getText().toString().isEmpty())//광고주 패스워드 재확인
                && !(binding.advisorLayout.signAdNameEditText.getText().toString().isEmpty())//광고주 닉네임
                && !(binding.advisorLayout.signAdKindEditText.getText().toString().isEmpty())//광고주 업종
                && !(binding.advisorLayout.signAdBusinessEditText.getText().toString().isEmpty())
                && isAdvisorIdInvalidate
                && isAdvisorNameInvalidate;//광고주 업체명
        binding.advisorLayout.signAdClearBtn.setEnabled(isEnabled);
    }
    //차주 아이디 중복체크
    @SuppressLint("CheckResult")
    private void checkDriverValidate(String id) {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.checkDriverValidate(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.getSuccesss()) {
                                Toast.makeText(this, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "사용 불가능한 아이디입니다.", Toast.LENGTH_SHORT).show();

                            }
                            isDriverIdInvalidate = response.getSuccesss();
                            checkDriverSignUpButtonEnabled();
                        }
                );
    }
    //차주 닉네임 중복체크
    @SuppressLint("CheckResult")
    private void checkDriverNameValidate(String id) {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.checkDriverNameValidate(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.getSuccesss()) {
                                Toast.makeText(this, "사용 가능한 닉네임입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "사용 불가능한 닉네임입니다.", Toast.LENGTH_SHORT).show();

                            }
                            isDriverNameInvalidate = response.getSuccesss();
                            checkDriverSignUpButtonEnabled();
                        }
                );
    }

    //차주 회원가입체크
    @SuppressLint("CheckResult")
    private void requestSignUpDriver() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);

        String carKind = arrayList.get(binding.driverLayout.signCarKindSpinner.getSelectedItemPosition());
        Log.e("ayhan", "carKind : " + carKind);

        retrofitInterface.requestSignUpDriver(binding.driverLayout.signDriverIdEditText.getText().toString(),
                binding.driverLayout.signDriverPwEditText.getText().toString(),
                binding.driverLayout.signDriverNameEditText.getText().toString(),
                carKind,
                binding.driverLayout.signDriverCarNameEditView.getText().toString(),
                binding.driverLayout.signDriverBusinessEditText.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.getSuccesss()) {
                                Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();

                            }
                        }
                );

    }

    //광고주 아이디 중복체크
    @SuppressLint("CheckResult")
    private void checkAdvisorValidate(String id) {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.checkAdvisorValidate(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.getSuccesss()) {
                                Toast.makeText(this, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "사용 불가능한 아이디입니다.", Toast.LENGTH_SHORT).show();

                            }
                            isAdvisorIdInvalidate = response.getSuccesss();
                            checkAdIdCheckBtnEnabled();
                        }
                );
    }

    //광고주 닉네임 중복체크
    @SuppressLint("CheckResult")
    private void checkAdvisorNameValidate(String id) {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.checkAdvisorNameValidate(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.getSuccesss()) {
                                Toast.makeText(this, "사용 가능한 닉네임입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(this, "사용 불가능한 닉네임입니다.", Toast.LENGTH_SHORT).show();

                            }
                            isAdvisorNameInvalidate = response.getSuccesss();
                            checkAdNameCheckBtnEnabled();
                        }
                );
    }

    //광고주 회원가입체크
    @SuppressLint("CheckResult")
    private void requestSignUpAdvisor() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);

        String carKind = arrayList.get(binding.driverLayout.signCarKindSpinner.getSelectedItemPosition());
        Log.e("ayhan", "carKind : " + carKind);

        retrofitInterface.requestSignUpAdvisor(binding.advisorLayout.signAdIdEditText.getText().toString(),
                binding.advisorLayout.signAdPwEditText.getText().toString(),
                binding.advisorLayout.signAdNameEditText.getText().toString(),
                binding.advisorLayout.signAdKindEditText.getText().toString(),
                binding.advisorLayout.signAdBusinessEditText.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.getSuccesss()) {
                                Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();

                            }
                        }
                );

    }
}


