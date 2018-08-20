package com.gtjh.common.util;

import retrofit2.http.PUT;

/**
 * Created by android on 2018/6/29.
 */

public class Contans {
    public class Tag {
        public static final int INIT_LANGUAGE = 1;
        public static final int INIT_MAIN = 2;
        public static final int CLASSIFY_MENU = 3;
        public static final int REGISTER = 4;
        public static final int CODE = 5;
        public static final int LOGIN = 6;
        public static final int ADDRESS_LIST=7;
        public static final int USER_INFO=8;
        public static final int SUB_INFO=9;
        public static final int ADDRESS_INITIALIZE=10;
        public static final int ADDRESS_SUBMIT=11;
        public static final int ADDRESS_COUNTY=12;
        public static final int ADDRESS_DELETE=13;
        public static final int ORDER_LIST=14;
        public static final int ORDER_DETAILS=15;
        public static final int ORDER_AGAIN=16;
        public static final int EVALUATION_INIT=17;
        public static final int EVALUATION_SUB=18;
        public static final int COLLECT_LIST=19;
        public static final int COLLECT_DELETE=20;
        public static final int FORGET_INIT=21;
        public static final int FORGET_SEND=22;
        public static final int FORGET_TOKEN=23;
        public static final int FORGET_PW=24;

        public static final int SEARCH=25;
        public static final int SEARCH_FILTRATE=26;

        public static final int CLASSIFY_CONTENT=27;
        public static final int CLASSIFY_FILTRATE=28;
        public static final int DETAILS=37;

        public static final int CART_LIST=29;
        public static final int CART_UPDATA=30;
        public static final int CART_SELECT=31;
        public static final int CART_SELECT_ALL=32;
        public static final int INIT_ORDER=33;
        public static final int ADD_COUPON=34;
        public static final int CANCEL_COUPON=35;
        public static final int SUBMIT_ORDER=36;

        public static final int ADD_FAVORITE=38;
        public static final int EVA_LIST=39;
        public static final int ADD_CART=40;
        public static final int SHIPPING_CART=41;
    }

    public class Url {
        public static final String URL_MAIN = "/cms/home/index";
        public static final String URL_CLASSIFY_MENU = "/general/base/menu";
        public static final String URL_REGISTER = "/customer/register/account";
        public static final String URL_CODE = "/customer/site/captcha";
        public static final String URL_LOGIN = "/customer/login/account";
        public static final String URL_ADDRESS_LIST = "/customer/address/index";
        public static final String URL_USER_INFO = "/customer/editaccount/index";
        public static final String URL_SUB_INFO = "/customer/editaccount/update";
        public static final String URL_ADDRESS_INITIALIZE = "/customer/address/edit";
        public static final String URL_ADDRESS_SUBMIT = "/customer/address/save";
        public static final String URL_ADDRESS_COUNTY = "/customer/address/changecountry";
        public static final String URL_ADDRESS_DELETE = "/customer/address/remove";
        public static final String URL_ORDER_LIST = "/customer/order/index";
        public static final String URL_ORDER_DETAILS = "/customer/order/view";
        public static final String URL_ORDER_AGAIN = "/customer/order/reorder";
        public static final String URL_EVALUATION_INIT = "/catalog/reviewproduct/add";
        public static final String URL_EVALUATION_SUB= " /catalog/reviewproduct/submitreview";
        public static final String URL_COLLECT_LIST= "/customer/productfavorite/index";
        public static final String URL_COLLECT_DELETE="/customer/productfavorite/remove";
        public static final String URL_FORGET_INIT="/customer/forgot/password";
        public static final String URL_FORGET_SEND="/customer/forgot/sendcode";
        public static final String URL_FORGET_TOKEN="/customer/forgot/resetpassword";
        public static final String URL_FORGET_PW="/customer/forgot/submitresetpassword";
        public static final String URL_EVA_LIST="/catalog/reviewproduct/lists";

        //首页模块
        public static final String URL_SEARCH="/catalogsearch/index/product";
        public static final String URL_SEARCH_FILTRATE="/catalogsearch/index/index";

        //分类模块
        public static final String URL_CLASSIFY_CONTENT="/catalog/category/product";
        public static final String URL_CLASSIFY_FILTRATE="/catalog/category/index";
        public static final String URL_DETAILS="/catalog/product/index";
        public static final String URL_ADD_FAVORITE="/catalog/product/favorite";
        public static final String URL_ADD_CART="/checkout/cart/add";

        //购物车
        public static final String URL_CAR_LIST="/checkout/cart/index";
        public static final String URL_CART_UPDATA="/checkout/cart/updateinfo";
        public static final String URL_CART_SELECT="/checkout/cart/selectone";
        public static final String URL_CART_SELECT_ALL="/checkout/cart/selectall";
        public static final String URL_INIT_ORDER="/checkout/onepage/index";
        public static final String URL_ADD_COUPON="/checkout/cart/addcoupon";
        public static final String URL_CANCEL_COUPON="/checkout/cart/cancelcoupon";
        public static final String URL_SUBMIT_ORDER="/checkout/onepage/submitorder";
        public static final String URL_SHIPPING_CART="/checkout/onepage/getshippingandcartinfo";
    }
}
