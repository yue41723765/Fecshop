package com.gtjh.shop_car.bean;

import java.util.List;

/**
 * Created by android on 2018/7/23.
 */

public class CartBean {
    private CartInfo cart_info;
    private CurrencyBean currency;

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCart_info(CartInfo cart_info) {
        this.cart_info = cart_info;
    }

    public CartInfo getCart_info() {
        return cart_info;
    }

    public class CartInfo{
        private String shipping_method; // 物流简码
        private String grand_total;      // 所有的总额（相当于订单总额）
        private String shipping_cost;   // 运费金额
        private String product_total;   // 购物车中所有产品的金额
        private List<ProductsListBean> products;



        public String getShipping_method() {
            return shipping_method;
        }

        public void setShipping_method(String shipping_method) {
            this.shipping_method = shipping_method;
        }

        public String getGrand_total() {
            return grand_total;
        }

        public void setGrand_total(String grand_total) {
            this.grand_total = grand_total;
        }

        public String getShipping_cost() {
            return shipping_cost;
        }

        public void setShipping_cost(String shipping_cost) {
            this.shipping_cost = shipping_cost;
        }

        public String getProduct_total() {
            return product_total;
        }

        public void setProduct_total(String product_total) {
            this.product_total = product_total;
        }

        public List<ProductsListBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsListBean> products) {
            this.products = products;
        }




    }
    public class CurrencyBean{


        /**
         * code : USD
         * rate : 1.0
         * symbol : $
         */

        private String code;
        private double rate;
        private String symbol;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }
}
