package com.mk.workdemo;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.mk.workdemo.CustomView.TitleBar;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TitleActivity extends BaseAcitivity {
    @IntDef({View.VISIBLE, View.INVISIBLE, View.GONE})
    @Retention(RetentionPolicy.SOURCE)
    @interface Visibility{}

    private View mLayoutMain;
    private TitleBar mTitleBar;
    private LinearLayout mLayoutContent;
    private View mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //根据布局文件构建的根UI
        mLayoutMain = getLayoutInflater().inflate(R.layout.title_bar_content,null);
        //根UI的第一层UI
        mLayoutContent = (LinearLayout) findViewById(R.id.title_bar_content);
        //第一层UI的一个控件
        mTitleBar = (TitleBar) findViewById(R.id.title_bar);
    }

    @Override
    public View findViewById( int id) {
        View view = mLayoutMain.findViewById(id);
        if(view == null){
            return super.findViewById(id);
        }
        return view;
    }

    /**
     * 向根UI添加新的布局
     * @param layoutResID
     */
    @Override
    public void setContentView( int layoutResID) {
        //需要添加的布局文件的View
        mContent = getLayoutInflater().inflate(layoutResID,null);
        //将该View添加到第一层UI上
        mLayoutContent.addView(mContent, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        //重新渲染布局文件
        super.setContentView(mLayoutMain);
    }
}
