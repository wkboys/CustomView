package com.template.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

class BasisView extends View {
    public BasisView(Context context) {
        super(context);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置笔画的基本属性
//        Paint paint=new Paint();
//        paint.setColor(0xFFFF0000);
//        paint.setStyle(Paint.Style.FILL);
//        paint.setStrokeWidth(50);
//
//        canvas.drawCircle(190,200,150,paint);
//        paint.setColor(0x7EFFFF00);
//        canvas.drawCircle(190,200,100,paint);

//        canvas.drawRGB(255,0,255);

//        Paint paint=new Paint();
//        paint.setColor(0xFFFF0000);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setStrokeWidth(50);
//        canvas.drawLine(100,100,200,200,paint);

//        Paint paint=new Paint();
//        paint.setColor(0xFFFF0000);
//        paint.setStrokeWidth(50);
//        canvas.drawPoint(100,100,paint);

//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(15);
//        canvas.drawRect(10,10,100,100,paint);
//        paint.setStyle(Paint.Style.FILL);
//        RectF rectF=new RectF(210f,10f,300f,100f);
//        canvas.drawRect(rectF,paint);

//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        Path path=new Path();
//        path.moveTo(10,10);
//        path.lineTo(10,100);
//        path.lineTo(300,100);
//        path.close();
//        canvas.drawPath(path,paint);

//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        Path path=new Path();
//        path.moveTo(10,10);
//        RectF rectF=new RectF(100,10,200,100);
//        path.arcTo(rectF,0,90,true);
//        canvas.drawPath(path,paint);

//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawRect(new Rect(50,50,200,100),paint);

        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        Path ovalPath=new Path();
        RectF rectF=new RectF(50,50,200,500);
        ovalPath.addOval(rectF,Path.Direction.CCW);
        Region rgn=new Region();
        rgn.setPath(ovalPath,new Region(50,50,200,200));
        drawRegion(canvas,rgn,paint);

    }

    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();
        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }


}
