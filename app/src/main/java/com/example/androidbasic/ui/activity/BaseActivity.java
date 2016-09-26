package com.example.androidbasic.ui.activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by vikas on 26/9/16.
 */

public class BaseActivity extends AppCompatActivity {

    private String LOG_TAG;

    public void setLogTag(String tag) {
        LOG_TAG = tag;
    }

    public void printLog(String string) {
        Log.d(LOG_TAG,string);
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Dialog came up the screen");
        builder.setPositiveButton("Close",null);
        builder.show();
    }
}
