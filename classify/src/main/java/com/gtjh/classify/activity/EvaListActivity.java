package com.gtjh.classify.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.R2;
import com.gtjh.classify.adapter.EvaListAdapter;
import com.gtjh.classify.bean.EvaBean;
import com.gtjh.classify.presenter.impl.ClassifyPresenterImpl;
import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.ToastUtils;
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

import butterknife.BindView;

/**
 * Created by android on 2018/7/31.
 */

public class EvaListActivity extends ToolBarActivity {
    @BindView(R2.id.rv_data)
    RecyclerView rvData;
    @BindView(R2.id.tv_hint)
    TextView tvHint;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private HashMap hashMap=new HashMap();
    private ClassifyPresenterImpl presenter;
    private int flag=0;
    private int page=1;
    private String id="";
    private int  load=0;

    private EvaListAdapter evaListAdapter;
    private List<EvaBean.ReviewListBean> listBeans=new ArrayList<>();
    @Override
    public void showSuccess(Object o, int tag) {

        switch (tag){
            case Contans.Tag.EVA_LIST:
                initData((ResponseData<Object>) o);
                break;
        }
    }

    private void initData(ResponseData<Object> o) {
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            showListViewStyle(false);
            return;
        }
        EvaBean data=gson.fromJson(gson.toJson(o.getData()),EvaBean.class);
        listBeans=data.getReviewList();
        if (data.getReview_count()!=0){
            load=0;
            tvHint.setVisibility(View.GONE);
        }else {
            tvHint.setVisibility(View.VISIBLE);
            load=1;
        }
        if (page==1){
            evaListAdapter.initData(listBeans);
        }else {
            evaListAdapter.setDatas(listBeans);
        }
        showListViewStyle(true);
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {

        setTitle(R.string.allEva);
        id=getIntent().getStringExtra("PRODUCETID");
        presenter=new ClassifyPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        hashMap.put("product_id",id);
        hashMap.put("p",page);
        presenter.evaList(hashMap,Contans.Tag.EVA_LIST);

        evaListAdapter=new EvaListAdapter(listBeans,this);
        rvData.setLayoutManager(new LinearLayoutManager(this));
        rvData.setAdapter(evaListAdapter);
        initRefreshLayout();
    }
    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new ClassicsHeader(EvaListActivity.this));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(EvaListActivity.this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                flag = 0;
                hashMap.clear();
                hashMap.put("product_id",id);
                hashMap.put("p",page);
                presenter.evaList(hashMap, Contans.Tag.EVA_LIST);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                flag = 1;
                hashMap.clear();
                hashMap.put("product_id",id);
                hashMap.put("p",page);
                presenter.evaList(hashMap,Contans.Tag.EVA_LIST);
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
        return R.layout.activity_eva_list;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }
}
