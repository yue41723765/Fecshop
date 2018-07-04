package com.gtjh.common.net.Rx.databus;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.gtjh.common.net.Rx.BaseSubscriber;
import com.gtjh.common.net.Rx.ExceptionHandle;
import com.gtjh.common.util.GsonUtils;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.util.type.Type;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 数据总线
 */
public class RxBus {
    private Set<Object> subscribers;

    /**
     * 注册
     */
    public synchronized void register(Object subscriber) {
        subscribers.add(subscriber);
    }

    /**
     * 取消注册
     */
    public synchronized void unRegister(Object subscriber) {
        subscribers.remove(subscriber);
    }


    private static volatile RxBus instance;

    private RxBus() {
        //读写分离的集合
        subscribers = new CopyOnWriteArraySet<>();
    }

    public static synchronized RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    /**
     * 把处理过程包装起来
     */
    public void chainProcess(Function function, final int tag) {
        Observable.just("")
                .subscribeOn(Schedulers.io())
                .flatMap(function)//在这里进行网络访问
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<Object>() {
                    @Override
                    public void next(Object data) {
                        RYLog.e("结果："+ GsonUtils.getGson().toJson(data));
                        send(data, tag);//把数据送到P层
                    }

                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {
                        RYLog.e("错误："+e.getMessage());
                    }
                });

    }

    public void send(Object data, int tag) {
        for (Object subscriber : subscribers) {
            //扫描注解,将数据发送到注册的对象标记方法的位置
            //subscriber表示层
            callMethodByAnnotion(subscriber, data, tag);
        }
    }

    /**
     * @param target
     * @param data
     */
    private void callMethodByAnnotion(Object target, Object data, int tag) {

        //1.得到presenter中写的所有的方法
        Method[] methodArray = target.getClass().getDeclaredMethods();
        for (int i = 0; i < methodArray.length; i++) {
            try {
                RegisterRxBus registerRxBus = methodArray[i].getAnnotation(RegisterRxBus.class);
                if (registerRxBus != null) {

                    //如果哪个方法上用了我们写的注解
                    //把数据传上去,再执行这个方法
                    Class paramType = methodArray[i].getParameterTypes()[0];
                    RYLog.e(data.getClass().getName()+"---"+paramType.getName()+tag+"--"+registerRxBus.value());
                    if (data.getClass().getName().equals(paramType.getName()) && registerRxBus.value() == tag) {
                        //执行
                        methodArray[i].setAccessible(true);
                        methodArray[i].invoke(target, new Object[]{data, tag});
                        RYLog.e(target.getClass().getName()+"里的"+methodArray[i].getName()+"执行了");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}









