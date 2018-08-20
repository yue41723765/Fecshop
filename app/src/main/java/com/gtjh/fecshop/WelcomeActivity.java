package com.gtjh.fecshop;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.GTJHApplication;
import com.gtjh.common.entity.Language;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.GsonUtils;
import com.gtjh.common.util.RYLog;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.file.FileUtil;
import com.gtjh.common.util.language.LanguageManage;
import com.gtjh.fecshop.presenter.InitPresenter;
import com.thoughtworks.xstream.XStream;

import org.greenrobot.eventbus.EventBus;
import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by android on 2018/7/3.
 */

public class WelcomeActivity extends BaseActivity {
    private InitPresenter presenter;
    private Handler handler = new Handler();

    @Override
    public void init(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        presenter = new InitPresenter(this);
        presenter.initLanguage(Contans.Tag.INIT_LANGUAGE);
        RxBus.getInstance().register(presenter);
        changeAppLanguage();
        if (SPUtil.getIsFirst(this)){
            gotoGuide();
        }else {
            gotoMain();
        }
    }

    private void gotoMain() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    private void gotoGuide() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    private void  changeAppLanguage(){
        String sta = SPUtil.getLanguage(this);
        if(sta != null && !"".equals(sta)){
            // 本地语言设置
            Locale myLocale = new Locale(sta);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
        }

    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    @Override
    public void showSuccess(Object o, int tag) {
        HashMap<String, Language.languageInfo> language = (HashMap<String, Language.languageInfo>) o;
        LanguageManage.getInstance().addLanguage(language);
        GTJHApplication.getApplication().language = LanguageManage.getInstance().getLanguageByCode("zh");
    }

    @Override
    public void showError(Throwable throwable) {

    }
}
