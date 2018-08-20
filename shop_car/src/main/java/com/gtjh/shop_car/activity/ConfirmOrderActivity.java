package com.gtjh.shop_car.activity;

import android.app.AliasActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.AddressListBean;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.event.AddressEvent;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.AliPayHelper;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.PayPalHelper;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.view.FiniDialog;
import com.gtjh.router_core.GTJHRouter;
import com.gtjh.shop_car.R;
import com.gtjh.shop_car.R2;
import com.gtjh.shop_car.adapter.OrderGoodsAdapter;
import com.gtjh.shop_car.adapter.PayMethodsAdapter;
import com.gtjh.shop_car.adapter.ShippingMethodsAdapter;
import com.gtjh.shop_car.bean.InitOrderBean;
import com.gtjh.shop_car.bean.MethodsListBean;
import com.gtjh.shop_car.bean.OrderProductsListBean;
import com.gtjh.shop_car.bean.ShippingBean;
import com.gtjh.shop_car.bean.SubmitOrderBean;
import com.gtjh.shop_car.event.RecycleTranslateAnimation;
import com.gtjh.shop_car.presenter.impl.OrderPresenterImpl;




import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;


/**
 * Created by android on 2018/7/24.
 * 已完成 还剩下支付未完成
 */

public class ConfirmOrderActivity extends ToolBarActivity {
    @BindView(R2.id.rl_address) //地址
    RelativeLayout rlAddress;
    @BindView(R2.id.tv_address_title)
    TextView tvAddressTitle;
    @BindView(R2.id.tv_address_person)
    TextView tvAddressContent;
    @BindView(R2.id.rl_shipping) //快递方式
    RelativeLayout rlShipping;
    @BindView(R2.id.tv_shipping_Methods)
    TextView tvShippingM;
    @BindView(R2.id.tv_shipping_price)
    TextView tvShippingP;
    @BindView(R2.id.rv_shipping)
    RecyclerView rvShipping;
    @BindView(R2.id.rl_pay)  //支付方式
    RelativeLayout rlPay;
    @BindView(R2.id.tv_methods_pay)
    TextView tvPayM;
    @BindView(R2.id.rv_pay)
    RecyclerView rvPay;
    @BindView(R2.id.et_coupon)  //添加优惠券
    EditText etCoupon;
    @BindView(R2.id.tv_coupon_message)
    TextView tvCouponMsg;
    @BindView(R2.id.tv_coupon_btn)
    TextView tvCouponBtn;
    @BindView(R2.id.et_remark) //添加备注
    EditText etMark;
    @BindView(R2.id.rl_data) //商品数据
    RecyclerView rvData;
    @BindView(R2.id.tv_total) //底下五个顺序列出
    TextView tvTotal;
    @BindView(R2.id.tv_weight)
    TextView tvWeight;
    @BindView(R2.id.tv_bulk)
    TextView tvBulk;
    @BindView(R2.id.tv_shipping)
    TextView tvShipping;
    @BindView(R2.id.tv_discount)
    TextView tvDiscount;
    @BindView(R2.id.tv_pay)
    TextView tvPay;
    @BindView(R2.id.tv_memory)
    TextView tvMemory;

    private OrderPresenterImpl presenter;
    private PayMethodsAdapter payMethodsAdapter;
    private ShippingMethodsAdapter shippingMethodsAdapter;
    private OrderGoodsAdapter orderGoodsAdapter;
    private List<OrderProductsListBean> orderProductsListBeans=new ArrayList<>();
    private List<MethodsListBean> payLisBeans=new ArrayList<>();
    private List<MethodsListBean> shippingLisBeans=new ArrayList<>();

    private Boolean isShipping=false;
    private Boolean isPay=false;

    private String mPayName="";
    private String mShippingName="";
    private String couponCode="";
    private String addressId="";
    private String changeAddressId="";
    private HashMap<String,Object> hashMap=new HashMap<>();
    private Boolean isCoupon=false;
    private Map<String,Object> billings=new HashMap<>();
    private InitOrderBean initOrderBean;
    private AddressListBean messageBean;

    private static final String TAG="TAG";
    private final int SDK_PAY_FLAG=100;
    private  String symbol="";



    @Override
    public void showSuccess(Object o, int tag) {

        switch (tag){
            case Contans.Tag.INIT_ORDER:
                initData((ResponseData<Object>) o);
                break;
            case Contans.Tag.ADD_COUPON:
                initCoupon((ResponseData<Object>) o,true);
                break;
            case Contans.Tag.CANCEL_COUPON:
                initCoupon((ResponseData<Object>) o,false);
                break;
            case Contans.Tag.SUBMIT_ORDER:
                submitOrder((ResponseData<Object>) o);
                break;
            case Contans.Tag.SHIPPING_CART:
                initShipping((ResponseData<Object>) o);
                break;
        }
    }

    //改变地址
    private void initShipping(ResponseData<Object> o) {
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            return;
        }
        ShippingBean shippingBean=gson.fromJson(gson.toJson(o.getData()),ShippingBean.class);
        addressId=messageBean.getAddress_id();
        tvAddressContent.setVisibility(View.VISIBLE);
        tvAddressTitle.setText(messageBean.getCountry()+messageBean.getState()+messageBean.getCity()+messageBean.getStreet1());
        tvAddressContent.setText(getResources().getString(R.string.consignee)+"："+messageBean.getFirst_name()+messageBean.getLast_name());

        //重新构造货运方式列表
        shippingMethodsAdapter.initData(shippingBean.getShippings());
        for (int i=0;i<shippingBean.getShippings().size();i++){
            if (shippingBean.getShippings().get(i).getChecked()!=null&&"true".equals(initOrderBean.getShippings().get(i).getChecked())){
                mShippingName=shippingBean.getShippings().get(i).getMethod();
                tvShippingM.setText(shippingBean.getShippings().get(i).getLabel());
                String price=shippingBean.getShippings().get(i).getName()+shippingBean.getShippings().get(i).getSymbol()+initOrderBean.getShippings().get(i).getCost();
                tvShippingP.setText(price);
                break;
            }
        }
        ShippingBean.CartInfoBean cartInfoBean=shippingBean.getCart_info();
        //底下五个
        tvTotal.setText(symbol+cartInfoBean.getProduct_total());
        tvWeight.setText(cartInfoBean.getProduct_weight()+"");
        tvBulk.setText(cartInfoBean.getProduct_volume()+"");
        tvShipping.setText(symbol+cartInfoBean.getShipping_cost());
        tvDiscount.setText("-"+symbol+cartInfoBean.getCoupon_cost());

        tvMemory.setText(symbol+"\t"+cartInfoBean.getGrand_total());

    }

    //提交订单
    private void submitOrder(ResponseData<Object> o) {
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            return;
        }
        SubmitOrderBean orderBean=gson.fromJson(gson.toJson(o.getData()),SubmitOrderBean.class);
        SubmitOrderBean.OrderInfoBean infoBean=orderBean.getOrderInfo();
        final String orderInfo ="app_id=2015052600090779&biz_content=%7B%22timeout_express%22%3A%2230m%22%2C%22seller_id%22%3A%22%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A%220.02%22%2C%22subject%22%3A%221%22%2C%22body%22%3A%22%E6%88%91%E6%98%AF%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE%22%2C%22out_trade_no%22%3A%22314VYGIAGG7ZOYY%22%7D&charset=utf-8&method=alipay.trade.app.pay&sign_type=RSA2&timestamp=2016-08-15%2012%3A12%3A15&version=1.0&sign=MsbylYkCzlfYLy9PeRwUUIg9nZPeN9SfXPNavUCroGKR5Kqvx0nEnd3eRmKxJuthNUx4ERCXe552EV9PfwexqW%2B1wbKOdYtDIb4%2B7PL3Pc94RZL0zKaWcaY3tSL89%2FuAVUsQuFqEJdhIukuKygrXucvejOUgTCfoUdwTi7z%2BZzQ%3D";   // 订单信息
         if ("alipay_standard".equals(orderBean.getOrderInfo().getPayment_method())){
             AliPayHelper aliPayHelper=new AliPayHelper();
             aliPayHelper.setAliPayClickListener(listener);
             aliPayHelper.startAliPaySerVice(this,infoBean.getOrder_id()+"",infoBean.getStore(),"",infoBean.getGrand_total());

        }else if ("paypal_standard".equals(orderBean.getOrderInfo().getPayment_method())){
             AddressListBean address=new AddressListBean();
             address.setCity(infoBean.getCustomer_address_city());
             address.setCountry(infoBean.getCustomer_address_country());
             address.setCountryName(infoBean.getCustomer_address_country_name());
             address.setZip(infoBean.getCustomer_address_zip());
             address.setState(infoBean.getCustomer_address_state());
             address.setStateName(infoBean.getCustomer_address_state_name());
             address.setLast_name(infoBean.getCustomer_lastname());
             address.setFirst_name(infoBean.getCustomer_firstname());
             address.setStreet1(infoBean.getCustomer_address_street1());
             address.setStreet2(infoBean.getCustomer_address_street2());
            PayPalHelper.getInstance().doPayPalPay(this,infoBean.getGrand_total(),infoBean.getOrder_currency_code(),infoBean.getStore(),infoBean.getIncrement_id(),address);
        }else {
            ToastUtils.showToastForText(this,o.getMessage());
            finish();
         }

    }
 /*   //支付宝回调
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            Map<String,String> result=(Map<String,String>)msg.obj;
            Toast.makeText(ConfirmOrderActivity.this, result.toString(),
                    Toast.LENGTH_LONG).show();
            finish();
        };
    };*/


    //添加优惠券 true 添加 false 取消
    private void initCoupon(ResponseData<Object> object,Boolean is) {
        tvCouponBtn.setEnabled(true);
        if (is){
            if (object.getCode()==200){
                //ToastUtils.showToastForText(this,object.getMessage());
                tvCouponBtn.setText(R.string.cancelCoupon);
                isCoupon=true;
                tvCouponMsg.setVisibility(View.GONE);
                presenter.initOrder(Contans.Tag.INIT_ORDER);
            }else {
                isCoupon=false;
                tvCouponMsg.setVisibility(View.VISIBLE);
                tvCouponMsg.setText(object.getMessage());
                tvCouponBtn.setText(R.string.addCoupon);
            }
        }else {
            if (object.getCode()!=200){
                //ToastUtils.showToastForText(this,object.getMessage());
                tvCouponMsg.setVisibility(View.VISIBLE);
                tvCouponMsg.setText(object.getMessage());
                tvCouponBtn.setText(R.string.cancelCoupon);
                isCoupon=true;
            }else {
                isCoupon=false;
                couponCode="";
                tvCouponMsg.setVisibility(View.GONE);
                tvCouponBtn.setText(R.string.addCoupon);
                presenter.initOrder(Contans.Tag.INIT_ORDER);
            }
        }

    }

    //初始化数据 因为接口很奇怪 所以写的很繁琐
    private void initData(ResponseData<Object> object){
        if (object.getCode()!=200){
            ToastUtils.showToastForText(this,object.getMessage());
            return;
        }
        initOrderBean=gson.fromJson(gson.toJson(object.getData()),InitOrderBean.class);
        symbol=initOrderBean.getCurrency_info().getSymbol();
        //地址
        messageBean=initOrderBean.getCart_address();
        Map<String,Object> stringObjectMap=gson.fromJson(gson.toJson(messageBean),Map.class);

        billings=stringObjectMap;
        addressId=initOrderBean.getCart_address_id()+"";
        if (messageBean.getEmail()==null){
            tvAddressContent.setVisibility(View.GONE);
        }else {
            tvAddressContent.setVisibility(View.VISIBLE);
            tvAddressTitle.setText(messageBean.getCountry()+messageBean.getState()+messageBean.getCity()+messageBean.getStreet1());
            tvAddressContent.setText(getResources().getString(R.string.consignee)+"："+messageBean.getFirst_name()+messageBean.getLast_name());
        }

        //两个方式

        shippingMethodsAdapter.initData(initOrderBean.getShippings());
             //转化
        Map<String,Object> map=gson.fromJson(gson.toJson(initOrderBean.getPayments()),Map.class);
        Iterator<Map.Entry<String,Object>> entry=map.entrySet().iterator();
        List<MethodsListBean> payLisBeans=new ArrayList<>();
        List<String> payNames=new ArrayList<>();
        int index=0;
        //写的有些繁琐 看接口就懂了
        while (entry.hasNext()){
            Map.Entry<String,Object> objectMap=entry.next();
            MethodsListBean bean=gson.fromJson(gson.toJson(objectMap.getValue()),MethodsListBean.class);
            payNames.add(index,objectMap.getKey());
            //key值是选中之后需要的
            bean.setMethod(objectMap.getKey());
            payLisBeans.add(index,bean);
            index++;
        }
        payMethodsAdapter.initData(payLisBeans);

        for (int i=0;i<payLisBeans.size();i++){
            if (payLisBeans.get(i).getChecked()!=null&&"true".equals(payLisBeans.get(i).getChecked())){
                tvPayM.setText(payLisBeans.get(i).getLabel());
                mPayName=payNames.get(i);
                break;
            }
        }
        for (int i=0;i<initOrderBean.getShippings().size();i++){
            if (initOrderBean.getShippings().get(i).getChecked()!=null&&"true".equals(initOrderBean.getShippings().get(i).getChecked())){
                mShippingName=initOrderBean.getShippings().get(i).getMethod();
                tvShippingM.setText(initOrderBean.getShippings().get(i).getLabel());
                String price=initOrderBean.getShippings().get(i).getName()+symbol+initOrderBean.getShippings().get(i).getCost();
                tvShippingP.setText(price);
                break;
            }
        }




        //商品数据
        InitOrderBean.CartInfoBean infoBean=initOrderBean.getCart_info();

        //优惠券
        if (infoBean.getCoupon_code()!=null&&!"null".equals(infoBean.getCoupon_code())){
            etCoupon.setText(infoBean.getCoupon_code());
            isCoupon=true;
            tvCouponBtn.setText(getResources().getString(R.string.cancelCoupon));
        }
        orderGoodsAdapter.setSymbol(symbol);
        orderGoodsAdapter.initData(infoBean.getProducts());
        //底下五个
        tvTotal.setText(symbol+infoBean.getProduct_total());
        tvWeight.setText(infoBean.getProduct_weight()+"");
        tvBulk.setText(infoBean.getProduct_volume()+"");
        tvShipping.setText(symbol+infoBean.getShipping_cost());
        tvDiscount.setText("-"+symbol+infoBean.getCoupon_cost());

        tvMemory.setText(symbol+"\t"+infoBean.getGrand_total());
    }
    @Override
    public void showError(Throwable throwable) {
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.subOrder));
        presenter=new OrderPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        presenter.initOrder(Contans.Tag.INIT_ORDER);
        PayPalHelper.getInstance().startPayPalService(this);
        initView();
        initEvent();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_order;
    }

    //监听
    private void initEvent() {
        shippingMethodsAdapter.setOnCheckedClickListener(new ShippingMethodsAdapter.onCheckedClickListener() {
            @Override
            public void onCheck(int pos, String name, String value,String price) {
                tvShippingM.setText(name);
                tvShippingP.setText(price);
                mShippingName=value;
            }
        });
        payMethodsAdapter.setOnCheckedClickListener(new PayMethodsAdapter.onCheckedClickListener() {
            @Override
            public void checked(int pos, String name,String value) {
                tvPayM.setText(name);
                mPayName=value;
            }
        });
        rlShipping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShipping){
                    isShipping=false;
                    rvShipping.setVisibility(View.GONE);
                }else {
                    isShipping=true;
                    RecycleTranslateAnimation.showTranslateAnimation(rvShipping);
                }
            }
        });
        rlPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPay){
                    isPay=false;
                    rvPay.setVisibility(View.GONE);
                }else {
                    isPay=true;
                    //rvPay.setVisibility(View.VISIBLE);
                    RecycleTranslateAnimation.showTranslateAnimation(rvPay);
                }
            }
        });
        tvCouponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isCoupon){
                    hashMap.clear();
                    hashMap.put("coupon_code", couponCode);
                    presenter.cancelCoupon(hashMap, Contans.Tag.CANCEL_COUPON);
                    tvCouponBtn.setEnabled(false);
                }else {
                    String code = etCoupon.getText().toString();
                    if (TextUtils.isEmpty(code)) {
                        ToastUtils.showToastForText(ConfirmOrderActivity.this, getResources().getString(R.string.addCodeHint));
                        return;
                    }
                    hashMap.clear();
                    hashMap.put("coupon_code", code);
                    presenter.addCoupon(hashMap, Contans.Tag.ADD_COUPON);
                    couponCode=code;
                    tvCouponBtn.setEnabled(false);
                }
            }
        });
        tvPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mark=etMark.getText().toString();
                if (TextUtils.isEmpty(mark)){
                    mark="";
                }
                hashMap.clear();
                hashMap.put("address_id",addressId);
                hashMap.put("billing",billings);
                hashMap.put("create_account",0);
                hashMap.put("shipping_method",mShippingName);
                hashMap.put("payment_method",mPayName);
                hashMap.put("order_remark",mark);
                Log.i("TAG",addressId+"-"+billings+"-"+mShippingName+"-"+mPayName+"-"+mark);
                presenter.submitOrder(hashMap,Contans.Tag.SUBMIT_ORDER);
            }
        });
        rlAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GTJHRouter.getInstance().build("/user/AddressListActivity").withString("ISORDER",addressId).navigation(ConfirmOrderActivity.this);
            }
        });
    }

    //初始化
    private void initView() {
        //new
        payMethodsAdapter=new PayMethodsAdapter(payLisBeans,this);
        shippingMethodsAdapter=new ShippingMethodsAdapter(shippingLisBeans,this);
        orderGoodsAdapter=new OrderGoodsAdapter(orderProductsListBeans,this);
        //布局
        rvPay.setLayoutManager(new LinearLayoutManager(this));
        rvShipping.setLayoutManager(new LinearLayoutManager(this));
        rvData.setLayoutManager(new LinearLayoutManager(this));
        //放
        rvData.setAdapter(orderGoodsAdapter);
        rvPay.setAdapter(payMethodsAdapter);
        rvShipping.setAdapter(shippingMethodsAdapter);

        rvData.setNestedScrollingEnabled(false);
    }


    //回调地址数据
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(AddressEvent event) {
        /* Do something */
        initChange(event.message);
    }
    private void initChange(AddressListBean message) {
        messageBean=message;
        hashMap.clear();
        hashMap.put("country",message.getCountry());
        hashMap.put("address_id",message.getAddress_id());
        hashMap.put("state",message.getState());
        hashMap.put("shipping_method",mShippingName);
        presenter.shippingCart(hashMap,Contans.Tag.SHIPPING_CART);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        PayPalHelper.getInstance().confirmPayResult(this,requestCode,resultCode,data,doResult);
    }

    private PayPalHelper.DoResult doResult=new PayPalHelper.DoResult() {
        @Override
        public void confirmSuccess() {
            finish();
            Log.i("RESULT","success");
        }

        @Override
        public void confirmNetWorkError() {
            Log.i("RESULT","confirmNetWorkError");
        }

        @Override
        public void customerCanceled() {
            Log.i("RESULT","customerCanceled");
        }

        @Override
        public void confirmFuturePayment() {
            Log.i("RESULT","confirmFuturePayment");
        }

        @Override
        public void invalidPaymentConfiguration() {
            Log.i("RESULT","invalidPaymentConfiguration");
        }
    };

    private  AliPayHelper.AliPayClickListener listener=new AliPayHelper.AliPayClickListener() {
        @Override
        public void success() {
            Log.i("RESULT","success");
            finish();
        }

        @Override
        public void fail() {
            Log.i("RESULT","fail");
        }

        @Override
        public void cancel() {
            Log.i("RESULT","cancel");
            ToastUtils.showToastForText(ConfirmOrderActivity.this,"cancel");
        }

        @Override
        public void confirm() {
            Log.i("RESULT","confirm");
            ToastUtils.showToastForText(ConfirmOrderActivity.this,"confirmOrder");
        }
    };
    @Override
    protected void onDestroy() {
        PayPalHelper.getInstance().stopPayPalService(this);
        super.onDestroy();

    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

}
