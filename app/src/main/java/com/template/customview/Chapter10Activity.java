package com.template.customview;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_j);
        setTitle("Chapter10Activity");

        TextView tv=findViewById(R.id.shape_tv);
        findViewById(R.id.add_shape_corner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GradientDrawable drawable= (GradientDrawable) tv.getBackground();
                drawable.setCornerRadius(20);
            }
        });

    }
}