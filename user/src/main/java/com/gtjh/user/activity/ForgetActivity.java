package com.gtjh.user.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.user.R;
import com.gtjh.user.R2;
import com.gtjh.user.bean.ForgetBean;
import com.gtjh.user.presenter.impl.ForgetPresenterImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/16.
 */

public class ForgetActivity extends ToolBarActivity {
    @BindView(R2.id.et_email)
    EditText etEmail;
    @BindView(R2.id.et_code)
    EditText etCode;
    @BindView(R2.id.et_new)
    EditText etNew;
    @BindView(R2.id.et_again)
    EditText etAgain;
    @BindView(R2.id.tv_submit)
    TextView tvSubmit;
    @BindView(R2.id.btn_code)
    Button btnCode;

    @BindView(R2.id.ll_code)
    LinearLayout llCode;
    @BindView(R2.id.ll_email)
    LinearLayout llEmail;

    private ForgetPresenterImpl presenter;
    private String code="0000"; //生成随机验证码
    @Override
    public void showSuccess(Object o, int tag) {
        //接口文档写了四个接口 此时只有两个
        switch (tag){
            case Contans.Tag.FORGET_SEND:
                initCode((ResponseData)o);
                break;
            case Contans.Tag.FORGET_PW:
                initPw((ResponseData) o);
                break;
        }
    }

    private void initPw(ResponseData o) {
        //第四步 重置密码
        ToastUtils.showToastForText(this,o.getMessage());
        Log.i("Result",o.getMessage());
        if (o.getCode()==200){
            finish();
        }
    }

    private void initCode(ResponseData o) {
        //第二步 发送验证码
        Log.i("Result",o.getMessage());
        if (o.getCode()==200){
            btnCode.setEnabled(false);
        }
        ToastUtils.showToastForText(this,o.getMessage());
    }


    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.findPassword));

        presenter=new ForgetPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        initEvent();
    }

    private void initEvent() {
        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (isEmail(s.toString())){
                    btnCode.setEnabled(true);
                }else {
                    btnCode.setEnabled(false);
                }
            }
        });
        etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if (isEmail(etEmail.getText().toString())&&s.length()>0&&etNew.getText().length()>=6&&etAgain.getText().length()>=6){
                    tvSubmit.setEnabled(true);
                }else {
                    tvSubmit.setEnabled(false);
                }
            }
        });
        etNew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (isEmail(etEmail.getText().toString())&&s.length()>=6&&etCode.getText().length()>0&&etAgain.getText().length()>=6){
                    tvSubmit.setEnabled(true);
                }else {
                    tvSubmit.setEnabled(false);
                }
            }
        });
        etAgain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (isEmail(etEmail.getText().toString())&&s.length()>=6&&etCode.getText().length()>0&&etNew.getText().length()>=6){
                    tvSubmit.setEnabled(true);
                }else {
                    tvSubmit.setEnabled(false);
                }
            }
        });
        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=etEmail.getText().toString();
                HashMap<String,Object> map=new HashMap<>();
                map.put("email",email);
                presenter.forgetSend(map,Contans.Tag.FORGET_SEND);
            }
        });
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=etEmail.getText().toString();
                String newPw=etNew.getText().toString();
                String againPw=etAgain.getText().toString();
                String code=etCode.getText().toString();
                HashMap<String,Object> map=new HashMap<>();
                map.put("mailCode ",code);
                map.put("email",email);
                map.put("newPassword",newPw);
                map.put("confirmPassword",againPw);
                presenter.forgetPw(map,Contans.Tag.FORGET_PW);
            }
        });
    }

    private boolean isEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);

    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_forget_pw;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }
}
