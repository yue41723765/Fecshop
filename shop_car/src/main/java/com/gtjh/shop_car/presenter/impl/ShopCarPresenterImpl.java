package com.gtjh.shop_car.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.shop_car.model.impl.NetShopCarModel;
import com.gtjh.shop_car.presenter.IShopCarPresenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/23.
 */

public class ShopCarPresenterImpl extends BasePresenter implements IShopCarPresenter {
    private NetShopCarModel model;
    public ShopCarPresenterImpl(IBaseView view) {
        super(view);
        model=new NetShopCarModel();
    }

    @Override
    public void loadData(int tag) {
        model.loadData(tag);
    }

    @Override
    public void upData(HashMap<String, Object> map, int tag) {
        model.upData(map,tag);
    }

    @Override
    public void selectOne(HashMap<String, Object> map, int tag) {
        model.selectOne(map,tag);
    }

    @Override
    public void selectAll(HashMap<String, Object> map, int tag) {
        model.selectAll(map,tag);
    }


    @RegisterRxBus(Contans.Tag.CART_LIST)
    public void loadData(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }

    @RegisterRxBus(Contans.Tag.CART_UPDATA)
    public void upData(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }

    @RegisterRxBus(Contans.Tag.CART_SELECT)
    public void selectOne(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }


    @RegisterRxBus(Contans.Tag.CART_SELECT_ALL)
    public void selectAll(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }
}
