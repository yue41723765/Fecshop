package com.gtjh.common.view;

/**
 * Created by android on 2018/7/2.
 */

public interface IBaseView<T> {
    void showDialog();

    void hideDialog();

    void showSuccess(T t,int tag);

    void showError(Throwable throwable);
}
