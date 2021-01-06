package com.template.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MetricsFont extends View {
    public MetricsFont(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);


        int baseLineY=200;
        int baseLineX=0;
        Paint paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(120);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("harvic\'s blog",baseLineX,baseLineY,paint);

        Paint.FontMetrics fm = paint.getFontMetrics();
        float ascent=baseLineY+fm.ascent;
        float descent=baseLineY+fm.descent;
        float top=baseLineY+fm.top;
        float bottom=baseLineY+fm.bottom;

        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX,baseLineY,3000,baseLineY,paint);
        paint.setColor(Color.BLUE);
        canvas.drawLine(baseLineX,top,3000,top,paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX,ascent,3000,ascent,paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX,descent,3000,descent,paint);
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX,bottom,3000,bottom,paint);

    }
}
