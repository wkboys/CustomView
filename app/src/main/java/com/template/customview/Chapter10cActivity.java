package com.template.customview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter10cActivity extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_j_c);
        setTitle("Chapter10(3)Activity");

        ImageView iv_1 = (ImageView) findViewById(R.id.img1);
        ImageView iv_2 = (ImageView) findViewById(R.id.img2);

        Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.cat);
        iv_1.setImageBitmap(bmp);

        //压缩图像后,显示
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 1, bos);
        byte[] bytes = bos.toByteArray();
        Bitmap bmp1 = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        iv_2.setImageBitmap(bmp1);


        ImageView iv_3 = (ImageView) findViewById(R.id.img3);
        ImageView iv_4 = (ImageView) findViewById(R.id.img4);


        ByteArrayOutputStream bos3 = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 1, bos3);

        byte[] bytes3 = bos3.toByteArray();
        Bitmap bmp3 = BitmapFactory.decodeByteArray(bytes3, 0, bytes3.length);

        iv_3.setImageBitmap(bmp3);


        ByteArrayOutputStream bos4 = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.WEBP, 1, bos4);

        byte[] bytes4 = bos4.toByteArray();
        Bitmap bmp4 = BitmapFactory.decodeByteArray(bytes4, 0, bytes4.length);

        iv_4.setImageBitmap(bmp4);

//        mergeTwoBit(iv_3, iv_4);
    }

    private void mergeTwoBit(ImageView iv_3, ImageView iv_4) {
        iv_3.setVisibility(View.GONE);
        iv_4.setVisibility(View.GONE);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        Bitmap watermark = BitmapFactory.decodeResource(getResources(), R.drawable.watermark);
        Bitmap result = createBitmap(bitmap, watermark);

        ImageView imageView = (ImageView) findViewById(R.id.img);
        imageView.setImageBitmap(result);
    }

    private Bitmap createBitmap(Bitmap src, Bitmap watermark) {
        if (src == null) {
            return null;
        }

        int w = src.getWidth();
        int h = src.getHeight();
        int ww = watermark.getWidth();
        int wh = watermark.getHeight();
        //创建空白图像
        Bitmap newb = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);//创建一个新的和SRC长度宽度一样的位图
        Canvas cv = new Canvas(newb);
        //画原图
        cv.drawBitmap(src, 0, 0, null);//在 0，0坐标开始画入src
        //在src的右下角画入水印
        cv.drawBitmap(watermark, w - ww + 5, h - wh + 5, null);
        return newb;
    }
    /**
     * 保存文件到手机SD卡根目录中
     */
    private void saveBmp(Bitmap bitmap) {
        File fileDir = Environment.getExternalStorageDirectory();
        String path = fileDir.getAbsolutePath() + "/lavor.webp";

        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.WEBP, 10, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}