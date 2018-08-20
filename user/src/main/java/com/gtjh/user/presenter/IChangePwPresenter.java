package com.gtjh.user.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/10.
 */

public interface IChangePwPresenter {
    void changePw(HashMap<String ,Object> param,int tag);
    void getPwConditions(int tag);
}
