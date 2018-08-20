package com.gtjh.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;

import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.view.HintRecyclerview;
import com.gtjh.common.view.OnItemClickLinster;
import com.gtjh.router_core.GTJHRouter;
import com.gtjh.user.LoginActivity;
import com.gtjh.user.R;
import com.gtjh.user.R2;
import com.gtjh.user.adapter.CollectAdapter;
import com.gtjh.user.bean.CollectBean;
import com.gtjh.user.bean.CollectListBean;
import com.gtjh.user.presenter.impl.CollectPresenterImpl;
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
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/16.
 */

public class CollectActivity extends ToolBarActivity implements CollectAdapter.onDeleteClickListener {
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R2.id.rv_data)
    HintRecyclerview recyclerView;
    @BindView(R2.id.ll_hint)
    LinearLayout llHint;
    @BindView(R2.id.tv_hint)
    TextView tvHint;

    private CollectAdapter adapter;
    private CollectPresenterImpl presenter;
    private int page=1;
    private HashMap<String ,Object> hashMap=new HashMap<>();
    private List<CollectBean.ProductListBean> listBeans=new ArrayList<>();
    private int flag=0;
   private int load=0;
    @Override
    public void showSuccess(Object o, int tag) {

        switch (tag){
            case Contans.Tag.COLLECT_LIST:
                initData((ResponseData<Object>)o);
                break;
            case Contans.Tag.COLLECT_DELETE:
                initSuccess((ResponseData<Object>) o);
                break;
        }
    }

    private void initSuccess(ResponseData<Object> o) {
        if (o.getCode()==200){
            hashMap.clear();
            hashMap.put("p",page);
            presenter.collectList(hashMap,Contans.Tag.COLLECT_LIST);
        }
        ToastUtils.showToastForText(this,o.getMessage());
    }

    private void initData(ResponseData<Object> o) {
        if (o.getCode()!=200){
            if (o.getCode()==1100003){
                Intent intent=new Intent(this, LoginActivity.class);
                startActivity(intent);
                SPUtil.saveIsLogin(this,false);
                SPUtil.clearToken(this);
                RxBus.getInstance().chainProcess(new Function() {
                    @Override
                    public Object apply(Object o) throws Exception {
                        return Observable.just(false);
                    }
                }, Contans.Tag.LOGIN);
                finish();
            }else {
                ToastUtils.showToastForText(this,o.getMessage());
            }
            return;
        }
        CollectBean data=gson.fromJson(gson.toJson(o.getData()), CollectBean.class);
        listBeans=data.getProductList();
        if (page==1){
            adapter.initData(listBeans);
            flag=0;
            load=0;
        }else {
            if (listBeans!=null&&listBeans.size()>1){
                adapter.setDatas(listBeans);
                flag=1;
                load=0;
            }else {
                flag=1;
                load=1;
            }
        }
        if (data.getCount()==0){
            flag=1;
            llHint.setVisibility(View.VISIBLE);
            load=1;
        }else {
            llHint.setVisibility(View.GONE);
        }
        showListViewStyle(true);
    }

    @Override
    public void showError(Throwable throwable) {
        showListViewStyle(false);
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.myCollect));

        presenter=new CollectPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        hashMap.put("p",page);
        presenter.collectList(hashMap, Contans.Tag.COLLECT_LIST);

        adapter=new CollectAdapter(listBeans,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
        adapter.setOnDeleteClickListener(this);
        initRefreshLayout();
    }


    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new ClassicsHeader(CollectActivity.this));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(CollectActivity.this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page=1;
                flag = 0;
                hashMap.clear();
                hashMap.put("p",page);
                presenter.collectList(hashMap, Contans.Tag.COLLECT_LIST);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                flag = 1;
                page++;
                hashMap.clear();
                hashMap.put("p",page);
                presenter.collectList( hashMap,Contans.Tag.COLLECT_LIST);
            }
        });
    }
    private void showListViewStyle(boolean isSuccess) {
        if (flag == 0) {
            refreshLayout.finishRefresh(1000, isSuccess);
            if (load==1) {
                refreshLayout.setNoMoreData(false);
            }
        } else if (flag == 1 &&load==1) {
            refreshLayout.finishLoadMore(1000, isSuccess, false);
        } else {
            refreshLayout.finishLoadMore(1000, isSuccess, true);
        }
    }

    @OnClick(R2.id.tv_hint)
    public void shop(){
        //前往购物
        GTJHRouter.getInstance().build("/fecshop/MainActivity").withString("CHECKED","2").navigation(CollectActivity.this);
        finish();
    }

    @Override
    public void onDelete(String id) {
        //刪除商品
        hashMap.clear();
        hashMap.put("favorite_id",id);
        presenter.deleteCollect(hashMap,Contans.Tag.COLLECT_DELETE);
    }

    @Override
    public void onItem(String id) {
        GTJHRouter.getInstance().build("/classify/CommodityDetailsActivity").withString("PRODUCETID",id).navigation(CollectActivity.this);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_collect;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }


}
