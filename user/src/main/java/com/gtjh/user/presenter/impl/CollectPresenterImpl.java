package com.gtjh.user.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.user.model.impl.UserModel;
import com.gtjh.user.presenter.ICollectPresenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/16.
 */

public class CollectPresenterImpl extends BasePresenter implements ICollectPresenter {
    private UserModel model;
    public CollectPresenterImpl(IBaseView view) {
        super(view);
        model=new UserModel();
    }

    @Override
    public void collectList(HashMap<String, Object> param, int tag) {
        model.collectList(param,tag);
    }

    @Override
    public void deleteCollect(HashMap<String, Object> param, int tag) {
        model.deleteCollect(param,tag);
    }

    @RegisterRxBus(Contans.Tag.COLLECT_LIST)
    public void collectList(ResponseData<Object> result,int tag){
        getView().showSuccess(result,tag);
    }


    @RegisterRxBus(Contans.Tag.COLLECT_DELETE)
    public void deleteCollect(ResponseData<Object> result,int tag){
        getView().showSuccess(result,tag);
    }
}
