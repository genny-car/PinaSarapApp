package com.app.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Edit_Profile extends AppCompatActivity {

    Button back_btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        back_btn1 = (Button) findViewById(R.id.back_btn1);

        back_btn1.setOnClickListener(view -> {
           startActivity(new Intent(Edit_Profile.this, BottomNav.class));
        });

    }

}