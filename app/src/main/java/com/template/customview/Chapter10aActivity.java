package com.template.customview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter10aActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_j_a);
        setTitle("Chapter10(1)Activity");

        TelescopeViews telescopeViews=findViewById(R.id.telescopeViews);
        telescopeViews.setVisibility(View.GONE);

        ImageView iv=findViewById(R.id.iv);

//        setByArray(iv);
//        setBySteam(iv);
        iv.setVisibility(View.GONE);

        //测试inJustDecodeBounds属性,获取图片宽高
        findViewById(R.id.injust_decode_bounds_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInJustDecodeBounds();
            }
        });

        //采样率
        findViewById(R.id.in_sample_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInSample();
            }
        });

        //7.5.3.4 inScaled
        findViewById(R.id.in_scaled_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInScaled();
            }
        });


        //7.5.3.4 inDensity、inTargetDensity
        findViewById(R.id.in_density_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInDensity();
            }
        });

        //7.5.3.5 inPreferredConfig
        findViewById(R.id.in_preferred_config_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInPreferredConfig();
            }
        });

    }


    //测试inJustDecodeBounds属性,获取图片宽高
    private void testInJustDecodeBounds() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, options);
        Log.d("qijian", "bitmap:" + bitmap);
        Log.d("qijian", "realwidth:" + options.outWidth + "   realheight:" + options.outHeight + "    mimeType:" + options.outMimeType);
        Toast.makeText(Chapter10aActivity.this, "realwidth:" + options.outWidth + "   realheight:" + options.outHeight + " mimeType:" + options.outMimeType
                , Toast.LENGTH_SHORT).show();
    }

    //测试采样率函数
    private void testInSample() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.scenery, options);

        ImageView iv = (ImageView) findViewById(R.id.img);
        int sampleSize = calSampleSize(options, iv.getWidth(), iv.getHeight());
        Toast.makeText(Chapter10aActivity.this, "sampleSize" + sampleSize, Toast.LENGTH_SHORT).show();


        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = sampleSize;
        try {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.scenery, options2);
            iv.setImageBitmap(bmp);
        } catch (OutOfMemoryError err) {
            //TODO OOM
        }
    }


    //dstWidth和dstHeight分别为目标ImageView的宽高
    public static int calSampleSize(BitmapFactory.Options options, int dstWidth, int dstHeight) {
        int rawWidth = options.outWidth;
        int rawHeight = options.outHeight;
        int inSampleSize = 1;
        if (rawWidth > dstWidth || rawHeight > dstHeight) {
            float ratioHeight = (float) rawHeight / dstHeight;
            float ratioWidth = (float) rawWidth / dstHeight;
            inSampleSize = (int) Math.min(ratioWidth, ratioHeight);
        }
        return inSampleSize;
    }

    //7.5.3.5 inPreferredConfig
    public void testInPreferredConfig() {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.scenery);
        String LogStr = "ARGB888_width:" + bmp.getWidth() + "  height:" + bmp.getHeight() + " 内存:" + bmp.getByteCount();
        Log.d("qijian", LogStr);
        Toast.makeText(Chapter10aActivity.this, LogStr, Toast.LENGTH_SHORT).show();


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.scenery, options);
        String LogStr2 = "ARGB565_width:" + bitmap.getWidth() + "  height:" + bitmap.getHeight() + " 内存:" + bitmap.getByteCount();
        Log.d("qijian", LogStr2);
        Toast.makeText(Chapter10aActivity.this, LogStr2, Toast.LENGTH_SHORT).show();
    }


    public void testInScaled() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.scenery);
        Log.d("qijian", "drawableBmp_width:" + bitmap.getWidth() + "  height:" + bitmap.getHeight() + " 内存:" + bitmap.getByteCount());
        Toast.makeText(Chapter10aActivity.this, "drawableBmp_width:" + bitmap.getWidth() + "  height:" + bitmap.getHeight() + " 内存:" + bitmap.getByteCount(),
                Toast.LENGTH_SHORT).show();


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap noScaleBmp = BitmapFactory.decodeResource(getResources(), R.drawable.scenery, options);
        Log.d("qijian", "drawableBmp_width:" + noScaleBmp.getWidth() + "  height:" + noScaleBmp.getHeight() + " 内存:" + noScaleBmp.getByteCount());
        Toast.makeText(Chapter10aActivity.this, "drawableBmp_width:" + noScaleBmp.getWidth() + "  height:" + noScaleBmp.getHeight() + " 内存:" + noScaleBmp.getByteCount(), Toast.LENGTH_SHORT).show();
    }


    public void testInDensity() {
        //从Drawable里读取
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = 1;
        options.inTargetDensity = 2;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.scenery, options);
        Log.d("qijian", "drawableBmp_width:" + bitmap.getWidth() + "  height:" + bitmap.getHeight() + " 内存:" + bitmap.getByteCount());

        //直接从文件中读取
        File file = Environment.getExternalStorageDirectory();
        String path = file.getAbsolutePath() + "/scenery.png";
        Bitmap bmp = BitmapFactory.decodeFile(path, options);
        if (bmp == null) {
            Toast.makeText(Chapter10aActivity.this, "请确保SD卡根目录存在scenery.png", Toast.LENGTH_SHORT).show();
        } else {
            String toastStr = "fileBmp_width:" + bmp.getWidth() + "  height:" + bmp.getHeight() + " 内存:" + bmp.getByteCount();
            Log.d("qijian", toastStr);
            Toast.makeText(Chapter10aActivity.this, toastStr, Toast.LENGTH_SHORT).show();
        }

    }


    private void setBySteam(ImageView iv) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream inputStream = getImageStream("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=205441424,1768829584&fm=26&gp=0.jpg");
                    final Bitmap bitMap = BitmapFactory.decodeStream(inputStream);

                    iv.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bitMap);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static InputStream getImageStream(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection httpURLconnection = (HttpURLConnection) url.openConnection();
        httpURLconnection.setRequestMethod("GET");
        httpURLconnection.setReadTimeout(6 * 1000);
        if (httpURLconnection.getResponseCode() == 200) {
            return httpURLconnection.getInputStream();

        }
        return null;
    }


    private void setByArray(ImageView iv) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] data = getImage("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=205441424,1768829584&fm=26&gp=0.jpg");
                    int length = data.length;

                    final Bitmap bitMap = BitmapFactory.decodeByteArray(data, 0, length);

                    iv.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bitMap);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static byte[] getImage(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection httpURLconnection = (HttpURLConnection) url.openConnection();
        httpURLconnection.setRequestMethod("GET");
        httpURLconnection.setReadTimeout(6 * 1000);
        InputStream in = null;
        if (httpURLconnection.getResponseCode() == 200) {
            in = httpURLconnection.getInputStream();
            byte[] result = readStream(in);
            in.close();
            return result;

        }
        return null;
    }

    public static byte[] readStream(InputStream in) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = in.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.close();
        in.close();
        return outputStream.toByteArray();
    }

}