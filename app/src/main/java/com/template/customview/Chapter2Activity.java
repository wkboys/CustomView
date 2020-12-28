package com.template.customview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_b);
        setTitle("Chapter2Activity");
    }
}