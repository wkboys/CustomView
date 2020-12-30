package com.template.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
class CustomTextView extends TextView {
    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScaleSize(float num){
        setScaleX(num);
    }

    public float getScaleSize(){
        return 0.5f;
    }
}
