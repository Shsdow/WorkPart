package com.mk.workdemo.surfaceview_camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mk.workdemo.R;
import com.mk.workdemo.utils.LogUtil;


public class TakePhotoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView takePh, startCompress, imageSizeShow, imageCompressSizeShow;
    private ImageView imageShow, imageCompressShow;
    private NewCameraPreview newCameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo);
        initView();
        initListener();

    }

    private void initListener() {
        takePh.setOnClickListener(this);
        newCameraPreview.setOnClickListener(this);
    }

    private void initView() {
        takePh = (TextView) findViewById(R.id.tv_take_photo);
        startCompress = (TextView) findViewById(R.id.tv_compress_pic);
        imageSizeShow = (TextView) findViewById(R.id.tv_image_size);
        imageCompressSizeShow = (TextView) findViewById(R.id.tv_image_compress_size);
        imageShow = (ImageView) findViewById(R.id.iv_image_show);
        imageCompressShow = (ImageView) findViewById(R.id.iv_compress_image);
        newCameraPreview = (NewCameraPreview) findViewById(R.id.iv_image_show_pre);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_take_photo:
                LogUtil.d("tv_take_photo:进行拍照");
                takeph();
                break;

            case R.id.iv_image_show_pre:
                LogUtil.d("iv_image_show_pre:进行拍照");
                takeph();
                break;
        }
    }

    public void takeph() {
        newCameraPreview.getBmp();
        newCameraPreview.setPicCallBack(new NewCameraPreview.PicCallBack() {
            @Override
            public void callback(Bitmap bitmap) {
                Bitmap newBitmap = setRotate(bitmap,0);
//                Bitmap newBitmap = framedImage(bitmap);
                LogUtil.d("newBItmap weight and height :" + newBitmap.getWidth() + "," + newBitmap.getHeight());
                imageShow.setImageBitmap(newBitmap);

                imageSizeShow.setText(getString(R.string.size, bitmap.getByteCount()));

            }
        });
    }

    //生成带圆角的矩形
    private Bitmap setRotate(Bitmap bitmap, int radiu) {
        //利用原图片新建一张新的图片bitmap,这样的bitmap的大小与原先相同
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //依据新建的bitmap新建画布
        Canvas canvas = new Canvas(newBitmap);
        //新建画笔
        Paint paint = new Paint();
        //画笔的设置
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        //新建矩形
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        //消除掉画布原先的图像
//        canvas.drawARGB(0, 0, 0, 0);
        //新建一个圆弧矩形
        canvas.drawRoundRect(rectF, radiu, radiu, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return newBitmap;
    }

    public static Bitmap framedImage(Bitmap bitmap) {
        //获得宽度和高度
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int avg = 0;

        if (width > height) {
            avg = height;
        } else {
            avg = width;
        }
        LogUtil.d("avg:" + avg);
        Drawable imageDrawable = new BitmapDrawable(bitmap);
        //新建一个新的输出图片
        Bitmap outputBitmap = Bitmap.createBitmap(avg, avg, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(outputBitmap);
        //新建一个矩形
        RectF outerRect = new RectF(0, 0, avg, avg);
        //产生一个红色的圆角矩形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        canvas.drawRoundRect(outerRect, avg / 8, avg / 8, paint);
        //将原图片绘制到这个圆角矩形上
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        imageDrawable.setBounds(0, 0, avg, avg);
        canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);
        imageDrawable.draw(canvas);
        canvas.restore();
        LogUtil.d("width and height:" + outputBitmap.getWidth() + "," + outputBitmap.getHeight());
        return outputBitmap;
    }
}
