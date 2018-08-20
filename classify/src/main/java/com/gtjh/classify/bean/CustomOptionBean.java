package com.gtjh.classify.bean;

import java.util.List;

/**
 * Created by android on 2018/8/2.
 */

public class CustomOptionBean {
    /**
     * info : [{"key":"red","val":"red","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/40/45/1/7/17147202419675158.jpg"},{"key":"white","val":"white","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/40/45/1/7/17147202419675158.jpg"}]
     * require : 1
     */

    private int require;
    private List<CustomOptionListBean> info;

    public int getRequire() {
        return require;
    }

    public void setRequire(int require) {
        this.require = require;
    }

    public List<CustomOptionListBean> getInfo() {
        return info;
    }

    public void setInfo(List<CustomOptionListBean> info) {
        this.info = info;
    }


}
