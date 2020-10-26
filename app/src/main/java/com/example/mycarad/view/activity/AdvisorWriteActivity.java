package com.example.mycarad.view.activity;

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
import com.example.mycarad.databinding.ActivityWriteAdvisorBinding;

public class AdvisorWriteActivity extends AppCompatActivity {

    private ActivityWriteAdvisorBinding binding;

    Button writeClearBtn;
    EditText titleEdit;
    EditText areaEdit;
    EditText conectEdit;
    EditText writeEdit;
    EditText moneyEdit;
    CheckBox carKindCheckBox1;
    CheckBox carKindCheckBox2;
    CheckBox carKindCheckBox3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_advisor);

        writeClearBtn = findViewById(R.id.writeAdvClearButton);
        titleEdit = findViewById(R.id.writeAdvTitleEdit);
        areaEdit = findViewById(R.id.writeAdvAraeEdit);
        conectEdit = findViewById(R.id.writeAdvConectEdit);
        writeEdit = findViewById(R.id.writeAdvWriteEdit);
        carKindCheckBox1 = findViewById(R.id.writeAdvCarKindCheck);
        carKindCheckBox2 = findViewById(R.id.writeAdvCarKindCheck2);
        carKindCheckBox3 = findViewById(R.id.writeAdvCarKindCheck3);

        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        carKindCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkWriteClearBtnEnabled();
            }
        });

        carKindCheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkWriteClearBtnEnabled();
            }
        });

        carKindCheckBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkWriteClearBtnEnabled();
            }
        });

        titleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //   Log.e("title", "beforeTextChanged " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClearBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        areaEdit.addTextChangedListener(new TextWatcher() {
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
        conectEdit.addTextChangedListener(new TextWatcher() {
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
        writeEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //   Log.e("write", "beforeTextChanged " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClearBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        writeClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "작성완료", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), AdvisorViewActivity.class);
                getApplicationContext().startActivity(intent);
                finish();
            }
        });
    }

    // title, write 값이 있을 때 로그인 버튼 활성화 처리
    private void checkWriteClearBtnEnabled() {
        boolean isEnabled = !(titleEdit.getText().toString().isEmpty())
                && !(areaEdit.getText().toString().isEmpty())
                && !(conectEdit.getText().toString().isEmpty())
                && !(writeEdit.getText().toString().isEmpty())
                && ((carKindCheckBox1.isChecked()) || (carKindCheckBox2.isChecked()) || (carKindCheckBox3.isChecked()));
        writeClearBtn.setEnabled(isEnabled);
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


