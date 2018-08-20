package com.gtjh.classify;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.gtjh.classify.activity.ClassifyActivity;
import com.gtjh.classify.adapter.MenuAdapter;
import com.gtjh.classify.adapter.MenuChildAdapter;
import com.gtjh.classify.model.enetity.Menu;
import com.gtjh.classify.presenter.impl.ClassifyPresenterImpl;
import com.gtjh.common.BaseFragment;
import com.gtjh.common.dialog.linster.OnRightLinster;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.GsonUtils;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.view.OnItemClickLinster;
import com.gtjh.router_core.GTJHRouter;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;

/**
 * Created by android on 2018/7/2.
 */

public class ClassifyFragment extends BaseFragment {
    @BindView(R2.id.rv_navigation)
    RecyclerView rv_navigation;
    @BindView(R2.id.rv_data)
    RecyclerView rv_data;
    @BindView(R2.id.view_right)
    RelativeLayout rvRight;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ClassifyPresenterImpl presenter;

    private MenuAdapter adapter;

    private MenuChildAdapter childAdapter;

    @Override
    public void showError(Throwable throwable) {
        super.showError(throwable);
        showListViewStyle(false);
    }

    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag) {
            case Contans.Tag.CLASSIFY_MENU:
                initData((LinkedHashMap<String, Menu>) o);
                break;
        }
    }

    private void initData(LinkedHashMap<String, Menu> map) {
        map.remove("home");
        final ArrayList<Menu> list = new ArrayList();
        list.addAll(map.values());
        adapter = new MenuAdapter(list, getActivity());
        adapter.setLinster(new OnItemClickLinster() {
            @Override
            public void onItemClick(int position, View view) {
                Menu menu = adapter.getItem(position);
                adapter.setSelectPosition(position);
                initChild(menu.getChild());
            }
        });
        rv_navigation.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_navigation.setAdapter(adapter);
        initChild(list.get(0).getChild());
        showListViewStyle(true);
    }

    private void initChild(final Map<String, Menu.MenuChild> child) {
        if (child != null) {
            childAdapter.initData(child.values());
        } else {
            childAdapter.clearData();
        }
        RYLog.e(childAdapter.getItemCount());
    }

    @Override
    protected void init() {
        presenter = new ClassifyPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        presenter.loadData(Contans.Tag.CLASSIFY_MENU);

        childAdapter = new MenuChildAdapter(null, getActivity());
        rv_data.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rv_data.setAdapter(childAdapter);
        rvRight.setOnClickListener(onClickListener);
        initRefreshLayout();
    }
    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //搜索
            GTJHRouter.getInstance().build("/main/SearchActivity").navigation(getActivity());
        }
    };


    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new BezierCircleHeader(mContext));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.loadData(Contans.Tag.CLASSIFY_MENU);
            }
        });
    }
    private void showListViewStyle(boolean isSuccess) {
        refreshLayout.finishRefresh(1000, isSuccess);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;
    }
}
