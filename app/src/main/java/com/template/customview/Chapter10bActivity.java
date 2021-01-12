package com.template.customview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter10bActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_j_b);
        setTitle("Chapter10(2)Activity");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avator);
        ImageView iv = findViewById(R.id.img);
        CustomDrawable drawable = new CustomDrawable(bitmap);
//        iv.setImageDrawable(drawable);

        TextView tv = findViewById(R.id.tv);
        tv.setBackgroundDrawable(drawable);

        Matrix matrix =new Matrix();
        matrix.setScale(2,1);

//        Bitmap src = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
////        Bitmap cutedBmp=Bitmap.createBitmap(src,src.getWidth()/3,src.getHeight()/3,src.getWidth()/3,src.getHeight()/3);
//        Bitmap cutedBmp=Bitmap.createBitmap(src,src.getWidth()/3,src.getHeight()/3,src.getWidth()/3,src.getHeight()/3,matrix,true);
//        iv.setImageBitmap(cutedBmp);

//        createBmpByColors(iv);

//        //一定要加 防止oom
//        try {
//            Bitmap src = BitmapFactory.decodeResource(getResources(), R.drawable.scenery);
//            Bitmap cutedBmp=Bitmap.createScaledBitmap(src,300,200,true);
//            iv.setImageBitmap(cutedBmp);
//        }catch (Exception e){
//
//        }

        //基本提取Alpha图像
        baseExtraAlpha();

        //发光效果
//        adVanceExtraAlpha();

        iv.setVisibility(View.GONE);
        setTwoBitmap();
        setGreen();
    }

    private void setGreen() {
        Bitmap srcBmp = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        ImageView iv1 = (ImageView) findViewById(R.id.img3);
        iv1.setImageBitmap(srcBmp);
        Bitmap desBmp = srcBmp.copy(Bitmap.Config.ARGB_8888, true);
        for (int h = 0; h < srcBmp.getHeight(); h++) {
            for (int w = 0; w < srcBmp.getWidth(); w++) {
                int originColor = srcBmp.getPixel(w, h);

                int red = (Color.red(originColor));
                int alpha = Color.alpha(originColor);
                int green = Color.green(originColor);
                int blue = Color.blue(originColor);

                if (green < 200) {
                    green += 30;
                }

                desBmp.setPixel(w, h, Color.argb(alpha, red, green, blue));
            }
        }
        ImageView iv2 = (ImageView) findViewById(R.id.img4);
        iv2.setImageBitmap(desBmp);
    }

    private void setTwoBitmap() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);

        ImageView iv1 = (ImageView) findViewById(R.id.img1);
        iv1.setImageBitmap(bitmap);
        int density = bitmap.getDensity();
        Log.d("qijian", "density:" + density + "  width:" + bitmap.getWidth() + " height:" + bitmap.getHeight());

        int scaledDensity = density * 2;
        bitmap.setDensity(scaledDensity);
        Log.d("qijian", "density:" + bitmap.getDensity() + "  width:" + bitmap.getWidth() + " height:" + bitmap.getHeight());
        ImageView iv2 = (ImageView) findViewById(R.id.img2);
        iv2.setImageBitmap(bitmap);
    }

    //基本提取Alpha图像
    private void baseExtraAlpha() {
        Bitmap srcBmp = BitmapFactory.decodeResource(getResources(), R.drawable.cat_dog);

        Bitmap bitmap = Bitmap.createBitmap(srcBmp.getWidth(), srcBmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        canvas.drawBitmap(srcBmp.extractAlpha(), 0, 0, paint);

        ImageView iv = (ImageView) findViewById(R.id.img);
        iv.setImageBitmap(bitmap);

        srcBmp.recycle();
    }

    //发光效果
    private void adVanceExtraAlpha() {
        Bitmap srcBmp = BitmapFactory.decodeResource(getResources(), R.drawable.cat_dog);
        //获取Alpha bitmap
        Paint alphaPaint = new Paint();
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(20, BlurMaskFilter.Blur.NORMAL);
        alphaPaint.setMaskFilter(blurMaskFilter);
        int[] offsetXY = new int[2];
        Bitmap alphaBmp = srcBmp.extractAlpha(alphaPaint, offsetXY);
        //创建Bitmap
        Bitmap bitmap = Bitmap.createBitmap(alphaBmp.getWidth(), alphaBmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        canvas.drawBitmap(alphaBmp, 0, 0, paint);
        //绘制源图像
        canvas.drawBitmap(srcBmp, -offsetXY[0], -offsetXY[1], null);
        //设置图像并回收没用的图像资源
        ImageView iv = (ImageView) findViewById(R.id.img);
        iv.setImageBitmap(bitmap);
        srcBmp.recycle();
    }

    public void createBmpByColors(ImageView iv){
        int windth=300,height=200;
        int[] colors=initColors(windth,height);
        Bitmap bitmap=Bitmap.createBitmap(colors,windth,height,Bitmap.Config.ARGB_8888);
        iv.setImageBitmap(bitmap);
    }

    private int[] initColors(int width,int height){
        int[] colors=new int[width*height];
        for (int y = 0; y < height ; y++) {
            for (int x = 0; x < width; x++) {
                int r= x*255/(width-1);
                int g=y*255/(width-1);
                int b=255-Math.min(r,g);
                int a=Math.max(r,g);
                colors[y*width+x]= Color.argb(a,r,g,b);
            }
        }
        return colors;
    }
}