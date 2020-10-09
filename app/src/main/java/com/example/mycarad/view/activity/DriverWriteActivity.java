package com.example.mycarad.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycarad.R;

public class DriverWriteActivity extends AppCompatActivity {

    Button writeClearBtn;
    EditText titleEdit;
    EditText tuningEdit;
    EditText writeEdit;
    CheckBox tuningCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_driver);

        writeClearBtn = findViewById(R.id.writeDriverClearButton);
        titleEdit = findViewById(R.id.writeDriverTitleEdit);
        tuningEdit = findViewById(R.id.writeDriverTuningEdit);
        writeEdit = findViewById(R.id.writeDriverWriteEdit);
        tuningCheckBox = findViewById(R.id.writeDriverTuningCheck);
        tuningCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tuningEdit.setVisibility(View.VISIBLE);
                } else {
                    tuningEdit.setVisibility(View.GONE);
                }
            }
        });

        writeClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "작성완료", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), DriverViewActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });

        titleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //   Log.e("title", "beforeTextChanged " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClewrBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tuningEdit.addTextChangedListener(new TextWatcher() {
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
        writeEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //   Log.e("write", "beforeTextChanged " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkWriteClewrBtnEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    // title, write 값이 있을 때 로그인 버튼 활성화 처리
    private void checkWriteClewrBtnEnabled() {
        boolean isEnabled = !(titleEdit.getText().toString().isEmpty()) && !(writeEdit.getText().toString().isEmpty());
        writeClearBtn.setEnabled(isEnabled);

    }
}


