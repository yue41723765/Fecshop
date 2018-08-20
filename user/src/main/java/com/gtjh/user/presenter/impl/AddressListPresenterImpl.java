package com.gtjh.user.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.user.bean.AddressBean;
import com.gtjh.user.bean.AddressInitializeBean;
import com.gtjh.user.model.impl.UserModel;
import com.gtjh.user.presenter.IAddressListPresenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/10.
 */

public class AddressListPresenterImpl extends BasePresenter implements IAddressListPresenter {
    private UserModel model;
    public AddressListPresenterImpl(IBaseView view) {
        super(view);
        model=new UserModel();
    }

    @Override
    public void addressList( int tag) {
        //列表
        model.addressList(tag);
    }

    @Override
    public void addressInitialize(HashMap<String, Object> param, int tag) {
        //初始化
        model.addressInitialize(param,tag);
    }

    @Override
    public void addressSubmit(HashMap<String, Object> param, int tag) {
        //提交
        model.addressSubmit(param,tag);
    }

    @Override
    public void addressCounty(HashMap<String, Object> param, int tag) {
        model.addressCounty(param,tag);
    }

    @Override
    public void deleteAddress(HashMap<String, Object> param, int tag) {
        model.deleteAddress(param,tag);
    }

    @RegisterRxBus(Contans.Tag.ADDRESS_LIST)
    public void addressList(ResponseData<AddressBean> responseData,int tag){
        getView().showSuccess(responseData,tag);
    }
    @RegisterRxBus(Contans.Tag.ADDRESS_INITIALIZE)
    public void addressInitialize(ResponseData<AddressInitializeBean> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }
    @RegisterRxBus(Contans.Tag.ADDRESS_SUBMIT)
    public void addressSubmit(ResponseData<Object> responseData,int tag){
        getView().showSuccess(responseData,tag);
    }

    @RegisterRxBus(Contans.Tag.ADDRESS_COUNTY)
    public void addressCounty(ResponseData<Object> responseData,int tag){
        getView().showSuccess(responseData,tag);
    }

    @RegisterRxBus(Contans.Tag.ADDRESS_DELETE)
    public void deleteAddress(ResponseData<Object> responseData,int tag){
        getView().showSuccess(responseData,tag);
    }
}
