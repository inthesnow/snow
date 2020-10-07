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
                if(b) {
                    binding.carUserLayout.signUpLayout.setVisibility(View.VISIBLE);
                    binding.advisorLayout.signUpLayout.setVisibility(View.GONE);
                } else {
                    binding.carUserLayout.signUpLayout.setVisibility(View.GONE);
                    binding.advisorLayout.signUpLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        arrayList = new ArrayList<>();
        arrayList.add("대형");
        arrayList.add("중형");
        arrayList.add("소형");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayList);

        carKind = binding.carUserLayout.signCarKindSpinner;
        carKind.setAdapter(arrayAdapter);
        carKind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),arrayList.get(i)+"가 선택되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }


  /*  @Override
    public void onClick(View v){
        if (v == caruesrBtn) {
            setContentView(R.layout.activity_signup_caruser);
        } else if (v == advisorBtn) {
            setContentView(R.layout.activity_signup_advisor);
        }
    }*/
}

