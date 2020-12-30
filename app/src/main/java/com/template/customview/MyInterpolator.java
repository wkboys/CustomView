package com.template.customview;

import android.animation.TimeInterpolator;

class MyInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float imput) {
        return 1-imput;
    }
}
