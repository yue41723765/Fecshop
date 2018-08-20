package com.gtjh.common.util;

import com.gtjh.common.entity.CurrencyListBean;
import com.gtjh.common.entity.LanguageListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2018/8/8.
 */

public class LanguageSaveList  {
    private  List<LanguageListBean> languageList=new ArrayList<>();
    private  List<CurrencyListBean> currencyList=new ArrayList<>();
    private  String currentLang="zh";
    private  String currentCurrency="CNY";
    public LanguageSaveList(){
        languageList.clear();
        languageList.add(new LanguageListBean("zh","zh_CN","中文",1));
        languageList.add(new LanguageListBean("en","en_US","English",1));
        languageList.add(new LanguageListBean("fr","fr_FR","Français",1));
        languageList.add(new LanguageListBean("es","es_ES","Español",1));
    }
    public  List<LanguageListBean> getLanguageList() {
        return languageList;
    }

    public  void setCurrencyList(List<CurrencyListBean> currencyList) {
        this.currencyList = currencyList;
    }

    public  List<CurrencyListBean> getCurrencyList() {
        return currencyList;
    }

    public  void setCurrentLang(String currentLang) {
        this.currentLang = currentLang;
    }

    public  String getCurrentLang() {
        return currentLang;
    }

    public  void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    public  String getCurrentCurrency() {
        return currentCurrency;
    }

}
