package com.template.customview;

import android.animation.TypeEvaluator;
import android.graphics.Point;

class FallingBallEvaluator implements TypeEvaluator<Point> {
    private Point point=new Point();

    @Override
    public Point evaluate(float v, Point start, Point t1) {
        point.x=(int)(start.x+v*(t1.x-start.x));
        if (v*2 <=1){
            point.y=(int)(start.y+v*2*(t1.y+start.y));
        }else {
            point.y=t1.y;
        }
        return point;
    }
}
