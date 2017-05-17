package com.example.odain.alertapp.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.odain.alertapp.R;

/**
 * Created by odain on 5/16/2017.
 */

public class AlertActivity extends AppCompatActivity {

    TextView mTextView, timerTextView;
    Button cancelButton, confirmButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AlertTheme);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.red));
            getWindow().setStatusBarColor(getResources().getColor(R.color.red_dark));
        }
        setContentView(R.layout.activity_alert);

        mTextView = (TextView) findViewById(R.id.warning_text_view);
        timerTextView = (TextView) findViewById(R.id.timer_text_view);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        confirmButton = (Button) findViewById(R.id.confirm_button);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent report = new Intent();
                report.setClass(v.getContext(), ReportActivity.class);
                startActivity(report);
            }
        });




        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTextView.setText(""+millisUntilFinished / 1000);
                mTextView.setText("Are You Sure?");
                mTextView.setGravity(View.TEXT_ALIGNMENT_CENTER);
            }

            public void onFinish() {
                mTextView.setText("Cancelled!");
                finish();
            }
        }.start();

    }

    @Override
    public void finish() {
        super.finish();
    }

    void setUpViews(){
    }

    void createViews(){

    }
}
