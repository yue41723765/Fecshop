package com.gtjh.main.bean;

import java.util.List;

/**
 * Created by android on 2018/7/17.
 */

public class SearchResultBean {
    private List<SearchResultListBean> products;

    public List<SearchResultListBean> getProducts() {
        return products;
    }

    public void setProducts(List<SearchResultListBean> products) {
        this.products = products;
    }
}
