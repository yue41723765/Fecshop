package com.gtjh.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.event.IsClassifyEvent;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;

import com.gtjh.common.util.RYLog;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.view.HintRecyclerview;
import com.gtjh.common.view.OnItemClickLinster;
import com.gtjh.router_core.GTJHRouter;
import com.gtjh.user.LoginActivity;
import com.gtjh.user.bean.OrderBean;
import com.gtjh.user.bean.OrderListBean;
import com.gtjh.user.R;
import com.gtjh.user.R2;
import com.gtjh.user.adapter.OrderAdapter;
import com.gtjh.user.presenter.impl.OrderPresenterImpl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/13.
 * 李 -这一页因为ButterKnife一直报错 所以所有的注射都改成手动了 报错原因未知
 */

public class OrderActivity extends ToolBarActivity implements OrderAdapter.onAgainClickListener, OrderAdapter.onAllClickListener {
    SmartRefreshLayout refreshLayout;
    RecyclerView recyclerView;
    TextView tvHint;
    LinearLayout llHint;
    private OrderPresenterImpl presenter;
    private int flag=0;
    private int load=0;
    private int pageNum=1;
    private OrderAdapter adapter;
    private List<OrderListBean> listBeans=new ArrayList<>();
    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag){
            case Contans.Tag.ORDER_LIST:
                initData((ResponseData<OrderBean>) o);
                break;
            case Contans.Tag.ORDER_AGAIN:
                initSuccess((ResponseData<Object>)o);
                break;
        }
    }

    private void initSuccess(ResponseData<Object> o) {
        if (o.getCode()==200){
            GTJHRouter.getInstance().build("/fecshop/MainActivity").withString("CHECKED","2").navigation(OrderActivity.this);
            finish();
        }else {
            ToastUtils.showToastForText(this,o.getMessage());
        }
    }

    private void initData(ResponseData<OrderBean> o) {
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
        OrderBean orderBean=gson.fromJson(gson.toJson(o.getData()),OrderBean.class);
        listBeans=orderBean.getOrderList();
        if (pageNum==1){
            adapter.initData(listBeans);
        }else {
            if (listBeans!=null&&listBeans.size()>0){
                adapter.setDatas(listBeans);
                load=0;
            }
        }
        if (!"0".equals(orderBean.getCount())){
            llHint.setVisibility(View.GONE);
        }else {
            llHint.setVisibility(View.VISIBLE);
        }
        showListViewStyle(true);
    }

    @Override
    public void showError(Throwable throwable) {
        showListViewStyle(false);
    }

    @Override
    public void init(Bundle savedInstanceState) {
        refreshLayout=findViewById(R.id.refreshLayout_re);
        recyclerView=findViewById(R.id.rv_datas);
        tvHint=findViewById(R.id.tv_empty);
        llHint=findViewById(R.id.ll_empty);
        setTitle(getResources().getString(R.string.myOrder));

        presenter=new OrderPresenterImpl(this);
        RxBus.getInstance().register(presenter);
         HashMap<String,Object> map=new HashMap<>();
         map.put("p",pageNum);
        presenter.orderList(map, Contans.Tag.ORDER_LIST);

        adapter=new OrderAdapter(listBeans,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnAgainClickListener(this);
        adapter.setOnAllClickListener(this);
        initRefreshLayout();
        initEvent();
    }

    private void initEvent() {
        tvHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //前往购物
                GTJHRouter.getInstance().build("/fecshop/MainActivity").withString("CHECKED","2").navigation(OrderActivity.this);
                finish();
            }
        });
    }

    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new ClassicsHeader(OrderActivity.this));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(OrderActivity.this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                pageNum=1;
                flag = 0;
                HashMap<String,Object> map=new HashMap<>();
                map.put("p",pageNum);
                presenter.orderList( map,Contans.Tag.ORDER_LIST);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                flag = 1;
                pageNum++;
                HashMap<String,Object> map=new HashMap<>();
                map.put("p",pageNum);
                presenter.orderList( map,Contans.Tag.ORDER_LIST);
            }
        });
    }
    private void showListViewStyle(boolean isSuccess) {
        if (flag == 0) {
            refreshLayout.finishRefresh(1000, isSuccess);
        } else if (flag == 1 && load==1) {
            refreshLayout.finishLoadMore(1000, isSuccess, false);
        } else {
            refreshLayout.finishLoadMore(1000, isSuccess, true);
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_order_list;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    @Override
    public void onAgain(String order_id) {
        //重新下单
        HashMap<String ,Object> map=new HashMap<>();
        map.put("order_id",order_id);
        presenter.orderAgain(map,Contans.Tag.ORDER_AGAIN);
    }

    @Override
    public void onAll(String orderId) {
        //查看详情
        Intent intent=new Intent(OrderActivity.this,OrderDetailsActivity.class);
        intent.putExtra("ORDERID",orderId);
        startActivity(intent);
    }
}
