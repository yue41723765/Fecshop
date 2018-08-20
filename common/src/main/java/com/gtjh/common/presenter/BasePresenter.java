package com.gtjh.common.presenter;

import com.gtjh.common.view.IBaseView;

/**
 * Created by android on 2018/7/2.
 */

public class BasePresenter {
    private IBaseView view;

    public IBaseView getView() {
        return view;
    }
    public BasePresenter(IBaseView view) {
        this.view = view;
    }
}
