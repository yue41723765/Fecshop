package com.gtjh.common.net;



import com.gtjh.common.app.ConfigKeys;
import com.gtjh.common.app.ProjectInit;
import com.gtjh.common.net.Rx.RxRestService;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by jett on 2018/6/6.
 */

public final class RestCreator {
    /**
     * 产生一个全局的Retrofit客户端
     */
    private static final class RetrofitHolder{
        private static final String BASE_URL= ProjectInit.getConfiguration(ConfigKeys.API_HOST);
        private static final Retrofit RETROFIT_CLIENT=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .build();

    }
    private static final class OKHttpHolder{
        private static final int TIME_OUT=60;
        private static final OkHttpClient OK_HTTP_CLIENT=new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor((Interceptor) ProjectInit.getConfiguration(ConfigKeys.INTERCEPTOR))
                .build();
    }


    //提供接口让调用者得到retrofit对象
    private static final class RxRestServiceHolder{
        private static final RxRestService REST_SERVICE=RetrofitHolder.RETROFIT_CLIENT.create(RxRestService.class);
    }
    /**
     * 获取对象
     */
    public static RxRestService getRxRestService(){
        return RxRestServiceHolder.REST_SERVICE;
    }

}








