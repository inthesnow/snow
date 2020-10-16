package com.example.mycarad.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivitySignupBinding;
import com.example.mycarad.server.ValidateRequest;

import org.json.JSONObject;

import java.util.ArrayList;

import static android.os.Build.ID;
import static javax.net.ssl.SSLEngineResult.Status.OK;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    private Spinner carKind;
    private boolean validate = false;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

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
        binding.driverLayout.signDriverIdCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = binding.driverLayout.signDriverIdEditText.getText().toString();
                if(validate){
                    return;//검증 완료
                }
                //검증시작
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override

                    public void onResponse(String response) {

                        try{
                            Toast.makeText(SignupActivity.this, response, Toast.LENGTH_LONG).show();
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){//사용할 수 있는 아이디라면
                                Toast.makeText(SignupActivity.this, "사용 가능한 아이디 입니다.", Toast.LENGTH_SHORT).show();
                                validate = true;//검증완료

                            }else{//사용할 수 없는 아이디라면
                                Toast.makeText(getApplicationContext(), "사용할 수 없는 아이디입니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }

                };//Response.Listener 완료

                //Volley 라이브러리를 이용해서 실제 서버와 통신을 구현하는 부분

                ValidateRequest validateRequest = new ValidateRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                queue.add(validateRequest);
            }
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
        binding.driverLayout.signDriverNameCheck.setOnClickListener(
                v -> Toast.makeText(this,
                        "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show());
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
            Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
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
        binding.advisorLayout.signAdIdCheck.setOnClickListener(
                v -> Toast.makeText(this,
                        "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show());
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
        binding.advisorLayout.signAdNameCheck.setOnClickListener(
                v -> Toast.makeText(this,
                        "사용가능한 아이디입니다.", Toast.LENGTH_SHORT).show());
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
            Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
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
                && binding.driverLayout.signCarKindSpinner.getSelectedItemPosition() != 0;//차명
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
                && !(binding.advisorLayout.signAdBusinessEditText.getText().toString().isEmpty());//광고주 업체명
        binding.advisorLayout.signAdClearBtn.setEnabled(isEnabled);
    }
}
