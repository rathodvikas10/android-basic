package com.example.androidbasic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.androidbasic.R;

/**
 * Created by vikas on 26/9/16.
 */

public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        launchApplication();
    }

    private void launchApplication() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
