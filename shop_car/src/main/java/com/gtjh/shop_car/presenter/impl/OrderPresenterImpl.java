package com.gtjh.shop_car.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.shop_car.model.impl.NetShopCarModel;
import com.gtjh.shop_car.presenter.IOrderPresenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/24.
 */

public class OrderPresenterImpl extends BasePresenter implements IOrderPresenter {
    private NetShopCarModel netShopCarModel;
    public OrderPresenterImpl(IBaseView view) {
        super(view);
        netShopCarModel=new NetShopCarModel();
    }

    @Override
    public void initOrder(int tag) {
        netShopCarModel.initOrder(tag);
    }

    @Override
    public void addCoupon(HashMap<String, Object> map, int tag) {
        netShopCarModel.addCoupon(map,tag);
    }

    @Override
    public void cancelCoupon(HashMap<String, Object> map, int tag) {
        netShopCarModel.cancelCoupon(map,tag);
    }

    @Override
    public void submitOrder(HashMap<String, Object> map, int tag) {
        netShopCarModel.submitOrder(map,tag);
    }

    @Override
    public void shippingCart(HashMap<String, Object> map, int tag) {
        netShopCarModel.changeAddress(map,tag);
    }

    @RegisterRxBus(Contans.Tag.INIT_ORDER)
    public void initOrder(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }

    @RegisterRxBus(Contans.Tag.ADD_COUPON)
    public void addCoupon(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }

    @RegisterRxBus(Contans.Tag.CANCEL_COUPON)
    public void cancelCoupon(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }

    @RegisterRxBus(Contans.Tag.SUBMIT_ORDER)
    public void submitOrder(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }
    @RegisterRxBus(Contans.Tag.SHIPPING_CART)
    public void shippingCart(ResponseData<Object> responseData, int tag){
        getView().showSuccess(responseData,tag);
    }
}
