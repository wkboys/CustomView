package com.template.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

class EraserView_SRCOUT extends View {

    private Paint mBitPaint;
    private Bitmap BmpDst,BmpSrc,BmpText;
    private Path mPath;
    private float mPreX,mPreY;

    public EraserView_SRCOUT(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        mBitPaint=new Paint();
        mBitPaint.setColor(Color.RED);
        mBitPaint.setStyle(Paint.Style.STROKE);
        mBitPaint.setStrokeWidth(45);

        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inSampleSize=2;
        BmpSrc=BitmapFactory.decodeResource(getResources(),R.drawable.dog,options);
        BmpDst=Bitmap.createBitmap(BmpSrc.getWidth(),BmpSrc.getHeight(),Bitmap.Config.ARGB_8888);
        BmpText=BitmapFactory.decodeResource(getResources(),R.drawable.guaguaka_text,null);
        mPath=new Path();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(),event.getY());
                mPreX=event.getX();
                mPreY=event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float endX=(mPreX+event.getX())/2;
                float endY=(mPreY+event.getY())/2;
                mPath.quadTo(mPreX,mPreY,endX,endY);
                mPreX=event.getX();
                mPreY=event.getY();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(BmpText,null,new RectF(0,0,BmpDst.getWidth(),BmpDst.getHeight()),mBitPaint);
        int layerId=canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        //先把手势轨迹滑到目标图像上
        Canvas c=new Canvas(BmpDst);
        c.drawPath(mPath,mBitPaint);
        //然后把图像目标画到画布上
        canvas.drawBitmap(BmpDst,0,0,mBitPaint);
        //计算原图像区域
        mBitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(BmpSrc,0,0,mBitPaint);
        mBitPaint.setXfermode(null);
        canvas.restoreToCount(layerId);

    }

}
