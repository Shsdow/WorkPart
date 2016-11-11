package com.mk.workdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitleText("主页面");
//        setLeftAndIcon("后退", R.drawable.ic_action_add, false);
        setRightText("123");
        setRightFirstDrawable(R.drawable.ic_action_exit);
        findViewById(R.id.tv_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondAcitivity.class));
            }
        });

    }
}
