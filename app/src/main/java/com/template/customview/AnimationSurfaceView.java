package com.template.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

class AnimationSurfaceView extends SurfaceView {
    private SurfaceHolder surfaceHolder;
    private boolean flag=false; //线程标识
    private Bitmap bitmap_bg;   //背景图
    private float mSurfeceWindth,mSurfeceHeight; //屏幕宽高
    private int mBitposX;
    private Canvas mCanvas;
    private Thread thread;
    private  enum State{
        LEFT,RINGHT
    }
    private State state=State.LEFT;     //默认向左
    private final  int BITMAP_STEP=10;   //背景画布移动步伐

    public AnimationSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        surfaceHolder=getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                flag=true;
                startAnimation();
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                flag=false;
            }
        });

    }

    private void startAnimation() {
        mSurfeceWindth=getWidth();
        mSurfeceHeight=getHeight();
        int mWindth= (int) (mSurfeceWindth * 3 / 2);
        //将图片宽度缩放到屏幕的3/2倍。高度充满屏幕
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.scenery);
        bitmap_bg=Bitmap.createScaledBitmap(bitmap,mWindth, (int) mSurfeceHeight,true);
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){
                    mCanvas=surfaceHolder.lockCanvas();
                    DrawView();
                    surfaceHolder.unlockCanvasAndPost(mCanvas);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }

    private void DrawView() {
        mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);//清空屏幕
        mCanvas.drawBitmap(bitmap_bg,mBitposX,0,null);
        switch (state){
            case LEFT:
                mBitposX -= BITMAP_STEP;
                break;
            case RINGHT:
                mBitposX += BITMAP_STEP;
                break;
            default:
                break;
        }
        if (mBitposX <= -mSurfeceWindth /2 ){
         state=State.RINGHT;
        }
        if (mBitposX >= 0){
            state=State.LEFT;
        }

    }

}
