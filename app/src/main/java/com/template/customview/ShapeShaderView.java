package com.template.customview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

class ShapeShaderView extends View {

    private ShapeDrawable mSHareDrawable;

    public ShapeShaderView(Context context) {
        super(context);
        init();
    }


    public ShapeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShapeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mSHareDrawable=new ShapeDrawable(new RectShape());
        mSHareDrawable.setBounds(new Rect(100,100,1000,1000));
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.avator);
        BitmapShader bitmapShader=new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        mSHareDrawable.getPaint().setShader(bitmapShader);

        // 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1/2f,1/2f,1/2f,0,0,
                1/3f,1/3f,1/3f,0,0,
                1/4f,1/4f,1/4f,0,0,
                0,0,0,1,0
        });

//        mSHareDrawable.getPaint().setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        mSHareDrawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mSHareDrawable.draw(canvas);
    }
}
