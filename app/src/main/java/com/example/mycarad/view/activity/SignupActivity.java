package com.example.mycarad.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivitySignupBinding;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;

    private Spinner carKind;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        binding.carButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    binding.driverLayout.signUpLayout.setVisibility(View.VISIBLE);
                    binding.advisorLayout.signUpLayout.setVisibility(View.GONE);
                } else {
                    binding.driverLayout.signUpLayout.setVisibility(View.GONE);
                    binding.advisorLayout.signUpLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        arrayList = new ArrayList<>();
        arrayList.add("선택");
        arrayList.add("대형");
        arrayList.add("중형");
        arrayList.add("소형");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);

        carKind = binding.driverLayout.signCarKindSpinner;
        carKind.setAdapter(arrayAdapter);
        carKind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }
}
