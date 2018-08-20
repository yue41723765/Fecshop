package com.gtjh.classify.bean;

import java.util.List;

/**
 * Created by android on 2018/8/1.
 */

public class EvaBean {
    /**
     * product : {"product_id":"580835d0f656f240742f0b7c","spu":"p10001","price_info":{"price":{"symbol":"$","value":6.05,"code":"USD"},"special_price":{"symbol":"$","value":5.05,"code":"USD"}},"imgUrl":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/150/150/2/01/20160905101021_28071.jpg","name":"Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl"}
     * reviewList : [{"_id":{"$oid":"5a3083bbbfb7ae0f2760d422"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"113.116.126.150","summary":"99999999999","review_content":"99999999999999999999999","review_date":1513128891,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a30822bbfb7ae0f01028703"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"113.116.126.150","summary":"5555555","review_content":"5555555555555555555555555","review_date":1513128491,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a2ff2b7bfb7ae45f1172973"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"183.11.70.54","summary":"呃呃呃","review_content":"日日日的","review_date":1513091767,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a2ff1aebfb7ae3dae336d44"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"183.11.70.54","summary":"111","review_content":"111","review_date":1513091502,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a2ff197bfb7ae3dae336d43"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"183.11.70.54","summary":"1111","review_content":"111111","review_date":1513091479,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a2e0323bfb7ae5f1d2d06b2"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"183.14.76.219","summary":"3232","review_content":"3232","review_date":1512964899,"store":"fecshop.appfront.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59f1b535bfb7ae43950d79b3"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"4","name":"44444 6666","user_id":46,"ip":"183.14.76.189","summary":"9999999999999","review_content":"99999999999999999999543253453299","review_date":1509012789,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59cf1841bfb7ae2f73783266"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 6666","user_id":46,"ip":"113.116.127.4","summary":"44444444","review_content":"44444444444444444","review_date":1506744385,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59cf1814bfb7ae2f73783265"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 6666","user_id":46,"ip":"113.116.127.4","summary":"rerer","review_content":"erere","review_date":1506744340,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59cf17b2bfb7ae29ca553ff5"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"3","name":"44444 6666","user_id":46,"ip":"113.116.127.4","summary":"111111111111","review_content":"222222222222222","review_date":1506744242,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59cf16e3bfb7ae29ca553ff4"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 6666","user_id":46,"ip":"113.116.127.4","summary":"44444","review_content":"5555","review_date":1506744035,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59ce09e4bfb7ae27953db5d3"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 6666","user_id":46,"ip":"113.116.127.4","summary":"323232","review_content":"3232323232","review_date":1506675172,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59aa367cbfb7ae304321cd12"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"z j","user_id":265,"ip":"59.173.138.127","summary":"zj","review_content":"rewrw","review_date":1504327292,"store":"fecshop.appfront.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5918251dbfb7ae0d724ec1b2"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"4","name":"55@55.com 55@55.com","user_id":116,"ip":"183.11.68.141","summary":"呃呃呃呃呃","review_content":"点点滴滴","review_date":1494754589,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1494754645},{"_id":{"$oid":"581023cff656f21e6d2f0b78"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":5,"name":"1111","summary":"terry water","review_content":"Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl  ,Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl  Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl ","review_date":1477545111,"store":"fecshop.appfront.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1477970004},{"_id":{"$oid":"58104fb2f656f2ec072f0b77"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":5,"name":"lucy","summary":"omeone on an issue with a mention","review_content":"omeone on an issue with a mentionomeone on an issue with a mentionomeone on an issue with a mentionomeone on an issue with a mentionomeone on an issue with a mention","review_date":1477545096,"store":"fecshop.appfront.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1477970004},{"_id":{"$oid":"581070acf656f2ed072f0b77"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":3,"name":"marith","summary":"It features striped style,with long sleeve and round neck design","review_content":"Sweater is a must have in cold days. If you don't have one,add this to your wardrobe.It features striped style,with long sleeve and round neck design. Comfortable to wearand easy to match.Sweater is a must have in cold days. If you don't have one,add this to your wardrobe.It features striped style,with long sleeve and round neck design. Comfortable to wearand easy to match.Sweater is a must have in cold days. If you don't have one,add this to your wardrobe.It features striped style,with long sleeve and round neck design. Comfortable to wearand easy to match.Sweater is a must have in cold days. If you don't have one,add this to your wardrobe.It features striped style,with long sleeve and round neck design. Comfortable to wearand easy to match.","review_date":1477545038,"store":"fecshop.appfront.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1477970004}]
     * review_count : 17
     * reviw_rate_star_average : 5
     * reviw_rate_star_info : {"star_0":0,"star_1":0,"star_2":0,"star_3":0,"star_4":0,"star_5":0}
     */

    private ProductBean product;
    private int review_count;
    private int reviw_rate_star_average;
    private ReviwRateStarInfoBean reviw_rate_star_info;
    private List<ReviewListBean> reviewList;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public int getReviw_rate_star_average() {
        return reviw_rate_star_average;
    }

    public void setReviw_rate_star_average(int reviw_rate_star_average) {
        this.reviw_rate_star_average = reviw_rate_star_average;
    }

    public ReviwRateStarInfoBean getReviw_rate_star_info() {
        return reviw_rate_star_info;
    }

    public void setReviw_rate_star_info(ReviwRateStarInfoBean reviw_rate_star_info) {
        this.reviw_rate_star_info = reviw_rate_star_info;
    }

    public List<ReviewListBean> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<ReviewListBean> reviewList) {
        this.reviewList = reviewList;
    }

    public static class ProductBean {
        /**
         * product_id : 580835d0f656f240742f0b7c
         * spu : p10001
         * price_info : {"price":{"symbol":"$","value":6.05,"code":"USD"},"special_price":{"symbol":"$","value":5.05,"code":"USD"}}
         * imgUrl : http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/150/150/2/01/20160905101021_28071.jpg
         * name : Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl
         */

        private String product_id;
        private String spu;
        private PriceInfoBean price_info;
        private String imgUrl;
        private String name;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static class PriceInfoBean {
            /**
             * price : {"symbol":"$","value":6.05,"code":"USD"}
             * special_price : {"symbol":"$","value":5.05,"code":"USD"}
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
                 * symbol : $
                 * value : 6.05
                 * code : USD
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
                 * symbol : $
                 * value : 5.05
                 * code : USD
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

    public static class ReviwRateStarInfoBean {
        /**
         * star_0 : 0
         * star_1 : 0
         * star_2 : 0
         * star_3 : 0
         * star_4 : 0
         * star_5 : 0
         */

        private int star_0;
        private int star_1;
        private int star_2;
        private int star_3;
        private int star_4;
        private int star_5;

        public int getStar_0() {
            return star_0;
        }

        public void setStar_0(int star_0) {
            this.star_0 = star_0;
        }

        public int getStar_1() {
            return star_1;
        }

        public void setStar_1(int star_1) {
            this.star_1 = star_1;
        }

        public int getStar_2() {
            return star_2;
        }

        public void setStar_2(int star_2) {
            this.star_2 = star_2;
        }

        public int getStar_3() {
            return star_3;
        }

        public void setStar_3(int star_3) {
            this.star_3 = star_3;
        }

        public int getStar_4() {
            return star_4;
        }

        public void setStar_4(int star_4) {
            this.star_4 = star_4;
        }

        public int getStar_5() {
            return star_5;
        }

        public void setStar_5(int star_5) {
            this.star_5 = star_5;
        }
    }

    public static class ReviewListBean {
        /**
         * _id : {"$oid":"5a3083bbbfb7ae0f2760d422"}
         * product_spu : p10001
         * product_id : 580835d0f656f240742f0b7c
         * rate_star : 5
         * name : 44444 666
         * user_id : 46
         * ip : 113.116.126.150
         * summary : 99999999999
         * review_content : 99999999999999999999999
         * review_date : 1513128891
         * store : fecshop.apphtml5.fancyecommerce.com
         * lang_code : en
         * status : 1
         * audit_user : 2
         * audit_date : 1513129505
         */

        private IdBean _id;
        private String product_spu;
        private String product_id;
        private String rate_star;
        private String name;
        private int user_id;
        private String ip;
        private String summary;
        private String review_content;
        private int review_date;
        private String store;
        private String lang_code;
        private int status;
        private int audit_user;
        private int audit_date;

        public IdBean get_id() {
            return _id;
        }

        public void set_id(IdBean _id) {
            this._id = _id;
        }

        public String getProduct_spu() {
            return product_spu;
        }

        public void setProduct_spu(String product_spu) {
            this.product_spu = product_spu;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getRate_star() {
            return rate_star;
        }

        public void setRate_star(String rate_star) {
            this.rate_star = rate_star;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getReview_content() {
            return review_content;
        }

        public void setReview_content(String review_content) {
            this.review_content = review_content;
        }

        public int getReview_date() {
            return review_date;
        }

        public void setReview_date(int review_date) {
            this.review_date = review_date;
        }

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
        }

        public String getLang_code() {
            return lang_code;
        }

        public void setLang_code(String lang_code) {
            this.lang_code = lang_code;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getAudit_user() {
            return audit_user;
        }

        public void setAudit_user(int audit_user) {
            this.audit_user = audit_user;
        }

        public int getAudit_date() {
            return audit_date;
        }

        public void setAudit_date(int audit_date) {
            this.audit_date = audit_date;
        }

        public static class IdBean {
            /**
             * $oid : 5a3083bbbfb7ae0f2760d422
             */

            private String $oid;

            public String get$oid() {
                return $oid;
            }

            public void set$oid(String $oid) {
                this.$oid = $oid;
            }
        }
    }
}
