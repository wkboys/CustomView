package com.template.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.chapter1)
    Button chapter1;
    @BindView(R.id.chapter2)
    Button chapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.chapter1, R.id.chapter2, R.id.chapter3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.chapter1:
                startActivity(new Intent(MainActivity.this, Chapter1Activity.class));
                break;
            case R.id.chapter2:
                startActivity(new Intent(MainActivity.this, Chapter2Activity.class));
                break;
            case R.id.chapter3:
                startActivity(new Intent(MainActivity.this, Chapter3Activity.class));
                break;
        }
    }

}