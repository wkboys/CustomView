package com.template.customview;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
class SimmerTextView extends TextView {
    private Paint mPaint;
    private int mDx;
    private LinearGradient mLinearGradient;
    public SimmerTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = getPaint();
        int length = (int) mPaint.measureText(getText().toString());
        createAnim(length);
        createLinearGradient(length);

    }
    private void createAnim(int length) {
        ValueAnimator animator = ValueAnimator.ofInt(0, 2 * length);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                mDx = (Integer) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(2000);
        animator.start();
    }

    private void createLinearGradient(int length) {
        mLinearGradient = new LinearGradient(-length, 0, 0, 0, new int[]{
                getCurrentTextColor(), 0xff00ff00, getCurrentTextColor()
        },
                new float[]{
                        0,
                        0.5f,
                        1
                },
                Shader.TileMode.CLAMP
        );
    }


    @Override
    protected void onDraw(Canvas canvas) {

        Matrix matrix = new Matrix();
        matrix.setTranslate(mDx, 0);
        mLinearGradient.setLocalMatrix(matrix);
        mPaint.setShader(mLinearGradient);

        super.onDraw(canvas);
    }


}
