package com.gtjh.user.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/10.
 */

public interface IEditUserInfoPresenter {
    void editUserInfo(int tag);
    void submitUserInfo(HashMap<String,Object> param,int tag);
}
