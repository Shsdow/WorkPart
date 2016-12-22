package com.mk.workdemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mk.workdemo.R;
import com.mk.workdemo.utils.LogUtil;

public class MyClassLoaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_class_loader);
        ClassLoader mClassLoader = getClassLoader();
        if(mClassLoader !=null){
            LogUtil.d("oncreate "+mClassLoader.toString() );
        }
    }
}
