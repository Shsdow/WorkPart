package com.mk.workdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mk.workdemo.Activities.SecondAcitivity;
import com.mk.workdemo.Activities.TitleActivity;
import com.mk.workdemo.Utils.LogUtils;
import com.mk.workdemo.Utils.ShowDialog;

public class MainActivity extends TitleActivity implements View.OnClickListener {
    private String[] dia = new String[]{"wo",".","数量"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitleText("主页面");
//        setLeftAndIcon("后退", R.drawable.ic_action_add, false);
        setRightText("123");
        setRightFirstDrawable(R.drawable.ic_action_exit);
        LogUtils.d("我在MainActivity中");
        findViewById(R.id.tv_dialog_confirm).setOnClickListener(this);
        findViewById(R.id.tv_dialog_alert_one).setOnClickListener(this);
        findViewById(R.id.tv_dialog_alert_two).setOnClickListener(this);
        findViewById(R.id.tv_dialog_edit).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_jump:
                startActivity(new Intent(MainActivity.this, SecondAcitivity.class));
                break;
            case R.id.tv_dialog_confirm:
                ShowDialog.showConfiromDialog(this, "标题", "内容", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"点击了确定",Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.tv_dialog_alert_one:
                ShowDialog.showSelectDialog(this, "选择1", "选择内容1", "哈哈哈", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"选择1",Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.tv_dialog_alert_two:
                ShowDialog.showSelectDialog(this, "选择2", "选择内容2", "", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"点击了确定",Toast.LENGTH_SHORT).show();
                    }
                }, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"点击了取消",Toast.LENGTH_SHORT).show();

                    }
                });

                break;
            case R.id.tv_dialog_edit:
                ShowDialog.showEditDialog(this, "我是标题", "我是内容", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,""+view.getTag(),Toast.LENGTH_SHORT).show();
//                        LogUtils.d(view.getTag());
                    }
                },dia);
                break;
        }

    }
}
