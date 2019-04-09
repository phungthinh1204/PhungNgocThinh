package com.example.admin.docbaoonline.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.admin.docbaoonline.R;
import com.example.admin.docbaoonline.Utils;

/**
 * Created by Thinh Phung on 3/31/2018.
 */

public class SettingActivity extends AppCompatActivity {

    ToggleButton toggleNightMode;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.setting_activity);

        toggleNightMode = findViewById(R.id.toggleNightMode);
        toggleNightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(SettingActivity.this,"Changed!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
