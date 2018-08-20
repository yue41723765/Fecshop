package com.gtjh.user;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.user.activity.ForgetActivity;
import com.gtjh.user.presenter.impl.LoginPresenterImpl;
import com.gtjh.user.util.AsteriskPasswordTransformationMethod;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/6.
 */

public class LoginActivity extends ToolBarActivity {
    @BindView(R2.id.tv_updatePwd)
    TextView tv_updatePwd;
    @BindView(R2.id.tv_register)
    TextView tv_register;
    @BindView(R2.id.tv_login)
    TextView tv_login;

    @BindView(R2.id.et_email)
    EditText et_email;
    @BindView(R2.id.et_pwd)
    EditText et_pwd;
    @BindView(R2.id.tv_warn)
    TextView tvWarn;
    private LoginPresenterImpl presenter;

    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag) {
            case Contans.Tag.LOGIN:
                ResponseData data = (ResponseData) o;
                if (data.getCode() == 200) {
                    ToastUtils.showToastForText(this, getResources().getString(R.string.loginSuccess));
                    SPUtil.saveIsLogin(this,  true);
                    RxBus.getInstance().chainProcess(new Function() {
                        @Override
                        public Object apply(Object o) throws Exception {
                            return Observable.just(true);
                        }
                    }, Contans.Tag.LOGIN);
                    finish();
                } else {
                    ToastUtils.showToastForText(this, ((ResponseData) o).getMessage());
                }
                tv_login.setEnabled(true);
                break;
        }

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        toolbar.setBackground(null);
        presenter = new LoginPresenterImpl(this);
        RxBus.getInstance().register(presenter);

        et_pwd.setTransformationMethod(new AsteriskPasswordTransformationMethod());
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    @OnClick(R2.id.tv_updatePwd)
    public void updatePassword() {
        //忘记密码
        Intent intent=new Intent(LoginActivity.this, ForgetActivity.class);
        startActivity(intent);
    }

    HashMap<String, Object> map = new HashMap<>();

    @OnClick(R2.id.tv_login)
    public void login() {
        String pwd = et_pwd.getText().toString();
        String email = et_email.getText().toString();
        if (TextUtils.isEmpty(pwd)) {
            initWarn();
            return;
        } else if (TextUtils.isEmpty(email)) {
            initWarn();
            return;
        }
        tv_login.setEnabled(false);
        map.clear();
        map.put("password", pwd);
        map.put("email", email);
        map.put("captcha", "");
        presenter.login(map, Contans.Tag.LOGIN);
    }

    private void initWarn(){
        if (tvWarn.getVisibility()==View.VISIBLE){
            return;
        }
        tvWarn.setVisibility(View.VISIBLE);
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvWarn.setVisibility(View.GONE);
                        timer.cancel();
                    }
                });
            }
        },3000,3000);
    }

    @OnClick(R2.id.tv_register)
    public void register() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
