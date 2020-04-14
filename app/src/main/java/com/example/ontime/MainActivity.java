package com.example.ontime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    public boolean loggedIn = false;
    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(loggedIn == true){
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent i = new Intent(MainActivity.this, RestoranActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
            },SPLASH_TIME_OUT);

        }
        else{
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }
            },SPLASH_TIME_OUT);
        }
    }
}
