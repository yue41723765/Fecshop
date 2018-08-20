package com.gtjh.user;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.util.view.ViewHelp;
import com.gtjh.user.presenter.impl.RegisterPresenterImpl;
import com.gtjh.user.util.AsteriskPasswordTransformationMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by android on 2018/7/5.
 */

public class RegisterActivity extends ToolBarActivity {
    @BindView(R2.id.et_code)
    EditText et_code;
    @BindView(R2.id.tv_register)
    TextView tv_register;
    @BindView(R2.id.et_last_name)
    EditText et_last_name;
    @BindView(R2.id.et_first_name)
    EditText et_first_name;
    @BindView(R2.id.et_pwd)
    EditText et_pwd;
    @BindView(R2.id.et_confirm_pwd)
    EditText et_confirm_pwd;
    @BindView(R2.id.et_email)
    EditText et_email;
    @BindView(R2.id.cb_isSubscribe)
    CheckBox cb_isSubscribe;

    @BindView(R2.id.iv)
    ImageView iv;
    private RegisterPresenterImpl presenter;

    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag) {
            case Contans.Tag.CODE:
                showCode((ResponseData<HashMap<String, String>>) o);
                break;
            case Contans.Tag.REGISTER:
                showRegisterResult((ResponseData<Map<String, String>>) o);
                break;
        }
    }

    private void showRegisterResult(ResponseData<Map<String, String>> data) {
        if (data.getCode() == 200) {
            ToastUtils.showToastForText(this, data.getData().get("content"));
            finish();
        } else {
            ToastUtils.showToastForText(this, data.getData().get("error"));
        }
    }

    private void showCode(ResponseData<HashMap<String, String>> data) {
        String base64 = data.getData().get("image");
        iv.setImageBitmap(base64ToBitmap(base64));

//        et_email.setText("995887176@qq.com");
//        et_confirm_pwd.setText("123123");
//        et_pwd.setText("123123");
//        et_first_name.setText("任");
//        et_last_name.setText("洋");
    }

    @Override
    public void showError(Throwable throwable) {

    }

    /**
     * base64转为bitmap
     *
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    @Override
    public void init(Bundle savedInstanceState) {
        toolbar.setBackground(null);
        presenter = new RegisterPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        presenter.loadCode(Contans.Tag.CODE);

        et_first_name.addTextChangedListener(new MyTextWatcher(et_first_name.getId()));
        et_last_name.addTextChangedListener(new MyTextWatcher(et_last_name.getId()));
        et_pwd.addTextChangedListener(new MyTextWatcher(et_pwd.getId()));
        et_confirm_pwd.addTextChangedListener(new MyTextWatcher(et_confirm_pwd.getId()));
        et_email.addTextChangedListener(new MyTextWatcher(et_email.getId()));

        et_pwd.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        et_confirm_pwd.setTransformationMethod(new AsteriskPasswordTransformationMethod());
    }

    @OnClick(R2.id.tv_register)
    public void register() {
        String email = et_email.getText().toString();
        String password = et_pwd.getText().toString();
        String confirmPwd = et_confirm_pwd.getText().toString();
        String firstname = et_first_name.getText().toString();
        String lastname = et_last_name.getText().toString();
        boolean is_subscribed = cb_isSubscribe.isSelected();
        String captcha = et_code.getText().toString();
        if (et_last_name.getCompoundDrawables()[2]==null) {
            ToastUtils.showToastForText(this, getResources().getString(R.string.surnameHint));
            return;
        } else if (et_first_name.getCompoundDrawables()[2]==null) {
            ToastUtils.showToastForText(this,getResources().getString( R.string.nameHint));
            return;
        } else if (et_email.getCompoundDrawables()[2]==null) {
            ToastUtils.showToastForText(this, getResources().getString(R.string.mailHint));
            return;
        } else if (et_pwd.getCompoundDrawables()[2]==null && et_confirm_pwd.getCompoundDrawables()[0]==null) {
            ToastUtils.showToastForText(this,getResources().getString( R.string.passwordHint));
            return;
        } else if (TextUtils.isEmpty(captcha) || captcha.length() != 4) {
            ToastUtils.showToastForText(this,getResources().getString( R.string.codeHint));
            return;
        }
        HashMap<String, Object> param = new HashMap<>();
        param.put("email", email);
        param.put("password", password);
        param.put("firstname", firstname);
        param.put("lastname", lastname);
        param.put("is_subscribed", is_subscribed);
        param.put("captcha", captcha);
        presenter.register(param, Contans.Tag.REGISTER);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }


    class MyTextWatcher implements TextWatcher {
        private int id;

        public MyTextWatcher(int id) {
            this.id = id;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (id == R.id.et_first_name) {
                if (s.length() >= 1) {
                    ViewHelp.getInstance().setImgForViewRight(et_first_name, getResources().getDrawable(R.drawable.correct));
                } else {
                    ViewHelp.getInstance().setImgForViewRight(et_first_name, null);
                }
            } else if (id == R.id.et_last_name) {
                if (s.length() >= 1) {
                    ViewHelp.getInstance().setImgForViewRight(et_last_name, getResources().getDrawable(R.drawable.correct));
                } else {
                    ViewHelp.getInstance().setImgForViewRight(et_last_name, null);
                }
            } else if (id == R.id.et_pwd) {
                if (s.length() >= 6) {
                    ViewHelp.getInstance().setImgForViewRight(et_pwd, getResources().getDrawable(R.drawable.correct));
                } else {
                    ViewHelp.getInstance().setImgForViewRight(et_pwd, null);
                }
            } else if (id == R.id.et_confirm_pwd) {
                if (s.length() >= 6 && et_confirm_pwd.getText().toString().equals(et_pwd.getText().toString())) {
                    ViewHelp.getInstance().setImgForViewRight(et_confirm_pwd, getResources().getDrawable(R.drawable.correct));
                } else {
                    ViewHelp.getInstance().setImgForViewRight(et_confirm_pwd, null);
                }
            } else if (id == R.id.et_email) {
                if (isEmail(et_email.getText().toString())) {
                    ViewHelp.getInstance().setImgForViewRight(et_email, getResources().getDrawable(R.drawable.correct));
                } else {
                    ViewHelp.getInstance().setImgForViewRight(et_email, null);
                }
            }

        }
    }

    private boolean isEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);

    }
}
