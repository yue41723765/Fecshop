package com.gtjh.main;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.google.gson.Gson;
import com.gtjh.common.BaseFragment;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.view.CustomGridManager;
import com.gtjh.main.activity.SearchActivity;
import com.gtjh.main.adapter.AdvertAdapter;
import com.gtjh.main.adapter.MainPruductAdapter;
import com.gtjh.main.model.entity.Main;
import com.gtjh.main.presenter.impl.MainPresenterImpl;
import com.gtjh.main.view.ImageViewHolder;
import com.gtjh.router_core.GTJHRouter;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.header.FunGameHitBlockHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by android on 2018/7/2.
 */

public class MainFragment extends BaseFragment {

    @BindView(R2.id.cb_banner)
    ConvenientBanner banner;
    private MainPresenterImpl presenter;
    @BindView(R2.id.rv_advert)
    RecyclerView rv_advert;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @BindView(R2.id.rv_product)
    RecyclerView rv_product;
    private AdvertAdapter adapter;

    private MainPruductAdapter pruductAdapter;

    private Gson gson=new Gson();
    @Override
    protected void init() {
        presenter = new MainPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        presenter.loadMainInfo(Contans.Tag.INIT_MAIN);
        initRefreshLayout();
    }

    //初始化banner
    private void initBanner(final List<Main.Advert.AdvertInfo> banners) {
        banner.setPages(new CBViewHolderCreator<ImageViewHolder<Main.Advert.AdvertInfo>>() {
            @Override
            public ImageViewHolder createHolder() {
                return new ImageViewHolder();
            }
        }, banners)
                .setPageIndicator(new int[]{R.drawable.dot_default, R.drawable.dot_select})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT).startTurning(3000);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag) {
            case Contans.Tag.INIT_MAIN:
                ResponseData<Main> responseData = (ResponseData<Main>) o;
                if (((ResponseData<Main>) o).getCode()!=200){
                    showListViewStyle(false);
                }else {
                    showListViewStyle(true);
                }
                initBanner(responseData.getData().getAdvertiseImg().bigImgList);
                initRV(responseData.getData().getAdvertiseImg().smallImgList);
                initProduct(responseData.getData().getProductList());
                break;
        }
    }

    @Override
    public void showError(Throwable throwable) {
        super.showError(throwable);
        showListViewStyle(false);
    }

    private void initProduct(List<Main.Product> productList) {
        List<Main.Product.ProductChild> datas = new ArrayList<>();
        for (Main.Product product : productList) {
            Main.Product.ProductChild one = product.one;
            datas.add(one);
            Main.Product.ProductChild two = product.two;
            if (two != null) {
                datas.add(two);
            }
        }
        if (pruductAdapter==null) {
            pruductAdapter = new MainPruductAdapter(datas, getActivity());
        }
        CustomGridManager gridManager = new CustomGridManager(getActivity(),2);
        gridManager.setScrollEnabled(false);

        rv_product.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rv_product.setNestedScrollingEnabled(false);
        rv_product.setAdapter(pruductAdapter);
        pruductAdapter.setOnItemListener(new MainPruductAdapter.OnItemClickListener() {
            @Override
            public void onItem(int position, String id) {
                GTJHRouter.getInstance().build("/classify/CommodityDetailsActivity").withString("PRODUCETID",id).navigation(getActivity());
            }
        });
    }

    private void initRV(List<Main.Advert.AdvertInfo> advertInfos) {
        if (adapter==null) {
            adapter = new AdvertAdapter(advertInfos, getActivity());
        }
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_advert.setLayoutManager(manager);
        rv_advert.setAdapter(adapter);

    }
    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new BezierCircleHeader(mContext));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                presenter.loadMainInfo(Contans.Tag.INIT_MAIN);
            }
        });
    }
    private void showListViewStyle(boolean isSuccess) {
        refreshLayout.finishRefresh(1000, isSuccess);
    }
    @OnClick(R2.id.iv_search)
    public void search(){
        Intent intent=new Intent(mContext, SearchActivity.class);
        startActivity(intent);
    }
}
