package com.gtjh.user.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.user.model.impl.UserModel;
import com.gtjh.user.presenter.IForgetPresenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/16.
 */

public class ForgetPresenterImpl extends BasePresenter implements IForgetPresenter {
    private UserModel model;
    public ForgetPresenterImpl(IBaseView view) {
        super(view);
        model=new UserModel();
    }

    @Override
    public void forgetInit(int tag) {
        model.forgetInit(tag);
    }

    @Override
    public void forgetSend(HashMap<String, Object> param, int tag) {
        model.forgetSendCode(param,tag);
    }

    @Override
    public void forgetToken(HashMap<String, Object> param, int tag) {
        model.forgetTokenInit(param,tag);
    }

    @Override
    public void forgetPw(HashMap<String, Object> param, int tag) {
        model.forgetPw(param,tag);
    }
    @RegisterRxBus(Contans.Tag.FORGET_INIT)
    public void forgetInit(ResponseData<Object> result,int tag){
        getView().showSuccess(result,tag);
    }
    @RegisterRxBus(Contans.Tag.FORGET_SEND)
    public void forgetSend(ResponseData result,int tag){
        getView().showSuccess(result,tag);
    }
    @RegisterRxBus(Contans.Tag.FORGET_TOKEN)
    public void forgetToken(ResponseData<Object> result,int tag){
        getView().showSuccess(result,tag);
    }
    @RegisterRxBus(Contans.Tag.FORGET_PW)
    public void forgetPw(ResponseData result,int tag){
        getView().showSuccess(result,tag);
    }
}
