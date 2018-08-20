package com.gtjh.common.util.hook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.gtjh.common.GTJHApplication;
import com.gtjh.common.ProxyLoginActivity;
import com.gtjh.router_core.Warehouse;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HookUtil {
    private Context context;
    private static HookUtil instance;

    public static void init(Context context) {
        if (instance == null) {
            instance = new HookUtil();
            instance.hookStartActivity(context);
            instance.hookHookMh(context);
        }
    }

    private HookUtil() {

    }


    public void hookHookMh(Context context) {
        try {
            Class<?> forName = Class.forName("android.app.ActivityThread");
            Field currentActivityThreadField = forName.getDeclaredField("sCurrentActivityThread");
            currentActivityThreadField.setAccessible(true);
//            还原系统的ActivityTread   mH
            Object activityThreadObj = currentActivityThreadField.get(null);

            Field handlerField = forName.getDeclaredField("mH");
            handlerField.setAccessible(true);
//            hook点找到了
            Handler mH = (Handler) handlerField.get(activityThreadObj);
            Field callbackField = Handler.class.getDeclaredField("mCallback");

            callbackField.setAccessible(true);

            callbackField.set(mH, new ActivityMH(mH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void hookStartActivity(Context context) {
//        还原 gDefault 成员变量  反射  调用一次
        this.context = context;
        try {
            Class<?> ActivityManagerNativecls = Class.forName("android.app.ActivityManagerNative");
            Field gDefault = ActivityManagerNativecls.getDeclaredField("gDefault");
            gDefault.setAccessible(true);
//            因为是静态变量  所以获取的到的是系统值  hook   伪hook
            Object defaltValue = gDefault.get(null);
            //mInstance对象
            Class<?> SingletonClass = Class.forName("android.util.Singleton");

            Field mInstance = SingletonClass.getDeclaredField("mInstance");
//        还原 IactivityManager对象  系统对象
            mInstance.setAccessible(true);
            Object iActivityManagerObject = mInstance.get(defaltValue);
            Class<?> IActivityManagerIntercept = Class.forName("android.app.IActivityManager");
            startActivty startActivtyMethod = new startActivty(iActivityManagerObject);
//            第二参数  是即将返回的对象 需要实现那些接口
            Object oldIactivityManager = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader()
                    , new Class[]{IActivityManagerIntercept}
                    , startActivtyMethod);
//            将系统的iActivityManager  替换成    自己通过动态代理实现的对象   oldIactivityManager对象  实现了 IActivityManager这个接口的所有方法
            mInstance.set(defaltValue, oldIactivityManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ActivityMH implements Handler.Callback {
        private Handler mH;

        public ActivityMH(Handler mH) {
            this.mH = mH;
        }

        @Override
        public boolean handleMessage(Message msg) {
//LAUNCH_ACTIVITY ==100 即将要加载一个activity了
            if (msg.what == 100) {
//加工 --完  一定丢给系统  secondActivity  -hook->proxyActivity---hook->    secondeActivtiy
                handleLuachActivity(msg);
            }
//做了真正的跳转
            mH.handleMessage(msg);
            return true;
        }

        private void handleLuachActivity(Message msg) {
//            还原
            Object obj = msg.obj;
            try {
                Field intentField = obj.getClass().getDeclaredField("intent");
                intentField.setAccessible(true);
                //  ProxyActivity   2
                Intent realyIntent = (Intent) intentField.get(obj);
//                sconedActivity  1
                Intent oldIntent = realyIntent.getParcelableExtra("oldIntent");
                if (oldIntent != null) {
//                    集中式登录
                    if (GTJHApplication.getApplication().user!=null||!Warehouse.activityClass.containsValue(Class.forName(oldIntent.getComponent().getClassName()))) {

//                      登录  还原  把原有的意图    放到realyIntent
                        realyIntent.setComponent(oldIntent.getComponent());
                    } else {

                        ComponentName componentName = new ComponentName( context, Warehouse.routes.get("/init/loginActivity").getDestination().getName());
                        realyIntent.putExtra("extraIntent", oldIntent.getComponent()
                                .getClassName());
                        realyIntent.setComponent(componentName);
                        Field activityInfoField= obj.getClass().getDeclaredField("activityInfo");
                        activityInfoField.setAccessible(true);
                        ActivityInfo activityInfo= (ActivityInfo) activityInfoField.get(obj);
//              插件的class  packageName--->loadeApk   系统   第一次 IPackageManager ----》activitry  -——》包名   ---》
//                    不够 IPackageManage.getPackageInfo()
                        activityInfo.applicationInfo.packageName = oldIntent.getPackage() == null ? oldIntent.getComponent().getPackageName()
                                : oldIntent.getPackage();
                        hookPackgeManager();
                    }

                }



            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }


    private void hookPackgeManager() {
//          hook   方法  IPackageManager.getPackgeInfo

        // 这一步是因为 initializeJavaContextClassLoader 这个方法内部无意中检查了这个包是否在系统安装
        // 如果没有安装, 直接抛出异常, 这里需要临时Hook掉 PMS, 绕过这个检查.

        Class<?> activityThreadClass = null;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
            Method currentActivityThreadMethod = activityThreadClass.getDeclaredMethod("currentActivityThread");
            currentActivityThreadMethod.setAccessible(true);
            Object currentActivityThread = currentActivityThreadMethod.invoke(null);

            // 获取ActivityThread里面原始的 sPackageManager
            Field sPackageManagerField = activityThreadClass.getDeclaredField("sPackageManager");
            sPackageManagerField.setAccessible(true);
            Object sPackageManager = sPackageManagerField.get(currentActivityThread);

            // 准备好代理对象, 用来替换原始的对象
            Class<?> iPackageManagerInterface = Class.forName("android.content.pm.IPackageManager");
            Object proxy = Proxy.newProxyInstance(iPackageManagerInterface.getClassLoader()
                    , new Class[]{iPackageManagerInterface},new IPackageManagerHandler(sPackageManager) );
            sPackageManagerField.set(currentActivityThread,proxy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class startActivty implements InvocationHandler {
        private Object iActivityManagerObject;

        public startActivty(Object iActivityManagerObject) {
            this.iActivityManagerObject = iActivityManagerObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            Log.i("INFO", "invoke    " + method.getName());
            if ("startActivity".equals(method.getName())) {
                Log.i("INFO", "-----------------startActivity--------------------------");
//瞒天过海
//                寻找传进来的intent
                Intent intent = null;
                int index = 0;
                for (int i = 0; i < args.length; i++) {
//                    intent
                    Object arg = args[i];
                    if (arg instanceof Intent) {
                        intent = (Intent) args[i];
                        index = i;
                    }
                }
//目的  ---载入acgtivity  将它还原
                if (intent!=null&&GTJHApplication.getApplication().user==null&&intent.getComponent()!=null&& Warehouse.activityClass.containsValue(Class.forName(intent.getComponent().getClassName()))){
                    Intent newIntent = new Intent();
                   ComponentName componentName = new ComponentName(context, ProxyLoginActivity.class);
                    newIntent.setComponent(componentName);
//                真实的意图 被我隐藏到了  键值对
                    newIntent.putExtra("oldIntent", intent);
                    args[index] = newIntent;
                }

            }

            return method.invoke(iActivityManagerObject, args);
        }
    }
}
