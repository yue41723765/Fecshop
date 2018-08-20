package com.gtjh.user.bean;

import com.gtjh.common.entity.AddressListBean;

import java.util.List;

/**
 * Created by android on 2018/7/10.
 */

public class AddressBean {
    private List<AddressListBean> addressList;

    public List<AddressListBean> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressListBean> addressList) {
        this.addressList = addressList;
    }
}
