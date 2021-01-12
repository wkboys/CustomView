package com.template.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

class TelescopeViews extends View {
    private Bitmap bitmap;
    private ShapeDrawable drawable;
    private static final int RADIUS=180;
    private static final int  FACTOR=3;
    private final Matrix matrix=new Matrix();

    public TelescopeViews(Context context) {
        super(context);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
    }

    public TelescopeViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       final int x= (int) event.getX();
       final int y= (int) event.getY();
       matrix.setTranslate(RADIUS - x * FACTOR,RADIUS-y*FACTOR);
       drawable.getPaint().getShader().setLocalMatrix(matrix);

       drawable.setBounds(x-RADIUS,y-RADIUS,x+RADIUS,y+RADIUS);
       invalidate();
        return true;

    }

    public TelescopeViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap==null){
            Bitmap bmp= BitmapFactory.decodeResource(getResources(),R.drawable.scenery);
            bitmap=Bitmap.createScaledBitmap(bmp,getWidth(),getHeight(),false);
            BitmapShader shader=new BitmapShader(Bitmap.createScaledBitmap(bitmap,bitmap.getWidth()*FACTOR,bitmap.getHeight()*FACTOR,true),
                    Shader.TileMode.CLAMP,    Shader.TileMode.CLAMP);
            drawable=new ShapeDrawable(new OvalShape());
            drawable.getPaint().setShader(shader);
            drawable.setBounds(0,0,RADIUS*2,RADIUS*2);

        }
        canvas.drawBitmap(bitmap,0,0,null);
        drawable.draw(canvas);
    }
}
