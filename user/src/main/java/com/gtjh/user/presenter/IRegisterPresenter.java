package com.gtjh.user.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/5.
 */

public interface IRegisterPresenter {
    void  register(HashMap<String,Object> param,int tag);

    void loadCode(int tag);

}
