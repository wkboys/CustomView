package com.template.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

class ShapeView extends View {
    private ShapeDrawable mShapeDrawable;
    public ShapeView(Context context) {
        super(context);
        init();
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
//        mShapeDrawable=new ShapeDrawable(new RectShape());
//        mShapeDrawable=new ShapeDrawable(new OvalShape());
//        mShapeDrawable=new ShapeDrawable(new ArcShape(0,300 ));

//        float[] outerR=new float[]{12,12,12,12,0,0,0,0};
//        RectF inset=new RectF(6,6,6,6);
//        float[] innerR=new float[]{50,12,0,0,12,50,0,0};
//        mShapeDrawable=new ShapeDrawable(new RoundRectShape(outerR,inset,innerR));

//        Path path=new Path();
//        path.moveTo(0,0);
//        path.lineTo(100,0);
//        path.lineTo(100,100);
//        path.lineTo(0,100);
//        path.close();
////        mShapeDrawable=new ShapeDrawable(new PathShape(path,100,100));
//        mShapeDrawable=new ShapeDrawable(new PathShape(path,100,200));
//        mShapeDrawable.setBounds(new Rect(0,0,250,150));

        Rect rect1=new Rect(50,0,90,150);
        Rect rect2=new Rect(0,50,250,100);
        Region region=new Region(rect1);
        Region region2=new Region(rect2);
        region.op(region2,Region.Op.XOR);
        mShapeDrawable=new ShapeDrawable(new RegionShape(region));
        mShapeDrawable.setBounds(new Rect(0,0,250,150));

//        mShapeDrawable.setBounds(new Rect(50,50,200,100));
        mShapeDrawable.getPaint().setColor(Color.YELLOW);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mShapeDrawable.draw(canvas);
    }
}
