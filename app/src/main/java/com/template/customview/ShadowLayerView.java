package com.template.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

class ShadowLayerView extends View {

    private Paint mPaint=new Paint();
    private Bitmap mDogBmp;
    private boolean mSetShadow=true;

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(25);
        mDogBmp= BitmapFactory.decodeResource(getResources(),R.drawable.dog_edge);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mSetShadow){
            mPaint.setShadowLayer(1,10,10,Color.GRAY);
        }else {
            mPaint.clearShadowLayer();
        }
        canvas.drawColor(Color.WHITE);
        canvas.drawText("嘻嘻嘻",100,100,mPaint);
        canvas.drawCircle(300,100,50,mPaint);
        canvas.drawBitmap(mDogBmp,null,new Rect(500,50,500+mDogBmp.getWidth(),50+mDogBmp.getHeight()),mPaint);


    }

    public void setShadow(boolean showShadow){
        mSetShadow=showShadow;
        postInvalidate();
    }


}
