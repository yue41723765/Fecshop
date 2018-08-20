package com.gtjh.shop_car;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.common.BaseFragment;
import com.gtjh.common.GTJHApplication;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.view.OnItemClickLinster;
import com.gtjh.router_core.GTJHRouter;
import com.gtjh.shop_car.activity.ConfirmOrderActivity;
import com.gtjh.shop_car.adapter.CartAdapter;
import com.gtjh.shop_car.bean.CartBean;
import com.gtjh.shop_car.bean.ProductsListBean;
import com.gtjh.shop_car.presenter.impl.ShopCarPresenterImpl;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by android on 2018/7/2.
 */

public class ShopCarFragment extends BaseFragment {
  /*  @BindView(R2.id.title)
    TextView tv_center;*/
    @BindView(R2.id.tv_title)
    TextView title;
    @BindView(R2.id.rv_car)
    RecyclerView rvCar;
    @BindView(R2.id.all)
    CheckBox cbAll;
    @BindView(R2.id.tv_pay)
    TextView tvPay;
    @BindView(R2.id.tv_money)
    TextView tvMoney;
    @BindView(R2.id.tv_hint)
    TextView tvHint;
    @BindView(R2.id.rl_bottom)
    RelativeLayout rlBottom;
    @BindView(R2.id.tv_shipping)
    TextView tvShipping;
    @BindView(R2.id.ll_hint)
    LinearLayout llHint;
    private CartAdapter adapter;
    private ShopCarPresenterImpl presenter;
    private Gson gson=new Gson();
    private List<ProductsListBean> listBeans=new ArrayList<>();
    private HashMap<String,Object> hashMap=new HashMap<>();
    private Boolean oneChecked=false;
    private Boolean isOne=false;
    private Boolean isLoad=true;
    @Override
    public void showSuccess(Object o, int tag) {
        //没走这个方法
        switch (tag){
            case Contans.Tag.CART_LIST:
                initData((ResponseData<Object> )o);
                break;
            case Contans.Tag.CART_UPDATA:
                initInfo((ResponseData<Object>) o);
                break;
            case Contans.Tag.CART_SELECT:
                initInfo((ResponseData<Object>) o);
                break;
            case Contans.Tag.CART_SELECT_ALL:
                initInfo((ResponseData<Object>) o);
                break;
        }
    }

    private void initInfo(ResponseData<Object> o) {
        if (o.getCode()==200){
            presenter.loadData(Contans.Tag.CART_LIST);
        }else {
            ToastUtils.showToastForText(mContext,o.getMessage());
        }
    }

    @Override
    public void showError(Throwable throwable) {
        super.showError(throwable);
        rlBottom.setVisibility(View.GONE);
        llHint.setVisibility(View.VISIBLE);
    }

    private void initData(ResponseData<Object> o) {
        //有数据为CartBean 无数据为{cart_info}
        Map<String,Object> map=gson.fromJson(gson.toJson(o.getData()),Map.class);
        if ("false".equals(map.get("cart_info").toString())){
            rlBottom.setVisibility(View.GONE);
            llHint.setVisibility(View.VISIBLE);
            rvCar.setVisibility(View.GONE);
            return;
        }else {
            llHint.setVisibility(View.GONE);
            rlBottom.setVisibility(View.VISIBLE);
            rvCar.setVisibility(View.VISIBLE);
        }
        CartBean data= gson.fromJson(gson.toJson(o.getData()),CartBean.class);
        CartBean.CartInfo info=data.getCart_info();
        CartBean.CurrencyBean currency=data.getCurrency();
        tvMoney.setText(currency.getSymbol()+info.getProduct_total());
        if (info.getShipping_method()==null||"".equals(info.getShipping_method())){
            tvShipping.setText(R.string.notShipping);
        }else
        {
            tvShipping.setText(info.getShipping_method()+":"+currency.getSymbol()+info.getShipping_cost());
        }
        adapter.setSymbol(currency.getSymbol());
        adapter.initData(info.getProducts());
        for (int i=0;i<info.getProducts().size();i++){
            if (1!=info.getProducts().get(i).getActive()) {
                oneChecked = false;
                break;
            }
            if((info.getProducts().size()-1)==i){
                if (1==info.getProducts().get(i).getActive()) {
                    oneChecked = true;
                }
            }
        }
        if (cbAll.isChecked()!=oneChecked){
            isOne=true;
            cbAll.setChecked(oneChecked);
        }
    }

    @Override
    protected void init() {

        presenter=new ShopCarPresenterImpl(this);
        RxBus.getInstance().register(presenter);

        presenter.loadData(Contans.Tag.CART_LIST);
        adapter=new CartAdapter(listBeans,mContext);
        rvCar.setLayoutManager(new LinearLayoutManager(mContext));
        rvCar.setAdapter(adapter);

        initEvent();
    }

    private void initEvent() {
        adapter.setOnLoseClickListener(new CartAdapter.onLoseClickListener() {
            @Override
            public void onLose(int pos, double id) {
                hashMap.clear();
                hashMap.put("up_type","less_one");
                hashMap.put("item_id",id);
                upData();
            }

            @Override
            public void onAdd(int pos, double id) {
                hashMap.clear();
                hashMap.put("up_type","add_one");
                hashMap.put("item_id",id);
                upData();
            }

            @Override
            public void onDelete(int pos, double id) {
                hashMap.clear();
                hashMap.put("up_type","remove");
                hashMap.put("item_id",id);
                upData();
            }

            @Override
            public void onCheck(int pos, double id, Boolean isCheck) {
                hashMap.clear();
                if (isCheck){
                    hashMap.put("checked",1);
                }else {
                    hashMap.put("checked",0);
                }
                hashMap.put("item_id",id);
                presenter.selectOne(hashMap,Contans.Tag.CART_SELECT);
            }

            @Override
            public void onItem(int pos, String id) {
                //点击进入详情
                GTJHRouter.getInstance().build("/classify/CommodityDetailsActivity").withString("PRODUCETID",id).navigation(getActivity());
            }
        });
        cbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isOne){
                    isOne=false;
                    Log.i("IS","isone："+isOne+"ischenck:"+isChecked);
                }else {
                    hashMap.clear();
                    if (isChecked){
                        hashMap.put("checked",1);
                    }else {
                        hashMap.put("checked",0);
                    }
                    presenter.selectAll(hashMap,Contans.Tag.CART_SELECT_ALL);
                }
            }
        });
        tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( SPUtil.getIsLogin(mContext)){
                    Intent intent=new Intent(mContext, ConfirmOrderActivity.class);
                    startActivity(intent);
                }else {
                    return;
                }

            }
        });
    }

    private void upData() {
        presenter.upData(hashMap,Contans.Tag.CART_UPDATA);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop_car;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            if (presenter!=null){
                presenter.loadData(Contans.Tag.CART_LIST);
            }
        }
    }
}
