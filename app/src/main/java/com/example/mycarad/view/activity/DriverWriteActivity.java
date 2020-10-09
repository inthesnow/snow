package com.example.mycarad.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;
import androidx.databinding.DataBindingUtil;

import com.example.mycarad.R;
import com.example.mycarad.databinding.ActivitySignupBinding;
import com.example.mycarad.databinding.ActivityWriteDriverBinding;

public class DriverWriteActivity extends AppCompatActivity {

    private ActivityWriteDriverBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_write_driver);

        binding.writeDriverClearButton.setOnClickListener(new CompoundButton.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
