package com.gtjh.shop_car.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/5.
 */

public interface IShopCarPresenter {

    void loadData(int tag);
    void upData(HashMap<String,Object> map,int tag);
    void selectOne(HashMap<String,Object> map,int tag);
    void selectAll(HashMap<String,Object> map,int tag);
}
