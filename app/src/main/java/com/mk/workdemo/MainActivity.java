package com.mk.workdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mk.workdemo.Activities.SecondAcitivity;
import com.mk.workdemo.Activities.TitleActivity;
import com.mk.workdemo.Utils.LogUtils;

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
        LogUtils.d("我在MainActivity中");

    }
}
