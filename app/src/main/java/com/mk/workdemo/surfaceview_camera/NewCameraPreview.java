package com.mk.workdemo.surfaceview_camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


import com.mk.workdemo.utils.LogUtil;
import com.mk.workdemo.utils.ShowToast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewCameraPreview
        extends SurfaceView implements SurfaceHolder.Callback {
    private static final int IMG_WIDTH = 100;
    private static final int IMG_HEIGHT = 100;

    private Context context;

    private Camera mCamera;
    private boolean isPreviewing = false;
    private boolean capturing = false;

    private Bitmap bitmap2;

    public NewCameraPreview(Context context) {
        this(context,null);
    }

    //获得SurfaceHolder
    public NewCameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        this.context = context;

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(final SurfaceHolder holder) {
        LogUtil.d("CameraPreview SurfaceCreated");
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(IMG_WIDTH, IMG_HEIGHT, Bitmap.Config.ARGB_8888);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtil.d("cameraNum:" +Camera.getNumberOfCameras());
                if (Camera.getNumberOfCameras() == 2) {
                    try {
                        if (!isPreviewing) {
                            mCamera = Camera.open(0);
                            //设置相机捕捉照片时的角度
                            mCamera.setDisplayOrientation(90);
                            initCamera(holder);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        post(new Runnable() {
                            @Override
                            public void run() {
                                ShowToast.shortTime("打开摄像头发生异常");
                                ((Activity) context).finish();
                            }
                        });
                    }
                } else {
                    post(new Runnable() {
                        @Override
                        public void run() {
                            ShowToast.shortTime("未检测到摄像头");
                            ((Activity) context).finish();
                        }
                    });
                }
            }
        }).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        LogUtil.d("CameraPreview SurfaceChanged");
    }
    // 初始化Camera
    private void initCamera(SurfaceHolder holder) {
        LogUtil.d("CameraPreview InitCamera");
        if (!isPreviewing && mCamera != null) {
            Camera.Parameters parameters = mCamera.getParameters();
//            parameters.setPreviewFpsRange(4, 10);
//            parameters.setPreviewSize(1024, 768);
//            parameters.setPictureFormat(ImageFormat.JPEG);
//            parameters.setJpegQuality(100);
//            parametersarameters.setPictureSize(2592, 1944);


//            parameters.setPreviewSize(100, 100);
            parameters.setPictureFormat(ImageFormat.JPEG);
//            parameters.setPictureSize(100, 100);

//            parameters.setFlashMode("off"); // 无闪光灯
//            parameters.setWhiteBalance(Camera.Parameters.WHITE_BALANCE_AUTO);
//            parameters.setSceneMode(Camera.Parameters.SCENE_MODE_AUTO);
//            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
//            parameters.setPreviewFormat(ImageFormat.YV12);
            parameters.setPictureSize(320,240);
            parameters.setPreviewSize(320,240);


            try {
                mCamera.setParameters(parameters);
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();
                isPreviewing = true;
                LogUtil.d("CameraPreview Started");
            } catch (Exception e) {
                throw new RuntimeException("setParameters failed");
            }
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        LogUtil.d("CameraPreview SurfaceDestroyed");
        if (mCamera != null) {
            if (isPreviewing) {
                mCamera.stopPreview();
                LogUtil.d("CameraPreview Stopped");
            }
            mCamera.release();
            mCamera = null;
            isPreviewing = false;
            LogUtil.d("CameraPreview Released");
        }
    }

    public void getBmp() {
        LogUtil.d("getBmp():"+ new SimpleDateFormat("MM-dd-HH-mm-ss",Locale.CHINA).format(new Date()));
        if(!capturing && mCamera != null) {
            capturing = true;
            mCamera.takePicture(null, null, callback);
        }
    }

    private Camera.PictureCallback callback = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            final Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
            bitmap2 = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());
            Canvas canvas = new Canvas(bitmap2);

            Matrix matrix = new Matrix();
//            matrix.setRotate(90);
            //调节拍照后的图片的角度
            matrix.setRotate(90, bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            canvas.drawBitmap(bmp, matrix, paint);

            LogUtil.d("拍照结束开始矫正:" + new SimpleDateFormat("MM-dd HH:mm:ss", Locale.CHINA).format(new Date()));

            if(picCallBack!= null){
                picCallBack.callback(bitmap2);
            }

            capturing = false;
        }
    };

    private PicCallBack picCallBack;

    public void setPicCallBack(PicCallBack picCallBack) {
        this.picCallBack = picCallBack;
    }

    public interface PicCallBack{
        void callback(Bitmap bitmap);
    }
}
