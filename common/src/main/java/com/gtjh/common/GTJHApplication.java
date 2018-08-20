package com.gtjh.common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;
import android.util.Log;

import com.gtjh.common.app.ProjectInit;
import com.gtjh.common.entity.Language;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.common.image.glide.GlideImageLoader;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.hook.HookUtil;
import com.gtjh.router_core.GTJHRouter;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by android on 2018/6/29.
 */

public class GTJHApplication extends Application {
    private static GTJHApplication application;
    public Object user;
    public Language.languageInfo language;
    public boolean isLogin;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        ImageLoaderPresenter.init(new GlideImageLoader());
        ProjectInit.init(this)
                .withApiHost("http://appserver.shop.saneim.com")
                .withLanguage("zh")
                .withInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                .addHeader("Connection", "keep-alive")
                                .addHeader("fecshop-lang", SPUtil.getLanguage(GTJHApplication.this))
                                .addHeader("fecshop-currency",SPUtil.getCurrency(GTJHApplication.this))
                                .addHeader("Cookie", "hello");
                        String uuid = SPUtil.getUid(GTJHApplication.this);
                        String token = SPUtil.getToken(GTJHApplication.this);
                        if (uuid != null)
                            builder.addHeader("fecshop-uuid", uuid);
                        if (token != null)
                            builder.addHeader("access-token", token);
                        Request request = builder.build();
                        Response response = chain.proceed(request);
                        uuid = response.header("fecshop-uuid");
                        Log.i("UUID",uuid);
                        token = response.header("access-token");
                        if (!TextUtils.isEmpty(uuid)) {
                            SPUtil.saveUid(GTJHApplication.this, uuid);
                        }
                        if (!TextUtils.isEmpty(token)) {
                            SPUtil.saveToken(GTJHApplication.this,  token);
                        }
                        return response;
                    }
                })
                .configure();

        GTJHRouter.init(this);
        //GTJHRouter.getInstance().initGroup("main");
        //HookUtil.init(this);
    }

    public static GTJHApplication getApplication() {
        return application;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
