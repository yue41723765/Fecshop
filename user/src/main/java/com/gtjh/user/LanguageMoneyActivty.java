package com.gtjh.user;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.CurrencyListBean;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.LanguageSaveList;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.util.language.LanguageManage;
import com.gtjh.user.adapter.CurrencyAdapter;
import com.gtjh.user.adapter.LanguageMoneyAdapter;
import com.gtjh.user.bean.LanguageAndCurrencyBean;
import com.gtjh.user.event.OnSelectorClickListener;
import com.gtjh.user.presenter.impl.GetLanguagePresenterImpl;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by android on 2018/7/6.
 */

public class LanguageMoneyActivty extends ToolBarActivity {
    @BindView(R2.id.rv_language)
    RecyclerView rv_language;
    @BindView(R2.id.rv_money)
    RecyclerView rv_money;
    private LanguageMoneyAdapter adapter;
    private CurrencyAdapter currencyAdapter;
    private LanguageSaveList languageSaveList=new LanguageSaveList();
    private GetLanguagePresenterImpl presenter;
    private String cuS="";
    private String langS="";
    @Override
    public void showSuccess(Object o, int tag) {

        switch (tag){
            case Contans.Tag.INIT_MAIN:
                initData((ResponseData<Object>) o);
                break;
        }
    }

    private void initData(ResponseData<Object> o) {
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            return;
        }
        LanguageAndCurrencyBean data=gson.fromJson(gson.toJson(o.getData()),LanguageAndCurrencyBean.class);
        Map<String,Object> map=gson.fromJson(gson.toJson(data.getCurrency().getCurrencyList()),Map.class);
        Iterator<Map.Entry<String,Object>> iterator=map.entrySet().iterator();
        List<CurrencyListBean> listBeans=new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<String,Object> entry=iterator.next();
            CurrencyListBean bean=gson.fromJson(gson.toJson(entry.getValue()),CurrencyListBean.class);
            listBeans.add(bean);
        }
        languageSaveList.setCurrencyList(listBeans);
        currencyAdapter.initData(languageSaveList.getCurrencyList());
    }


    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.languageAndCurrency));
        Build build=new Build();
        build.setListener(onClickListener);
        build.setTextColor(Color.BLACK);
        build.setTextSize(30);
        build.setText(getResources().getString(R.string.save));
        setRight(build);
        presenter=new GetLanguagePresenterImpl(this);
        RxBus.getInstance().register(presenter);


        presenter.getLanguage(Contans.Tag.INIT_MAIN);
        adapter=new LanguageMoneyAdapter(languageSaveList.getLanguageList(),this);
        currencyAdapter=new CurrencyAdapter(languageSaveList.getCurrencyList(),this);
        rv_money.setLayoutManager(new LinearLayoutManager(this));
        rv_language.setLayoutManager(new LinearLayoutManager(this));
        rv_money.setAdapter(currencyAdapter);
        rv_language.setAdapter(adapter);
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //保存
            cuS=currencyAdapter.getName();
            langS=adapter.getName();
            if (TextUtils.isEmpty(cuS)){
                cuS=SPUtil.getCurrency(LanguageMoneyActivty.this);
            }
            if (TextUtils.isEmpty(langS)){
                langS=SPUtil.getLanguage(LanguageMoneyActivty.this);
            }
            Log.i("TAG",cuS+langS);
            SPUtil.saveCurrency(LanguageMoneyActivty.this,cuS);
            SPUtil.saveLanguage(LanguageMoneyActivty.this,langS);
            EventBus.getDefault().post("EVENT_REFRESH_LANGUAGE");
        }
    };
    @Override
    public int getLayoutId() {
        return R.layout.activity_language_money;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }
}
