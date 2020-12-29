package com.template.customview;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
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

//                Animation alpha_Anim=new AlphaAnimation(0.1f,1.0f);
//                Animation scale_Anim=new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                Animation rotate_Anim=new RotateAnimation(0,-650,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                AnimationSet setAnim=new AnimationSet(true);
//                setAnim.addAnimation(alpha_Anim);
//                setAnim.addAnimation(scale_Anim);
////                setAnim.addAnimation(rotate_Anim);
//                setAnim.setDuration(3000);
//                setAnim.setFillAfter(true);
//                setAnim.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                        rotate_Anim.setDuration(3000);
//                        tv.startAnimation(rotate_Anim);
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
//                setAnim.setInterpolator(new AccelerateDecelerateInterpolator());
//                tv.startAnimation(setAnim);

                Animation rotataAnim=AnimationUtils.loadAnimation(Chapter2Activity.this,R.anim.rotateanim3);
//                rotataAnim.setInterpolator(new AccelerateDecelerateInterpolator());
//                rotataAnim.setInterpolator(new AccelerateInterpolator());
//                rotataAnim.setInterpolator(new DecelerateInterpolator());
//                rotataAnim.setInterpolator(new LinearInterpolator());
//                rotataAnim.setInterpolator(new BounceInterpolator());
//                rotataAnim.setInterpolator(new AnticipateInterpolator());
//                rotataAnim.setInterpolator(new OvershootInterpolator());
//                rotataAnim.setInterpolator(new AnticipateOvershootInterpolator());
                rotataAnim.setInterpolator(new CycleInterpolator(1));
                tv.startAnimation(rotataAnim);

                ImageView imageView=findViewById(R.id.img);
                ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f,1.2f,1.0f,1.2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setInterpolator(new BounceInterpolator());
                scaleAnimation.setDuration(6000);
                imageView.startAnimation(scaleAnimation);

                 ImageView lodimageView=findViewById(R.id.loading);
                RotateAnimation rotateAnimation=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                rotateAnimation.setDuration(2000);
                rotateAnimation.setInterpolator(new LinearInterpolator());
                lodimageView.startAnimation(rotateAnimation);

            }
        });
        final Animation animation1 = AnimationUtils.loadAnimation(Chapter2Activity.this,R.anim.scale_alpha_anim);
        final Animation animation2 = AnimationUtils.loadAnimation(Chapter2Activity.this,R.anim.scale_alpha_anim);
        final Animation animation3 = AnimationUtils.loadAnimation(Chapter2Activity.this,R.anim.scale_alpha_anim);
        final Animation animation4 = AnimationUtils.loadAnimation(Chapter2Activity.this,R.anim.scale_alpha_anim);

        final ImageView circle1 = (ImageView)findViewById(R.id.circle1);
        final ImageView circle2 = (ImageView)findViewById(R.id.circle2);
        final ImageView circle3 = (ImageView)findViewById(R.id.circle3);
        final ImageView circle4 = (ImageView)findViewById(R.id.circle4);

        findViewById(R.id.start_can).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                circle1.startAnimation(animation1);

                animation2.setStartOffset(600);
                circle2.startAnimation(animation2);

                animation3.setStartOffset(1200);
                circle3.startAnimation(animation3);

                animation4.setStartOffset(1800);
                circle4.startAnimation(animation4);
            }
        });
        ImageView frame_img = findViewById(R.id.frame_image);
        AnimationDrawable background = (AnimationDrawable) frame_img.getBackground();
        background.start();

        ImageView frame_img2 = findViewById(R.id.frame_image2);
        AnimationDrawable anim=new AnimationDrawable();
        for (int i = 1; i <= 14; i++) {
            int id = getResources().getIdentifier("list_icon_gif_playing" + i, "drawable", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            anim.addFrame(drawable, 60);
        }

        anim.setOneShot(false);
        frame_img2.setBackgroundDrawable(anim);
        anim.start();


    }
}