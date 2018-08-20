package com.gtjh.common.net.Rx;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gtjh.common.util.GsonUtils;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.util.type.Type;

import io.reactivex.functions.Function;

public  class HandleFuc implements Function<String, Object> {
    private TypeToken token;

    public HandleFuc(TypeToken token) {
        this.token = token;
    }

    @Override
    public Object apply(String s) throws Exception {
        RYLog.e(s);
        return  GsonUtils.getGson().fromJson(s, token.getType());
    }

}