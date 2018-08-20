package com.gtjh.shop_car.presenter;

import android.view.View;

import java.util.HashMap;

/**
 * Created by android on 2018/7/24.
 */

public interface IOrderPresenter {
    void initOrder(int tag);
    void addCoupon(HashMap<String,Object> map,int tag);
    void cancelCoupon(HashMap<String,Object> map,int tag);
    void submitOrder(HashMap<String,Object> map,int tag);
    void shippingCart(HashMap<String,Object> map,int tag);
}
