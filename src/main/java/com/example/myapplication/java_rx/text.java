package com.example.myapplication.java_rx;


/**
 * Created by Administrator on 2016/8/8.
 */
public class text {
    public static void main(String[] args) throws Exception
    {
        watched xiaoming = new concretewatched();

        watcher watcher1 = new concretewatcher();
        watcher watcher2 = new concretewatcher();
        watcher watcher3 = new concretewatcher();

        xiaoming.addwatcher(watcher1);
        xiaoming.addwatcher(watcher2);
        xiaoming.addwatcher(watcher3);

        xiaoming.notifywatcher("我要偷东西了");

    }
}
