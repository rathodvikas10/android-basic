package com.example.androidbasic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.androidbasic.R;

/**
 * Created by vikas on 26/9/16.
 */

public class ActivityBasicActivity extends BaseActivity {

    private String LOG_TAG = "ACTIVITY_BASIC";
    private Button showActivity;
    private Button showDialog;
    private Button showExternalDialog;
    private Button finishActivity;
    private Button onDestroy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_basic);
        this.showDialog = (Button) findViewById(R.id.show_dialog);
        this.showActivity = (Button) findViewById(R.id.show_activity);
        this.showExternalDialog = (Button) findViewById(R.id.show_external_dialog);
        this.finishActivity = (Button) findViewById(R.id.finish);
        this.onDestroy = (Button) findViewById(R.id.on_destroy);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        showActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityBasicActivity.this,OpenActivity.class);
                startActivity(intent);
            }
        });

        showExternalDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        finishActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        onDestroy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityBasicActivity.this,OnDestroyActivity.class);
                startActivity(intent);
            }
        });

        setLogTag(LOG_TAG);
        printLog("onCreate");

        HomeWatcher mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                printLog("onHomePressed");
            }
            @Override
            public void onHomeLongPressed() {
                printLog("onHomeLongPressed");
            }
        });
        mHomeWatcher.startWatch();
    }

    @Override
    protected void onStart() {
        super.onStart();
        printLog("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        printLog("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        printLog("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        printLog("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        printLog("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        printLog("onRestart");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        printLog("onBackPressed");
    }

}
