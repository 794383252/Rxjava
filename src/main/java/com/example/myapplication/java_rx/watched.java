package com.example.myapplication.java_rx;


/**
 * Created by Administrator on 2016/8/8.
 */
public interface watched {
    public void addwatcher(watcher watcher);
    public void movewatcher(watcher watcher);
    public void notifywatcher(String str);
}
