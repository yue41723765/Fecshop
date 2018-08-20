package com.gtjh.shop_car.bean;

import com.gtjh.common.entity.AddressListBean;

import java.util.List;

/**
 * Created by android on 2018/7/24.
 */

public class InitOrderBean  {
    private Object payments;
    private List<MethodsListBean> shippings;
    private String current_shipping_method;
    private String current_payment_method;
    private CartInfoBean cart_info;
    private CurrencyInfoBean currency_info;
    private AddressListBean cart_address;
    private int cart_address_id;
    public class CurrencyInfoBean{

        /**
         * code : EUR
         * rate : 0.93
         * symbol : €
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

    public class CartInfoBean{
        private int items_count;
        private double product_weight;
        private String grand_total;
        private String shipping_cost;
        private String coupon_cost;
        private String product_total;
        private String product_volume;
        private String coupon_code;
        private List<OrderProductsListBean> products;

        public void setProduct_volume(String product_volume) {
            this.product_volume = product_volume;
        }

        public String getProduct_volume() {
            return product_volume;
        }

        public void setCoupon_code(String coupon_code) {
            this.coupon_code = coupon_code;
        }

        public String getCoupon_code() {
            return coupon_code;
        }

        public int getItems_count() {
            return items_count;
        }

        public void setItems_count(int items_count) {
            this.items_count = items_count;
        }

        public double getProduct_weight() {
            return product_weight;
        }

        public void setProduct_weight(double product_weight) {
            this.product_weight = product_weight;
        }

        public String getGrand_total() {
            return grand_total;
        }

        public void setGrand_total(String grand_total) {
            this.grand_total = grand_total;
        }

        public List<OrderProductsListBean> getProducts() {
            return products;
        }

        public void setProducts(List<OrderProductsListBean> products) {
            this.products = products;
        }

        public String getShipping_cost() {
            return shipping_cost;
        }

        public void setShipping_cost(String shipping_cost) {
            this.shipping_cost = shipping_cost;
        }

        public String getCoupon_cost() {
            return coupon_cost;
        }

        public void setCoupon_cost(String coupon_cost) {
            this.coupon_cost = coupon_cost;
        }

        public String getProduct_total() {
            return product_total;
        }

        public void setProduct_total(String product_total) {
            this.product_total = product_total;
        }
    }

    public Object getPayments() {
        return payments;
    }

    public void setPayments(Object payments) {
        this.payments = payments;
    }

    public List<MethodsListBean> getShippings() {
        return shippings;
    }

    public void setShippings(List<MethodsListBean> shippings) {
        this.shippings = shippings;
    }

    public String getCurrent_shipping_method() {
        return current_shipping_method;
    }

    public void setCurrent_shipping_method(String current_shipping_method) {
        this.current_shipping_method = current_shipping_method;
    }

    public String getCurrent_payment_method() {
        return current_payment_method;
    }

    public void setCurrent_payment_method(String current_payment_method) {
        this.current_payment_method = current_payment_method;
    }

    public CartInfoBean getCart_info() {
        return cart_info;
    }

    public void setCart_info(CartInfoBean cart_info) {
        this.cart_info = cart_info;
    }

    public CurrencyInfoBean getCurrency_info() {
        return currency_info;
    }

    public void setCurrency_info(CurrencyInfoBean currency_info) {
        this.currency_info = currency_info;
    }

    public AddressListBean getCart_address() {
        return cart_address;
    }

    public void setCart_address(AddressListBean cart_address) {
        this.cart_address = cart_address;
    }

    public int getCart_address_id() {
        return cart_address_id;
    }

    public void setCart_address_id(int cart_address_id) {
        this.cart_address_id = cart_address_id;
    }
}
