package com.gtjh.fecshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gtjh.common.util.PayPalHelper;


/**
 * Created by android on 2018/8/10.
 */

public class PayActivity extends AppCompatActivity {
    Button button;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);
        PayPalHelper.getInstance().startPayPalService(this);
        button=findViewById(R.id.btn_touch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PayPalHelper.getInstance().doPayPalPay(PayActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        PayPalHelper.getInstance().confirmPayResult(this,requestCode,resultCode,data,doResult);
    }


    private PayPalHelper.DoResult doResult=new PayPalHelper.DoResult() {
        @Override
        public void confirmSuccess() {

        }

        @Override
        public void confirmNetWorkError() {

        }

        @Override
        public void customerCanceled() {

        }

        @Override
        public void confirmFuturePayment() {

        }

        @Override
        public void invalidPaymentConfiguration() {

        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        PayPalHelper.getInstance().stopPayPalService(this);
    }
}
