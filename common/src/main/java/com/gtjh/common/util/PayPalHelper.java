package com.gtjh.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.gtjh.common.entity.AddressListBean;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalItem;


import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalPaymentDetails;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.paypal.android.sdk.payments.ShippingAddress;

import org.json.JSONException;

import java.math.BigDecimal;

/**
 * Created by android on 2018/8/9.
 */

public class PayPalHelper {
    private static final String TAG = "PayPalHelper";
    //配置何種环境 一般沙盒 正式


    private static final int REQUEST_CODE_PAYMENT = 1;
    private static final int REQUEST_CODE_FUTURE_PAYMENT = 2;
    private static final int REQUEST_CODE_PROFILE_SHARING = 3;

// 配置各种支付类型，一般就沙盒测试的和正式的

    private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
    private final static String CONFIG_CLIENT_ID="AXR9Zha3tJizHRQllOPP2Q-02Smxksqgua-AMIOmhrtgy06dHxZmZwa93nFs7ddgSTQ-B9IuL7cSWixa";


    // note that these credentials will differ between live & sandbox environments.
    // when testing in sandbox, this is likely the -facilitator email address.
    private static final String CONFIG_RECEIVER_EMAIL = "yangtingting163163-seller@163.com";
    private static PayPalHelper payPalHelper;

    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(CONFIG_ENVIRONMENT)
            .clientId(CONFIG_CLIENT_ID);

    private PayPalHelper() {
    }

    public static PayPalHelper getInstance() {
        if (payPalHelper == null) {
            synchronized (PayPalHelper.class) {
                payPalHelper = new PayPalHelper();
            }
        }
        return payPalHelper;
    }

    /*
    * 启动服务*/
    public void startPayPalService(Context context) {
        Intent intent = new Intent(context, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        context.startService(intent);

    }

    /*停止服务*/
    public void stopPayPalService(Context context) {
        context.stopService(new Intent(context, PayPalService.class));
    }

    /*开始执行支付操作*/
    public void doPayPalPay(Context context, String money, String symbol, String title, String id, AddressListBean listBean) {
        PayPalPayment thingToBuy = getStuffToBuy(PayPalPayment.PAYMENT_INTENT_SALE,symbol,money,title,id,listBean);

        Intent intent = new Intent(context, PaymentActivity.class);

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);
        ((Activity) context).startActivityForResult(intent, REQUEST_CODE_PAYMENT);
    }





    //商品详细传送
    private PayPalPayment getStuffToBuy(String paymentIntent, String symbol,String money, String title, String id, AddressListBean listBean) {
        //--- include an item list, payment amountdetails
       //钱
        PayPalPayment  payment= new PayPalPayment(new BigDecimal(money),symbol , title,paymentIntent);
        //地址
        payment.custom(title);
        payment.invoiceNumber(id);
        ShippingAddress address=new ShippingAddress();
        address.city(listBean.getCity());
        address.countryCode(listBean.getCountry());
        address.postalCode(listBean.getZip());
        address.state(listBean.getState());
        address.line1(listBean.getStreet1());
        address.line2(listBean.getStreet2());
        address.recipientName(listBean.getFirst_name()+listBean.getLast_name());
        payment.providedShippingAddress(address);
        return payment;
    }

    //返回结果
    public void confirmPayResult(final Context context, int requestCode, int resultCode, Intent data, final DoResult doResult) {
        if (resultCode == Activity.RESULT_OK) {
            PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if (confirm != null) {
                try {
                    Log.i("paymentExample", confirm.toJSONObject().toString(4));
                    if (doResult!=null){
                        doResult.confirmSuccess();
                    }
                    // TODO: send 'confirm' to your server for verification.
                    // see https://developer.paypal.com/webapps/developer/docs/integration/mobile/verify-mobile-payment/
                    // for more details.

                } catch (JSONException e) {
                    Log.e("paymentExample", "an extremely unlikely failure occurred: ", e);
                }
            }
        }
        else if (resultCode == Activity.RESULT_CANCELED) {
            Log.i("paymentExample", "The user canceled.");
            if (doResult!=null){
                doResult.customerCanceled();
            }
        }
        else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Log.i("paymentExample", "An invalid payment was submitted. Please see the docs.");
            if (doResult!=null){
                doResult.invalidPaymentConfiguration();
            }
        }
    }
    public interface DoResult {
        //与服务确认支付成功
        void confirmSuccess();

        // 网络异常或者json返回有问题
        void confirmNetWorkError();

        //用户取消支付
        void customerCanceled();

        //授权支付
        void confirmFuturePayment();

        // 订单支付验证无效
        void invalidPaymentConfiguration();
    }


}
