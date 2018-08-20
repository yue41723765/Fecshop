package com.gtjh.shop_car.model.impl;

import com.google.gson.reflect.TypeToken;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.HandleFuc;
import com.gtjh.common.net.Rx.RxRestClient;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.shop_car.model.IShopCarModel;

import java.util.HashMap;
import java.util.LinkedHashMap;

import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/5.
 */

public class NetShopCarModel implements IShopCarModel {
    @Override
    public void loadData(int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CAR_LIST)
                        .params(new HashMap<String, Object>())
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void upData(final HashMap<String, Object> map, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CART_UPDATA)
                        .params(map)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void selectOne(final HashMap<String, Object> map, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CART_SELECT)
                        .params(map)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void selectAll(final HashMap<String, Object> map, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CART_SELECT_ALL)
                        .params(map)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void initOrder(int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_INIT_ORDER)
                        .params(new HashMap<String, Object>())
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void addCoupon(final HashMap<String, Object> map, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ADD_COUPON)
                        .params(map)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void cancelCoupon(final HashMap<String, Object> map, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_CANCEL_COUPON)
                        .params(map)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void submitOrder(final HashMap<String, Object> map, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_SUBMIT_ORDER)
                        .params(map)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void changeAddress(final HashMap<String, Object> map, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_SHIPPING_CART)
                        .params(map)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

}
