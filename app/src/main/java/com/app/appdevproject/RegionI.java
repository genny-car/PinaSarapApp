package com.app.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RegionI extends AppCompatActivity {
    ImageButton backbtn_reg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_i);

        backbtn_reg1 = (ImageButton) findViewById(R.id.backbtn_reg1);

        backbtn_reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegionI.this,Luzon.class));
            }
        });


    }
}