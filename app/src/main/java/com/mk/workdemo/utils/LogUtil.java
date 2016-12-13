package com.mk.workdemo.utils;

import android.util.Log;

import com.mk.workdemo.BuildConfig;

import java.util.Locale;

/**
 * Monkeyon 2016/11/11.
 */


public class LogUtil {
    private static boolean isDebug = BuildConfig.DEBUG;

    private static String generateTag() {
        String tag = "%s-%s(Line:%d)";
        //StackTraceElement 堆栈帧 对象
//        StackTraceElement caller = new Throwable().getStackTrace()[2];
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String className = caller.getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        tag = String.format(Locale.CHINA, tag, className, caller.getClassName(), caller.getLineNumber());
        String cusTag = "cus_log";
        return cusTag + ":" + tag;
    }

    public static void d(Object contect) {
        if (!isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.d(tag, contect.toString());
    }

    public static void d(Object contect, Throwable throwable) {
        if (isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.e(tag, contect.toString(), throwable);
    }

    public static void e(Object contect) {
        if (!isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.d(tag, contect.toString());
    }

    public static void e(Object contect, Throwable throwable) {
        if (isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.e(tag, contect.toString(), throwable);
    }

    public static void i(Object contect) {
        if (!isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.d(tag, contect.toString());
    }

    public static void i(Object contect, Throwable throwable) {
        if (isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.e(tag, contect.toString(), throwable);
    }


}
