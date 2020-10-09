package com.example.mycarad.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycarad.R;

public class DriverViewActivity extends AppCompatActivity {

    EditText titleEdit;
    EditText tuningEdit;
    EditText writeEdit;
    CheckBox tuningCheckBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_driver);

        titleEdit = findViewById(R.id.viewDriverTitleEdit);
        tuningEdit = findViewById(R.id.viewDriverTuningEdit);
        writeEdit = findViewById(R.id.viewDriverviewEdit);
        tuningCheckBox = findViewById(R.id.writeDriverTuningCheck);
    }
}
