package com.training.android.threadquiz;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    final Handler handler = new Handler();
    int time = 10; //second
    Switch mSwhStart;
    TextView mScore, mColor, mColorname;
    Button mTrue, mFalse;
    Runnable r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwhStart = (Switch) findViewById(R.id.swhStart);
        mScore = (TextView) findViewById(R.id.tvScore);
        mColor = (TextView) findViewById(R.id.tvColor);
        mColorname = (TextView) findViewById(R.id.tvColorName);
        mTrue = (Button) findViewById(R.id.btnTrue);
        mFalse = (Button) findViewById(R.id.btnFalse);
        mColor.setText("10");
        mSwhStart.setOnCheckedChangeListener(this);

        r = new Runnable() {
            public void run() {
                time--;
                mColor.setText(time + "");
            }
        };
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {

            handler.postDelayed(r, 1000);


            changecolor();

        } else {

        }
    }

    public void changecolor() {

        Random rand = new Random();
        Random randColor = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;
        int randColorText = randColor.nextInt((3 - 1) + 1) + 1;

        if (randomNum == 1) {
            mColor.setBackgroundColor(Color.RED);
        } else if (randomNum == 2) {
            mColor.setBackgroundColor(Color.GREEN);
        } else {
            mColor.setBackgroundColor(Color.YELLOW);
        }

        if (randColorText == 1) {
            mColorname.setText("Yellow");
        } else if (randColorText == 2) {
            mColorname.setText("Red");
        } else {
            mColorname.setText("Green");
        }
    }
}