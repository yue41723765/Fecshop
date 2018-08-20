package com.gtjh.user.model.impl;

import com.google.gson.reflect.TypeToken;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.HandleFuc;
import com.gtjh.common.net.Rx.RxRestClient;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.user.model.ICodeModel;

import java.util.HashMap;

import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/5.
 */

public class CodeModelImpl implements ICodeModel {
    @Override
    public void loadCode(int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CODE)
                        .params(new HashMap<String, Object>())
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,String>>>() {
                        }));
            }
        }, tag);
    }
}
