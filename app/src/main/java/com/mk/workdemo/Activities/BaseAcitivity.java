package com.mk.workdemo.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 所有Activity的基类
 */

public class BaseAcitivity extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;

    protected boolean isVisible;//是否和用户交互
    protected boolean isDestory;//activity是否destory标志位

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mContext = this;
        mActivity = this;
        isDestory = false;
        AtyManager.INSTANCE().addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestory = true;
        AtyManager.INSTANCE().removeActivity(this);
    }
}
