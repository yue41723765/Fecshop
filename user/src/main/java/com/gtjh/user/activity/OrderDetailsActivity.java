package com.gtjh.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.AddressListBean;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.AliPayHelper;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.PayPalHelper;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.view.CustomLinearLayoutManager;
import com.gtjh.common.view.HintRecyclerview;
import com.gtjh.user.R;
import com.gtjh.user.R2;
import com.gtjh.user.RegisterActivity;
import com.gtjh.user.adapter.OrderDetailsAdapter;
import com.gtjh.user.bean.OrderDetailsBean;
import com.gtjh.user.bean.OrderDetailsListBean;
import com.gtjh.user.presenter.impl.OrderPresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by android on 2018/7/13.
 */

public class OrderDetailsActivity extends ToolBarActivity {
    @BindView(R2.id.tv_order_id)
    TextView tvOrderId;
    @BindView(R2.id.tv_state)
    TextView tvOrderState;
    @BindView(R2.id.tv_date)
    TextView tvOrderDate;
    @BindView(R2.id.tv_shipping)
    TextView tvOrderShipping;
    @BindView(R2.id.tv_address)
    TextView tvOrderAddress;
    @BindView(R2.id.tv_name)
    TextView tvOrderName;
    @BindView(R2.id.tv_telephone)
    TextView tvOrderTelephone;
    @BindView(R2.id.tv_payment)
    TextView tvOrderPayment;
    @BindView(R2.id.tv_count)
    TextView tvOrderCount;
    @BindView(R2.id.tv_freight)
    TextView tvOrderFreight;
    @BindView(R2.id.tv_preferential)
    TextView tvOrderPreferential;
    @BindView(R2.id.tv_total)
    TextView tvOrderTotal;
    @BindView(R2.id.tv_bottom_total)
    TextView tvBottomTotal;
    @BindView(R2.id.tv_pay)
    TextView tvBottomPay;
    @BindView(R2.id.tv_shipping_name)
    TextView tvOrderShippingName;
    @BindView(R2.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R2.id.rl_data)
    HintRecyclerview rlData;

    private OrderDetailsAdapter adapter;
    private OrderPresenterImpl presenter;
    private List<OrderDetailsListBean> listBeans=new ArrayList<>();
    private HashMap<String ,Object> map=new HashMap<>();
    private int state=0; //0为已完成 1为待支付
    private String payment="";
    private   AddressListBean address=new AddressListBean();
    private   OrderDetailsBean.OrderBean orderBean;
    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag){
            case Contans.Tag.ORDER_DETAILS:
            initData((ResponseData<Object>) o);
            break;
        }
    }

    private void initData(ResponseData<Object> o) {
        OrderDetailsBean data=gson.fromJson(gson.toJson(o.getData()),OrderDetailsBean.class);
       orderBean=data.getOrder();
        //状态
        orderStatus(orderBean.getOrder_status());
        //商品列表
        adapter.setStatus(state);
        adapter.setSymbol(orderBean.getCurrency_symbol());
        adapter.initData(orderBean.getProducts());
        //一些文字数据
        tvOrderId.setText(orderBean.getIncrement_id());
        tvOrderState.setText(orderBean.getOrder_status());
        tvOrderDate.setText(orderBean.getCreated_at());

        tvOrderShippingName.setText(orderBean.getShipping_method());
        tvOrderShipping.setText("HKBRAM  "+orderBean.getCurrency_symbol()+" "+orderBean.getShipping_total());
        tvOrderAddress.setText(orderBean.getCustomer_address_street1());
        tvOrderName.setText(orderBean.getCustomer_lastname()+"  "+orderBean.getCustomer_firstname());
        tvOrderTelephone.setText(orderBean.getCustomer_telephone());

        tvOrderPayment.setText(orderBean.getPayment_method());

        tvOrderCount.setText(orderBean.getCurrency_symbol()+" "+orderBean.getBase_subtotal());
        tvOrderFreight.setText(orderBean.getCurrency_symbol()+" "+orderBean.getShipping_total());
        tvOrderTotal.setText(orderBean.getCurrency_symbol()+" "+orderBean.getSubtotal());
        tvOrderPreferential.setText("-"+orderBean.getCurrency_symbol()+" "+orderBean.getSubtotal_with_discount());

        //底部总计
        tvBottomTotal.setText(orderBean.getCurrency_symbol()+" "+orderBean.getSubtotal());


        address.setCity(orderBean.getCustomer_address_city());
        address.setCountry(orderBean.getCustomer_address_country());
        address.setCountryName(orderBean.getCustomer_address_country_name());
        address.setZip(orderBean.getCustomer_address_zip());
        address.setState(orderBean.getCustomer_address_state());
        address.setStateName(orderBean.getCustomer_address_state_name());
        address.setLast_name(orderBean.getCustomer_lastname());
        address.setFirst_name(orderBean.getCustomer_firstname());
        address.setStreet1(orderBean.getCustomer_address_street1());
        address.setStreet2(orderBean.getCustomer_address_street2());
    }

    private void orderStatus(String status) {
        switch (status){
            case "payment_pending":
                state=1;
                llBottom.setVisibility(View.VISIBLE);
                break;
            case "completed":
                state=0;
                llBottom.setVisibility(View.GONE);
                break;
            default:
                llBottom.setVisibility(View.GONE);
                state=1;
                break;
        }
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.orderDetails));

        presenter=new OrderPresenterImpl(this);
        RxBus.getInstance().register(presenter);

        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(this);
        linearLayoutManager.setScrollEnabled(false);
        adapter=new OrderDetailsAdapter(listBeans,this);
        rlData.setLayoutManager(linearLayoutManager);
        rlData.setAdapter(adapter);
        String orderId=getIntent().getStringExtra("ORDERID");
        map.put("order_id",orderId);
        presenter.orderDetails(map, Contans.Tag.ORDER_DETAILS);
        PayPalHelper.getInstance().startPayPalService(this);
    }


    @OnClick(R2.id.tv_pay)
    public void register() {
        //去支付
        if ("alipay_standard".equals(payment)){
            AliPayHelper aliPayHelper=new AliPayHelper();
            aliPayHelper.setAliPayClickListener(listener);
            aliPayHelper.startAliPaySerVice(this,orderBean.getOrder_id()+"",orderBean.getCreated_at(),"",orderBean.getGrand_total());

        }else if ("paypal_standard".equals(payment)){

            PayPalHelper.getInstance().doPayPalPay(this,orderBean.getGrand_total(),orderBean.getOrder_currency_code(),orderBean.getCreated_at(),orderBean.getIncrement_id(),address);
        }else {
            //ToastUtils.showToastForText(this,"");
            finish();
        }
    }
    AliPayHelper.AliPayClickListener listener=new AliPayHelper.AliPayClickListener() {
        @Override
        public void success() {
            finish();
            ToastUtils.showToastForText(OrderDetailsActivity.this,"success");
        }

        @Override
        public void fail() {
            ToastUtils.showToastForText(OrderDetailsActivity.this,"fail");
        }

        @Override
        public void cancel() {
            ToastUtils.showToastForText(OrderDetailsActivity.this,"cancel");
        }

        @Override
        public void confirm() {
            ToastUtils.showToastForText(OrderDetailsActivity.this,"confirm");
        }
    };

    PayPalHelper.DoResult doResult=new PayPalHelper.DoResult() {
        @Override
        public void confirmSuccess() {
            finish();
            ToastUtils.showToastForText(OrderDetailsActivity.this,"success");
        }

        @Override
        public void confirmNetWorkError() {
            ToastUtils.showToastForText(OrderDetailsActivity.this,"Error");
        }

        @Override
        public void customerCanceled() {
            ToastUtils.showToastForText(OrderDetailsActivity.this,"Cancel");
        }

        @Override
        public void confirmFuturePayment() {
            ToastUtils.showToastForText(OrderDetailsActivity.this,"confirmFuturePayment");
        }

        @Override
        public void invalidPaymentConfiguration() {
            ToastUtils.showToastForText(OrderDetailsActivity.this,"invalidPaymentConfiguration");
        }
    };
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        PayPalHelper.getInstance().confirmPayResult(this,requestCode,resultCode,data,doResult);
    }

    @Override
    protected void onDestroy() {
        PayPalHelper.getInstance().stopPayPalService(this);
        super.onDestroy();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_details;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }
}
