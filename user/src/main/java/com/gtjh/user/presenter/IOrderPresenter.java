package com.gtjh.user.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/13.
 */

public interface IOrderPresenter  {
    void loadCode(int tag);

    void orderList(HashMap<String,Object> param,int tag);
    void orderDetails(HashMap<String,Object> param,int tag);
    void orderAgain(HashMap<String,Object> param,int tag);

    void evaluationInit(HashMap<String,Object> param,int tag);
    void evaluationSub(HashMap<String,Object> param,int tag);
}
