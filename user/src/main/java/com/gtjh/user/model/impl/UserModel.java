package com.gtjh.user.model.impl;

import com.google.gson.reflect.TypeToken;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.HandleFuc;
import com.gtjh.common.net.Rx.RxRestClient;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.user.model.IUserModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/5.
 */

public class UserModel implements IUserModel{
    @Override
    public void login(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_LOGIN)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void register(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_REGISTER)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Map<String,String>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void updatePwd(HashMap<String, Object> param, int tag) {

    }


    @Override
    public void editAccountInfo(int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_USER_INFO)
                        .params(new HashMap<String, Object>())
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Map<String,String>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void submitAccountInfo(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_SUB_INFO)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Map<String,String>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void addressList( int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ADDRESS_LIST)
                        .params(new HashMap<String, Object>())
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void addressInitialize(final HashMap<String, Object> param, int tag) {
        //编辑初始化 无id为新建初始化，有id为编辑初始化
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ADDRESS_INITIALIZE)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void addressSubmit(final HashMap<String, Object> param, int tag) {
        //编辑提交 无id为新建，有id为编辑
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ADDRESS_SUBMIT)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void addressCounty(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ADDRESS_COUNTY)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void deleteAddress(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ADDRESS_DELETE)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<Object>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void orderList(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ORDER_LIST)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void orderDetails(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ORDER_DETAILS)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void orderAgain(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_ORDER_AGAIN)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void evaluationInitialize(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_EVALUATION_INIT)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void evaluationSubmit(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_EVALUATION_SUB)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void collectList(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_COLLECT_LIST)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void deleteCollect(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_COLLECT_DELETE)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void forgetInit(int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_FORGET_INIT)
                        .params(new HashMap<String, Object>())
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void forgetSendCode(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_FORGET_SEND)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void forgetTokenInit(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_FORGET_TOKEN)
                        .params(param)
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void forgetPw(final HashMap<String, Object> param, int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_FORGET_PW)
                        .params(param)
                        .build()
                        .post()
                        .map(new HandleFuc(new TypeToken<ResponseData>() {
                        }));
            }
        }, tag);
    }

    @Override
    public void languageM( int tag) {
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return RxRestClient.create()
                        .url(Contans.Url.URL_MAIN)
                        .params(new HashMap<String, Object>())
                        .build()
                        .get()
                        .map(new HandleFuc(new TypeToken<ResponseData<HashMap<String,Object>>>() {
                        }));
            }
        }, tag);
    }
}
