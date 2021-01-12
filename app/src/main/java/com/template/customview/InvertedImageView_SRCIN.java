package com.template.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

class InvertedImageView_SRCIN extends View {
    private Paint mBitPaint;
    private Bitmap BmpDST,BmpSRC,BmpRevert;
    public InvertedImageView_SRCIN(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        mBitPaint=new Paint();
        BmpDST= BitmapFactory.decodeResource(getResources(),R.drawable.dog_invert_shade,null);
        BmpSRC=BitmapFactory.decodeResource(getResources(),R.drawable.dog,null);
        Matrix matrix=new Matrix();
        matrix.setScale(1F,-1F);
        BmpRevert=Bitmap.createBitmap(BmpSRC,0,0,BmpSRC.getWidth(),BmpSRC.getHeight(),matrix,true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width=getWidth()/2;
        int height=width * BmpDST.getHeight()/BmpDST.getWidth();
        //画出小狗图像
        canvas.drawBitmap(BmpSRC,null,new RectF(0,0,width,height),mBitPaint);
        //下移画布 画出倒影
        int layoutId=canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        canvas.translate(0,height);

        canvas.drawBitmap(BmpDST,null,new RectF(0,0,width,height),mBitPaint);
        mBitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(BmpRevert,null,new RectF(0,0,width,height),mBitPaint);
        mBitPaint.setXfermode(null);
        canvas.restoreToCount(layoutId);
    }
}
