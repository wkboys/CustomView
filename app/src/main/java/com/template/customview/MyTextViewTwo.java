package com.template.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
class MyTextViewTwo extends TextView {

    public MyTextViewTwo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.MyTextViewTwo);
        float headerHeight = typedArray.getDimension(R.styleable.MyTextViewTwo_headerHeigt, -1);
        int age=typedArray.getInt(R.styleable.MyTextViewTwo_age,-1);
        typedArray.recycle();

        this.setText("headerHeight:"+headerHeight+ " age:"+age);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight= MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        Log.e("zzz","measureWidth="+measureWidth+" measureHeight="+measureHeight+
                " measureWidthMode="+measureWidthMode +" measureHeightMode="+measureHeightMode);
        Log.e("zzz",   "MeasureSpec.AT_MOST="+MeasureSpec.AT_MOST+"  MeasureSpec.EXACTLY="+
                MeasureSpec.EXACTLY+" MeasureSpec.UNSPECIFIED="+MeasureSpec.UNSPECIFIED);
    }
}
