package com.example.ontime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    public TextView register_tw;
    public TextView login_tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        register_tw = (TextView) findViewById(R.id.welcome_page_register_tw);
        login_tw = (TextView) findViewById(R.id.welcome_page_login_tw);
        register_tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        login_tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
