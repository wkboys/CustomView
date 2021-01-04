package com.template.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
class MyTextView extends TextView {


    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCharText(Character character){
        setText(String.valueOf(character));
    }
}
