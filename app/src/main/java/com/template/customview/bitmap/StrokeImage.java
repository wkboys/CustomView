package com.template.customview.bitmap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
class StrokeImage extends ImageView {
    public StrokeImage(Context context) {
        super(context);
    }

    public StrokeImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StrokeImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Paint p=new Paint();
        p.setColor(Color.CYAN);
        setStateDrawable(this, p);

    }

    private void setStateDrawable(ImageView v, Paint paint) {
        //拿到原图片
        BitmapDrawable bd= (BitmapDrawable) v.getDrawable();
        Bitmap srcbmp=bd.getBitmap();
        //制作纯色背景
        Bitmap bitmap= Bitmap.createBitmap(srcbmp.getWidth(),srcbmp.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        canvas.drawBitmap(srcbmp.extractAlpha(),0,0,paint);
        //增加状态
        StateListDrawable sld=new StateListDrawable();
        sld.addState(new int[]{android.R.attr.state_pressed},new BitmapDrawable(bitmap));
        //设置背景会移除padding 需重新设置
        v.setBackgroundDrawable(sld);

    }


}
