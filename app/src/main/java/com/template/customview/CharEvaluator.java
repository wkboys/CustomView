package com.template.customview;

import android.animation.TypeEvaluator;


public class CharEvaluator implements TypeEvaluator<Character> {
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt  = (int)startValue;
        int endInt = (int)endValue;
        int curInt = (int)(startInt + fraction *(endInt - startInt));
        char result = (char)curInt;
        return result;
    }
}
