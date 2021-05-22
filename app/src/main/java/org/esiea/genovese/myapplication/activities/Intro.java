package org.esiea.genovese.myapplication.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.esiea.genovese.myapplication.R;

public class Intro extends AppCompatActivity {

    private static int INTRO_TIME_OUT = 2500; //Wait in ms
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Intro.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },INTRO_TIME_OUT);
    }
}
