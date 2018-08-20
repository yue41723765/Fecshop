package com.gtjh.classify.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.classify.R;
import com.gtjh.classify.R2;
import com.gtjh.classify.adapter.ClassifyPageAdapter;
import com.gtjh.classify.bean.ClassifyBean;
import com.gtjh.classify.bean.ClassifyPageBean;
import com.gtjh.classify.bean.ClassifyPageListBean;
import com.gtjh.classify.dialog.ClassifyFilterDialog;
import com.gtjh.classify.presenter.impl.ClassifyPresenterImpl;
import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.view.HintRecyclerview;
import com.gtjh.router_core.GTJHRouter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by android on 2018/7/19.
 */

public class ClassifyActivity extends ToolBarActivity implements View.OnClickListener {
    @BindView(R2.id.ll_filtrate)
    LinearLayout filtrate;
    @BindView(R2.id.iv_title)
    ImageView ivTitle;
    @BindView(R2.id.rv_data)
    HintRecyclerview recyclerView;
    @BindView(R2.id.tv_hiht)
    TextView tvHint;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private String id ="";
    private HashMap<String,Object> hashMap=new HashMap<>();
    private ClassifyPresenterImpl presenter;
    private int page=1;
    private int load=0;
    private int flag=0;
    private String sortColumn="";
    private String price="";
    private Boolean isLoadFiltrate=false;
    private Map<String,String> filter=new HashMap<>();
    private ClassifyFilterDialog dialog;
    private List<ClassifyPageListBean> listBeans=new ArrayList<>();
    private ClassifyPageAdapter adapter;
    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag){
            case Contans.Tag.CLASSIFY_CONTENT:
                initData((ResponseData<Object>) o);
                break;
            case Contans.Tag.CLASSIFY_FILTRATE:
                initFiltrate((ResponseData<Object>)o);
                break;
        }
    }

    private void initFiltrate(ResponseData<Object> o) {
        if (o.getCode()==200){
            ClassifyBean bean=gson.fromJson(gson.toJson(o.getData()),ClassifyBean.class);
            setTitle(bean.getName());
            if (bean.getImage()!=null&&!"".equals(bean.getImage())){
                ImageLoaderPresenter.getInstance().loadRound(this, bean.getImage(), ivTitle);
                ivTitle.setVisibility(View.VISIBLE);
            }
            dialog=new ClassifyFilterDialog(this,bean);
            dialog.setOnFiltrateClickListener(new ClassifyFilterDialog.onFiltrateClickListener() {
                @Override
                public void onFiltrate(String pri,String sort,String cate, Map<String, String> filterAttrs) {
                    filter=filterAttrs;
                    price=pri;
                    sortColumn=sort;
                    page=1;
                    if (cate!=null&&!"".equals(cate)){
                        id=cate;
                    }
                    hashMap.clear();
                    hashMap.put("categoryId",id);
                    //后台不能直接接受map需要转为json
                    hashMap.put("filterAttrs", mapToJson(filter));
                    hashMap.put("filterPrice",price);
                    hashMap.put("p",page);
                    hashMap.put("sortColumn",sortColumn);
                    Log.i("TAG",id+"-"+filter+"-"+price+"-"+page+"-"+sortColumn);
                    presenter.classifyContent(hashMap,Contans.Tag.CLASSIFY_CONTENT);
                }
            });
            isLoadFiltrate=true;
        }else {
            ToastUtils.showToastForText(this,o.getMessage());
        }
    }

    private String mapToJson(Map<String, String> map) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }
    private void initData(ResponseData<Object> o) {
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            showListViewStyle(false);
            return;
        }
        ClassifyPageBean bean=gson.fromJson(gson.toJson(o.getData()),ClassifyPageBean.class);
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
        }else {
            if (listBeans!=null&&listBeans.size()>0){
                adapter.setDatas(listBeans);
                load=0;
                flag=1;
            }else {
                load=1;
                flag=1;
            }
        }
        showListViewStyle(true);
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        id=getIntent().getStringExtra("categoryId");
        presenter=new ClassifyPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        hashMap.put("categoryId",id);
        Log.i("TAGID",id);
        presenter.classifyFilter(hashMap, Contans.Tag.CLASSIFY_FILTRATE);
        hashMap.put("p",page);
        presenter.classifyContent(hashMap,Contans.Tag.CLASSIFY_CONTENT);
        filtrate.setOnClickListener(this);

        adapter=new ClassifyPageAdapter(listBeans,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        initEvent();
        initRefreshLayout();
    }

    private void initEvent() {
        adapter.setOnItemClickListener(new ClassifyPageAdapter.onItemClickListener() {
            @Override
            public void onItem(String productId) {
                GTJHRouter.getInstance().build("/classify/CommodityDetailsActivity").withString("PRODUCETID",productId).navigation(ClassifyActivity.this);
            }
        });
    }


    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new ClassicsHeader(ClassifyActivity.this));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(ClassifyActivity.this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                flag = 0;
                page=1;
                hashMap.clear();
                hashMap.put("categoryId",id);
                hashMap.put("filterAttrs",filter);
                hashMap.put("filterPrice",price);
                hashMap.put("p",page);
                hashMap.put("sortColumn",sortColumn);
                presenter.classifyContent(hashMap, Contans.Tag.CLASSIFY_CONTENT);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                flag = 1;
                page++;
                hashMap.clear();
                hashMap.put("categoryId",id);
                hashMap.put("filterAttrs",filter);
                hashMap.put("filterPrice",price);
                hashMap.put("p",page);
                hashMap.put("sortColumn",sortColumn);
                presenter.classifyContent(hashMap,Contans.Tag.CLASSIFY_CONTENT);
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
        return R.layout.activity_classify;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    @Override
    public void onClick(View v) {
        if (isLoadFiltrate){
            dialog.show();
        }else {
            ToastUtils.showToastForText(this,"load...");
            return;
        }
    }
}
