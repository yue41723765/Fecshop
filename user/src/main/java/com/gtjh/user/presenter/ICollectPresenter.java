package com.gtjh.user.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/16.
 */

public interface ICollectPresenter {
    void collectList(HashMap<String,Object> param,int tag);
    void deleteCollect(HashMap<String,Object> param,int tag);
}
