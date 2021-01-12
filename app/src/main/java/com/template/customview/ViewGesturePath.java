package com.template.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class ViewGesturePath extends SurfaceView {
    private Paint mPaint;
    private Path mPath;
    public ViewGesturePath(Context context) {
        super(context);
        init();
    }
    public ViewGesturePath(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public ViewGesturePath(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init(){
        setWillNotDraw(false);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);

        mPath = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int)event.getX();
        int y = (int)event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            mPath.moveTo(x,y);
            return true;
        }else if (event.getAction() == MotionEvent.ACTION_MOVE){
            mPath.lineTo(x,y);
        }
//        postInvalidate();

        //使用缓冲Canvas绘制
        drawCanvas();
        return super.onTouchEvent(event);
    }

    private void drawCanvas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SurfaceHolder holder = getHolder();
                holder.addCallback(new SurfaceHolder.Callback() {
                    @Override
                    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

                    }

                    @Override
                    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                    }

                    @Override
                    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

                    }
                });
                Canvas canvas = holder.lockCanvas();
                canvas.drawPath(mPath,mPaint);
                holder.unlockCanvasAndPost(canvas);
            }
        }).start();

    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawPath(mPath,mPaint);
//    }
}
