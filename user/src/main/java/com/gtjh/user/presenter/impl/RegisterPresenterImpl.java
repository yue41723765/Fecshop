package com.gtjh.user.presenter.impl;

import com.google.gson.internal.LinkedTreeMap;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.user.model.impl.CodeModelImpl;
import com.gtjh.user.model.impl.UserModel;
import com.gtjh.user.presenter.IRegisterPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by android on 2018/7/5.
 */

public class RegisterPresenterImpl extends BasePresenter implements IRegisterPresenter {
    private UserModel model;
    private CodeModelImpl codeModel;

    public RegisterPresenterImpl(IBaseView view) {
        super(view);
        model = new UserModel();
        codeModel = new CodeModelImpl();
    }

    @Override
    public void register(HashMap<String, Object> param, int tag) {
        model.register(param, tag);
    }

    @Override
    public void loadCode(int tag) {
        codeModel.loadCode(tag);
    }

    @RegisterRxBus(Contans.Tag.CODE)
    private void codeSuccess(ResponseData<HashMap<String, String>> data, int tag) {
        getView().showSuccess(data,tag);
    }

    @RegisterRxBus(Contans.Tag.REGISTER)
    private void registerSuccess(ResponseData<Map<String,String>> map, int tag) {
        getView().showSuccess(map,tag);
    }
}
