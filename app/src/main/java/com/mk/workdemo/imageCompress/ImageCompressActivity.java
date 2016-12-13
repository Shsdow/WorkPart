package com.mk.workdemo.imageCompress;

import android.os.Bundle;

import com.mk.workdemo.activities.TitleActivity;
import com.mk.workdemo.R;

public class ImageCompressActivity extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_compress);
        setTitleText("图片压缩");
    }
}
