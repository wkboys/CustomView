package com.template.customview;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter3Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private ValueAnimator repeatAnimator;
    private AnimatorSet animatorSet;
    private boolean mIsMenuOpen=false;
    private Button mMenuButton;
    private Button mItemButton1;
    private Button mItemButton2;
    private Button mItemButton3;
    private Button mItemButton4;
    private Button mItemButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_c);
        setTitle("Chapter3Activity");
        tv = findViewById(R.id.tv);
        Button btn=findViewById(R.id.btn);
        ImageView ball_img = findViewById(R.id.ball_img);
        ImageView ball_img2 = findViewById(R.id.ball_img2);
        CustomTextView customTextView= findViewById(R.id.custom_text);
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
//                doAnimation();

//                repeatAnimator = doRepeatAnim();
//                ValueAnimator newAnimator = repeatAnimator.clone();
//                newAnimator.setDuration(1000);
//                newAnimator.start();

//                setInterpolator();

//                setEvaluator();

//                setArgbEvaluator();

//                setCharEvaluator();

//                setFallingBallEvaluator(ball_img);

//                setObject();

//                ObjectAnimator animator=ObjectAnimator.ofObject(ball_img2,"fallingPos",new FallingBallEvaluator(),new Point(0,0),new Point(500,500));
                ObjectAnimator animator=ObjectAnimator.ofFloat(customTextView,"ScaleSize",6);
                animator.setDuration(2000);
                animator.start();
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Chapter3Activity.this,"clicked me",Toast.LENGTH_SHORT).show();
            }
        });
        Button btn_cancel=findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeatAnimator!=null){
                    repeatAnimator.removeAllUpdateListeners();
                    repeatAnimator.cancel();
                }
            }
        });

        Button btn2=findViewById(R.id.btn2);
        TextView mTv1=findViewById(R.id.tv_1);
        TextView mTv2=findViewById(R.id.tv_2);
        btn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                ObjectAnimator tv1BgAnimator=ObjectAnimator.ofInt(mTv1,"BackgroundColor",0xffff00ff,0xffffff00,0xffff00ff);
                ObjectAnimator tv1TranslateY=ObjectAnimator.ofFloat(mTv1,"translationY",0,300,0);
                ObjectAnimator tv2TranslateY=ObjectAnimator.ofFloat(mTv2,"translationY",0,400,0);

//                tv1TranslateY.setStartDelay(2000);
//                tv1TranslateY.setRepeatCount(ValueAnimator.INFINITE);
//                tv2TranslateY.setStartDelay(2000);

//                tv1BgAnimator.setStartDelay(2000);
//                tv1TranslateY.setRepeatCount(ValueAnimator.INFINITE);

//                tv1BgAnimator.setRepeatCount(ValueAnimator.INFINITE);
//                tv1TranslateY.setRepeatCount(ValueAnimator.INFINITE);
//                tv2TranslateY.setRepeatCount(ValueAnimator.INFINITE);

                animatorSet = new AnimatorSet();
//                animatorSet.playSequentially(tv1BgAnimator,tv1TranslateY,tv2TranslateY);
//                animatorSet.playTogether(tv1BgAnimator,tv1TranslateY,tv2TranslateY);

//                AnimatorSet.Builder builder= animatorSet.play(tv1TranslateY);
//                builder.with(tv2TranslateY);
//                builder.after(tv1BgAnimator);

                animatorSet.addListener(new Animator.AnimatorListener() {
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

//                tv1TranslateY.setDuration(50000); 在set中单独设置Duration无效
//                animatorSet.setTarget(mTv2);  设置目标控件

                tv1TranslateY.setStartDelay(2000);
                tv2TranslateY.setStartDelay(2000);
//                animatorSet.play(tv1TranslateY).with(tv2TranslateY);
                animatorSet.play(tv2TranslateY).with(tv1TranslateY);
                animatorSet.setStartDelay(2000);//在set中设置StartDelay 不影响单个控件 开始时间与第一个动画延时无关

                animatorSet.setDuration(2000);
                animatorSet.start();


            }
        });
        Button btn2_cancel=findViewById(R.id.btn2_cancel);
        btn2_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (animatorSet!=null){
                    animatorSet.cancel();
                }
            }
        });

        initView();

       Button btn3= findViewById(R.id.btn3);
        TextView tv3 = findViewById(R.id.tv_3);
       btn3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
//               ValueAnimator valueAnimator= (ValueAnimator) AnimatorInflater.loadAnimator(Chapter3Activity.this,R.animator.value_animator);
//               valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                   @Override
//                   public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                       int offset= (int) valueAnimator.getAnimatedValue();
//                       tv3.layout(offset,offset,tv3.getWidth()+offset,tv3.getHeight()+offset);
//                   }
//               });
//               valueAnimator.start();

//               ObjectAnimator objectAnimator= (ObjectAnimator) AnimatorInflater.loadAnimator(Chapter3Activity.this,R.animator.object_animator);
//               objectAnimator.setTarget(tv3);
//               objectAnimator.start();

               AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(Chapter3Activity.this,
                       R.animator.set_animator);
               set.setTarget(tv3);
               set.start();


           }
       });
    }

    private void initView() {
        mMenuButton = (Button) findViewById(R.id.menu);
        mMenuButton.setOnClickListener(this);

        mItemButton1 = (Button) findViewById(R.id.item1);
        mItemButton1.setOnClickListener(this);

        mItemButton2 = (Button) findViewById(R.id.item2);
        mItemButton2.setOnClickListener(this);

        mItemButton3 = (Button) findViewById(R.id.item3);
        mItemButton3.setOnClickListener(this);

        mItemButton4 = (Button) findViewById(R.id.item4);
        mItemButton4.setOnClickListener(this);

        mItemButton5 = (Button) findViewById(R.id.item5);
        mItemButton5.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (!mIsMenuOpen) {
            mIsMenuOpen = true;
            openMenu();
        } else {
            Toast.makeText(this, "你点击了" + v, Toast.LENGTH_SHORT).show();
            mIsMenuOpen = false;
            closeMenu();
        }
    }

    private void openMenu() {
        doAnimateOpen(mItemButton1, 0, 5, 300);
        doAnimateOpen(mItemButton2, 1, 5, 300);
        doAnimateOpen(mItemButton3, 2, 5, 300);
        doAnimateOpen(mItemButton4, 3, 5, 300);
        doAnimateOpen(mItemButton5, 4, 5, 300);
    }

    private void closeMenu() {
        doAnimateClose(mItemButton1, 0, 5, 300);
        doAnimateClose(mItemButton2, 1, 5, 300);
        doAnimateClose(mItemButton3, 2, 5, 300);
        doAnimateClose(mItemButton4, 3, 5, 300);
        doAnimateClose(mItemButton5, 4, 5, 300);
    }

    /**
     * 打开菜单的动画
     *
     * @param view   执行动画的view
     * @param index  view在动画序列中的顺序,从0开始
     * @param total  动画序列的个数
     * @param radius 动画半径
     *               <p/>
     *               Math.sin(x):x -- 为number类型的弧度，角度乘以0.017(2π/360)可以转变为弧度
     */
    private void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / (total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        //动画周期为500ms
        set.setDuration(500).start();
    }

    /**
     * 关闭菜单的动画
     *
     * @param view   执行动画的view
     * @param index  view在动画序列中的顺序
     * @param total  动画序列的个数
     * @param radius 动画半径
     */
    private void doAnimateClose(final View view, int index, int total,
                                int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.1f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.1f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));
        /**
         * 解决方案二
         */
//        set.addListener(new Animator.AnimatorListener() {
//            public void onAnimationStart(Animator animation) {
//
//            }
//            public void onAnimationEnd(Animator animation) {
//                view.setScaleX(1.0f);
//                view.setScaleY(1.0f);
//
//            }
//
//            public void onAnimationCancel(Animator animation) {
//
//            }
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
        set.setDuration(500).start();
    }



    private void setObject() {
        //                ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"alpha",1,0,1);
//                ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"rotation",0,180,0);
//                ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"rotationX",0,270,0);
//                ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"rotationY",0,180,0);
//                ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"translationX",0,200,-200,0);
//                ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"translationY",0,200,-100,0);
//                ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"scaleX",0,3,1);
        ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"scaleY",0,3,1);
        animator.setDuration(2000);
        animator.start();
    }

    private void setFallingBallEvaluator(ImageView ball_img) {
        ValueAnimator animator=ValueAnimator.ofObject(new FallingBallEvaluator(),new Point(0,0),new Point(500,500));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Point mCurPoint= (Point) valueAnimator.getAnimatedValue();
                ball_img.layout(mCurPoint.x,mCurPoint.y,mCurPoint.x+ball_img.getWidth(),mCurPoint.y+ball_img.getHeight());
            }
        });
        animator.setDuration(2000);
        animator.start();
    }

    private void setCharEvaluator() {
        ValueAnimator animator=ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char text= (char) valueAnimator.getAnimatedValue();
                tv.setText(String.valueOf(text));
            }
        });
        animator.setDuration(10000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    private void setArgbEvaluator() {
        ValueAnimator animator=ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue= (int) valueAnimator.getAnimatedValue();
                tv.setBackgroundColor(curValue);
            }
        });
        animator.start();
    }

    private void setEvaluator() {
        ValueAnimator animator=ValueAnimator.ofInt(0,400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue= (int) valueAnimator.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
            }
        });
        animator.setDuration(1000);
        animator.setEvaluator(new MyEvaluator());
        animator.start();
    }

    private void setInterpolator() {
        ValueAnimator animator=ValueAnimator.ofInt(0,300);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue= (int) valueAnimator.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
            }
        });
        animator.setDuration(1000);
        animator.setInterpolator(new MyInterpolator());
        animator.start();
    }

    private ValueAnimator doRepeatAnim() {
        ValueAnimator animator=ValueAnimator.ofInt(0,400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue= (int) valueAnimator.getAnimatedValue();
                tv.layout(curValue,curValue,curValue+tv.getWidth(),curValue+tv.getHeight());
            }
        });
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        return animator;
    }

    private void doAnimation() {
//        ValueAnimator animator=ValueAnimator.ofInt(0,400);
//        animator.setDuration(1000);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (Integer) animation.getAnimatedValue();
//                tv.layout(curValue,curValue,curValue+tv.getWidth(),curValue+tv.getHeight());
//
//            }
//        });
//        animator.start();

        ValueAnimator animator=ValueAnimator.ofFloat(0f,400f,50f,300f);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator1) {
                Float curValueFloat = (Float) animator1.getAnimatedValue();
                int curValue = curValueFloat.intValue();
                tv.layout(curValue,curValue,curValue+tv.getWidth(),curValue+tv.getHeight());
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                Log.e("zzz","onAnimationCancel");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.e("zzz","onAnimationEnd");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                Log.e("zzz","onAnimationRepeat");
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.e("zzz","onAnimationStart");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();//关闭界面要         animator.cancel();
    }
}