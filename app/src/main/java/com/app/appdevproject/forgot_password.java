package com.app.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class forgot_password extends AppCompatActivity {

    Button back_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        back_btn3 = (Button) findViewById(R.id.back_btn3);

        back_btn3.setOnClickListener(view -> {
            startActivity(new Intent(forgot_password.this, BottomNav.class));
        });
    }
}