package com.app.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView loadingtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progressBar);
        loadingtxt = findViewById(R.id.loadingtxt);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();
    }
    public void progressAnimation(){
        LoadingScreenAnimation anim = new LoadingScreenAnimation(this, progressBar, loadingtxt, 0f, 100f);
        anim.setDuration(5000);
        progressBar.setAnimation(anim);
    }
}

