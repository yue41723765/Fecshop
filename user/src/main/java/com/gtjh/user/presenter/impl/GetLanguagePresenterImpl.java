package com.gtjh.user.presenter.impl;

import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.presenter.BasePresenter;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.IBaseView;
import com.gtjh.user.model.impl.UserModel;
import com.gtjh.user.presenter.IGetLanguagePresenter;

/**
 * Created by android on 2018/8/9.
 */

public class GetLanguagePresenterImpl  extends BasePresenter implements IGetLanguagePresenter{
    UserModel model;
    public GetLanguagePresenterImpl(IBaseView view) {
        super(view);
        model=new UserModel();
    }

    @Override
    public void getLanguage(int tag) {
        model.languageM(tag);
    }

    @RegisterRxBus(Contans.Tag.INIT_MAIN)
    private void getLanguage(ResponseData<Object> result, int tag) {
        getView().showSuccess(result, tag);
    }
}
