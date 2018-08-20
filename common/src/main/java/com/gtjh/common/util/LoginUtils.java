package com.gtjh.common.util;

import android.content.Context;
import android.content.Intent;

import com.gtjh.common.net.Rx.databus.RxBus;
import com.paypal.android.sdk.payments.LoginActivity;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/8/16.
 */

public class LoginUtils {
    public static void tokenLose(Context context){
        Intent intent=new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        SPUtil.saveIsLogin(context,false);
        SPUtil.clearToken(context);
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return Observable.just(false);
            }
        }, Contans.Tag.LOGIN);
    }
}
