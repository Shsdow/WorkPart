package com.mk.workdemo.Utils;

import android.text.TextUtils;
import android.util.Log;

import com.mk.workdemo.BuildConfig;

import java.util.Locale;
import java.util.Objects;

/**
 * Monkeyon 2016/11/11.
 */


public class LogUtils {
    private static boolean isDebug = BuildConfig.DEBUG;

    private static String generateTag() {
        String tag = "%s.%s(L:%d)";
        StackTraceElement caller = new Throwable().getStackTrace()[2];
//        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String className = caller.getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        tag = String.format(Locale.CHINA, tag, className, caller.getClassName(), caller.getLineNumber());
        String cusTag = "cus_log";
        return cusTag + ":" + tag;
    }

    public static void d(Objects contect) {
        if (!isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.d(tag, contect.toString());
    }

    public static void d(Objects contect, Throwable throwable) {
        if (isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.e(tag, contect.toString(), throwable);
    }

    public static void e(Objects contect) {
        if (!isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.d(tag, contect.toString());
    }

    public static void e(Objects contect, Throwable throwable) {
        if (isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.e(tag, contect.toString(), throwable);
    }

    public static void i(Objects contect) {
        if (!isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.d(tag, contect.toString());
    }

    public static void i(Objects contect, Throwable throwable) {
        if (isDebug || contect == null) {
            return;
        }
        String tag = generateTag();
        Log.e(tag, contect.toString(), throwable);
    }


}
