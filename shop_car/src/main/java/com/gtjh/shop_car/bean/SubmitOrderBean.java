package com.gtjh.shop_car.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by android on 2018/7/25.
 */

public class SubmitOrderBean  {

    /**
     * redirectUrl : /payment/checkmoney/start
     * orderInfo : {"order_id":280,"increment_id":"1100000280","order_status":"payment_pending","store":"appserver.shop.saneim.com","created_at":1534472459,"updated_at":1534472459,"items_count":1,"total_weight":"3.00","order_currency_code":"CNY","order_to_base_rate":"6.3000","grand_total":"140.10","base_grand_total":"23.50","subtotal":"138.60","base_subtotal":"22.00","subtotal_with_discount":"0.00","base_subtotal_with_discount":"0.00","is_changed":1,"checkout_method":"standard","customer_id":6,"customer_group":null,"customer_email":"yue963045101@163.com","customer_firstname":"Mei","customer_lastname":"Yue","customer_is_guest":2,"remote_ip":null,"coupon_code":null,"payment_method":"check_money","shipping_method":"middle_shipping","shipping_total":"1.50","base_shipping_total":"1.50","customer_telephone":"17343045200","customer_address_country":"China","customer_address_state":"北京市","customer_address_city":"北京","customer_address_zip":"000000","customer_address_street1":"哈哈","customer_address_street2":"哈哈哈哈","order_remark":null,"txn_type":null,"txn_id":null,"payer_id":null,"ipn_track_id":null,"receiver_id":null,"verify_sign":null,"charset":null,"payment_fee":null,"payment_type":null,"correlation_id":null,"base_payment_fee":null,"protection_eligibility":null,"protection_eligibility_type":null,"secure_merchant_account_id":null,"build":null,"paypal_order_datetime":null,"theme_type":null,"if_is_return_stock":2,"payment_token":null,"version":0,"customer_address_state_name":"北京市","customer_address_country_name":"China","currency_symbol":"￥","products":[{"item_id":"365","store":"appserver.shop.saneim.com","order_id":"280","customer_id":null,"created_at":"1534472459","updated_at":"1534472459","product_id":"57bac5c6f656f2940a3bf570","sku":"432432","name":"圆领女士花卉印花无袖连衣裙","custom_option_sku":"white-xxl","image":"/1/7/17147202419675158.jpg","weight":"3.00","qty":"1","row_weight":"3.00","price":"138.60","base_price":"138.60","row_total":"138.60","base_row_total":"22.00","redirect_url":"/round-collar-floral-print-sleeveless-dress-for-women","spu_options":[],"custom_option":{"red-s":{"my_color":"red","my_size":"S","sku":"red-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-s":{"my_color":"white","my_size":"S","sku":"white-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-l":{"my_color":"white","my_size":"L","sku":"white-l","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-xxl":{"my_color":"white","my_size":"XXL","sku":"white-xxl","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}},"custom_option_info":{"My color":"white","My size":"XXL"}}]}
     */

    private String redirectUrl;
    private OrderInfoBean orderInfo;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public OrderInfoBean getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfoBean orderInfo) {
        this.orderInfo = orderInfo;
    }

    public static class OrderInfoBean {
        /**
         * order_id : 280
         * increment_id : 1100000280
         * order_status : payment_pending
         * store : appserver.shop.saneim.com
         * created_at : 1534472459
         * updated_at : 1534472459
         * items_count : 1
         * total_weight : 3.00
         * order_currency_code : CNY
         * order_to_base_rate : 6.3000
         * grand_total : 140.10
         * base_grand_total : 23.50
         * subtotal : 138.60
         * base_subtotal : 22.00
         * subtotal_with_discount : 0.00
         * base_subtotal_with_discount : 0.00
         * is_changed : 1
         * checkout_method : standard
         * customer_id : 6
         * customer_group : null
         * customer_email : yue963045101@163.com
         * customer_firstname : Mei
         * customer_lastname : Yue
         * customer_is_guest : 2
         * remote_ip : null
         * coupon_code : null
         * payment_method : check_money
         * shipping_method : middle_shipping
         * shipping_total : 1.50
         * base_shipping_total : 1.50
         * customer_telephone : 17343045200
         * customer_address_country : China
         * customer_address_state : 北京市
         * customer_address_city : 北京
         * customer_address_zip : 000000
         * customer_address_street1 : 哈哈
         * customer_address_street2 : 哈哈哈哈
         * order_remark : null
         * txn_type : null
         * txn_id : null
         * payer_id : null
         * ipn_track_id : null
         * receiver_id : null
         * verify_sign : null
         * charset : null
         * payment_fee : null
         * payment_type : null
         * correlation_id : null
         * base_payment_fee : null
         * protection_eligibility : null
         * protection_eligibility_type : null
         * secure_merchant_account_id : null
         * build : null
         * paypal_order_datetime : null
         * theme_type : null
         * if_is_return_stock : 2
         * payment_token : null
         * version : 0
         * customer_address_state_name : 北京市
         * customer_address_country_name : China
         * currency_symbol : ￥
         * products : [{"item_id":"365","store":"appserver.shop.saneim.com","order_id":"280","customer_id":null,"created_at":"1534472459","updated_at":"1534472459","product_id":"57bac5c6f656f2940a3bf570","sku":"432432","name":"圆领女士花卉印花无袖连衣裙","custom_option_sku":"white-xxl","image":"/1/7/17147202419675158.jpg","weight":"3.00","qty":"1","row_weight":"3.00","price":"138.60","base_price":"138.60","row_total":"138.60","base_row_total":"22.00","redirect_url":"/round-collar-floral-print-sleeveless-dress-for-women","spu_options":[],"custom_option":{"red-s":{"my_color":"red","my_size":"S","sku":"red-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-s":{"my_color":"white","my_size":"S","sku":"white-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-l":{"my_color":"white","my_size":"L","sku":"white-l","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-xxl":{"my_color":"white","my_size":"XXL","sku":"white-xxl","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}},"custom_option_info":{"My color":"white","My size":"XXL"}}]
         */

        private int order_id;
        private String increment_id;
        private String order_status;
        private String store;
        private int created_at;
        private int updated_at;
        private int items_count;
        private String total_weight;
        private String order_currency_code;
        private String order_to_base_rate;
        private String grand_total;
        private String base_grand_total;
        private String subtotal;
        private String base_subtotal;
        private String subtotal_with_discount;
        private String base_subtotal_with_discount;
        private int is_changed;
        private String checkout_method;
        private int customer_id;
        private Object customer_group;
        private String customer_email;
        private String customer_firstname;
        private String customer_lastname;
        private int customer_is_guest;
        private Object remote_ip;
        private Object coupon_code;
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
        private Object order_remark;
        private Object txn_type;
        private Object txn_id;
        private Object payer_id;
        private Object ipn_track_id;
        private Object receiver_id;
        private Object verify_sign;
        private Object charset;
        private Object payment_fee;
        private Object payment_type;
        private Object correlation_id;
        private Object base_payment_fee;
        private Object protection_eligibility;
        private Object protection_eligibility_type;
        private Object secure_merchant_account_id;
        private Object build;
        private Object paypal_order_datetime;
        private Object theme_type;
        private int if_is_return_stock;
        private Object payment_token;
        private int version;
        private String customer_address_state_name;
        private String customer_address_country_name;
        private String currency_symbol;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
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

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public int getItems_count() {
            return items_count;
        }

        public void setItems_count(int items_count) {
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

        public int getIs_changed() {
            return is_changed;
        }

        public void setIs_changed(int is_changed) {
            this.is_changed = is_changed;
        }

        public String getCheckout_method() {
            return checkout_method;
        }

        public void setCheckout_method(String checkout_method) {
            this.checkout_method = checkout_method;
        }

        public int getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(int customer_id) {
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

        public int getCustomer_is_guest() {
            return customer_is_guest;
        }

        public void setCustomer_is_guest(int customer_is_guest) {
            this.customer_is_guest = customer_is_guest;
        }

        public Object getRemote_ip() {
            return remote_ip;
        }

        public void setRemote_ip(Object remote_ip) {
            this.remote_ip = remote_ip;
        }

        public Object getCoupon_code() {
            return coupon_code;
        }

        public void setCoupon_code(Object coupon_code) {
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

        public Object getOrder_remark() {
            return order_remark;
        }

        public void setOrder_remark(Object order_remark) {
            this.order_remark = order_remark;
        }

        public Object getTxn_type() {
            return txn_type;
        }

        public void setTxn_type(Object txn_type) {
            this.txn_type = txn_type;
        }

        public Object getTxn_id() {
            return txn_id;
        }

        public void setTxn_id(Object txn_id) {
            this.txn_id = txn_id;
        }

        public Object getPayer_id() {
            return payer_id;
        }

        public void setPayer_id(Object payer_id) {
            this.payer_id = payer_id;
        }

        public Object getIpn_track_id() {
            return ipn_track_id;
        }

        public void setIpn_track_id(Object ipn_track_id) {
            this.ipn_track_id = ipn_track_id;
        }

        public Object getReceiver_id() {
            return receiver_id;
        }

        public void setReceiver_id(Object receiver_id) {
            this.receiver_id = receiver_id;
        }

        public Object getVerify_sign() {
            return verify_sign;
        }

        public void setVerify_sign(Object verify_sign) {
            this.verify_sign = verify_sign;
        }

        public Object getCharset() {
            return charset;
        }

        public void setCharset(Object charset) {
            this.charset = charset;
        }

        public Object getPayment_fee() {
            return payment_fee;
        }

        public void setPayment_fee(Object payment_fee) {
            this.payment_fee = payment_fee;
        }

        public Object getPayment_type() {
            return payment_type;
        }

        public void setPayment_type(Object payment_type) {
            this.payment_type = payment_type;
        }

        public Object getCorrelation_id() {
            return correlation_id;
        }

        public void setCorrelation_id(Object correlation_id) {
            this.correlation_id = correlation_id;
        }

        public Object getBase_payment_fee() {
            return base_payment_fee;
        }

        public void setBase_payment_fee(Object base_payment_fee) {
            this.base_payment_fee = base_payment_fee;
        }

        public Object getProtection_eligibility() {
            return protection_eligibility;
        }

        public void setProtection_eligibility(Object protection_eligibility) {
            this.protection_eligibility = protection_eligibility;
        }

        public Object getProtection_eligibility_type() {
            return protection_eligibility_type;
        }

        public void setProtection_eligibility_type(Object protection_eligibility_type) {
            this.protection_eligibility_type = protection_eligibility_type;
        }

        public Object getSecure_merchant_account_id() {
            return secure_merchant_account_id;
        }

        public void setSecure_merchant_account_id(Object secure_merchant_account_id) {
            this.secure_merchant_account_id = secure_merchant_account_id;
        }

        public Object getBuild() {
            return build;
        }

        public void setBuild(Object build) {
            this.build = build;
        }

        public Object getPaypal_order_datetime() {
            return paypal_order_datetime;
        }

        public void setPaypal_order_datetime(Object paypal_order_datetime) {
            this.paypal_order_datetime = paypal_order_datetime;
        }

        public Object getTheme_type() {
            return theme_type;
        }

        public void setTheme_type(Object theme_type) {
            this.theme_type = theme_type;
        }

        public int getIf_is_return_stock() {
            return if_is_return_stock;
        }

        public void setIf_is_return_stock(int if_is_return_stock) {
            this.if_is_return_stock = if_is_return_stock;
        }

        public Object getPayment_token() {
            return payment_token;
        }

        public void setPayment_token(Object payment_token) {
            this.payment_token = payment_token;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
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

        public String getCurrency_symbol() {
            return currency_symbol;
        }

        public void setCurrency_symbol(String currency_symbol) {
            this.currency_symbol = currency_symbol;
        }


        public static class ProductsBean {
            /**
             * item_id : 365
             * store : appserver.shop.saneim.com
             * order_id : 280
             * customer_id : null
             * created_at : 1534472459
             * updated_at : 1534472459
             * product_id : 57bac5c6f656f2940a3bf570
             * sku : 432432
             * name : 圆领女士花卉印花无袖连衣裙
             * custom_option_sku : white-xxl
             * image : /1/7/17147202419675158.jpg
             * weight : 3.00
             * qty : 1
             * row_weight : 3.00
             * price : 138.60
             * base_price : 138.60
             * row_total : 138.60
             * base_row_total : 22.00
             * redirect_url : /round-collar-floral-print-sleeveless-dress-for-women
             * spu_options : []
             * custom_option : {"red-s":{"my_color":"red","my_size":"S","sku":"red-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-s":{"my_color":"white","my_size":"S","sku":"white-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-l":{"my_color":"white","my_size":"L","sku":"white-l","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-xxl":{"my_color":"white","my_size":"XXL","sku":"white-xxl","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}}
             * custom_option_info : {"My color":"white","My size":"XXL"}
             */

            private String item_id;
            private String store;
            private String order_id;
            private Object customer_id;
            private String created_at;
            private String updated_at;
            private String product_id;
            private String sku;
            private String name;
            private String custom_option_sku;
            private String image;
            private String weight;
            private String qty;
            private String row_weight;
            private String price;
            private String base_price;
            private String row_total;
            private String base_row_total;
            private String redirect_url;
            private CustomOptionBean custom_option;
            private CustomOptionInfoBean custom_option_info;
            private List<?> spu_options;

            public String getItem_id() {
                return item_id;
            }

            public void setItem_id(String item_id) {
                this.item_id = item_id;
            }

            public String getStore() {
                return store;
            }

            public void setStore(String store) {
                this.store = store;
            }

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public Object getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(Object customer_id) {
                this.customer_id = customer_id;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public String getSku() {
                return sku;
            }

            public void setSku(String sku) {
                this.sku = sku;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCustom_option_sku() {
                return custom_option_sku;
            }

            public void setCustom_option_sku(String custom_option_sku) {
                this.custom_option_sku = custom_option_sku;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getQty() {
                return qty;
            }

            public void setQty(String qty) {
                this.qty = qty;
            }

            public String getRow_weight() {
                return row_weight;
            }

            public void setRow_weight(String row_weight) {
                this.row_weight = row_weight;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getBase_price() {
                return base_price;
            }

            public void setBase_price(String base_price) {
                this.base_price = base_price;
            }

            public String getRow_total() {
                return row_total;
            }

            public void setRow_total(String row_total) {
                this.row_total = row_total;
            }

            public String getBase_row_total() {
                return base_row_total;
            }

            public void setBase_row_total(String base_row_total) {
                this.base_row_total = base_row_total;
            }

            public String getRedirect_url() {
                return redirect_url;
            }

            public void setRedirect_url(String redirect_url) {
                this.redirect_url = redirect_url;
            }

            public CustomOptionBean getCustom_option() {
                return custom_option;
            }

            public void setCustom_option(CustomOptionBean custom_option) {
                this.custom_option = custom_option;
            }

            public CustomOptionInfoBean getCustom_option_info() {
                return custom_option_info;
            }

            public void setCustom_option_info(CustomOptionInfoBean custom_option_info) {
                this.custom_option_info = custom_option_info;
            }

            public List<?> getSpu_options() {
                return spu_options;
            }

            public void setSpu_options(List<?> spu_options) {
                this.spu_options = spu_options;
            }

            public static class CustomOptionBean {
                /**
                 * red-s : {"my_color":"red","my_size":"S","sku":"red-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}
                 * white-s : {"my_color":"white","my_size":"S","sku":"white-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}
                 * white-l : {"my_color":"white","my_size":"L","sku":"white-l","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}
                 * white-xxl : {"my_color":"white","my_size":"XXL","sku":"white-xxl","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}
                 */

                @SerializedName("red-s")
                private RedsBean reds;
                @SerializedName("white-s")
                private WhitesBean whites;
                @SerializedName("white-l")
                private WhitelBean whitel;
                @SerializedName("white-xxl")
                private WhitexxlBean whitexxl;

                public RedsBean getReds() {
                    return reds;
                }

                public void setReds(RedsBean reds) {
                    this.reds = reds;
                }

                public WhitesBean getWhites() {
                    return whites;
                }

                public void setWhites(WhitesBean whites) {
                    this.whites = whites;
                }

                public WhitelBean getWhitel() {
                    return whitel;
                }

                public void setWhitel(WhitelBean whitel) {
                    this.whitel = whitel;
                }

                public WhitexxlBean getWhitexxl() {
                    return whitexxl;
                }

                public void setWhitexxl(WhitexxlBean whitexxl) {
                    this.whitexxl = whitexxl;
                }

                public static class RedsBean {
                    /**
                     * my_color : red
                     * my_size : S
                     * sku : red-s
                     * qty : 444
                     * price : 0
                     * image : /1/7/17147202419675158.jpg
                     */

                    private String my_color;
                    private String my_size;
                    private String sku;
                    private int qty;
                    private int price;
                    private String image;

                    public String getMy_color() {
                        return my_color;
                    }

                    public void setMy_color(String my_color) {
                        this.my_color = my_color;
                    }

                    public String getMy_size() {
                        return my_size;
                    }

                    public void setMy_size(String my_size) {
                        this.my_size = my_size;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public int getQty() {
                        return qty;
                    }

                    public void setQty(int qty) {
                        this.qty = qty;
                    }

                    public int getPrice() {
                        return price;
                    }

                    public void setPrice(int price) {
                        this.price = price;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }
                }

                public static class WhitesBean {
                    /**
                     * my_color : white
                     * my_size : S
                     * sku : white-s
                     * qty : 444
                     * price : 0
                     * image : /1/7/17147202419675158.jpg
                     */

                    private String my_color;
                    private String my_size;
                    private String sku;
                    private int qty;
                    private int price;
                    private String image;

                    public String getMy_color() {
                        return my_color;
                    }

                    public void setMy_color(String my_color) {
                        this.my_color = my_color;
                    }

                    public String getMy_size() {
                        return my_size;
                    }

                    public void setMy_size(String my_size) {
                        this.my_size = my_size;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public int getQty() {
                        return qty;
                    }

                    public void setQty(int qty) {
                        this.qty = qty;
                    }

                    public int getPrice() {
                        return price;
                    }

                    public void setPrice(int price) {
                        this.price = price;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }
                }

                public static class WhitelBean {
                    /**
                     * my_color : white
                     * my_size : L
                     * sku : white-l
                     * qty : 444
                     * price : 0
                     * image : /1/7/17147202419675158.jpg
                     */

                    private String my_color;
                    private String my_size;
                    private String sku;
                    private int qty;
                    private int price;
                    private String image;

                    public String getMy_color() {
                        return my_color;
                    }

                    public void setMy_color(String my_color) {
                        this.my_color = my_color;
                    }

                    public String getMy_size() {
                        return my_size;
                    }

                    public void setMy_size(String my_size) {
                        this.my_size = my_size;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public int getQty() {
                        return qty;
                    }

                    public void setQty(int qty) {
                        this.qty = qty;
                    }

                    public int getPrice() {
                        return price;
                    }

                    public void setPrice(int price) {
                        this.price = price;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }
                }

                public static class WhitexxlBean {
                    /**
                     * my_color : white
                     * my_size : XXL
                     * sku : white-xxl
                     * qty : 444
                     * price : 0
                     * image : /1/7/17147202419675158.jpg
                     */

                    private String my_color;
                    private String my_size;
                    private String sku;
                    private int qty;
                    private int price;
                    private String image;

                    public String getMy_color() {
                        return my_color;
                    }

                    public void setMy_color(String my_color) {
                        this.my_color = my_color;
                    }

                    public String getMy_size() {
                        return my_size;
                    }

                    public void setMy_size(String my_size) {
                        this.my_size = my_size;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public int getQty() {
                        return qty;
                    }

                    public void setQty(int qty) {
                        this.qty = qty;
                    }

                    public int getPrice() {
                        return price;
                    }

                    public void setPrice(int price) {
                        this.price = price;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }
                }
            }

            public static class CustomOptionInfoBean {
                @SerializedName("My color")
                private String _$MyColor173; // FIXME check this code
                @SerializedName("My size")
                private String _$MySize266; // FIXME check this code

                public String get_$MyColor173() {
                    return _$MyColor173;
                }

                public void set_$MyColor173(String _$MyColor173) {
                    this._$MyColor173 = _$MyColor173;
                }

                public String get_$MySize266() {
                    return _$MySize266;
                }

                public void set_$MySize266(String _$MySize266) {
                    this._$MySize266 = _$MySize266;
                }
            }
        }
    }
}
