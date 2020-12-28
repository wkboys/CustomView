package com.template.customview;

import android.annotation.SuppressLint;
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
import android.util.Log;
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

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置笔画的基本属性
        Paint paint=new Paint();
        paint.setColor(0xFFFF0000);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(50);
        canvas.drawCircle(190,200,150,paint);
        paint.setColor(0x7EFFFF00);
        canvas.drawCircle(190,200,100,paint);

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

//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
//        Path ovalPath=new Path();
//        RectF rectF=new RectF(50,50,200,500);
//        ovalPath.addOval(rectF,Path.Direction.CCW);
//        Region rgn=new Region();
//        rgn.setPath(ovalPath,new Region(50,50,200,200));
//        drawRegion(canvas,rgn,paint);

//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
//        Region region=new Region(10,10,200,100);
//        region.union(new Rect(10,10,50,300));
//        drawRegion(canvas,region,paint);

//        Rect rect1=new Rect(100,100,400,200);
//        Rect rect2=new Rect(200,0,300,300);
//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(2);
//        canvas.drawRect(rect1,paint);
//        canvas.drawRect(rect2,paint);
//        Region region=new Region(rect1);
//        Region region2=new Region(rect2);
//        region.op(region2, Region.Op.XOR);//修改op后边的值
//        Paint paint_fill=new Paint();
//        paint.setColor(Color.GREEN);
//        paint.setStyle(Paint.Style.FILL);
//        drawRegion(canvas,region,paint_fill);

//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(2);
//        Region region1=new Region(100,100,400,200);
//        Region region2=new Region(200,0,300,300);
//        Region region=new Region();
//        region.op(region1, region2, Region.Op.XOR);
//        Paint paint_fill=new Paint();
//        paint.setColor(Color.GREEN);
//        paint.setStyle(Paint.Style.FILL);
//        drawRegion(canvas,region,paint_fill);

//        Paint paint=new Paint();
//        paint.setColor(Color.GREEN);
//        paint.setStyle(Paint.Style.FILL);
////        canvas.translate(100,100);
//        Rect rect1=new Rect(0,0,400,220);
//        canvas.drawRect(rect1,paint);

//        Paint paint_green=generatePaint(Color.GREEN, Paint.Style.STROKE,3);
//        Paint paint_red=generatePaint(Color.RED, Paint.Style.STROKE,3);
//        Rect rect1=new Rect(0,0,400,220);
//        canvas.drawRect(rect1,paint_green);
//        canvas.translate(100,100);
//        canvas.drawRect(rect1,paint_red);

//        canvas.drawColor(Color.RED);
//        canvas.clipRect(new Rect(100,100,200,200));
//        canvas.drawColor(Color.GREEN);

//        canvas.drawColor(Color.RED);
//        canvas.save();
//        canvas.clipRect(new Rect(100,100,800,800));
//        canvas.drawColor(Color.GREEN);
//        canvas.restore();
//        canvas.drawColor(Color.BLUE);
    }

    private Paint generatePaint(int color, Paint.Style style, int width) {
        Paint paint=new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }

    private void drawRegion(Canvas canvas, Region rgn, Paint paint) {
        RegionIterator iter = new RegionIterator(rgn);
        Rect r = new Rect();
        while (iter.next(r)) {
            canvas.drawRect(r, paint);
        }
    }


}
