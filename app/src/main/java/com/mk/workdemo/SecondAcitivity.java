package com.mk.workdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondAcitivity extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivity);
        setTitleText("我是SecondActivity");
    }
}
