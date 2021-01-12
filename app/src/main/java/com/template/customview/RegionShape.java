package com.template.customview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.drawable.shapes.Shape;

class RegionShape extends Shape {

    private Region mRegion;
    public RegionShape(Region region){
        assert (region!=null);
        mRegion=region;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        RegionIterator iter=new RegionIterator(mRegion);
        Rect r =new Rect();
        while (iter.next(r)){
            canvas.drawRect(r,paint);
        }
    }
}
