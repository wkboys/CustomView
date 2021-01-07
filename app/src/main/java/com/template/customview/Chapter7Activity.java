package com.template.customview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_g);
        setTitle("Chapter7Activity");
        ShadowLayerView shadowLayerView=findViewById(R.id.shadow);
        Button add=findViewById(R.id.add_black);
        Button delete=findViewById(R.id.delete_black);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shadowLayerView.setShadow(true);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shadowLayerView.setShadow(false);
            }
        });
        TextView tv=findViewById(R.id.tv_lay);
        tv.setShadowLayer(3,5,5, Color.RED);
    }
}