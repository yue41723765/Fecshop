package com.gtjh.classify.model.impl;

import com.google.gson.reflect.TypeToken;
import com.gtjh.classify.model.IClassifyModel;
import com.gtjh.classify.model.enetity.Menu;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.HandleFuc;
import com.gtjh.common.net.Rx.RxRestClient;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;

import java.util.HashMap;
import java.util.LinkedHashMap;

import io.reactivex.functions.Function;
import retrofit2.http.PATCH;

/**
 * Created by android on 2018/7/4.
 */

public class NetClassifyModel implements IClassifyModel {
    @Override
    public void loadData(int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CLASSIFY_MENU)
                        .params(new HashMap<String, Object>())
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<LinkedHashMap<String,Menu>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void classifyFilter(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CLASSIFY_FILTRATE)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void classifyContent(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CLASSIFY_CONTENT)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void getDetails(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_DETAILS)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void addFavorite(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ADD_FAVORITE)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void evaList(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_EVA_LIST)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void addCart(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ADD_CART)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }
}
