package com.gtjh.shop_car.model;

import java.util.HashMap;

/**
 * Created by android on 2018/7/5.
 */

public interface IShopCarModel {
    void loadData(int tag);
    //更新 购物车
    void upData(HashMap<String,Object> o,int tag);
    //选中 购物车
    void selectOne(HashMap<String,Object> map,int tag);
    //全选 购物车
    void selectAll(HashMap<String,Object> map,int tag);
    //初始化 订单
    void initOrder(int tag);
    //添加 优惠券
    void addCoupon(HashMap<String,Object> map,int tag);
    //取消 优惠券
    void cancelCoupon(HashMap<String,Object> map,int tag);
    //提交 订单
    void submitOrder(HashMap<String,Object> map,int tag);
    //切换地址
    void changeAddress(HashMap<String,Object> map,int tag);
}
