package com.gtjh.user.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/10.
 */

public interface IAddressListPresenter {
    void addressList(int tag);

    void addressInitialize(HashMap<String,Object> param,int tag);
    void addressSubmit(HashMap<String,Object> param,int tag);
    void addressCounty(HashMap<String,Object> param,int tag);
    void deleteAddress(HashMap<String,Object> param,int tag);
}
