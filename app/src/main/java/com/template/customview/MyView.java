package com.template.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;


public class MyView extends View {
    private Paint mPaint = new Paint();
    private Bitmap bitmap;// 位图

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint.setAntiAlias(true);
        // 获取位图
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.dog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawRect(canvas);
        drawBitmap(canvas);
    }

    private void drawRect(Canvas canvas){
        mPaint.setARGB(255,200,100,100);
        // 绘制原始位图
        canvas.drawRect(0,0,500,600,mPaint);

        canvas.translate(550,0);
        // 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawRect(0,0,500,600,mPaint);
    }

    private void drawBitmap(Canvas canvas){
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth()), mPaint);

        canvas.save();
        canvas.translate(510, 0);
        // 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0,
//                0, 0, 1, 0, 0,
//                0, 0, 0, 1, 0,

//                1, 0, 0, 0, 0,
//                0, 1, 0, 0, 50,
//                0, 0, 1, 0, 0,
//                0, 0, 0, 1, 0,

//                -1,0,0,0,255,
//                0,-1,0,0,255,
//                0,0,-1,0,255,
//                0,0,0,1,0

//                1.2f, 0, 0, 0, 0,
//                0, 1.2f, 0, 0, 50,
//                0, 0, 1.2f, 0, 0,
//                0, 0, 0, 1.2f, 0,

//                0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0,
//                0, 0, 1, 0, 0,
//                0, 0, 0, 1, 0,

//                0.213f, 0.715f, 0.072f, 0, 0,
//                0.213f, 0.715f, 0.072f, 0, 0,
//                0.213f, 0.715f, 0.072f, 0, 0,
//                0,       0,    0, 1, 0,

//                0,1,0,0,0,
//                1,0,0,0,0,
//                0,0,1,0,0,
//                0,0,0,1,0

                1/2f,1/2f,1/2f,0,0,
                1/3f,1/3f,1/3f,0,0,
                1/4f,1/4f,1/4f,0,0,
                0,0,0,1,0
        });
//        ColorMatrix colorMatrix = new ColorMatrix();
//        colorMatrix.setScale(1,1.3f,1,1);
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth()), mPaint);
        canvas.restore();

    }
}
