package com.example.mycarad.view.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivityViewDriverBinding;

public class DriverViewActivity extends AppCompatActivity {

    private ActivityViewDriverBinding binding;

    EditText titleEdit;
    EditText tuningEdit;
    EditText writeEdit;
    CheckBox tuningCheckBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_driver);

        setSupportActionBar(binding.includeAppBar.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleEdit = findViewById(R.id.viewDriverTitleEdit);
        tuningEdit = findViewById(R.id.viewDriverTuningEdit);
        writeEdit = findViewById(R.id.viewDriverviewEdit);
        tuningCheckBox = findViewById(R.id.writeDriverTuningCheck);
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
