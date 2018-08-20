package com.gtjh.user.activity;

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
import com.gtjh.user.LoginActivity;
import com.gtjh.user.bean.EditUserInfoBean;
import com.gtjh.user.R;
import com.gtjh.user.R2;
import com.gtjh.user.presenter.impl.EditUserInfoPresenterImpl;

import java.util.HashMap;
import java.util.regex.Pattern;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by android on 2018/7/10.
 * 账户信息详情修改页面
 */

public class AccountInfoActivity extends ToolBarActivity implements View.OnClickListener {
    @BindView(R2.id.iv_old)
    ImageView ivSurname;
    @BindView(R2.id.iv_new)
    ImageView ivName;
    @BindView(R2.id.iv_again)
    ImageView ivMail;
    @BindView(R2.id.tv_old_hint)
    TextView tvSurname;
    @BindView(R2.id.tv_new_hint)
    TextView tvName;
    @BindView(R2.id.tv_again_hint)
    TextView tvMail;
    @BindView(R2.id.et_old)
    EditText etSurname;
    @BindView(R2.id.et_new)
    EditText etName;
    @BindView(R2.id.tv_again)
    TextView etMail;

    private EditUserInfoPresenterImpl presenter;

    private int minNameLength=1;
    private int maxNameLength=30;
    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag){
            case Contans.Tag.USER_INFO:
                initData((ResponseData< Object >)o);
                break;
            case Contans.Tag.SUB_INFO:
                initResult((ResponseData<Object>)o);
                break;
        }
    }

    private void initResult(ResponseData<Object> o) {
        ToastUtils.showToastForText(this,o.getMessage());
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
        etMail.setText(data.getEmail()+"");
        if (!TextUtils.isEmpty(data.getFirstname())){
            etName.setVisibility(View.VISIBLE);
            etName.setText(data.getFirstname());
        }
        if (!TextUtils.isEmpty(data.getLastname())){
            etSurname.setVisibility(View.VISIBLE);
            etSurname.setText(data.getLastname());
        }
        minNameLength=Integer.valueOf(data.getMinNameLength());
        maxNameLength=Integer.valueOf(data.getMaxNameLength());

        etSurname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxNameLength)});
        etName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxNameLength)});
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.accountDetails));

        Build build=new Build();
        build.setText(getResources().getString(R.string.save));
        build.setListener(onRightClickListener);
        build.setTextColor(Color.BLACK);
        build.setTextSize(30);
        setRight(build);

        presenter=new EditUserInfoPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        presenter.editUserInfo(Contans.Tag.USER_INFO);
        initEvent();
    }

    private void initEvent() {
        tvMail.setOnClickListener(this);
        tvName.setOnClickListener(this);
        tvSurname.setOnClickListener(this);

        etSurname.addTextChangedListener(new editWatcher(R.id.et_old));
        etName.addTextChangedListener(new editWatcher(R.id.et_new));

        etSurname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxNameLength)});
        etName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxNameLength)});
    }

    //右上角 保存键的监听
    View.OnClickListener onRightClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //突然发现 名 姓 写反了= =
            String name=etSurname.getText().toString();
            String surname=etName.getText().toString();
            if (TextUtils.isEmpty(surname)||surname.length()<minNameLength){
                ToastUtils.showToastForText(AccountInfoActivity.this,getResources().getString(R.string.surnameHint));
                return;
            }
            if (TextUtils.isEmpty(name)||name.length()<minNameLength){
                ToastUtils.showToastForText(AccountInfoActivity.this,getResources().getString(R.string.nameHint));
                return;
            }
            HashMap<String,Object> param=new HashMap<>();
            param.put("firstname",surname);
            param.put("lastname",name);
            presenter.submitUserInfo(param,Contans.Tag.SUB_INFO);
        }
    };
    @Override
    public int getLayoutId() {
        return R.layout.activity_account_info;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv_new_hint) {
            if (etName.getVisibility() != View.VISIBLE) {
                getFocusable(etName);
            }

        } else if (i == R.id.tv_old_hint) {
            if (etSurname.getVisibility() != View.VISIBLE) {
                getFocusable(etSurname);
            }

        }
    }

    //三个输入框的监听  监听是否输入文字
    private class editWatcher implements TextWatcher {
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
            if (id == R.id.et_new) {
                if (s.length() >= 1) {
                    ivName.setVisibility(View.VISIBLE);
                } else {
                    ivName.setVisibility(View.GONE);
                }

            } else if (id == R.id.et_old) {
                if (s.length() >= 1) {
                    ivSurname.setVisibility(View.VISIBLE);
                } else {
                    ivSurname.setVisibility(View.GONE);
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
    //检测邮箱是否合法
    private boolean isEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);

    }
}
