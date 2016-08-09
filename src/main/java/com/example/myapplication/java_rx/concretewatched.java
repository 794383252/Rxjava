package com.example.myapplication.java_rx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
public class concretewatched implements watched {
    List<watcher> list=new ArrayList<>();
    @Override
    public void addwatcher(watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void movewatcher(watcher watcher) {
        list.remove(watcher);
    }

    @Override
    public void notifywatcher(String str) {
        for (watcher watcher:list)
        {
            watcher.updata(str);
        }
    }
}
