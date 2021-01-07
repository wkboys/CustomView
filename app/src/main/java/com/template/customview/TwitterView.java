package com.template.customview;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;


public class TwitterView extends View {
    private Paint mBitPaint;
    private Bitmap BmpDST,BmpSRC;
    public TwitterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mBitPaint = new Paint();
        BmpDST = BitmapFactory.decodeResource(getResources(), R.drawable.twiter_bg, null);
        BmpSRC = BitmapFactory.decodeResource(getResources(),R.drawable.twiter_light,null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();

        canvas.drawBitmap(BmpDST,0,0,mBitPaint);
        mBitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(BmpSRC,0,0,mBitPaint);

        mBitPaint.setXfermode(null);
        canvas.restore();
    }
}