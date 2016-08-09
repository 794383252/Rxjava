package com.example.myapplication.java_rx2;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2016/8/8.
 * 创建一个观察者
 */
public class simpleObserver implements Observer {

    public simpleObserver(simpleObservable observable)
    {
        //给被观察者添加一个观察者对象
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        System.out.print("data is change"+((simpleObservable)observable).getdata());
    }
}
