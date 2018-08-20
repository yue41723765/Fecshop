package com.gtjh.fecshop.model.impl;

import com.google.gson.reflect.TypeToken;
import com.gtjh.common.entity.Language;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.HandleFuc;
import com.gtjh.common.net.Rx.RxRestClient;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.RYLog;
import com.gtjh.fecshop.model.ILanguageModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/3.
 */

public class NetLanguageModel implements ILanguageModel {
    @Override
    public void loadLanguageData(int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url("/general/base/lang")
                        .params(new HashMap<String, Object>())
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<Language>() {
                        }));
            }
        }, tag);
    }
}
