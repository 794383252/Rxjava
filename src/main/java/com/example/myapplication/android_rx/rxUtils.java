package com.example.myapplication.android_rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/8.
 * <p>
 * 参考博客  http://blog.csdn.net/qq_18402085/article/details/50625886
 */
public class rxUtils {
    public static final String TAG = rxUtils.class.getSimpleName();

    //创建被观察者
    public static void createObservable() {
        //定义一个被观察者
        rx.Observable<String> observable = rx.Observable.create(new rx.Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //判断观察者和被观察者是否还有订阅关系
                if (!subscriber.isUnsubscribed()) {
                    //由于我们定义的被观察者的返回类型是String型，所以这里只能填String类型的
                    //添加的信息是观察者向被观察者发送的信息
                    subscriber.onNext("hello");
                    subscriber.onNext("hi");
                    subscriber.onNext(downLoadJson());
                    subscriber.onNext("world");
                    subscriber.onCompleted();
                }
            }
        });
        Subscriber<String> showSub = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ln", e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.i("ln", "result -->> " + s);
            }
        };
        //关联被观察者
        observable.subscribe(showSub);
    }

    //调用下载的方法
    public static String downLoadJson() {
        return "json data";
    }

    /**
     * 第二种create方式
     *
     * 在实际使用中更多的是使用第一种方法
     */
    public static void createPrint() {
        Observable.create(new Observable.OnSubscribe<Integer>() {

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 0; i <= 10; i++) {
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ln", e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.i("ln", "result -->> " + integer);
            }
        });
    }

    /**
     * 这种方法一般使用在被观察者返回的都是数字类型
     */
    public static void from() {
        //定义一个integer数组
        Integer[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //调用from方法数组转换为observable类型
        Observable observable = Observable.from(items);

        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i("ln", o.toString());
            }
        });
    }

    /**
     * 定时发送数据
     */
    public static void interval() {
        Integer[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //延迟一秒后每隔一秒发送一次数据
        Observable observable = Observable.interval(1, 1, TimeUnit.SECONDS);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i("ln", o.toString());
            }
        });
    }

    /**
     * 处理数组，可以发送多个数组或者是数组中的某一项
     */
    public static void just() {
        Integer[] items1 = {1, 2, 3, 4, 5, 6};
        Integer[] items2 = {3, 5, 6, 8, 3, 8};
        Observable observable = Observable.just(items1[1], items2[1]);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ln", e.getMessage());
            }

            @Override
            public void onNext(Integer o) {
                Log.i("ln", "result -->> " + o);
            }
        });
    }

    /**
     * 使用范围数据，指定输出数据的范围
     */
    public static void range()
    {
        Observable observable=Observable.range(1,40);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ln", e.getMessage());
            }

            @Override
            public void onNext(Integer o) {
                Log.i("ln", "result -->> " + o);
            }
        });
    }

    /**
     * 使用过滤功能
     */
    public static void filter()
    {
        Observable observable=Observable.just(1,2,3,4,5,6,7,8,9);
        observable.filter(new Func1<Integer,Boolean>() {
            @Override
            public Boolean call(Integer o) {
                return o<5;
            }
        }).observeOn(Schedulers.io()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("ln", "onCompleted");
            }

            @Override
            public void onNext(Integer o) {
                Log.i("ln", "result -->> " + o.toString());
            }
        });
    }

}
