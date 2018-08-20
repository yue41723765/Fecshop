package com.gtjh.main.model.impl;

import com.google.gson.reflect.TypeToken;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.HandleFuc;
import com.gtjh.common.net.Rx.RxRestClient;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.main.model.IMainModel;
import com.gtjh.main.model.entity.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/3.
 */

public class NetMainModel implements IMainModel {
    @Override
    public void loadMainInfo(int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_MAIN)
                        .params(new HashMap<String, Object>())
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Main>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void searchResult(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_SEARCH)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void searchFiltrate(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_SEARCH_FILTRATE)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }
}
