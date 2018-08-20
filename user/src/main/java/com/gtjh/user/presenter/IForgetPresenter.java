package com.gtjh.user.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/16.
 */

public interface IForgetPresenter {
    void forgetInit(int tag);
    void forgetSend(HashMap<String,Object> param,int tag);
    void forgetToken(HashMap<String,Object> param,int tag);
    void forgetPw(HashMap<String ,Object> param,int tag);
}
