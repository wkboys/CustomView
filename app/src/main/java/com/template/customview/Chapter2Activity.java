package com.template.customview;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_b);
        setTitle("Chapter2Activity");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv=findViewById(R.id.tv);
//                Animation  animation= AnimationUtils.loadAnimation(Chapter2Activity.this,
////                        R.anim.scaleanim3
////                        R.anim.scaleanim5
////                        R.anim.alphaanim
////                        R.anim.rotateanim
////                        R.anim.rotateanim2
////                        R.anim.translateanim
//                        R.anim.setanim
//                );
//                tv.startAnimation(animation);

//                ScaleAnimation scaleAnimation=new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                scaleAnimation.setDuration(700);
//                tv.startAnimation(scaleAnimation);

//                AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.1f);
//                alphaAnimation.setDuration(3000);
//                alphaAnimation.setFillBefore(true);
//                tv.startAnimation(alphaAnimation);

//                RotateAnimation rotateAnimation=new RotateAnimation(0,-650,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                rotateAnimation.setDuration(3000);
//                rotateAnimation.setFillAfter(true);
//                tv.startAnimation(rotateAnimation);

//                TranslateAnimation translateAnimation=new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,-80,Animation.ABSOLUTE,0,Animation.ABSOLUTE,-80);
//                translateAnimation.setDuration(2000);
//                translateAnimation.setFillBefore(true);
//                tv.startAnimation(translateAnimation);

                Animation alpha_Anim=new AlphaAnimation(0.1f,1.0f);
                Animation scale_Anim=new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                Animation rotate_Anim=new RotateAnimation(0,-650,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                AnimationSet setAnim=new AnimationSet(true);
                setAnim.addAnimation(alpha_Anim);
                setAnim.addAnimation(scale_Anim);
//                setAnim.addAnimation(rotate_Anim);
                setAnim.setDuration(3000);
                setAnim.setFillAfter(true);
                setAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        rotate_Anim.setDuration(3000);
                        tv.startAnimation(rotate_Anim);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                tv.startAnimation(setAnim);

            }
        });
    }
}