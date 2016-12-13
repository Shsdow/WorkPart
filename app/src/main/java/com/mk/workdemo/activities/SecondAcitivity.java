package com.mk.workdemo.activities;

import android.os.Bundle;

import com.mk.workdemo.R;

public class SecondAcitivity extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivity);
        setTitleText("我是SecondActivity");
    }
}
