package com.gtjh.classify.bean;

import java.util.List;

/**
 * Created by android on 2018/7/19.
 */

public class ClassifyPageBean {
    private List<ClassifyPageListBean> products;

    public void setProducts(List<ClassifyPageListBean> products) {
        this.products = products;
    }

    public List<ClassifyPageListBean> getProducts() {
        return products;
    }
}
