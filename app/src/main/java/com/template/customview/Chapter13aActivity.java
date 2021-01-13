package com.template.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Chapter13aActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private Button mCreateWndBtn, mRmvWndBtn;

    private ImageView mImageView;
    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_m_a);
        setTitle("Chapter13(1)Activity");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,Uri.parse("package:" + getPackageName()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivityForResult(intent, 100);
        } else {
            initView();
        }
    }

    private void initView() {
        mCreateWndBtn = (Button) findViewById(R.id.add_btn);
        mRmvWndBtn = (Button) findViewById(R.id.rmv_btn);
        mCreateWndBtn.setOnClickListener(this);
        mRmvWndBtn.setOnClickListener(this);

        mWindowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
    }

    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_btn) {
            mImageView = new ImageView(this);
            mImageView.setBackgroundResource(R.mipmap.ic_launcher);

            mLayoutParams = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 2099,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                            | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    ,
                    PixelFormat.TRANSPARENT);
            mLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            mLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
            mLayoutParams.x = 0;
            mLayoutParams.y = 300;
            mImageView.setOnTouchListener(this);
            mWindowManager.addView(mImageView, mLayoutParams);
        } else if (v.getId() == R.id.rmv_btn) {
            mWindowManager.removeViewImmediate(mImageView);
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE: {
                mLayoutParams.x = rawX-50;
                mLayoutParams.y = rawY-120;
                mWindowManager.updateViewLayout(mImageView, mLayoutParams);
                break;
            }
            default:
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        try {
            if (mWindowManager!=null)
            mWindowManager.removeView(mImageView);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            initView();
        }
    }

}