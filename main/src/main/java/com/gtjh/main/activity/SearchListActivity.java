package com.gtjh.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.view.HintRecyclerview;
import com.gtjh.main.R;
import com.gtjh.main.R2;
import com.gtjh.main.adapter.SearchResultAdapter;
import com.gtjh.main.bean.SearchFiltrateBean;
import com.gtjh.main.bean.SearchResultBean;
import com.gtjh.main.bean.SearchResultListBean;
import com.gtjh.main.presenter.impl.MainPresenterImpl;
import com.gtjh.main.view.dialog.SearchFiltrateDialog;
import com.gtjh.router_core.GTJHRouter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by android on 2018/7/17.
 */

public class SearchListActivity extends ToolBarActivity implements SearchResultAdapter.onItemClickListener, View.OnClickListener {
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R2.id.ll_filtrate)
    LinearLayout filtrate;
    @BindView(R2.id.rv_data)
    HintRecyclerview recyclerView;
    @BindView(R2.id.tv_hiht)
    TextView tvHint;

    private SearchResultAdapter adapter;
    private List<SearchResultListBean> listBeans=new ArrayList<>();

    private MainPresenterImpl presenter;
    private HashMap<String,Object> hashMap=new HashMap<>();
    private int page=1;
    private int load=0;
    private int flag=0;
    private String string="";
    private String price="";
    private Map<String,String> filter=new HashMap<>();
    private SearchFiltrateDialog  dialog;
    private Boolean isLoadFiltrate=false;

    private  SearchFiltrateBean  bean;

    @Override
    public void showSuccess(Object o, int tag) {

        switch (tag){
            case Contans.Tag.SEARCH:
                initData((ResponseData<Object>) o);
                break;
            case Contans.Tag.SEARCH_FILTRATE:
                initFiltrate((ResponseData<Object>)o);
                break;
        }
    }

    private void initFiltrate(ResponseData<Object> o) {
        if (o.getCode()==200){
            bean=gson.fromJson(gson.toJson(o.getData()),SearchFiltrateBean.class);
            dialog=new SearchFiltrateDialog(this,bean);
            dialog.setOnFiltrateClickListener(new SearchFiltrateDialog.onFiltrateClickListener() {
                @Override
                public void onFiltrate(String pri, Map<String, String> filterAttrs) {
                    page=1;
                    filter=filterAttrs;
                    price=pri;
                    hashMap.clear();
                    hashMap.put("q",string);
                    hashMap.put("filterAttrs",filter);
                    hashMap.put("price",price);
                    hashMap.put("p",page);
                    presenter.searchResult(hashMap,Contans.Tag.SEARCH);
                }
            });
            isLoadFiltrate=true;
        }else {
            ToastUtils.showToastForText(this,o.getMessage());
        }

    }

    private void initData(ResponseData<Object> o) {

        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            showListViewStyle(false);
            return;
        }
        SearchResultBean bean=gson.fromJson(gson.toJson(o.getData()),SearchResultBean.class);
        listBeans=bean.getProducts();
        if (page==1){
            adapter.initData(listBeans);
            load=0;
            flag=0;
            if (listBeans!=null&&listBeans.size()>0){
                tvHint.setVisibility(View.GONE);
            }else {
                tvHint.setVisibility(View.VISIBLE);
            }
            showListViewStyle(true);
        }else {
            if (listBeans!=null&&listBeans.size()>0){
                adapter.setDatas(listBeans);
                load=0;
                flag=1;
                showListViewStyle(true);
            }else {
                load=1;
                flag=1;
                showListViewStyle(false);
            }
        }

    }

    @Override
    public void showError(Throwable throwable) {
        showListViewStyle(false);
    }

    @Override
    public void init(Bundle savedInstanceState) {
         string=getIntent().getStringExtra("SEARCHTEXT");
        setTitle(string);


        adapter=new SearchResultAdapter(listBeans,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

        presenter=new MainPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        hashMap.put("q",string);
        //筛选条件
        presenter.searchFiltrate(hashMap,Contans.Tag.SEARCH_FILTRATE);
        //列表
        hashMap.put("p",page);
        presenter.searchResult(hashMap, Contans.Tag.SEARCH);

        filtrate.setOnClickListener(this);
        initRefreshLayout();
        initEvent();
    }

    private void initEvent() {
        adapter.setOnItemClickListener(new SearchResultAdapter.onItemClickListener() {
            @Override
            public void onItem(String productId) {
                GTJHRouter.getInstance().build("/classify/CommodityDetailsActivity").withString("PRODUCETID",productId).navigation(SearchListActivity.this);
            }
        });
    }

    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new ClassicsHeader(SearchListActivity.this));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(SearchListActivity.this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                flag = 0;
                page=1;
                hashMap.clear();
                hashMap.put("q",string);
                hashMap.put("filterAttrs",filter);
                hashMap.put("price",price);
                hashMap.put("p",page);
                presenter.searchResult(hashMap, Contans.Tag.SEARCH);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                flag = 1;
                page++;
                hashMap.clear();
                hashMap.put("q",string);
                hashMap.put("filterAttrs",filter);
                hashMap.put("price",price);
                hashMap.put("p",page);
                presenter.searchResult(hashMap,Contans.Tag.SEARCH);
            }
        });
    }
    private void showListViewStyle(boolean isSuccess) {
        if (flag == 0) {
            refreshLayout.finishRefresh(1000, isSuccess);
            if (load==1) {
                refreshLayout.setNoMoreData(false);
            }
        } else if (flag == 1 && load==1) {
            refreshLayout.finishLoadMore(1000, isSuccess, false);
        } else {
            refreshLayout.finishLoadMore(1000, isSuccess, true);
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_search_list;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    @Override
    public void onItem(String productId) {

    }

    @Override
    public void onClick(View v) {
        //筛选按钮
        if (isLoadFiltrate){
            dialog.show();
        }else {
            ToastUtils.showToastForText(this,"load...");
        }

    }
}
