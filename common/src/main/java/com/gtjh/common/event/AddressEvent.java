package com.gtjh.common.event;

import com.gtjh.common.entity.AddressListBean;

/**
 * Created by android on 2018/8/6.
 */

public class AddressEvent  {
    public final AddressListBean message;

    public AddressEvent(AddressListBean message) {
        this.message = message;
    }
}
