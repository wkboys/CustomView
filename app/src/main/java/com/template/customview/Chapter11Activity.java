package com.template.customview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter11Activity extends AppCompatActivity {
    private SeekBar mSeekBar;
    private ImageView mImageView;
    private Bitmap mOriginBmp,mTempBmp;
    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_k);
        setTitle("Chapter11Activity");

        mImageView = (ImageView) findViewById(R.id.img);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        mOriginBmp = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        mTempBmp = Bitmap.createBitmap(mOriginBmp.getWidth(), mOriginBmp.getHeight(),
                Bitmap.Config.ARGB_8888);

//        mSeekBar.setMax(20);
//        mSeekBar.setProgress(1);
//        mSeekBar.setProgress(10);

        TextView tv = (TextView)findViewById(R.id.tv);
        tv.setText("色彩旋转(-180——180):");
        mSeekBar.setMax(360);
        mSeekBar.setProgress(180);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//                Bitmap bitmap = handleColorMatrixBmp(progress);
                Bitmap bitmap=handleColorRotateBmp(progress);
                mImageView.setImageBitmap(bitmap);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private Bitmap handleColorMatrixBmp(int progress) {
        // 创建一个相同尺寸的可变的位图区,用于绘制调色后的图片
        Canvas canvas = new Canvas(mTempBmp); // 得到画笔对象
        Paint paint = new Paint(); // 新建paint
        paint.setAntiAlias(true); // 设置抗锯齿,也即是边缘做平滑处理
        ColorMatrix mSaturationMatrix = new ColorMatrix();

        mSaturationMatrix.setSaturation(progress);

        paint.setColorFilter(new ColorMatrixColorFilter(mSaturationMatrix));// 设置颜色变换效果
        canvas.drawBitmap(mOriginBmp, 0, 0, paint); // 将颜色变化后的图片输出到新创建的位图区
        // 返回新的位图，也即调色处理后的图片
        return mTempBmp;
    }


    private Bitmap handleColorRotateBmp(int progress){

        // 创建一个相同尺寸的可变的位图区,用于绘制调色后的图片
        Canvas canvas = new Canvas(mTempBmp); // 得到画笔对象
        Paint paint = new Paint(); // 新建paint
        paint.setAntiAlias(true); // 设置抗锯齿,也即是边缘做平滑处理
        ColorMatrix colorMatrix = new ColorMatrix();

        colorMatrix.setRotate(0,progress-180);

        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));// 设置颜色变换效果
        canvas.drawBitmap(mOriginBmp, 0, 0, paint); // 将颜色变化后的图片输出到新创建的位图区
        // 返回新的位图，也即调色处理后的图片
        return mTempBmp;
    }
}