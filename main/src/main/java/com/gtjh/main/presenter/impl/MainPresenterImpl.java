package com.gtjh.main.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.main.model.IMainModel;
import com.gtjh.main.model.entity.Main;
import com.gtjh.main.model.impl.NetMainModel;
import com.gtjh.main.presenter.IMainpresenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/3.
 */

public class MainPresenterImpl extends BasePresenter implements IMainpresenter {
    private IMainModel model;

    public MainPresenterImpl(IBaseView view) {
        super(view);
        model = new NetMainModel();
    }

    @Override
    public void loadMainInfo(int tag) {
        model.loadMainInfo(tag);
    }

    @Override
    public void searchResult(HashMap<String, Object> param, int tag) {
        model.searchResult(param,tag);
    }

    @Override
    public void searchFiltrate(HashMap<String, Object> param, int tag) {
        model.searchFiltrate(param,tag);
    }

    @RegisterRxBus(Contans.Tag.INIT_MAIN)
    private void mainInfo(ResponseData<Main> main, int tag) {
        getView().showSuccess(main,tag);
    }


    @RegisterRxBus(Contans.Tag.SEARCH)
    private void searchResult(ResponseData<Object> main, int tag) {
        getView().showSuccess(main,tag);
    }

    @RegisterRxBus(Contans.Tag.SEARCH_FILTRATE)
    private void searchFiltrate(ResponseData<Object> main, int tag) {
        getView().showSuccess(main,tag);
    }
}
