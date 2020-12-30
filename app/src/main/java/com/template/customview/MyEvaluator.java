package com.template.customview;

import android.animation.TypeEvaluator;

class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt=startValue;
//        return (int)(200+startInt+fraction*(endValue-startInt));
        return (int)(endValue-fraction*(endValue-startInt));
    }
}
