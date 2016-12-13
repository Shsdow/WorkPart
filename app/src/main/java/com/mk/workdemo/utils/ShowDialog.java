package com.mk.workdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mk.workdemo.R;

/**
 * MK on 2016/11/11.
 */

public class ShowDialog {
    public static void showConfiromDialog(Context context, String title, String message,
                                          final View.OnClickListener listener){
        final AlertDialog dialog = new AlertDialog.Builder(context, R.style.dialogStyle)
                .setCancelable(false).create();
        if(((Activity)context).isFinishing()){
            return;
        }
        dialog.show();
        dialog.setContentView(R.layout.dialog_confirom);
        TextView mTitle = (TextView) dialog.getWindow().findViewById(R.id.tv_dialog_confirom_title);
        TextView mContent = (TextView) dialog.getWindow().findViewById(R.id.tv_dialog_confirom_content);
        TextView mOk = (TextView) dialog.getWindow().findViewById(R.id.tv_dialog_confirom_ok);
        mTitle.setText(title);
        mContent.setText(message);
        dialog.getWindow().findViewById(R.id.tv_dialog_confirom_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onClick(view);
                }
                dialog.dismiss();
            }
        });
        dialog.getWindow().findViewById(R.id.tv_dialog_confirom_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
    public static void showSelectDialog(Context context, String title, String message,
                                        String msgSub, final View.OnClickListener listener) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.dialogStyle)
                .setCancelable(false).create();
        if (((Activity) context).isFinishing()) {
            return;
        }
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_alert);
        TextView tvTitle = (TextView) alertDialog.getWindow().findViewById(
                R.id.tv_edit_dialog_title);
        TextView tvMsg = (TextView) alertDialog.getWindow().findViewById(R.id.tv_select_dialog_msg);
        TextView tvSubMsg = (TextView) alertDialog.getWindow().findViewById(
                R.id.tv_select_dialog_submsg);
        tvTitle.setText(title);
        tvMsg.setText(message);
        tvSubMsg.setText(msgSub);
        if (TextUtils.isEmpty(message)) {
            tvMsg.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(msgSub)) {
            tvSubMsg.setVisibility(View.GONE);
        }
        alertDialog.getWindow().findViewById(R.id.tv_select_dialog_cancel).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
        alertDialog.getWindow().findViewById(R.id.tv_select_dialog_ok).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(view);
                        alertDialog.dismiss();
                    }
                });
    }

    public static void showSelectDialog(Context context, String title, String message,
                                        String msgSub, final View.OnClickListener listener,
                                        final View.OnClickListener dealCancel) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.dialogStyle)
                .setCancelable(false).create();
        if (((Activity) context).isFinishing()) {
            return;
        }
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_alert);
        TextView tvTitle = (TextView) alertDialog.getWindow().findViewById(
                R.id.tv_edit_dialog_title);
        TextView tvMsg = (TextView) alertDialog.getWindow().findViewById(R.id.tv_select_dialog_msg);
        TextView tvSubMsg = (TextView) alertDialog.getWindow().findViewById(
                R.id.tv_select_dialog_submsg);
        tvTitle.setText(title);
        tvMsg.setText(message);
        tvSubMsg.setText(msgSub);
        if (TextUtils.isEmpty(message)) {
            tvMsg.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(msgSub)) {
            tvSubMsg.setVisibility(View.GONE);
        }
        alertDialog.getWindow().findViewById(R.id.tv_select_dialog_cancel).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                view.setTag(alertDialog);
                dealCancel.onClick(view);
                alertDialog.dismiss();
            }
        });
        alertDialog.getWindow().findViewById(R.id.tv_select_dialog_ok).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                view.setTag(alertDialog);
                listener.onClick(view);
                alertDialog.dismiss();
            }
        });
    }


    public static void showEditDialog(Context context, String title, String message,
                                      View.OnClickListener listener) {
        showEditDialog(context, title, message, listener, new String[]{"请输入原因"});
    }

    public static void showEditDialog(Context context, String title, String message,
                                      final View.OnClickListener listener, final String[] hint) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.dialogStyle)
                .setCancelable(false).create();
        if (((Activity) context).isFinishing()) {
            return;
        }
        alertDialog.show();
        alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        alertDialog.setContentView(R.layout.dialog_edit);
        TextView tvTitle = (TextView) alertDialog.getWindow().findViewById(
                R.id.tv_edit_dialog_title);
        TextView tvMsg = (TextView) alertDialog.getWindow().findViewById(R.id.tv_edit_dialog_msg);
        final LinearLayout llContainer = (LinearLayout) alertDialog.getWindow().findViewById(
                R.id.ll_edit_dialog_container);

        for (int i = 0; i < hint.length; i++) {
            llContainer.getChildAt(i).setVisibility(View.VISIBLE);
            ((EditText) llContainer.getChildAt(i)).setHint(hint[i]);
            //输入数字
            if (hint[i].contains(".")) {
                ((EditText) llContainer.getChildAt(i)).setInputType(
                        InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            }
            if (hint[i].contains("数量")) {
                ((EditText) llContainer.getChildAt(i)).setInputType(InputType.TYPE_CLASS_NUMBER);
            }
        }
        tvTitle.setText(title);
        tvMsg.setText(message);
        if (TextUtils.isEmpty(message)) {
            tvMsg.setVisibility(View.GONE);
        }
        alertDialog.getWindow().findViewById(R.id.tv_edit_dialog_cancel).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog.getWindow().findViewById(R.id.tv_edit_dialog_ok).setOnClickListener(new View
                .OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < hint.length; i++) {
                    sb.append(((EditText) llContainer.getChildAt(i)).getText().toString()).append("!@#");
                }
                view.setTag(sb.toString());
                listener.onClick(view);
                alertDialog.dismiss();
            }
        });
    }
}
