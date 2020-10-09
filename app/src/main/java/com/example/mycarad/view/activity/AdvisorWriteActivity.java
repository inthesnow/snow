package com.example.mycarad.view.activity;

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

public class AdvisorWriteActivity extends AppCompatActivity {

    Button writeClearBtn;
    EditText titleEdit;
    EditText favorEdit;
    EditText conectEdit;
    EditText writeEdit;
    CheckBox carKindCheckBox1;
    CheckBox carKindCheckBox2;
    CheckBox carKindCheckBox3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_advisor);

        writeClearBtn = findViewById(R.id.writeAdvClearButton);
        titleEdit = findViewById(R.id.writeAdvTitleEdit);
        favorEdit = findViewById(R.id.writeAdvFavorPartEdit);
        conectEdit = findViewById(R.id.writeAdvConectEdit);
        writeEdit = findViewById(R.id.writeAdvWriteEdit);
        carKindCheckBox1 = findViewById(R.id.writeAdvCarKindCheck);
        carKindCheckBox2 = findViewById(R.id.writeAdvCarKindCheck2);
        carKindCheckBox3 = findViewById(R.id.writeAdvCarKindCheck3);

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

        favorEdit.addTextChangedListener(new TextWatcher() {
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
            }
        });
    }

    // title, write 값이 있을 때 로그인 버튼 활성화 처리
    private void checkWriteClearBtnEnabled() {
        boolean isEnabled = !(titleEdit.getText().toString().isEmpty())
                && !(favorEdit.getText().toString().isEmpty())
                && !(conectEdit.getText().toString().isEmpty())
                && !(writeEdit.getText().toString().isEmpty())
                && ((carKindCheckBox1.isChecked()) || (carKindCheckBox2.isChecked()) || (carKindCheckBox3.isChecked()));
        writeClearBtn.setEnabled(isEnabled);

    }
}


