package com.mk.workdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mk.workdemo.Activities.SecondAcitivity;
import com.mk.workdemo.Activities.TitleActivity;
import com.mk.workdemo.ImageCompress.ImageCompressActivity;
import com.mk.workdemo.TESTActivities.DialogTestActivity;
import com.mk.workdemo.Utils.LogUtils;
import com.mk.workdemo.Utils.ShowDialog;

public class MainActivity extends TitleActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitleText("主页面");
//        setLeftAndIcon("后退", R.drawable.ic_action_add, false);
        setRightText("123");
        setRightFirstDrawable(R.drawable.ic_action_exit);
        LogUtils.d("我在MainActivity中");
        findViewById(R.id.tv_jump).setOnClickListener(this);
        findViewById(R.id.tv_text_showdialog).setOnClickListener(this);
        findViewById(R.id.tv_image_compress).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_jump:
                startActivity(new Intent(MainActivity.this, SecondAcitivity.class));
                break;
            case R.id.tv_text_showdialog:
                startActivity(new Intent(MainActivity.this, DialogTestActivity.class));
                break;
            case R.id.tv_image_compress:
                startActivity(new Intent(MainActivity.this, ImageCompressActivity.class));
                break;
        }

    }
}
