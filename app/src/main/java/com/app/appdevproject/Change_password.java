package com.app.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Change_password extends AppCompatActivity {

    Button back_btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        back_btn2 = (Button) findViewById(R.id.back_btn2);

        back_btn2.setOnClickListener(view -> {
            startActivity(new Intent(Change_password.this, BottomNav.class));
        });
    }
}