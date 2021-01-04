package com.template.customview;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter4Activity extends AppCompatActivity {

    private LinearLayout linearLayoutContainer;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_d);
        setTitle("Chapter4Activity");

        Button btn =findViewById(R.id.btn);
        TextView tv=findViewById(R.id.tv_d);
        TextView tv_my=findViewById(R.id.tv_my);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                PropertyValuesHolder rotationHolder=PropertyValuesHolder.ofFloat("Rotation",60f,-60f,40f,-40f,-20f,20f,10f,-10f,0f);
//                PropertyValuesHolder alphaHolder=PropertyValuesHolder.ofFloat("alpha",0.1f,1f,0.1f,1f);
//                ObjectAnimator animator=ObjectAnimator.ofPropertyValuesHolder(tv,rotationHolder,alphaHolder);
//                animator.setDuration(2000);
//                animator.start();

//                PropertyValuesHolder charHolder=PropertyValuesHolder.ofObject("CharText",new CharEvaluator(),new Character('A'),new Character('Z'));
//                ObjectAnimator animator=ObjectAnimator.ofPropertyValuesHolder(tv_my,charHolder);
//                animator.setDuration(2000);
//                animator.setInterpolator(new AccelerateInterpolator());
//                animator.start();

                Keyframe frame0 = Keyframe.ofFloat(0f, 0);
                Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
                Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
                Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
                Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
                Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
                Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
                Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
                Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
                Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
                Keyframe frame10 = Keyframe.ofFloat(1, 0);
                PropertyValuesHolder frameHolder1 = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10);
//                Animator animator=ObjectAnimator.ofPropertyValuesHolder(tv_my,frameHolder1);
//                animator.setDuration(1000);
//                animator.start();

//                Keyframe frame0 = Keyframe.ofFloat(0f, 0);
//                Keyframe frame1 = Keyframe.ofFloat(0.5f, 100f);
//                Keyframe frame2 = Keyframe.ofFloat(1);
//                frame2.setValue(0f);
//                frame2.setInterpolator(new BounceInterpolator());
//                PropertyValuesHolder frameHolder1 = PropertyValuesHolder.ofKeyframe("rotation",frame0, frame1, frame2);
//                Animator animator=ObjectAnimator.ofPropertyValuesHolder(tv_my,frameHolder1);
//                animator.setDuration(3000);
//                animator.start();

//                Keyframe frame0 = Keyframe.ofObject(0f, new Character('A'));
//                Keyframe frame1 = Keyframe.ofObject(0.1f, new Character('L'));
//                Keyframe frame2 = Keyframe.ofObject(1,new Character('Z'));
//                PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("CharText",frame0,frame1,frame2);
//                frameHolder.setEvaluator(new CharEvaluator());
//                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(tv_my,frameHolder);
//                animator.setDuration(3000);
//                animator.start();

                Keyframe fcaleXframe0 = Keyframe.ofFloat(0f, 1);
                Keyframe fcaleXframe1 = Keyframe.ofFloat(0.1f, 1.1f);
                Keyframe fcaleXframe9 = Keyframe.ofFloat(0.9f,1.1f);
                Keyframe fcaleXframe10 = Keyframe.ofFloat(1,1);
                PropertyValuesHolder frameHolder2 = PropertyValuesHolder.ofKeyframe("ScaleX",fcaleXframe0, fcaleXframe1, fcaleXframe9,fcaleXframe10);
                Keyframe fcaleYframe0 = Keyframe.ofFloat(0f, 1);
                Keyframe fcaleYframe1 = Keyframe.ofFloat(0.1f, 1.1f);
                Keyframe fcaleYframe9 = Keyframe.ofFloat(0.9f,1.1f);
                Keyframe fcaleYframe10 = Keyframe.ofFloat(1,1);
                PropertyValuesHolder frameHolder3 = PropertyValuesHolder.ofKeyframe("ScaleY",fcaleYframe0, fcaleYframe1, fcaleYframe9,fcaleYframe10);
                Animator animator=ObjectAnimator.ofPropertyValuesHolder(tv_my,frameHolder1,frameHolder2,frameHolder3);
                animator.setDuration(1000);
                animator.start();

            }
        });

        Button btn2 =findViewById(R.id.btn_d);
        TextView tv2=findViewById(R.id.tv_d_2);
        TextView tv3=findViewById(R.id.tv_d_3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                tv2.animate().scaleY(2);
//                tv3.animate().scaleYBy(2);

                tv2.animate().scaleX(2).scaleY(2).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        Log.e("zzz","onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.e("zzz","onAnimationEnd");
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {
                        Log.e("zzz","onAnimationCancel");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {
                        Log.e("zzz","onAnimationRepeat");
                    }
                });
            }
        });

        Button btn_add =findViewById(R.id.add_btn);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addButtonView();
            }
        });
        Button btn_remove =findViewById(R.id.remove_btn);
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeButtonView();
            }
        });
         linearLayoutContainer=findViewById(R.id.linearlayoutcontainer);

//        LayoutTransition transition=new LayoutTransition();
//        ObjectAnimator animator=ObjectAnimator.ofFloat(null,"rotationY",0f,360f,0f);
//        transition.setAnimator(LayoutTransition.APPEARING,animator);
//        ObjectAnimator animOut=ObjectAnimator.ofFloat(null,"rotation",0f,90f,0f);
//        transition.setAnimator(LayoutTransition.DISAPPEARING,animOut);
//        linearLayoutContainer.setLayoutTransition(transition);

//        LayoutTransition transition=new LayoutTransition();
//        PropertyValuesHolder pvhLeft=PropertyValuesHolder.ofInt("left",0,0);
//        PropertyValuesHolder pvhTop=PropertyValuesHolder.ofInt("top",0,0);
//        PropertyValuesHolder pvhScaleX=PropertyValuesHolder.ofFloat("scaleX",1f,0f,1f);
//        Animator changeAppearAnimator=ObjectAnimator.ofPropertyValuesHolder(linearLayoutContainer,pvhLeft,pvhTop,pvhScaleX);
//        transition.setAnimator(LayoutTransition.CHANGE_APPEARING,changeAppearAnimator);
//        linearLayoutContainer.setLayoutTransition(transition);

        LayoutTransition transition = new LayoutTransition();
        @SuppressLint("ObjectAnimatorBinding")
        PropertyValuesHolder outLeft = PropertyValuesHolder.ofInt("left", 0, 0);
        @SuppressLint("ObjectAnimatorBinding")
        PropertyValuesHolder outTop = PropertyValuesHolder.ofInt("top", 0, 0);
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe frame10 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder mPropertyValuesHolder = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10);
        ObjectAnimator mObjectAnimatorChangeDisAppearing = ObjectAnimator.ofPropertyValuesHolder(this, outLeft, outTop, mPropertyValuesHolder);
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, mObjectAnimatorChangeDisAppearing);
        linearLayoutContainer.setLayoutTransition(transition);
        transition.addTransitionListener(new LayoutTransition.TransitionListener() {
            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

                Log.e("zzz", "start:" + "transitionType:" + transitionType + "count:" + container.getChildCount() + "view:" + view.getClass().getName());
            }

            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                Log.e("zzz", "end:" + "transitionType:" + transitionType + "count:" + container.getChildCount() + "view:" + view.getClass().getName());
            }
        });

    }

    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        linearLayoutContainer.addView(button, 0);
    }

    private void removeButtonView() {
        if (i > 0) {
            linearLayoutContainer.removeViewAt(0);
        }
        i--;
    }

}