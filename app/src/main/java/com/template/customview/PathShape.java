package com.template.customview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;

class PathShape extends Shape {
    private Path mPath;
    private float mStdWidth;
    private float mStdHeight;
    private float mScaleX;
    private float mScaleY;

    public PathShape(Path path,float stdWidth,float stdHeignt){
        mPath=path;
        mStdWidth=stdWidth;
        mStdHeight=stdHeignt;

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.scale(mScaleX,mScaleY);
        canvas.drawPath(mPath,paint);
        canvas.restore();

    }

    @Override
    protected void onResize(float width, float height) {
        mScaleX=width/mStdWidth;
        mScaleY=height/mStdHeight;
    }
}
