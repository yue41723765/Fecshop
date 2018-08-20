package com.gtjh.user.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.user.model.IUserModel;
import com.gtjh.user.model.impl.UserModel;
import com.gtjh.user.presenter.ILoginPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by android on 2018/7/6.
 */

public class LoginPresenterImpl extends BasePresenter implements ILoginPresenter {
    private IUserModel model;

    public LoginPresenterImpl(IBaseView view) {
        super(view);
        model = new UserModel();
    }

    @Override
    public void login(HashMap<String, Object> param, int tag) {
        model.login(param, tag);
    }

    @RegisterRxBus(Contans.Tag.LOGIN)
    private void loginResult(ResponseData<Object> result, int tag) {
        getView().showSuccess(result, tag);
    }
}
