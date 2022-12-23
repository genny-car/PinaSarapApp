package com.app.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    ImageButton profimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profimage = (ImageButton) findViewById(R.id.profimage);

        profimage.setOnClickListener(view -> {
            startActivity(new Intent(HomeActivity.this,ProfileActivity .class));
        });
    }
}