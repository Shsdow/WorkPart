package com.mk.workdemo.utils;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mk.workdemo.R;
import com.mk.workdemo.WorkApplition;

public class ShowToast {
    private static Toast toast;
    private static TextView tvText;

    public static void shortTime(Object text) {
        showToast(text, Toast.LENGTH_SHORT);
    }

    public static void longTime(Object text) {
        showToast(text, Toast.LENGTH_LONG);
    }

    private static void showToast(Object text, int duration) {

        if (TextUtils.isEmpty(text.toString())) {
            return;
        }
        if (toast == null) {
            View view = View.inflate(WorkApplition.getAppInstace(), R.layout.toast_layout, null);
            tvText = (TextView) view.findViewById(R.id.tv_toast);
            tvText.setText(String.valueOf(text));
            toast = Toast.makeText(WorkApplition.getAppInstace(), String.valueOf(text), duration);
            toast.setGravity(Gravity.BOTTOM, 0, DisplayUtil.dp2px(160));
            toast.setView(view);
        } else {
            tvText.setText(String.valueOf(text));
        }
        toast.show();
    }

    public static void showConnectError() {
        showToast("网络连接错误，请检查网络后重试", Toast.LENGTH_SHORT);
    }
}
