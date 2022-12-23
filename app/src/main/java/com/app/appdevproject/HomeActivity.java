package com.app.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    LottieAnimationView lottieprof;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lottieprof = findViewById(R.id.lottieprof);

        lottieprof.setOnClickListener(view -> {
            lottieprof.playAnimation();

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    startActivity(new Intent(HomeActivity.this,ProfileActivity .class));
                }
            }, 2000);

        });
    }

}