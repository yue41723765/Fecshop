package com.gtjh.user.bean;

/**
 * Created by android on 2018/8/9.
 */

public class CurrencyBean {
    private String currentCurrency;
    private Object currencyList;

    public String getCurrentCurrency() {
        return currentCurrency;
    }

    public void setCurrentCurrency(String currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    public Object getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(Object currencyList) {
        this.currencyList = currencyList;
    }
}
