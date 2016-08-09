package com.example.myapplication.java_rx2;

/**
 * Created by Administrator on 2016/8/8.
 */
public class myText {
    public static void main(String[] arg0) throws Exception
    {
        simpleObservable observable=new simpleObservable();

        simpleObserver observer=new simpleObserver(observable);

        observable.setdata(1);
        observable.setdata(2);
        observable.setdata(2);
        observable.setdata(3);
    }
}
