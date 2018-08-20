package com.gtjh.main.bean;

/**
 * Created by android on 2018/7/17.
 */

public class SearchResultListBean {
    /**
     * one : {"name":"Alluring Long Sleeve Open Back Draped Maxi Dress","sku":"sk1000-blue","_id":"","image":"//img.fancyecommerce.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160727121110_30054.jpg","price":{"symbol":"\u20ac","value":30.69,"code":"EUR"},"special_price":"","url":"/catalog/product/","product_id":"57cfc282f656f21231df9ded"}
     * two : {"name":"Round Collar Floral Print Sleeveless Dress For Women ","sku":"432432","_id":"","image":"//img.fancyecommerce.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/1/7/17147202419675158.jpg","price":{"symbol":"\u20ac","value":20.46,"code":"EUR"},"special_price":"","url":"/catalog/product/","product_id":"57bac5c6f656f2940a3bf570"}
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
         * name : Alluring Long Sleeve Open Back Draped Maxi Dress
         * sku : sk1000-blue
         * _id :
         * image : //img.fancyecommerce.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160727121110_30054.jpg
         * price : {"symbol":"\u20ac","value":30.69,"code":"EUR"}
         * special_price :
         * url : /catalog/product/
         * product_id : 57cfc282f656f21231df9ded
         */

        private String name;
        private String sku;
        private String _id;
        private String image;
        private PriceBean price;
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

        public static class PriceBean {
            /**
             * symbol : €
             * value : 30.69
             * code : EUR
             */

            private String symbol;
            private double value;
            private String code;

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
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

    public static class TwoBean {
        /**
         * name : Round Collar Floral Print Sleeveless Dress For Women
         * sku : 432432
         * _id :
         * image : //img.fancyecommerce.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/1/7/17147202419675158.jpg
         * price : {"symbol":"\u20ac","value":20.46,"code":"EUR"}
         * special_price :
         * url : /catalog/product/
         * product_id : 57bac5c6f656f2940a3bf570
         */

        private String name;
        private String sku;
        private String _id;
        private String image;
        private PriceBeanX price;
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

        public PriceBeanX getPrice() {
            return price;
        }

        public void setPrice(PriceBeanX price) {
            this.price = price;
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

        public static class PriceBeanX {
            /**
             * symbol : €
             * value : 20.46
             * code : EUR
             */

            private String symbol;
            private double value;
            private String code;

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
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
}
