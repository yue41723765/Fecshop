package com.gtjh.user.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.AddressListBean;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.event.AddressEvent;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.view.HintRecyclerview;
import com.gtjh.router_annotation.Extra;
import com.gtjh.router_annotation.Route;
import com.gtjh.user.LoginActivity;
import com.gtjh.user.bean.AddressBean;
import com.gtjh.user.R;
import com.gtjh.user.R2;
import com.gtjh.user.adapter.AddressAdapter;
import com.gtjh.user.presenter.impl.AddressListPresenterImpl;
import com.gtjh.user.util.dialog.HintDialog;
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
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/10.
 */
@Route(path = "/user/AddressListActivity")
public class AddressListActivity extends ToolBarActivity implements AddressAdapter.onDeleteClickListener, AddressAdapter.OnItemChangeClickListener {
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R2.id.rv_data)
    HintRecyclerview rvData;
    @BindView(R2.id.tv_hiht)
    TextView tvHint;
    @Extra(name = "ISORDER")
    public String addressId;
    private boolean isOrder=false;

    private AddressAdapter adapter;
    private List<AddressListBean> listBeans=new ArrayList<>();
    private int pageIndex=1;
    private int flag=0;
    private HashMap<String,Object> map=new HashMap<>();
    private int pageNum=1;
    private AddressListPresenterImpl presenter;
    @Override
    public void showSuccess(Object o, int tag) {

        switch (tag){
            case Contans.Tag.ADDRESS_LIST:
                initData((ResponseData<Object>) o);
                break;
            case Contans.Tag.ADDRESS_DELETE:
                initDelete((ResponseData<Object>) o);
                break;

        }
    }

    private void initDelete(ResponseData<Object> o) {
        ToastUtils.showToastForText(this,o.getMessage());
        presenter.addressList(Contans.Tag.ADDRESS_LIST);
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
        AddressBean data=gson.fromJson(gson.toJson(o.getData()),AddressBean.class);
        listBeans=data.getAddressList();
        if (isOrder){
            for (int i=0;i<listBeans.size();i++){
                if (listBeans.get(i).getAddress_id().equals(addressId)){
                    listBeans.get(i).setIs_default("1");
                }else {
                    listBeans.get(i).setIs_default("0");
                }
            }
        }
        adapter.initData(listBeans);

        showListViewStyle(true);
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
        }
        if (listBeans!=null&&listBeans.size()>0){
            tvHint.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(Throwable throwable) {
        showListViewStyle(false);
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.shipping_address));
        Build build=new Build();
        build.setText(getResources().getString(R.string.build));
        build.setListener(onRightClickListener);
        build.setTextColor(Color.BLACK);
        build.setTextSize(30);
        setRight(build);

        if (addressId!=null&&!"".equals(addressId)){
            isOrder=true;
        }
        presenter=new AddressListPresenterImpl(this);
        RxBus.getInstance().register(presenter);

        presenter.addressList(Contans.Tag.ADDRESS_LIST);
        adapter=new AddressAdapter(listBeans,AddressListActivity.this);
        rvData.setLayoutManager(new LinearLayoutManager(this));
        rvData.setAdapter(adapter);
        adapter.setOnDeleteClickListener(this);
        if (isOrder) {
            adapter.setOnItemChangeClickListener(this);
        }
        initRefreshLayout();
    }


    //新建按钮的监听
    private View.OnClickListener onRightClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(AddressListActivity.this,AddAddressActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_address_list;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new ClassicsHeader(AddressListActivity.this));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(AddressListActivity.this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                flag = 0;
                presenter.addressList( Contans.Tag.ADDRESS_LIST);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                flag = 1;
                presenter.addressList( Contans.Tag.ADDRESS_LIST);
            }
        });
    }
    /***
     * 成功失败列表视图样式
     * @param isSuccess 成功失败
     *
     * **/
    private void showListViewStyle(boolean isSuccess) {
        RYLog.e("pageIndex=" + pageIndex + "pageNum" + pageNum + "flag" + flag);
        if (flag == 0) {
            refreshLayout.finishRefresh(1000, isSuccess);
            if (pageIndex < pageNum) {
                refreshLayout.setNoMoreData(false);
            }
        } else if (flag == 1 && pageIndex < pageNum) {
            refreshLayout.finishLoadMore(1000, isSuccess, false);
        } else {
            refreshLayout.finishLoadMore(1000, isSuccess, true);
        }
}

    @Override
    public void onDelete(final String id) {
        //地址删除
        final HintDialog hintDialog=new HintDialog(this);
        hintDialog.setOnRightClickListener(new HintDialog.OnRightClickListener() {
            @Override
            public void onRight() {
                HashMap<String,Object> map=new HashMap<>();
                map.put("address_id",id);
                presenter.deleteAddress(map,Contans.Tag.ADDRESS_DELETE);
                hintDialog.cancel();
            }
        });
        hintDialog.show();
    }

    @Override
    public void onChange( AddressListBean bean) {
        Log.i("TAG","为啥不走啊"+bean.getAddress_id());
        EventBus.getDefault().post(new AddressEvent(bean));
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.addressList(Contans.Tag.ADDRESS_LIST);
    }
}
