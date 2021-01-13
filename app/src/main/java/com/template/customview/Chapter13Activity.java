package com.template.customview;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter13Activity extends AppCompatActivity implements View.OnTouchListener {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_m);
        setTitle("Chapter13Activity");

//        gestureDetector = new GestureDetector(new gestureListener());
//        gestureDetector.setOnDoubleTapListener(new doubleTapListener());
        TextView tv=findViewById(R.id.tv);
        tv.setOnTouchListener(this);
        tv.setClickable(true);
        tv.setLongClickable(true);

        gestureDetector = new GestureDetector(new simpleGestureListener());
        tv.setFocusable(true);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private class gestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Log.e("zzz","onDown");
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Log.e("zzz","onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.e("zzz","onSingleTapUp");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.e("zzz","onScroll:"+(motionEvent1.getX()-motionEvent.getX())+" distanceX");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Log.e("zzz","onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Log.e("zzz","onFling");
            return true;
        }
    }

    private class doubleTapListener implements GestureDetector.OnDoubleTapListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Log.e("zzz","onSingleTapConfirmed");
            Toast.makeText(Chapter13Activity.this,"onSingleTapConfirmed",Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.e("zzz","onDoubleTap");
            Toast.makeText(Chapter13Activity.this,"onDoubleTap",Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            Log.e("zzz","onDoubleTapEvent;"+motionEvent.getAction());
            Toast.makeText(Chapter13Activity.this,"onDoubleTapEvent",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{

        final int FLING_MIN_DISTANCE=100,FLING_MIN_VELOCITY=200;

        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX()-e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX)> FLING_MIN_VELOCITY){
                Log.e("zzz","Fling left");
                Toast.makeText(Chapter13Activity.this,"Fling left",Toast.LENGTH_SHORT).show();
            }else if (e2.getX()-e1.getX() > FLING_MIN_DISTANCE &&  Math.abs(velocityX)> FLING_MIN_VELOCITY){
                Log.e("zzz","Fling right");
                Toast.makeText(Chapter13Activity.this,"Fling right",Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return true;
        }
    }
}