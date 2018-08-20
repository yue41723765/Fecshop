package com.gtjh.user.bean;

/**
 * Created by android on 2018/7/13.
 */

public class OrderDetailsListBean {
    /**
     * imgUrl : //img.fancyecommerce.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/100/100/2/01/20160905101021_28071.jpg
     * name : Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl
     * sku : p10001-kahaki-xl
     * qty : 15
     * row_total : 58.65
     * product_id : 580835d0f656f240742f0b7c
     * custom_option_info : {"color":"khaki","size":"XL","test3":"t_1"}
     */

    public String imgUrl;
    private String name;
    private String sku;
    private String qty;
    private String row_total;
    private String product_id;
    private Object custom_option_info;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getRow_total() {
        return row_total;
    }

    public void setRow_total(String row_total) {
        this.row_total = row_total;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Object getCustom_option_info() {
        return custom_option_info;
    }

    public void setCustom_option_info(Object custom_option_info) {
        this.custom_option_info = custom_option_info;
    }


}
