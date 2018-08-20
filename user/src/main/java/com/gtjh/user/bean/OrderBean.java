package com.gtjh.user.bean;

import java.util.List;

/**
 * Created by android on 2018/7/13.
 */

public class OrderBean  {
    private List<OrderListBean> orderList;
    private String count;

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
