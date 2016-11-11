package com.mk.workdemo;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mk.workdemo.CustomView.TitleBar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.view.View.GONE;

public class TitleActivity extends BaseAcitivity {
    @IntDef({View.VISIBLE, View.INVISIBLE, GONE})
    @Retention(RetentionPolicy.SOURCE)
    @interface Visibility {
    }

    private View mLayoutMain;
    private TitleBar mTitleBar;
    private LinearLayout mLayoutContent;
    private View mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //根据布局文件构建的根UI
        mLayoutMain = getLayoutInflater().inflate(R.layout.title_bar_content, null);
        //根UI的第一层UI
        mLayoutContent = (LinearLayout) findViewById(R.id.title_bar_content);
        //第一层UI的一个控件
        mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        mTitleBar.setLeftDrawable(R.drawable.ic_action_back);
        mTitleBar.setTitleBarLeftClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public View findViewById(int id) {
        View view = mLayoutMain.findViewById(id);
        if (view == null) {
            return super.findViewById(id);
        }
        return view;
    }

    /**
     * 向根UI添加新的布局
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        //需要添加的布局文件的View
        mContent = getLayoutInflater().inflate(layoutResID, null);
        //将该View添加到第一层UI上
        mLayoutContent.addView(mContent, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        //重新渲染布局文件
        super.setContentView(mLayoutMain);
    }

    public ImageView getIvRight() {
        return mTitleBar.getIvRight();
    }


    //设置标题颜色，默认白色
    public void setTitleText(String titleText) {
        setTitleBarTextAndColor(titleText, R.color.white);
    }

    //设置标题内容、颜色
    public void setTitleBarTextAndColor(String titleText, int titleColor) {
        mTitleBar.setTitleBarTextAndColor(titleText, titleColor);
    }


    //设置左边的文字、颜色、大小（默认为14）
    public void setLeftText(String text) {
        setLeftTextAndColor(text, R.color.white);
    }

    public void setLeftTextAndColor(String leftText, int textColor) {

        setLeftTextAndColorAndSize(leftText, textColor, 14);
    }

    public void setLeftTextAndColorAndSize(String leftText, int textColor, float textSize) {
        mTitleBar.setLeftTextAndColorAndSize(leftText, textColor, textSize);
    }


    //设置右边文字的大小、颜色、大小
    public void setRightText(String text) {
        setRightTextAndColor(text, R.color.white);
    }

    public void setRightTextAndColor(String rightText, int textColor) {

        setRightTextAndColorAndSize(rightText, textColor, 14);
    }

    public void setRightTextAndColorAndSize(String rightText, int textColor, float textSize) {
        mTitleBar.setRightTextAndColorAndSize(rightText, textColor, textSize);
    }


    //设置右边图标和padding
    public void setRightDrawable(int drawableId) {

        setRightDrawabelAndPadding(drawableId, 0);
    }

    public void setRightDrawabelAndPadding(int drawableId, int paddingSize) {
        mTitleBar.setRightDrawabelAndPadding(drawableId, paddingSize);
    }

    //设置左边图标和padding
    public void setLeftDrawable(int drawableId) {

        setLeftDrawabelAndPadding(drawableId, 0);
    }

    public void setLeftDrawabelAndPadding(int drawableId, int paddingSize) {
        mTitleBar.setLeftDrawabelAndPadding(drawableId, paddingSize);
    }

    public void setRightFirstDrawable(int drawableId) {

        setRightFistDrawableAndPadding(drawableId, 0);
    }

    public void setRightFistDrawableAndPadding(int drawableId, int paddingSize) {
        mTitleBar.setRightFistDrawableAndPadding(drawableId, paddingSize);

    }

    /**
     * 设置控件的可见性
     */
    public void setRightFirstVisibility(@Visibility int visibility) {
        mTitleBar.setRightFirstVisibility(visibility);
    }

    public void setLeftVisibility(@Visibility int visibility) {
        mTitleBar.setLeftVisibility(visibility);
    }

    public void setRightVisibility(@Visibility int visibility) {
        mTitleBar.setRightVisibility(visibility);
    }

    /**
     * 以下三个为点击事件
     */
    public void setTitleBarLeftClick(View.OnClickListener onLeftClickListener) {
        mTitleBar.setTitleBarLeftClick(onLeftClickListener);
    }

    public void setTitleBarRightClick(View.OnClickListener onRightClickListener) {
        mTitleBar.setTitleBarRightClick(onRightClickListener);
    }

    public void setTitleBarFirstClick(View.OnClickListener onFirstClickListener) {
        mTitleBar.setTitleBarFirstClick(onFirstClickListener);
    }

    public void setLeftAndIcon(String text, int iconId, boolean isCoinAtLeft) {
        mTitleBar.setLeftAndIcon(text, iconId, isCoinAtLeft);
    }

    public void setRightAndIcon(String text, int iconId, boolean isCoinAtRight) {
        mTitleBar.setRightAndIcon(text, iconId, isCoinAtRight);
    }
}
