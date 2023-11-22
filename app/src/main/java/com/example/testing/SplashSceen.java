package com.example.testing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashSceen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        int SPLASH_DISPLAY_LENGTH = 2000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashSceen.this,LoginActivity.class);
                SplashSceen.this.startActivity(mainIntent);
                SplashSceen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}