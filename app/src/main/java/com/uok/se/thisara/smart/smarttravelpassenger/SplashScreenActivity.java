package com.uok.se.thisara.smart.smarttravelpassenger;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uok.se.thisara.smart.smarttravelpassenger.ui.login.LoginFragment;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent userSelectionIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(userSelectionIntent);
                finish();
            }
        }, 3000);
    }
}