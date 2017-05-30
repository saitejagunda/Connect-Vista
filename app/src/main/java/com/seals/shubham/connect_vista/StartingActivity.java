package com.seals.shubham.connect_vista;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartingActivity extends AppCompatActivity {

    Handler hnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        hnd = new Handler();
        hnd.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intenting to Login Page after 5 seconds.
                Intent intent = new Intent(StartingActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }
}
