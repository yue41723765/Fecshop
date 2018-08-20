package com.gtjh.user.bean;

import java.util.List;

/**
 * Created by android on 2018/7/13.
 */

public class OrderDetailsBean  {
    /**
     * order : {"order_id":"883","increment_id":"1100000883","order_status":"processing","created_at":"2017-10-26 16:41:58","items_count":"1","total_weight":"55.00","order_currency_code":"CNY","order_to_base_rate":"6.8700","grand_total":"542.40","base_grand_total":"78.95","subtotal":"34.70","base_subtotal":"5.05","subtotal_with_discount":"0.00","base_subtotal_with_discount":"0.00","checkout_method":"standard","customer_id":"46","customer_group":null,"customer_email":"2358269014@qq.com","customer_firstname":"fdsafasd","customer_lastname":"32423423432","customer_is_guest":"2","coupon_code":"","payment_method":"alipay_standard","shipping_method":"fast_shipping","shipping_total":"507.70","base_shipping_total":"73.90","customer_telephone":"312321","customer_address_country":"US","customer_address_state":"FL","customer_address_city":"321312","customer_address_zip":"123123","customer_address_street1":"321312","customer_address_street2":"3213","currency_symbol":"\u20ac","customer_address_state_name":"Niederösterreich","customer_address_country_name":"Austria","products":""}
     */

    private OrderBean order;

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public static class OrderBean {
        /**
         * order_id : 883
         * increment_id : 1100000883
         * order_status : processing
         * created_at : 2017-10-26 16:41:58
         * items_count : 1
         * total_weight : 55.00
         * order_currency_code : CNY
         * order_to_base_rate : 6.8700
         * grand_total : 542.40
         * base_grand_total : 78.95
         * subtotal : 34.70
         * base_subtotal : 5.05
         * subtotal_with_discount : 0.00
         * base_subtotal_with_discount : 0.00
         * checkout_method : standard
         * customer_id : 46
         * customer_group : null
         * customer_email : 2358269014@qq.com
         * customer_firstname : fdsafasd
         * customer_lastname : 32423423432
         * customer_is_guest : 2
         * coupon_code :
         * payment_method : alipay_standard
         * shipping_method : fast_shipping
         * shipping_total : 507.70
         * base_shipping_total : 73.90
         * customer_telephone : 312321
         * customer_address_country : US
         * customer_address_state : FL
         * customer_address_city : 321312
         * customer_address_zip : 123123
         * customer_address_street1 : 321312
         * customer_address_street2 : 3213
         * currency_symbol : €
         * customer_address_state_name : Niederösterreich
         * customer_address_country_name : Austria
         * products :
         */

        private String order_id;
        private String increment_id;
        private String order_status;
        private String created_at;
        private String items_count;
        private String total_weight;
        private String order_currency_code;
        private String order_to_base_rate;
        private String grand_total;
        private String base_grand_total;
        private String subtotal;
        private String base_subtotal;
        private String subtotal_with_discount;
        private String base_subtotal_with_discount;
        private String checkout_method;
        private String customer_id;
        private Object customer_group;
        private String customer_email;
        private String customer_firstname;
        private String customer_lastname;
        private String customer_is_guest;
        private String coupon_code;
        private String payment_method;
        private String shipping_method;
        private String shipping_total;
        private String base_shipping_total;
        private String customer_telephone;
        private String customer_address_country;
        private String customer_address_state;
        private String customer_address_city;
        private String customer_address_zip;
        private String customer_address_street1;
        private String customer_address_street2;
        private String currency_symbol;
        private String customer_address_state_name;
        private String customer_address_country_name;
        private List<OrderDetailsListBean> products;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getIncrement_id() {
            return increment_id;
        }

        public void setIncrement_id(String increment_id) {
            this.increment_id = increment_id;
        }

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getItems_count() {
            return items_count;
        }

        public void setItems_count(String items_count) {
            this.items_count = items_count;
        }

        public String getTotal_weight() {
            return total_weight;
        }

        public void setTotal_weight(String total_weight) {
            this.total_weight = total_weight;
        }

        public String getOrder_currency_code() {
            return order_currency_code;
        }

        public void setOrder_currency_code(String order_currency_code) {
            this.order_currency_code = order_currency_code;
        }

        public String getOrder_to_base_rate() {
            return order_to_base_rate;
        }

        public void setOrder_to_base_rate(String order_to_base_rate) {
            this.order_to_base_rate = order_to_base_rate;
        }

        public String getGrand_total() {
            return grand_total;
        }

        public void setGrand_total(String grand_total) {
            this.grand_total = grand_total;
        }

        public String getBase_grand_total() {
            return base_grand_total;
        }

        public void setBase_grand_total(String base_grand_total) {
            this.base_grand_total = base_grand_total;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getBase_subtotal() {
            return base_subtotal;
        }

        public void setBase_subtotal(String base_subtotal) {
            this.base_subtotal = base_subtotal;
        }

        public String getSubtotal_with_discount() {
            return subtotal_with_discount;
        }

        public void setSubtotal_with_discount(String subtotal_with_discount) {
            this.subtotal_with_discount = subtotal_with_discount;
        }

        public String getBase_subtotal_with_discount() {
            return base_subtotal_with_discount;
        }

        public void setBase_subtotal_with_discount(String base_subtotal_with_discount) {
            this.base_subtotal_with_discount = base_subtotal_with_discount;
        }

        public String getCheckout_method() {
            return checkout_method;
        }

        public void setCheckout_method(String checkout_method) {
            this.checkout_method = checkout_method;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public Object getCustomer_group() {
            return customer_group;
        }

        public void setCustomer_group(Object customer_group) {
            this.customer_group = customer_group;
        }

        public String getCustomer_email() {
            return customer_email;
        }

        public void setCustomer_email(String customer_email) {
            this.customer_email = customer_email;
        }

        public String getCustomer_firstname() {
            return customer_firstname;
        }

        public void setCustomer_firstname(String customer_firstname) {
            this.customer_firstname = customer_firstname;
        }

        public String getCustomer_lastname() {
            return customer_lastname;
        }

        public void setCustomer_lastname(String customer_lastname) {
            this.customer_lastname = customer_lastname;
        }

        public String getCustomer_is_guest() {
            return customer_is_guest;
        }

        public void setCustomer_is_guest(String customer_is_guest) {
            this.customer_is_guest = customer_is_guest;
        }

        public String getCoupon_code() {
            return coupon_code;
        }

        public void setCoupon_code(String coupon_code) {
            this.coupon_code = coupon_code;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public String getShipping_method() {
            return shipping_method;
        }

        public void setShipping_method(String shipping_method) {
            this.shipping_method = shipping_method;
        }

        public String getShipping_total() {
            return shipping_total;
        }

        public void setShipping_total(String shipping_total) {
            this.shipping_total = shipping_total;
        }

        public String getBase_shipping_total() {
            return base_shipping_total;
        }

        public void setBase_shipping_total(String base_shipping_total) {
            this.base_shipping_total = base_shipping_total;
        }

        public String getCustomer_telephone() {
            return customer_telephone;
        }

        public void setCustomer_telephone(String customer_telephone) {
            this.customer_telephone = customer_telephone;
        }

        public String getCustomer_address_country() {
            return customer_address_country;
        }

        public void setCustomer_address_country(String customer_address_country) {
            this.customer_address_country = customer_address_country;
        }

        public String getCustomer_address_state() {
            return customer_address_state;
        }

        public void setCustomer_address_state(String customer_address_state) {
            this.customer_address_state = customer_address_state;
        }

        public String getCustomer_address_city() {
            return customer_address_city;
        }

        public void setCustomer_address_city(String customer_address_city) {
            this.customer_address_city = customer_address_city;
        }

        public String getCustomer_address_zip() {
            return customer_address_zip;
        }

        public void setCustomer_address_zip(String customer_address_zip) {
            this.customer_address_zip = customer_address_zip;
        }

        public String getCustomer_address_street1() {
            return customer_address_street1;
        }

        public void setCustomer_address_street1(String customer_address_street1) {
            this.customer_address_street1 = customer_address_street1;
        }

        public String getCustomer_address_street2() {
            return customer_address_street2;
        }

        public void setCustomer_address_street2(String customer_address_street2) {
            this.customer_address_street2 = customer_address_street2;
        }

        public String getCurrency_symbol() {
            return currency_symbol;
        }

        public void setCurrency_symbol(String currency_symbol) {
            this.currency_symbol = currency_symbol;
        }

        public String getCustomer_address_state_name() {
            return customer_address_state_name;
        }

        public void setCustomer_address_state_name(String customer_address_state_name) {
            this.customer_address_state_name = customer_address_state_name;
        }

        public String getCustomer_address_country_name() {
            return customer_address_country_name;
        }

        public void setCustomer_address_country_name(String customer_address_country_name) {
            this.customer_address_country_name = customer_address_country_name;
        }

        public List<OrderDetailsListBean> getProducts() {
            return products;
        }

        public void setProducts(List<OrderDetailsListBean> products) {
            this.products = products;
        }
    }
}
