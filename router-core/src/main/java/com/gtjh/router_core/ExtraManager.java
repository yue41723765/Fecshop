package com.gtjh.router_core;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.LruCache;

import com.gtjh.router_core.template.IBindFragment;
import com.gtjh.router_core.template.IExtra;


/**
 * @author Lance
 * @date 2018/2/23
 */

public class ExtraManager {


    public static final String SUFFIX_AUTOWIRED_EXTRA = "_Activity";
    public static final String SUFFIX_AUTOWIRED_FRGMENT = "_Fragment";
    public static final String SUFFIX_AUTOWIRED_VIEW = "_View";
    private static ExtraManager instance;
    private LruCache<String, IExtra> activityClassCache;
    private LruCache<String, IBindFragment> fragmentClassCache;

    public static ExtraManager getInstance() {
        if (instance == null) {
            synchronized (GTJHRouter.class) {
                if (instance == null) {
                    instance = new ExtraManager();
                }
            }
        }
        return instance;
    }


    public ExtraManager() {
        activityClassCache = new LruCache<>(66);
        fragmentClassCache= new LruCache<>(66);
    }


    /**
     * 注入
     *
     * @param instance
     */
    public void loadExtras(Activity instance) {
        loadExtrasActivity(instance,SUFFIX_AUTOWIRED_EXTRA);
    }
    public void loadExtras(Fragment instance) {
        loadExtrasFragment(instance,SUFFIX_AUTOWIRED_FRGMENT);
    }
    /**
     * 注入
     *
     * @param instance
     * @param mark
     */
    public void loadExtrasActivity(Object instance,String mark) {
        //查找对应activity的缓存
        String className = instance.getClass().getName();
        IExtra iExtra = activityClassCache.get(className);
        try {
            if (null == iExtra) {
                iExtra = (IExtra) Class.forName(instance.getClass().getName() +
                        mark).getConstructor().newInstance();
            }
            iExtra.loadIntentValue(instance);
          //  iExtra.loadViewValue(instance);
            activityClassCache.put(className, iExtra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadExtrasFragment(Fragment instance,String mark) {
        //查找对应activity的缓存
        String className = instance.getClass().getName();
        IBindFragment iExtra = fragmentClassCache.get(className);
        try {
            if (null == iExtra) {
                iExtra = (IBindFragment) Class.forName(instance.getClass().getName() +
                        mark).getConstructor().newInstance();
            }
         //   iExtra.loadViewValue(instance);
            fragmentClassCache.put(className, iExtra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
