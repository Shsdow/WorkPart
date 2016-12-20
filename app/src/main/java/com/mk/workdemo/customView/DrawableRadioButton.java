package com.mk.workdemo.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.mk.workdemo.R;


/**
 * Created by Jessie on 2016/9/19.
 * 字+图混排 自定义设置图片的大小
 */
public class DrawableRadioButton extends RadioButton{

    public static final int DRAWABLE_RADIO_LEFT = 0;
    public static final int DRAWABLE_RADIO_TOP = 1;
    public static final int DRAWABLE_RADIO_RIGHT = 2;
    public static final int DRAWABLE_RADIO_BOTTOM = 3;
    private int radioLeftHeight = 0;
    private int radioLeftWidth = 0;
    private int radioRightHeight = 0;
    private int radioRightWidth = 0;
    private int radioTopHeight = 0;
    private int radioTopWidth = 0;
    private int radioBottomHeight = 0;
    private int radioBottomWidth = 0;

    public DrawableRadioButton(Context context) {
        this(context, null);
    }

    public DrawableRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public DrawableRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    /**
     * 初始化读取参数
     */
    private void init(Context context, AttributeSet attrs, int defStyle) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DrawableRadioButton, defStyle,
                0);
        if (a != null) {

            int count = a.getIndexCount();
            int index;
            for (int i = 0; i < count; i++) {
                index = a.getIndex(i);
                switch (index) {
                    case R.styleable.DrawableRadioButton_radio_left_height:
                        radioLeftHeight = a.getDimensionPixelSize(index, 0);
                        break;
                    case R.styleable.DrawableRadioButton_radio_left_width:
                        radioLeftWidth = a.getDimensionPixelSize(index, 0);
                        break;
                    case R.styleable.DrawableRadioButton_radio_top_height:
                        radioTopHeight = a.getDimensionPixelSize(index, 0);
                        break;
                    case R.styleable.DrawableRadioButton_radio_top_width:
                        radioTopWidth = a.getDimensionPixelSize(index, 0);
                        break;
                    case R.styleable.DrawableRadioButton_radio_right_height:
                        radioRightHeight = a.getDimensionPixelSize(index, 0);
                        break;
                    case R.styleable.DrawableRadioButton_radio_right_width:
                        radioRightWidth = a.getDimensionPixelSize(index, 0);
                        break;

                    case R.styleable.DrawableRadioButton_radio_bottom_height:
                        radioBottomHeight = a.getDimensionPixelSize(index, 0);
                        break;
                    case R.styleable.DrawableRadioButton_radio_bottom_width:
                        radioBottomWidth = a.getDimensionPixelSize(index, 0);
                        break;
                }
            }

            /**
             * 取一圈修改大小，大小是读取的
             * getCompoundDrawables: 获取4个位置的图片（左、上、右、下）
             * setCompoundDrawables：设置4个位置的图片 （左、上、右、下）
             */
            Drawable[] drawables = getCompoundDrawables();
            setImageSize(drawables[0], DRAWABLE_RADIO_LEFT);
            setImageSize(drawables[1], DRAWABLE_RADIO_TOP);
            setImageSize(drawables[2], DRAWABLE_RADIO_RIGHT);
            setImageSize(drawables[3], DRAWABLE_RADIO_BOTTOM);
            setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
        }
        if (a != null) {
            a.recycle();//回收a
        }
    }

    /**
     * 设定图片的大小
     */
    private void setImageSize(Drawable d, int dir) {
        int height = 0;
        int width = 0;
        if (d == null) {
            return;
        }
        switch (dir) {
            case DRAWABLE_RADIO_LEFT:
                height = radioLeftHeight;
                width = radioLeftWidth;
                break;
            case DRAWABLE_RADIO_TOP:
                height = radioTopHeight;
                width = radioTopWidth;
                break;
            case DRAWABLE_RADIO_RIGHT:
                height = radioRightHeight;
                width = radioRightWidth;
                break;
            case DRAWABLE_RADIO_BOTTOM:
                height = radioBottomHeight;
                width = radioBottomWidth;
                break;
        }
        d.setBounds(0, 0, width, height);
    }
}
