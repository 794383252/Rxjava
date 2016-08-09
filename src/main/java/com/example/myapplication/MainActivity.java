package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.android_rx.rxUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 调用create方法
     *
     * @param view
     */
    public void createMethon(View view) {
        rxUtils.createObservable();
    }

    public void createMethon2(View view) {
        rxUtils.createPrint();
    }

    public void from(View view) {
        rxUtils.from();
    }

    public void interval(View view) {
        rxUtils.interval();
    }

    public void just(View view) {
        rxUtils.just();
    }

    public void range(View view) {
        rxUtils.range();
    }
    public void filter(View view)
    {
        rxUtils.filter();
    }
}
