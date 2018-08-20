package com.gtjh.classify.presenter.impl;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.gtjh.classify.model.IClassifyModel;
import com.gtjh.classify.model.enetity.Menu;
import com.gtjh.classify.model.impl.NetClassifyModel;
import com.gtjh.classify.presenter.IClassifyPresenter;


import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.GsonUtils;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.view.IBaseView;

import java.util.HashMap;
import java.util.LinkedHashMap;

import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/4.
 */

public class ClassifyPresenterImpl extends BasePresenter implements IClassifyPresenter {
    private IClassifyModel model;
    public ClassifyPresenterImpl(IBaseView view) {
        super(view);
        model=new NetClassifyModel();
    }
    @Override
    public void loadData(int tag) {
        model.loadData(tag);
    }

    @Override
    public void classifyFilter(HashMap<String, Object> param, int tag) {
        model.classifyFilter(param,tag);
    }

    @Override
    public void classifyContent(HashMap<String, Object> param, int tag) {
        model.classifyContent(param,tag);
    }

    @Override
    public void getDetails(HashMap<String, Object> param, int tag) {
        model.getDetails(param,tag);
    }

    @Override
    public void addFavorite(HashMap<String, Object> param, int tag) {
        model.addFavorite(param,tag);
    }

    @Override
    public void evaList(HashMap<String, Object> param, int tag) {
        model.evaList(param,tag);
    }

    @Override
    public void addCart(HashMap<String, Object> param, int tag) {
        model.addCart(param,tag);
    }

    @RegisterRxBus(Contans.Tag.CLASSIFY_MENU)
    private void resultData(LinkedHashMap<String,Menu> object, int tag){
        getView().showSuccess(object,tag);
    }

    @RegisterRxBus(Contans.Tag.CLASSIFY_FILTRATE)
    private void classifyFilter(ResponseData<Object> object, int tag){
        getView().showSuccess(object,tag);
    }

    @RegisterRxBus(Contans.Tag.CLASSIFY_CONTENT)
    private void classifyContent(ResponseData<Object>object, int tag){
        getView().showSuccess(object,tag);
    }

    @RegisterRxBus(Contans.Tag.DETAILS)
    private void getDetails(ResponseData<Object>object, int tag){
        getView().showSuccess(object,tag);
    }


    @RegisterRxBus(Contans.Tag.ADD_FAVORITE)
    private void addFavorite(ResponseData<Object>object, int tag){
        getView().showSuccess(object,tag);
    }


    @RegisterRxBus(Contans.Tag.EVA_LIST)
    private void evaList(ResponseData<Object>object, int tag){
        getView().showSuccess(object,tag);
    }

    @RegisterRxBus(Contans.Tag.ADD_CART)
    private void addCart(ResponseData<Object>object, int tag){
        getView().showSuccess(object,tag);
    }
}
