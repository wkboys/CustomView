package com.template.customview;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Chapter10fActivity extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_j_f);
        setTitle("Chapter10(6)Activity");

    }
}