package com.gtjh.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gtjh.common.view.IBaseView;

import butterknife.ButterKnife;

/**
 * Created by android on 2018/7/3.
 */

public abstract class BaseFragment extends Fragment implements IBaseView {
    public View view;
    public Context mContext;

    public View getRootView() {
        return view;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        mContext=getContext();
        return view;
    }

    protected abstract void init();

    protected abstract int getLayoutId();
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()) {
            init();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        // 通过这两个判断，就可以知道什么时候去加载数据了
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isVisible()) {
            init(); // 加载数据的方法
        }
    }
    @Override
    public void showDialog() {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void hideDialog() {

    }
}
