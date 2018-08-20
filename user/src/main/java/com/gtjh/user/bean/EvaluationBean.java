package com.gtjh.user.bean;

/**
 * Created by android on 2018/7/13.
 */

public class EvaluationBean {
    /**
     * product : {"product_id":"580835d0f656f240742f0b7c","spu":"p10001","price_info":{"price":{"symbol":"\u20ac","value":5.63,"code":"EUR"},"special_price":{"symbol":"\u20ac","value":4.7,"code":"EUR"}},"imgUrl":"//img.fancyecommerce.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/150/150/2/01/20160905101021_28071.jpg","product_name":"Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl"}
     * customer_name : 44444 666
     * reviewCaptchaActive : true
     */

    private ProductBean product;
    private String customer_name;
    private boolean reviewCaptchaActive;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public boolean isReviewCaptchaActive() {
        return reviewCaptchaActive;
    }

    public void setReviewCaptchaActive(boolean reviewCaptchaActive) {
        this.reviewCaptchaActive = reviewCaptchaActive;
    }

    public static class ProductBean {
        /**
         * product_id : 580835d0f656f240742f0b7c
         * spu : p10001
         * price_info : {"price":{"symbol":"\u20ac","value":5.63,"code":"EUR"},"special_price":{"symbol":"\u20ac","value":4.7,"code":"EUR"}}
         * imgUrl : //img.fancyecommerce.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/150/150/2/01/20160905101021_28071.jpg
         * product_name : Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl
         */

        private String product_id;
        private String spu;
        private PriceInfoBean price_info;
        private String imgUrl;
        private String product_name;

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getSpu() {
            return spu;
        }

        public void setSpu(String spu) {
            this.spu = spu;
        }

        public PriceInfoBean getPrice_info() {
            return price_info;
        }

        public void setPrice_info(PriceInfoBean price_info) {
            this.price_info = price_info;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public static class PriceInfoBean {
            /**
             * price : {"symbol":"\u20ac","value":5.63,"code":"EUR"}
             * special_price : {"symbol":"\u20ac","value":4.7,"code":"EUR"}
             */

            private PriceBean price;
            private SpecialPriceBean special_price;

            public PriceBean getPrice() {
                return price;
            }

            public void setPrice(PriceBean price) {
                this.price = price;
            }

            public SpecialPriceBean getSpecial_price() {
                return special_price;
            }

            public void setSpecial_price(SpecialPriceBean special_price) {
                this.special_price = special_price;
            }

            public static class PriceBean {
                /**
                 * symbol : €
                 * value : 5.63
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

            public static class SpecialPriceBean {
                /**
                 * symbol : €
                 * value : 4.7
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
}
