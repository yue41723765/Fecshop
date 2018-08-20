package com.gtjh.user;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.test.mock.MockContext;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gtjh.common.BaseFragment;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.SPUtil;
import com.gtjh.user.activity.CollectActivity;
import com.gtjh.user.activity.OrderActivity;
import com.gtjh.user.activity.WebActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by android on 2018/7/2.
 */

public class UserFragment extends BaseFragment {
    @BindView(R2.id.tv_center)
    TextView tv_center;
    @BindView(R2.id.rl_head)
    View rl_head;
    @BindView(R2.id.btn_register)
    TextView btn_register;
    @BindView(R2.id.btn_login)
    TextView btn_login;
    @BindView(R2.id.view_right)
    RelativeLayout right;
    @BindView(R2.id.rl_currency)
    RelativeLayout rl_currency;
    @BindView(R2.id.tv_currency)
    TextView tv_currency;
    @BindView(R2.id.tv_language)
    TextView tv_language;

    @Override
    public void showSuccess(Object o, int tag) {

    }

    @Override
    protected void init() {
        tv_center.setText(R.string.user_name);
        right.setVisibility(View.GONE);
        RxBus.getInstance().register(this);
        Log.i("TOKEN",SPUtil.getToken(mContext));
        Log.i("TOKEN","uid"+SPUtil.getUid(mContext));
        tv_currency.setText(SPUtil.getCurrency(mContext));
        tv_language.setText(SPUtil.getLanguage(mContext));
        initView();
    }

    private void initView() {
        Boolean isLogin=SPUtil.getIsLogin(mContext);
        if (isLogin){
            rl_head.setVisibility(View.GONE);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @OnClick(R2.id.btn_login)
    public void login() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R2.id.btn_register)
    public void register() {
        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        startActivity(intent);
    }
    @OnClick(R2.id.tv_account)
    public void account(){
        //我的账户
            Intent intent = new Intent(getActivity(), AccountActivity.class);
            startActivity(intent);

    }


    @RegisterRxBus(Contans.Tag.LOGIN)
    private void loginSuccess(Boolean isLoginSuccess, int tag) {
        if (isLoginSuccess) {
            rl_head.setVisibility(View.GONE);
        }else {
            rl_head.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R2.id.rl_language)
    public void startLanguage() {
        Intent intent = new Intent(getActivity(), LanguageMoneyActivty.class);
        startActivity(intent);
    }
    @OnClick(R2.id.rl_currency)
    public void startCurrency() {
        Intent intent = new Intent(getActivity(), LanguageMoneyActivty.class);
        startActivity(intent);
    }
    @OnClick(R2.id.tv_order)
    public void order(){
        //我的订单
        if (  SPUtil.getIsLogin(mContext)) {
           Intent intent=new Intent(getActivity(),OrderActivity.class);
           startActivity(intent);
        }else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R2.id.tv_collect)
    public void collect(){
        //我的收藏
        if (  SPUtil.getIsLogin(mContext)) {
            Intent intent = new Intent(getActivity(), CollectActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }
    @OnClick(R2.id.tv_about)
    public void aboutUs(){
        //关于我们
        WebActivity.startActivity(getActivity(),getResources().getString(R.string.aboutUs),"http://appfront.shop.saneim.com/aboutus");
    }
    @OnClick(R2.id.tv_contact)
    public void contactUs(){
        //联系我们

        WebActivity.startActivity(getActivity(),getResources().getString(R.string.contactUs),"http://appfront.shop.saneim.com/contactus");
    }
    @OnClick(R2.id.tv_clause)
    public void clause(){
        //法律
        WebActivity.startActivity(getActivity(),getResources().getString(R.string.clause),"http://appfront.shop.saneim.com/privacypolicy");
    }
}
