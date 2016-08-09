package com.example.myapplication.java_rx2;

import java.util.Observable;

/**
 * Created by Administrator on 2016/8/8.
 * 创建一个被观察者
 */
public class simpleObservable extends Observable {
    private int data = 0;

    public int getdata() {
        return data;
    }

    public void setdata(int i) {
        if (data != i) {
            data = i;
            //数据发生改变
            setChanged();
            //通知观察者表示状态发生改变
            notifyObservers();
        }

    }
}
