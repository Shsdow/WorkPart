package com.mk.workdemo.CustomView;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mk.workdemo.R;


public class TitleBar extends LinearLayout {

    private Context mContent;

    private LinearLayout mLayoutLeft;
    private LinearLayout mLayoutRight;
    private ImageView mIvLeft, mIvRight, mFistRight;
    private TextView mTvLeft, mTvRight, mTvTitle;


    public TitleBar(Context context) {
        super(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContent = context;
        if (isInEditMode()) {
            return;
        }
        //获得屏幕界面的根Window，将布局添加进去
        View titleBar = LayoutInflater.from(mContent).inflate(R.layout.title_bar, (ViewGroup) ((Activity) getContext()).getWindow().getDecorView(), false);
        addView(titleBar, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }
}
