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

class GetSegmentView extends View {

    private Paint mPaint;
    private final Path mDstPath;
    private final Path mCirclePath;
    private final PathMeasure mPathMeasure;
    private Float mCurAnimValue;


    public GetSegmentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        mPaint.setColor(Color.BLACK);

        mDstPath = new Path();
        mCirclePath = new Path();
        mCirclePath.addCircle(150,150,100,Path.Direction.CW);
        mPathMeasure = new PathMeasure(mCirclePath,true);

        ValueAnimator animator=ValueAnimator.ofFloat(0,1);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurAnimValue = (Float) animator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.translate(100,100);
//        Path path=new Path();
////        path.addRect(-50,-50,50,50,Path.Direction.CCW);
//        path.addRect(-50,-50,50,50,Path.Direction.CW);
//        Path dst=new Path();
//        dst.lineTo(10,100);
//        PathMeasure measure=new PathMeasure(path,false);
////        measure.getSegment(0,150,dst,true);
//        measure.getSegment(0,150,dst,false);
//        canvas.drawPath(dst,mPaint);

//        canvas.drawColor(Color.WHITE);
//        float stop=mPathMeasure.getLength()*mCurAnimValue;
//        mDstPath.reset();
//        mPathMeasure.getSegment(0,stop,mDstPath,true);
//        canvas.drawPath(mDstPath,mPaint);

        float length = mPathMeasure.getLength();
        float stop = length * mCurAnimValue;
        float start = (float) (stop - ((0.5 - Math.abs(mCurAnimValue - 0.5)) * length));
        mDstPath.reset();
        canvas.drawColor(Color.WHITE);
        mPathMeasure.getSegment(start, stop, mDstPath, true);
//        mPathMeasure.getSegment(0, stop, mDstPath, true);
        canvas.drawPath(mDstPath, mPaint);

    }
}
