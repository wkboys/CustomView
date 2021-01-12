package com.template.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

class SaveLayerUseExample extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    public SaveLayerUseExample(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mBitmap=BitmapFactory.decodeResource(getResources(),R.drawable.dog);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap,0,0,mPaint);

//        int layerID=canvas.saveLayer(0,0,getWidth(),getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);
//        canvas.skew(1.732f,0);
//        canvas.drawRect(0,0,150,160,mPaint);
//        canvas.restoreToCount(layerID);

//        int layerID=canvas.saveLayer(0,0,200,200,mPaint,Canvas.ALL_SAVE_FLAG);
//        canvas.drawColor(Color.GRAY);
//        canvas.restoreToCount(layerID);

        int layerID=canvas.saveLayerAlpha(0,0,200,200,100,Canvas.ALL_SAVE_FLAG);
        canvas.drawColor(Color.WHITE);
        canvas.restoreToCount(layerID);

    }
}
