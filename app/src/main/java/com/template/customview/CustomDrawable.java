package com.template.customview;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class CustomDrawable extends Drawable {
    private Paint mPaint;
    private Bitmap mBitmap;
    private BitmapShader bitmapShader;
    private RectF mBound;

    public CustomDrawable(Bitmap bitmap){
        mBitmap=bitmap;
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawRoundRect(mBound,20,20,mPaint);
    }

    @Override
    public void setAlpha(int i) {
        mPaint.setAlpha(i);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);

        bitmapShader=new BitmapShader(Bitmap.createScaledBitmap(mBitmap,right-left,bottom-top,true), Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        mPaint.setShader(bitmapShader);
        mBound=new RectF(left,top,right,bottom);

    }

//    @Override
//    public int getIntrinsicWidth() {
//        return mBitmap.getWidth();
//    }
//
//    @Override
//    public int getIntrinsicHeight() {
//        return mBitmap.getHeight();
//    }


}
