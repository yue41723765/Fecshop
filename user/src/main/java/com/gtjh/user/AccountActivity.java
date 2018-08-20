package com.gtjh.user;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.SPUtil;
import com.gtjh.user.activity.AccountInfoActivity;
import com.gtjh.user.activity.AddressListActivity;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/9.
 */

public class AccountActivity extends ToolBarActivity {

    private  Intent intent;
    @Override
    public void showSuccess(Object o, int tag) {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.myAccount));
        Log.i("Account",SPUtil.getToken(AccountActivity.this));
    }


    @OnClick(R2.id.ll_account)
    public void account() {
        //账户信息
        if (  SPUtil.getIsLogin(this)) {
            intent = new Intent(AccountActivity.this, AccountInfoActivity.class);
            startActivity(intent);
        }else {
            intent = new Intent(AccountActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R2.id.ll_address)
    public void address() {
        //货运地址
        if (  SPUtil.getIsLogin(this)) {
           intent=new Intent(AccountActivity.this,AddressListActivity.class);
           startActivity(intent);
        }else {
           intent = new Intent(AccountActivity.this, LoginActivity.class);
           startActivity(intent);
        }
    }

    @OnClick(R2.id.ll_password)
    public void password() {
        //账户密码
        if (  SPUtil.getIsLogin(this)) {
           intent=new Intent(AccountActivity.this,ChangePwActivity.class);
           startActivity(intent);
        }else {
            intent = new Intent(AccountActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R2.id.tv_out)
    public void exit() {
        //退出登录 清除账号信息
        SPUtil.clearToken(AccountActivity.this);
        SPUtil.saveIsLogin(AccountActivity.this,false);
        RxBus.getInstance().chainProcess(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return Observable.just(false);
            }
        }, Contans.Tag.LOGIN);
        finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_account;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }
}
