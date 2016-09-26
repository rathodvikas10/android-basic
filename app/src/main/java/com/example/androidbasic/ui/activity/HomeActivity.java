package com.example.androidbasic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by vikas on 26/9/16.
 */

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this,ActivityBasicActivity.class);
        startActivity(intent);
    }
}
