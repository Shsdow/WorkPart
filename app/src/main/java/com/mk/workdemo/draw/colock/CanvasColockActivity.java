package com.mk.workdemo.draw.colock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mk.workdemo.R;

public class CanvasColockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Clock(this));
    }
}
