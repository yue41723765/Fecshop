package com.gtjh.user.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.user.bean.EditUserInfoBean;
import com.gtjh.user.model.IUserModel;
import com.gtjh.user.model.impl.UserModel;
import com.gtjh.user.presenter.IChangePwPresenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/10.
 */

public class ChangePwPresenterImpl extends BasePresenter implements IChangePwPresenter {
    private IUserModel model;
    public ChangePwPresenterImpl(IBaseView view) {
        super(view);
        model=new UserModel();
    }

    @Override
    public void changePw(HashMap<String, Object> param, int tag) {
        model.submitAccountInfo(param, tag);
    }

    @Override
    public void getPwConditions(int tag) {
        model.editAccountInfo(tag);
    }

    @RegisterRxBus(Contans.Tag.USER_INFO)
    private void getConditions(ResponseData<EditUserInfoBean> result, int tag) {
        getView().showSuccess(result, tag);
    }

    @RegisterRxBus(Contans.Tag.SUB_INFO)
    private void changePw(ResponseData<Object> result, int tag) {
        getView().showSuccess(result, tag);
    }
}
