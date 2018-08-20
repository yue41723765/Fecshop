package com.gtjh.classify.bean;

/**
 * Created by android on 2018/7/19.
 */

public class ClassifyPageListBean {

    /**
     * one : {"name":"肩带长袖高低日礼服","sku":"kilw0001","_id":"57bab0d5f656f2940a3bf56e","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/1/22/12229472_1.jpg","price":{"symbol":"$","value":"358.00","code":"USD"},"special_price":{"symbol":"$","value":"124.00","code":"USD"},"url":"/catalog/product/57bab0d5f656f2940a3bf56e","product_id":"57bab0d5f656f2940a3bf56e"}
     * two : {"name":"迷你长袖开衩","sku":"sk1000-khak","_id":"57cfc212f656f28b5adf9deb","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160715121751_13739.jpg","price":{"symbol":"$","value":"44.56","code":"USD"},"special_price":{"symbol":"$","value":"40.56","code":"USD"},"url":"/catalog/product/57cfc212f656f28b5adf9deb","product_id":"57cfc212f656f28b5adf9deb"}
     */

    private OneBean one;
    private TwoBean two;

    public OneBean getOne() {
        return one;
    }

    public void setOne(OneBean one) {
        this.one = one;
    }

    public TwoBean getTwo() {
        return two;
    }

    public void setTwo(TwoBean two) {
        this.two = two;
    }

    public static class OneBean {
        /**
         * name : 肩带长袖高低日礼服
         * sku : kilw0001
         * _id : 57bab0d5f656f2940a3bf56e
         * image : http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/1/22/12229472_1.jpg
         * price : {"symbol":"$","value":"358.00","code":"USD"}
         * special_price : {"symbol":"$","value":"124.00","code":"USD"}
         * url : /catalog/product/57bab0d5f656f2940a3bf56e
         * product_id : 57bab0d5f656f2940a3bf56e
         */

        private String name;
        private String sku;
        private String _id;
        private String image;
        private PriceBean price;
        private PriceBean special_price;
        private String url;
        private String product_id;

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

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public PriceBean getPrice() {
            return price;
        }

        public void setPrice(PriceBean price) {
            this.price = price;
        }

        public PriceBean getSpecial_price() {
            return special_price;
        }

        public void setSpecial_price(PriceBean special_price) {
            this.special_price = special_price;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }


    }

    public static class TwoBean {
        /**
         * name : 迷你长袖开衩
         * sku : sk1000-khak
         * _id : 57cfc212f656f28b5adf9deb
         * image : http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160715121751_13739.jpg
         * price : {"symbol":"$","value":"44.56","code":"USD"}
         * special_price : {"symbol":"$","value":"40.56","code":"USD"}
         * url : /catalog/product/57cfc212f656f28b5adf9deb
         * product_id : 57cfc212f656f28b5adf9deb
         */

        private String name;
        private String sku;
        private String _id;
        private String image;
        private PriceBean price;
        private PriceBean special_price;
        private String url;
        private String product_id;

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

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public PriceBean getPrice() {
            return price;
        }

        public void setPrice(PriceBean price) {
            this.price = price;
        }

        public PriceBean getSpecial_price() {
            return special_price;
        }

        public void setSpecial_price(PriceBean special_price) {
            this.special_price = special_price;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }



    }

    public static class PriceBean {
        /**
         * symbol : $
         * value : 124.00
         * code : USD
         */

        private String symbol;
        private String value;
        private String code;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
