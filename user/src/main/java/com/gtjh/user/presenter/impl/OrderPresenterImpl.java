package com.gtjh.user.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.user.model.impl.CodeModelImpl;
import com.gtjh.user.model.impl.UserModel;
import com.gtjh.user.presenter.IOrderPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by android on 2018/7/13.
 */

public class OrderPresenterImpl extends BasePresenter implements IOrderPresenter {
    private UserModel model;
    private CodeModelImpl codeModel;
    public OrderPresenterImpl(IBaseView view) {
        super(view);
        model=new UserModel();
        codeModel=new CodeModelImpl();
    }

    @Override
    public void loadCode(int tag) {
        codeModel.loadCode(tag);
    }

    @Override
    public void orderList(HashMap<String, Object> param, int tag) {
        model.orderList(param,tag);
    }

    @Override
    public void orderDetails(HashMap<String, Object> param, int tag) {
        model.orderDetails(param,tag);
    }

    @Override
    public void orderAgain(HashMap<String, Object> param, int tag) {
        model.orderAgain(param,tag);
    }

    @Override
    public void evaluationInit(HashMap<String, Object> param, int tag) {
        model.evaluationInitialize(param,tag);
    }

    @Override
    public void evaluationSub(HashMap<String, Object> param, int tag) {
        model.evaluationSubmit(param,tag);
    }

    @RegisterRxBus(Contans.Tag.ORDER_LIST)
    private void orderList(ResponseData<Map<String,String>> map, int tag) {
        getView().showSuccess(map,tag);
    }


    @RegisterRxBus(Contans.Tag.ORDER_DETAILS)
    private void orderDetails(ResponseData<Map<String,String>> map, int tag) {
        getView().showSuccess(map,tag);
    }
    @RegisterRxBus(Contans.Tag.ORDER_AGAIN)
    private void orderAgain(ResponseData<Map<String,String>> map, int tag) {
        getView().showSuccess(map,tag);
    }

    @RegisterRxBus(Contans.Tag.EVALUATION_INIT)
    private void evaluationInit(ResponseData<Map<String,String>> map, int tag) {
        getView().showSuccess(map,tag);
    }
    @RegisterRxBus(Contans.Tag.EVALUATION_SUB)
    private void evaluationSub(ResponseData<Map<String,String>> map, int tag) {
        getView().showSuccess(map,tag);
    }


    @RegisterRxBus(Contans.Tag.CODE)
    private void codeSuccess(ResponseData<HashMap<String, String>> data, int tag) {
        getView().showSuccess(data,tag);
    }
}
