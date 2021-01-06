package com.template.customview;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

public class Chapter5Activity extends AppCompatActivity {

    static {
        //可加可不加
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_e);
        setTitle("Chapter5Activity");
        ImageView iv=findViewById(R.id.iv);
        AnimatedVectorDrawableCompat compat=AnimatedVectorDrawableCompat.create(this,R.drawable.line_animated_vector);
        iv.setImageDrawable(compat);
        ((Animatable)iv.getDrawable()).start();

        final ImageView imageView = (ImageView) findViewById(R.id.anim_img);
        //将焦点放在ImageView上
        imageView.setFocusable(true);
        imageView.setFocusableInTouchMode(true);
        imageView.requestFocus();
        imageView.requestFocusFromTouch();
        EditText editText = (EditText)findViewById(R.id.edit);

        //当EditText获得焦点时开始动画
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){

                    AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                            Chapter5Activity.this, R.drawable.animated_vecotr_search
                    );
                    imageView.setImageDrawable(animatedVectorDrawableCompat);
                    ((Animatable) imageView.getDrawable()).start();
                }
            }
        });


    }
}