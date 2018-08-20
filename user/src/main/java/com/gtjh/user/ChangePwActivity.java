package com.gtjh.user;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;

import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.user.bean.EditUserInfoBean;
import com.gtjh.user.presenter.impl.ChangePwPresenterImpl;
import com.gtjh.user.util.AsteriskPasswordTransformationMethod;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/10.
 */

public class ChangePwActivity extends ToolBarActivity implements View.OnClickListener {
    @BindView(R2.id.iv_old)
    ImageView ivOld;
    @BindView(R2.id.iv_new)
    ImageView ivnew;
    @BindView(R2.id.iv_again)
    ImageView ivAgain;
    @BindView(R2.id.tv_old_hint)
    TextView tvOld;
    @BindView(R2.id.tv_new_hint)
    TextView tvNew;
    @BindView(R2.id.tv_again_hint)
    TextView tvAgain;
    @BindView(R2.id.et_old)
    EditText etOld;
    @BindView(R2.id.et_new)
    EditText etNew;
    @BindView(R2.id.et_again)
    EditText etAgain;

    private ChangePwPresenterImpl presenter;
    private int minPwLength=6;
    private int maxPwLength=30;
    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag){
            case Contans.Tag.SUB_INFO:
                showChangePwResult((ResponseData<Map<String, String>>) o);
                break;
            case Contans.Tag.USER_INFO:
                initData((ResponseData<Object>)o);
                break;
        }
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
        EditUserInfoBean data=gson.fromJson(gson.toJson(o.getData()),EditUserInfoBean.class);
        minPwLength=Integer.valueOf(data.getMinPassLength());
        maxPwLength=Integer.valueOf(data.getMaxPassLength());
        etNew.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxPwLength)});
        etAgain.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxPwLength)});


    }

    private void showChangePwResult(ResponseData<Map<String, String>> data) {
        ToastUtils.showToastForText(this, data.getMessage());
    }
    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.changePassword));
        Build build=new Build();
        build.setText(getResources().getString(R.string.save));
        build.setListener(onRightClickListener);
        build.setTextColor(Color.BLACK);
        build.setTextSize(30);
        setRight(build);

        presenter=new ChangePwPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        initEvent();
        presenter.getPwConditions(Contans.Tag.USER_INFO);
    }

    private void initEvent() {
        tvAgain.setOnClickListener(this);
        tvNew.setOnClickListener(this);
        tvOld.setOnClickListener(this);

        //密码样式变成 ****
        etOld.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        etAgain.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        etNew.setTransformationMethod(new AsteriskPasswordTransformationMethod());

        etOld.addTextChangedListener(new editWatcher(R.id.et_old));
        etNew.addTextChangedListener(new editWatcher(R.id.et_new));
        etAgain.addTextChangedListener(new editWatcher(R.id.et_again));

        //限制输入字数
        etNew.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxPwLength)});
        etAgain.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxPwLength)});
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_change_pw;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    //三个按键的监听
    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_again_hint) {
            if (etAgain.getVisibility() != View.VISIBLE) {
                getFocusable(etAgain);
            }

        } else if (i == R.id.tv_new_hint) {
            if (etNew.getVisibility() != View.VISIBLE) {
                getFocusable(etNew);
            }

        } else if (i == R.id.tv_old_hint) {
            if (etOld.getVisibility() != View.VISIBLE) {
                getFocusable(etOld);
            }

        }
    }
    //保存的监听
    View.OnClickListener onRightClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String newPassword=etNew.getText().toString();
            String confirmPassword=etAgain.getText().toString();
            String oldPassword=etOld.getText().toString();
            if (TextUtils.isEmpty(newPassword) || newPassword.length()<minPwLength) {
                ToastUtils.showToastForText(ChangePwActivity.this, getResources().getString(R.string.newPasswordHint));
                return;
            }
            if (TextUtils.isEmpty(confirmPassword) || confirmPassword.length()<minPwLength) {
                ToastUtils.showToastForText(ChangePwActivity.this,getResources().getString( R.string.newPasswordHint));
                return;
            }
            if (TextUtils.isEmpty(oldPassword) || oldPassword.length()<6) {
                ToastUtils.showToastForText(ChangePwActivity.this, getResources().getString(R.string.oldPasswordHint));
                return;
            }
            if (!newPassword.equals(confirmPassword)) {
                ToastUtils.showToastForText(ChangePwActivity.this,getResources().getString( R.string.inconformity));
                return;
            }
            HashMap<String, Object> param = new HashMap<>();
            param.put("new_password", newPassword);
            param.put("confirm_new_password", confirmPassword);
            param.put("current_password", oldPassword);
            presenter.changePw(param, Contans.Tag.SUB_INFO);
        }
    };
    //三个输入框的监听  监听是否输入文字
    private class editWatcher implements TextWatcher{
        private  int id;

        public editWatcher(int id){
            this.id=id;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (id == R.id.et_again) {
                if (s.length() >= 6) {
                    ivAgain.setVisibility(View.VISIBLE);
                } else {
                    ivAgain.setVisibility(View.GONE);
                }

            } else if (id == R.id.et_new) {
                if (s.length() >= 6) {
                    ivnew.setVisibility(View.VISIBLE);
                } else {
                    ivnew.setVisibility(View.GONE);
                }

            } else if (id == R.id.et_old) {
                if (s.length() >= 6) {
                    ivOld.setVisibility(View.VISIBLE);
                } else {
                    ivOld.setVisibility(View.GONE);
                }

            }
        }
    }

    //弹出菜单
    private void getFocusable(View view){
        view.setVisibility(View.VISIBLE);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view,0);
    }

}
