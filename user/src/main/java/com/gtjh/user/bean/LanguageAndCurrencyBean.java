package com.gtjh.user.bean;

import java.util.List;

/**
 * Created by android on 2018/8/9.
 */

public class LanguageAndCurrencyBean {

    /**
     * language : {"langList":[{"code":"fr","language":"fr_FR","languageName":"Français"},{"code":"en","language":"en_US","languageName":"English"},{"code":"es","language":"es_ES","languageName":"Español"},{"code":"zh","language":"zh_CN","languageName":"中文"}],"currentLang":"en"}
     * currency : {"currencyList":{"EUR":{"code":"EUR","rate":0.93,"symbol":"\u20ac"},"USD":{"code":"USD","rate":1,"symbol":"$"},"GBP":{"code":"GBP","rate":0.8,"symbol":"£"},"CNY":{"code":"CNY","rate":6.3,"symbol":"￥"}},"currentCurrency":"USD"}
     */

    private LanguageBean language;
    private CurrencyBean currency;

    public LanguageBean getLanguage() {
        return language;
    }

    public void setLanguage(LanguageBean language) {
        this.language = language;
    }

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    public static class LanguageBean {
        /**
         * langList : [{"code":"fr","language":"fr_FR","languageName":"Français"},{"code":"en","language":"en_US","languageName":"English"},{"code":"es","language":"es_ES","languageName":"Español"},{"code":"zh","language":"zh_CN","languageName":"中文"}]
         * currentLang : en
         */

        private String currentLang;

        public String getCurrentLang() {
            return currentLang;
        }

        public void setCurrentLang(String currentLang) {
            this.currentLang = currentLang;
        }
    }

    public static class CurrencyBean {
        /**
         * currencyList : {"EUR":{"code":"EUR","rate":0.93,"symbol":"\u20ac"},"USD":{"code":"USD","rate":1,"symbol":"$"},"GBP":{"code":"GBP","rate":0.8,"symbol":"£"},"CNY":{"code":"CNY","rate":6.3,"symbol":"￥"}}
         * currentCurrency : USD
         */

        private Object currencyList;
        private String currentCurrency;

        public Object getCurrencyList() {
            return currencyList;
        }

        public void setCurrencyList(Object currencyList) {
            this.currencyList = currencyList;
        }

        public String getCurrentCurrency() {
            return currentCurrency;
        }

        public void setCurrentCurrency(String currentCurrency) {
            this.currentCurrency = currentCurrency;
        }
    }
}
