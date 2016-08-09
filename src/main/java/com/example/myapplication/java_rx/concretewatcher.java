package com.example.myapplication.java_rx;

/**
 * Created by Administrator on 2016/8/8.
 */
public class concretewatcher implements watcher {
    @Override
    public void updata(String str) {
        System.out.print(str);
    }
}
