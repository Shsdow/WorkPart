package com.mk.workdemo.CustomView;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
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

    private LinearLayout mLayoutLeft, mLayoutRight, mLayoutFirstRight;
    private ImageView mIvLeft, mIvRight, mIvFistRight;
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

        mLayoutLeft = (LinearLayout) titleBar.findViewById(R.id.title_bar_left);
        mLayoutRight = (LinearLayout) titleBar.findViewById(R.id.titlt_bar_right);
        mLayoutFirstRight = (LinearLayout) titleBar.findViewById(R.id.title_bar_first_right);
        mIvLeft = (ImageView) titleBar.findViewById(R.id.title_bar_left_icon);
        mTvLeft = (TextView) titleBar.findViewById(R.id.title_bar_left_text);
        mIvFistRight = (ImageView) titleBar.findViewById(R.id.title_bar_first_right_icon);
        mIvRight = (ImageView) titleBar.findViewById(R.id.title_bar_right_icon);
        mTvRight = (TextView) titleBar.findViewById(R.id.title_bar_right_text);
        mTvTitle = (TextView) titleBar.findViewById(R.id.title_bar_title);
    }

    public ImageView getIvRight() {
        return mIvRight;
    }


    //设置标题内容、颜色
    public void setTitleBarTextAndColor(String titleText, int titleColor) {
        mTvTitle.setText(titleText);
        mTvTitle.setTextColor(ContextCompat.getColor(getContext(), titleColor));
    }

    //设置左边的图标
    public void setLeftDrawable(int drawableId) {
        //隐藏文字
        mTvLeft.setVisibility(GONE);
        //显示图标
        mIvLeft.setVisibility(VISIBLE);
        mIvLeft.setImageDrawable(ContextCompat.getDrawable(getContext(), drawableId));
    }

    //设置左边的文字、颜色、大小
    public void setLeftTextAndColorAndSize(String leftText, int textColor, float textSize) {
        mIvLeft.setVisibility(GONE);
        mTvLeft.setVisibility(VISIBLE);
        mTvLeft.setText(leftText);
        mTvLeft.setTextColor(ContextCompat.getColor(getContext(), textColor));
        mTvLeft.setTextSize(textSize);
    }


    //设置右边文字的大小、颜色、大小
    public void setRightTextAndColorAndSize(String rightText, int textColor, float textSize) {
        mIvRight.setVisibility(GONE);
        mTvRight.setVisibility(VISIBLE);
        mTvRight.setText(rightText);
        mTvRight.setTextColor(ContextCompat.getColor(getContext(), textColor));
        mTvRight.setTextSize(textSize);
    }


    //设置右边图标和padding
    public void setRightDrawabelAndPadding(int drawableId, int paddingSize) {
        mIvRight.setVisibility(VISIBLE);
        mTvRight.setVisibility(GONE);
        mIvRight.setImageDrawable(ContextCompat.getDrawable(getContext(), drawableId));
        int dp = dip2px(getContext(), paddingSize);
        mIvRight.setPadding(dp, dp, dp, dp);
    }

    //设置左边图标和padding
    public void setLeftDrawabelAndPadding(int drawableId, int paddingSize) {
        mIvLeft.setVisibility(VISIBLE);
        mTvLeft.setVisibility(GONE);
        mIvLeft.setImageDrawable(ContextCompat.getDrawable(getContext(), drawableId));
        int dp = dip2px(getContext(), paddingSize);
        mIvRight.setPadding(dp, dp, dp, dp);
    }


    public void setRightFistDrawableAndPadding(int drawableId, int paddingSize) {
        mIvFistRight.setVisibility(VISIBLE);
        mIvFistRight.setImageDrawable(ContextCompat.getDrawable(getContext(), drawableId));
        int dp = dip2px(getContext(), paddingSize);
        mIvFistRight.setPadding(dp, dp, dp, dp);
    }

    /**
     * 设置控件的可见性
     */
    public void setRightFirstVisibility(int visibility) {
        mIvFistRight.setVisibility(visibility);
    }

    public void setLeftVisibility(int visibility) {
        mLayoutLeft.setVisibility(visibility);
    }

    public void setRightVisibility(int visibility) {
        mLayoutRight.setVisibility(visibility);
    }

    /**
     * 以下三个为点击事件
     *
     * @param onLeftClickListener
     */
    public void setTitleBarLeftClick(OnClickListener onLeftClickListener) {
        mLayoutLeft.setOnClickListener(onLeftClickListener);
    }

    public void setTitleBarRightClick(OnClickListener onRightClickListener) {
        mLayoutRight.setOnClickListener(onRightClickListener);
    }

    public void setTitleBarFirstClick(OnClickListener onFirstClickListener) {
        mLayoutFirstRight.setOnClickListener(onFirstClickListener);
    }

    /**
     *
     *
     */
    public void setLeftAndIcon(String text, int iconId, boolean isCoinAtLeft) {
        mIvLeft.setVisibility(GONE);
        mTvLeft.setVisibility(VISIBLE);
        mTvLeft.setText(text);
        if (isCoinAtLeft) {
            mTvLeft.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), iconId), null, null, null);
        } else {
            mTvLeft.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getContext(), iconId), null);
        }
        mTvLeft.setCompoundDrawablePadding(10);
    }

    public void setRightAndIcon(String text, int iconId, boolean isCoinAtRight) {
        mTvRight.setVisibility(GONE);
        mTvRight.setVisibility(VISIBLE);
        mTvRight.setText(text);
        if (isCoinAtRight) {
            mTvRight.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    ContextCompat.getDrawable(getContext(), iconId), null, null, null);
        } else {
            mTvRight.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null, null, ContextCompat.getDrawable(getContext(), iconId), null);
        }
        mTvRight.setCompoundDrawablePadding(10);
    }


    /**
     * 单位换算
     *
     * @param context
     * @param dpValues
     * @return
     */
    public int dip2px(Context context, float dpValues) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValues * scale + 0.5f);
    }
}
