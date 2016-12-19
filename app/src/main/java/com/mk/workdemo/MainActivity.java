package com.mk.workdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mk.workdemo.activities.RotateRectActivity;
import com.mk.workdemo.activities.SecondAcitivity;
import com.mk.workdemo.activities.TitleActivity;
import com.mk.workdemo.draw.colock.CanvasColockActivity;
import com.mk.workdemo.draw.colock.MatrixChangeAcitvity;
import com.mk.workdemo.drawable.DrawableActivity;
import com.mk.workdemo.imageCompress.ImageCompressActivity;
import com.mk.workdemo.surfaceview_camera.TakePhotoActivity;
import com.mk.workdemo.testActivities.DialogTestActivity;
import com.mk.workdemo.utils.LogUtil;

public class MainActivity extends TitleActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitleText("主页面");
//        setLeftAndIcon("后退", R.drawable.ic_action_add, false);
        setRightText("123");
        setRightFirstDrawable(R.drawable.ic_action_exit);
        LogUtil.d("我在MainActivity中");
        findViewById(R.id.tv_jump).setOnClickListener(this);
        findViewById(R.id.tv_text_showdialog).setOnClickListener(this);
        findViewById(R.id.tv_image_compress).setOnClickListener(this);
        findViewById(R.id.tv_capture_pic).setOnClickListener(this);
        findViewById(R.id.tv_colock).setOnClickListener(this);
        findViewById(R.id.tv_rotate_canvas).setOnClickListener(this);
        findViewById(R.id.tv_matrix_change).setOnClickListener(this);
        findViewById(R.id.tv_drawable).setOnClickListener(this);
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
            case R.id.tv_capture_pic:
                startActivity(new Intent(MainActivity.this, TakePhotoActivity.class));
                break;
            case R.id.tv_colock:
                startActivity(new Intent(MainActivity.this, CanvasColockActivity.class));
                break;
            case R.id.tv_rotate_canvas:
                startActivity(new Intent(MainActivity.this, RotateRectActivity.class));
                break;
            case R.id.tv_matrix_change:
                startActivity(new Intent(MainActivity.this, MatrixChangeAcitvity.class));
                break;
            case R.id.tv_drawable:

                startActivity(new Intent(MainActivity.this,DrawableActivity.class));
                break;
        }

    }
}
