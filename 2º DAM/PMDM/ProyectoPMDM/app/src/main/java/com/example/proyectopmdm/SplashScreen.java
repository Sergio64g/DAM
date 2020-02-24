package com.example.proyectopmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        instancias();
        animacion();



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        }, 3050);
    }



    private void instancias() {
        progressBar = this.findViewById(R.id.progressBar);
    }

    private void animacion() {
        ObjectAnimator.ofInt(progressBar, "progress", 0, 100)
                .setDuration(3000)
                .start();
    }
}
