package com.mk.workdemo;

import android.app.Application;
import android.util.DisplayMetrics;

/**
 * Created by monkey on 16-12-12.
 */

public class WorkApplition extends Application {

    public static int screenWidth;
    public static int screenHeight;
    public static float screenDensity;
    public static float scaledDensity;
    public static WorkApplition applition;

    public static WorkApplition getAppInstace() {
        return applition;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        applition = this;
        getDisplayMetrics();
    }

    private void getDisplayMetrics() {
        DisplayMetrics metric = getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = metric.widthPixels;
        screenHeight = metric.heightPixels;
        screenDensity = metric.density;
        scaledDensity = metric.scaledDensity;
    }

}
