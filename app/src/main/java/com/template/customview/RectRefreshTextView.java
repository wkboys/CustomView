package com.template.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;


public class RectRefreshTextView extends SurfaceView {
    private Paint mPaint;

    public RectRefreshTextView(Context context) {
        super(context);
        init();
    }

    public RectRefreshTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectRefreshTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
//        mPaint.setColor(Color.argb(0x1F, 0xFF, 0xFF, 0xFF));
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30);

        getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                drawText(holder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }
        });
    }

    private List<Integer> mInts=new ArrayList<>();
    private void drawText(final SurfaceHolder holder) {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    Canvas canvas = holder.lockCanvas();
//                    mInts.add(i);
//                    if (canvas != null) {
//                        for (int num:mInts){
//                            canvas.drawText(num + "", num * 30, 50, mPaint);
//                        }
//                    }
//                    try {
//                        Thread.sleep(800);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    holder.unlockCanvasAndPost(canvas);
//                }

                //先进行清屏操作
                while (true) {
                    Rect dirtyRect = new Rect(0, 0, 1, 1);
                    Canvas canvas = holder.lockCanvas(dirtyRect);
                    Rect canvasRect = canvas.getClipBounds();
                    if (getWidth() == canvasRect.width() && getHeight() == canvasRect.height()) {
                        canvas.drawColor(Color.BLACK);
                        holder.unlockCanvasAndPost(canvas);
                        Log.d("qijian","clear canvas");
                    } else {
                        holder.unlockCanvasAndPost(canvas);
                        break;
                    }
                }

                //画图
                for (int i = 0; i < 10; i++) {
                    int itemWidth = 50;
                    int itemHeight = 50;
                    Rect rect = new Rect(i*itemWidth,0,(i+1)*itemWidth-10,itemHeight);
                    Canvas canvas = holder.lockCanvas(rect);
                    if (canvas != null) {
                        canvas.drawColor(Color.GREEN);
                        canvas.drawText(i + "", i*itemWidth+10, itemHeight/2, mPaint);
                    }
                    try {
                        holder.unlockCanvasAndPost(canvas);
                        Thread.sleep(800);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

//                //先进行清屏操作
//                while (true) {
//                    Rect dirtyRect = new Rect(0, 0, 1, 1);
//                    Canvas canvas = holder.lockCanvas(dirtyRect);
//                    Rect canvasRect = canvas.getClipBounds();
//                    if (getWidth() == canvasRect.width() && getHeight() == canvasRect.height()) {
//                        canvas.drawColor(Color.BLACK);
//                        holder.unlockCanvasAndPost(canvas);
//                    } else {
//                        holder.unlockCanvasAndPost(canvas);
//                        break;
//                    }
//                }
//
//                //画图
//                for (int i = 0; i < 10; i++) {
//                    //画大方
//                    if (i == 0) {
//                        Canvas canvas = holder.lockCanvas(new Rect(10, 10, 600, 600));
//                        dumpCanvasRect(canvas);
//                        canvas.drawColor(Color.RED);
//                        holder.unlockCanvasAndPost(canvas);
//                    }
//
//                    //画中方
//                    if (i == 1) {
//                        Canvas canvas = holder.lockCanvas(new Rect(30, 30, 570, 570));
//                        dumpCanvasRect(canvas);
//                        canvas.drawColor(Color.GREEN);
//                        holder.unlockCanvasAndPost(canvas);
//                    }
//
//                    //画小方
//                    if (i == 2) {
//                        Canvas canvas = holder.lockCanvas(new Rect(60, 60, 540, 540));
//                        dumpCanvasRect(canvas);
//                        canvas.drawColor(Color.BLUE);
//                        holder.unlockCanvasAndPost(canvas);
//                    }
//
//                    //画圆形
//                    if (i == 3) {
//                        Canvas canvas = holder.lockCanvas(new Rect(200, 200, 400, 400));
//                        dumpCanvasRect(canvas);
//                        mPaint.setColor(Color.argb(0x3F, 0xFF, 0xFF, 0xFF));
//                        canvas.drawCircle(300, 300, 100, mPaint);
//                        holder.unlockCanvasAndPost(canvas);
//                    }
//                    //写字
//                    if (i == 4) {
//                        Canvas canvas = holder.lockCanvas(new Rect(250, 250, 350, 350));
//                        dumpCanvasRect(canvas);
//                        mPaint.setColor(Color.RED);
//                        canvas.drawText(i + "", 300, 300, mPaint);
//                        holder.unlockCanvasAndPost(canvas);
//                    }
//
//
//                    try {
//                        Thread.sleep(800);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }).start();
    }

    private void dumpCanvasRect(Canvas canvas) {
        if (canvas != null) {
            Rect rect = canvas.getClipBounds();
            Log.d("qijian", "left:" + rect.left + "  top:" + rect.top + "  right:" + rect.right + "  bottom:" + rect.bottom);
        }
    }
}
