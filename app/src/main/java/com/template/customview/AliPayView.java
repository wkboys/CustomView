package com.template.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

class AliPayView extends View {

    private Paint mPaint;
    private final Path mDstPath;
    private final Path mCirclePath;
    private final PathMeasure mPathMeasure;
    private Float mCurAnimValue;

    private int mCentX = 150;
    private int mCentY = 150;
    private int mRadius = 100;
    boolean mNext=false;

    public AliPayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.BLACK);

        mDstPath = new Path();
        mCirclePath = new Path();

        mCirclePath.addCircle(mCentX,mCentY,mRadius,Path.Direction.CW);
        mCirclePath.moveTo(mCentX-mRadius/2,mCentY);
        mCirclePath.lineTo(mCentX,mCentY+mRadius/2);
        mCirclePath.lineTo(mCentX+mRadius/2,mCentY-mRadius/3);

        mPathMeasure = new PathMeasure(mCirclePath,false);

        ValueAnimator animator=ValueAnimator.ofFloat(0,2);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurAnimValue = (Float) animator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(4000);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        if (mCurAnimValue<1){
           float stop= mPathMeasure.getLength()+mCurAnimValue;
           mPathMeasure.getSegment(0,stop,mDstPath,true);
        }else {
            if (!mNext){
                mNext=true;
                mPathMeasure.getSegment(0,mPathMeasure.getLength(),mDstPath,true);
                mPathMeasure.nextContour();
            }
            float stop = mPathMeasure.getLength() * (mCurAnimValue - 1);
            mPathMeasure.getSegment(0, stop, mDstPath, true);
        }
        canvas.drawPath(mDstPath, mPaint);

    }
}
