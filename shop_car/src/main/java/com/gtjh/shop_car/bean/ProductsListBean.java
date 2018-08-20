package com.gtjh.shop_car.bean;

import java.util.List;

/**
 * Created by android on 2018/7/23.
 */

public class ProductsListBean {

    /**
     * item_id : 394
     * product_id : 580835d0f656f240742f0b7c
     * sku : p10001-kahaki-xl
     * name : Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl
     * qty : 1
     * custom_option_sku :
     * product_price : 5.05
     * product_row_price : 5.05
     * base_product_price : 5.05
     * base_product_row_price : 5.05
     * product_weight : 55
     * product_row_weight : 55
     * product_url : /raglan-sleeves-letter-printed-crew-neck-sweatshirt-53386451-77774122
     * custom_option : []
     * spu_options : {"color":"khaki","size":"XL","test3":"t_1"}
     * img_url : //img.fancyecommerce.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/150/150/2/01/20160905101021_28071.jpg
     * url : /catalog/product/580835d0f656f240742f0b7c
     * custom_option_info : {"color":"khaki","size":"XL","test3":"t_1"}
     */

    private Double active;
    private Double item_id;
    private String product_id;
    private String sku;
    private String name;
    private Double qty;
    private String custom_option_sku;
    private double product_price;
    private double product_row_price;
    private double base_product_price;
    private double base_product_row_price;
    private String product_url;
    private Object spu_options;
    private String img_url;
    private String url;
    private Object custom_option_info;

    public void setCustom_option_info(Object custom_option_info) {
        this.custom_option_info = custom_option_info;
    }

    public Object getCustom_option_info() {
        return custom_option_info;
    }

    public void setActive(double active) {
        this.active = active;
    }

    public double getActive() {
        return active;
    }

    public double getItem_id() {
        return item_id;
    }

    public void setItem_id(double item_id) {
        this.item_id = item_id;
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

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getCustom_option_sku() {
        return custom_option_sku;
    }

    public void setCustom_option_sku(String custom_option_sku) {
        this.custom_option_sku = custom_option_sku;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public double getProduct_row_price() {
        return product_row_price;
    }

    public void setProduct_row_price(double product_row_price) {
        this.product_row_price = product_row_price;
    }

    public double getBase_product_price() {
        return base_product_price;
    }

    public void setBase_product_price(double base_product_price) {
        this.base_product_price = base_product_price;
    }

    public double getBase_product_row_price() {
        return base_product_row_price;
    }

    public void setBase_product_row_price(double base_product_row_price) {
        this.base_product_row_price = base_product_row_price;
    }
    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public Object getSpu_options() {
        return spu_options;
    }

    public void setSpu_options(Object spu_options) {
        this.spu_options = spu_options;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public static class SpuOptionsBean {
        /**
         * color : khaki
         * size : XL
         * test3 : t_1
         */

        private String color;
        private String size;
        private String test3;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getTest3() {
            return test3;
        }

        public void setTest3(String test3) {
            this.test3 = test3;
        }
    }

    public static class CustomOptionInfoBean {
        /**
         * color : khaki
         * size : XL
         * test3 : t_1
         */

        private String color;
        private String size;
        private String test3;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getTest3() {
            return test3;
        }

        public void setTest3(String test3) {
            this.test3 = test3;
        }
    }
}
