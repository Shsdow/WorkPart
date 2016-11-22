package com.mk.workdemo.ImageCompress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mk.workdemo.Activities.TitleActivity;
import com.mk.workdemo.R;

public class ImageCompressActivity extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_compress);
        setTitleText("图片压缩");
    }
}
