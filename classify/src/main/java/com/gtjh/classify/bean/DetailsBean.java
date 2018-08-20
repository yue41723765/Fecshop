package com.gtjh.classify.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by android on 2018/7/20.
 */

public class DetailsBean {



    private ProductBean product;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public static class ProductBean {


        private GroupAttrArrBean groupAttrArr;
        private String name;
        private String sku;
        private int package_number;
        private String spu;
        private ProductReviewBean productReview;
        private String custom_option_showImg_attr;
        private String attr_group;
        private int review_count;
        private String reviw_rate_star_average;
        private ReviwRateStarInfoBean reviw_rate_star_info;
        private PriceInfoBean price_info;
        private Object custom_items;
        private String description;
        private String _id;
        private int is_favorite; //0未 1已
        private List<String> thumbnail_img;
        private List<String> image_detail;
        private List<List<String>> tier_price;
        private List<OptionsBean> options;
        private Object custom_option;


        public GroupAttrArrBean getGroupAttrArr() {
            return groupAttrArr;
        }

        public void setGroupAttrArr(GroupAttrArrBean groupAttrArr) {
            this.groupAttrArr = groupAttrArr;
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

        public int getPackage_number() {
            return package_number;
        }

        public void setPackage_number(int package_number) {
            this.package_number = package_number;
        }

        public String getSpu() {
            return spu;
        }

        public void setSpu(String spu) {
            this.spu = spu;
        }

        public ProductReviewBean getProductReview() {
            return productReview;
        }

        public void setProductReview(ProductReviewBean productReview) {
            this.productReview = productReview;
        }

        public String getCustom_option_showImg_attr() {
            return custom_option_showImg_attr;
        }

        public void setCustom_option_showImg_attr(String custom_option_showImg_attr) {
            this.custom_option_showImg_attr = custom_option_showImg_attr;
        }

        public String getAttr_group() {
            return attr_group;
        }

        public void setAttr_group(String attr_group) {
            this.attr_group = attr_group;
        }

        public int getReview_count() {
            return review_count;
        }

        public void setReview_count(int review_count) {
            this.review_count = review_count;
        }

        public String getReviw_rate_star_average() {
            return reviw_rate_star_average;
        }

        public void setReviw_rate_star_average(String reviw_rate_star_average) {
            this.reviw_rate_star_average = reviw_rate_star_average;
        }

        public ReviwRateStarInfoBean getReviw_rate_star_info() {
            return reviw_rate_star_info;
        }

        public void setReviw_rate_star_info(ReviwRateStarInfoBean reviw_rate_star_info) {
            this.reviw_rate_star_info = reviw_rate_star_info;
        }

        public PriceInfoBean getPrice_info() {
            return price_info;
        }

        public void setPrice_info(PriceInfoBean price_info) {
            this.price_info = price_info;
        }

        public Object getCustom_items() {
            return custom_items;
        }

        public void setCustom_items(Object custom_items) {
            this.custom_items = custom_items;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int getIs_favorite() {
            return is_favorite;
        }

        public void setIs_favorite(int is_favorite) {
            this.is_favorite = is_favorite;
        }

        public List<String> getThumbnail_img() {
            return thumbnail_img;
        }

        public void setThumbnail_img(List<String> thumbnail_img) {
            this.thumbnail_img = thumbnail_img;
        }

        public List<String> getImage_detail() {
            return image_detail;
        }

        public void setImage_detail(List<String> image_detail) {
            this.image_detail = image_detail;
        }

        public List<List<String>> getTier_price() {
            return tier_price;
        }

        public void setTier_price(List<List<String>> tier_price) {
            this.tier_price = tier_price;
        }

        public List<OptionsBean> getOptions() {
            return options;
        }

        public void setOptions(List<OptionsBean> options) {
            this.options = options;
        }

        public Object getCustom_option() {
            return custom_option;
        }

        public void setCustom_option(Object custom_option) {
            this.custom_option = custom_option;
        }

        public static class GroupAttrArrBean {
            /**
             * weight : 0.3 Kg
             * long : 20 Cm
             * width : 20 Cm
             * high : 2 Cm
             * volume weight : 0.16 Kg
             * my remark : 2222
             * style : Work
             * pattern type : Letter
             * sleeve length : Short-Sleeves
             * collar : Round Neck
             * color : khaki
             * size : XL
             * test3 : t_1
             */

            private String weight;
            @SerializedName("long")
            private String longX;
            private String width;
            private String high;
            @SerializedName("volume weight")
            private String _$VolumeWeight269; // FIXME check this code
            @SerializedName("my remark")
            private String _$MyRemark96; // FIXME check this code
            private String style;
            @SerializedName("pattern type")
            private String _$PatternType14; // FIXME check this code
            @SerializedName("sleeve length")
            private String _$SleeveLength318; // FIXME check this code
            private String collar;
            private String color;
            private String size;
            private String test3;

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getLongX() {
                return longX;
            }

            public void setLongX(String longX) {
                this.longX = longX;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String get_$VolumeWeight269() {
                return _$VolumeWeight269;
            }

            public void set_$VolumeWeight269(String _$VolumeWeight269) {
                this._$VolumeWeight269 = _$VolumeWeight269;
            }

            public String get_$MyRemark96() {
                return _$MyRemark96;
            }

            public void set_$MyRemark96(String _$MyRemark96) {
                this._$MyRemark96 = _$MyRemark96;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String get_$PatternType14() {
                return _$PatternType14;
            }

            public void set_$PatternType14(String _$PatternType14) {
                this._$PatternType14 = _$PatternType14;
            }

            public String get_$SleeveLength318() {
                return _$SleeveLength318;
            }

            public void set_$SleeveLength318(String _$SleeveLength318) {
                this._$SleeveLength318 = _$SleeveLength318;
            }

            public String getCollar() {
                return collar;
            }

            public void setCollar(String collar) {
                this.collar = collar;
            }

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

        public static class ProductReviewBean {
            /**
             * _id : {"$oid":"580835d0f656f240742f0b7c"}
             * spu : p10001
             * review_count : 17
             * coll : [{"_id":{"$oid":"5a3083bbbfb7ae0f2760d422"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"113.116.126.150","summary":"99999999999","review_content":"99999999999999999999999","review_date":1513128891,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a30822bbfb7ae0f01028703"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"113.116.126.150","summary":"5555555","review_content":"5555555555555555555555555","review_date":1513128491,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a2ff2b7bfb7ae45f1172973"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"183.11.70.54","summary":"呃呃呃","review_content":"日日日的","review_date":1513091767,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a2ff1aebfb7ae3dae336d44"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"183.11.70.54","summary":"111","review_content":"111","review_date":1513091502,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a2ff197bfb7ae3dae336d43"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"183.11.70.54","summary":"1111","review_content":"111111","review_date":1513091479,"store":"fecshop.apphtml5.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"5a2e0323bfb7ae5f1d2d06b2"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 666","user_id":46,"ip":"183.14.76.219","summary":"3232","review_content":"3232","review_date":1512964899,"store":"fecshop.appfront.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59f1b535bfb7ae43950d79b3"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"4","name":"44444 6666","user_id":46,"ip":"183.14.76.189","summary":"9999999999999","review_content":"99999999999999999999543253453299","review_date":1509012789,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59cf1841bfb7ae2f73783266"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 6666","user_id":46,"ip":"113.116.127.4","summary":"44444444","review_content":"44444444444444444","review_date":1506744385,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59cf1814bfb7ae2f73783265"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"5","name":"44444 6666","user_id":46,"ip":"113.116.127.4","summary":"rerer","review_content":"erere","review_date":1506744340,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505},{"_id":{"$oid":"59cf17b2bfb7ae29ca553ff5"},"product_spu":"p10001","product_id":"580835d0f656f240742f0b7c","rate_star":"3","name":"44444 6666","user_id":46,"ip":"113.116.127.4","summary":"111111111111","review_content":"222222222222222","review_date":1506744242,"store":"fecshop.appserver.fancyecommerce.com","lang_code":"en","status":1,"audit_user":2,"audit_date":1513129505}]
             * noActiveStatus : 10
             */

            private IdBean _id;
            private String spu;
            private int review_count;
            private int noActiveStatus;
            private List<CollBean> coll;

            public IdBean get_id() {
                return _id;
            }

            public void set_id(IdBean _id) {
                this._id = _id;
            }

            public String getSpu() {
                return spu;
            }

            public void setSpu(String spu) {
                this.spu = spu;
            }

            public int getReview_count() {
                return review_count;
            }

            public void setReview_count(int review_count) {
                this.review_count = review_count;
            }

            public int getNoActiveStatus() {
                return noActiveStatus;
            }

            public void setNoActiveStatus(int noActiveStatus) {
                this.noActiveStatus = noActiveStatus;
            }

            public List<CollBean> getColl() {
                return coll;
            }

            public void setColl(List<CollBean> coll) {
                this.coll = coll;
            }

            public static class IdBean {
                /**
                 * $oid : 580835d0f656f240742f0b7c
                 */

                private String $oid;

                public String get$oid() {
                    return $oid;
                }

                public void set$oid(String $oid) {
                    this.$oid = $oid;
                }
            }

            public static class CollBean {
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

                private IdBeanX _id;
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

                public IdBeanX get_id() {
                    return _id;
                }

                public void set_id(IdBeanX _id) {
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

                public static class IdBeanX {
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

        public static class PriceInfoBean {
            private PriceBean price;
            private Object special_price;

            public PriceBean getPrice() {
                return price;
            }

            public void setPrice(PriceBean price) {
                this.price = price;
            }

            public Object getSpecial_price() {
                return special_price;
            }

            public void setSpecial_price(Object special_price) {
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
        }

        public static class OptionsBean {
            /**
             * label : color
             * value : [{"attr_val":"black","active":"active","_id":{"$oid":"5808352af656f23f742f0b7a"},"name":{"name_en":"Raglan Sleeves Letter Printed Crew Neck Sweatshirt","name_fr":"","name_de":"","name_es":"","name_ru":"","name_pt":"","name_zh":"袖子信件印刷船员脖子运动衫"},"url_key":"/raglan-sleeves-letter-printed-crew-neck-sweatshirt-61337464","image":{"gallery":[{"image":"/2/01/20161007110608_50811.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/2/01/20161007110608_78124.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}},"color":"black","size":"XL","test3":"t_1","main_img":"/2/01/20161007110608_78124.jpg","url":"/catalog/product/5808352af656f23f742f0b7a","show_as_img":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/50/55/2/01/20161007110608_78124.jpg"},{"attr_val":"khaki","active":"current","_id":{"$oid":"580835d0f656f240742f0b7c"},"name":{"name_en":"Raglan Sleeves Letter Printed Crew Neck Sweatshirt kahaki-xl","name_fr":"","name_de":"","name_es":"","name_ru":"","name_pt":"","name_zh":"袖子信件印刷船员颈部运动衫kahaki xl","name_it":""},"url_key":"/raglan-sleeves-letter-printed-crew-neck-sweatshirt-53386451-77774122","image":{"gallery":[{"image":"/2/01/20160905101021_56532.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101022_25969.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101022_79159.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101021_28071147710702992998.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101021_28071147710703579813.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/2/01/20160905101021_28071.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}},"color":"khaki","size":"XL","test3":"t_1","main_img":"/2/01/20160905101021_28071.jpg","url":"/catalog/product/580835d0f656f240742f0b7c","show_as_img":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/50/55/2/01/20160905101021_28071.jpg"}]
             */

            private String label;
            private List<ValueBean> value;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public List<ValueBean> getValue() {
                return value;
            }

            public void setValue(List<ValueBean> value) {
                this.value = value;
            }

            public static class ValueBean {
                /**
                 * attr_val : black
                 * active : active
                 * _id : {"$oid":"5808352af656f23f742f0b7a"}
                 * name : {"name_en":"Raglan Sleeves Letter Printed Crew Neck Sweatshirt","name_fr":"","name_de":"","name_es":"","name_ru":"","name_pt":"","name_zh":"袖子信件印刷船员脖子运动衫"}
                 * url_key : /raglan-sleeves-letter-printed-crew-neck-sweatshirt-61337464
                 * image : {"gallery":[{"image":"/2/01/20161007110608_50811.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/2/01/20161007110608_78124.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}}
                 * color : black
                 * size : XL
                 * test3 : t_1
                 * main_img : /2/01/20161007110608_78124.jpg
                 * url : /catalog/product/5808352af656f23f742f0b7a
                 * show_as_img : http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/50/55/2/01/20161007110608_78124.jpg
                 */

                private String attr_val;
                private String active;
                private IdBeanXX _id;
                private String show_as_img;

                public String getAttr_val() {
                    return attr_val;
                }

                public void setAttr_val(String attr_val) {
                    this.attr_val = attr_val;
                }

                public String getActive() {
                    return active;
                }

                public void setActive(String active) {
                    this.active = active;
                }

                public IdBeanXX get_id() {
                    return _id;
                }

                public void set_id(IdBeanXX _id) {
                    this._id = _id;
                }


                public String getShow_as_img() {
                    return show_as_img;
                }

                public void setShow_as_img(String show_as_img) {
                    this.show_as_img = show_as_img;
                }

                public static class IdBeanXX {
                    /**
                     * $oid : 5808352af656f23f742f0b7a
                     */

                    private String $oid;

                    public String get$oid() {
                        return $oid;
                    }

                    public void set$oid(String $oid) {
                        this.$oid = $oid;
                    }
                }

                public static class NameBean {
                    /**
                     * name_en : Raglan Sleeves Letter Printed Crew Neck Sweatshirt
                     * name_fr :
                     * name_de :
                     * name_es :
                     * name_ru :
                     * name_pt :
                     * name_zh : 袖子信件印刷船员脖子运动衫
                     */

                    private String name_en;
                    private String name_fr;
                    private String name_de;
                    private String name_es;
                    private String name_ru;
                    private String name_pt;
                    private String name_zh;

                    public String getName_en() {
                        return name_en;
                    }

                    public void setName_en(String name_en) {
                        this.name_en = name_en;
                    }

                    public String getName_fr() {
                        return name_fr;
                    }

                    public void setName_fr(String name_fr) {
                        this.name_fr = name_fr;
                    }

                    public String getName_de() {
                        return name_de;
                    }

                    public void setName_de(String name_de) {
                        this.name_de = name_de;
                    }

                    public String getName_es() {
                        return name_es;
                    }

                    public void setName_es(String name_es) {
                        this.name_es = name_es;
                    }

                    public String getName_ru() {
                        return name_ru;
                    }

                    public void setName_ru(String name_ru) {
                        this.name_ru = name_ru;
                    }

                    public String getName_pt() {
                        return name_pt;
                    }

                    public void setName_pt(String name_pt) {
                        this.name_pt = name_pt;
                    }

                    public String getName_zh() {
                        return name_zh;
                    }

                    public void setName_zh(String name_zh) {
                        this.name_zh = name_zh;
                    }
                }

                public static class ImageBean {
                    /**
                     * gallery : [{"image":"/2/01/20161007110608_50811.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}]
                     * main : {"image":"/2/01/20161007110608_78124.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}
                     */

                    private MainBean main;
                    private List<GalleryBean> gallery;

                    public MainBean getMain() {
                        return main;
                    }

                    public void setMain(MainBean main) {
                        this.main = main;
                    }

                    public List<GalleryBean> getGallery() {
                        return gallery;
                    }

                    public void setGallery(List<GalleryBean> gallery) {
                        this.gallery = gallery;
                    }

                    public static class MainBean {
                        /**
                         * image : /2/01/20161007110608_78124.jpg
                         * label :
                         * sort_order :
                         * is_thumbnails : 1
                         * is_detail : 1
                         */

                        private String image;
                        private String label;
                        private String sort_order;
                        private String is_thumbnails;
                        private String is_detail;

                        public String getImage() {
                            return image;
                        }

                        public void setImage(String image) {
                            this.image = image;
                        }

                        public String getLabel() {
                            return label;
                        }

                        public void setLabel(String label) {
                            this.label = label;
                        }

                        public String getSort_order() {
                            return sort_order;
                        }

                        public void setSort_order(String sort_order) {
                            this.sort_order = sort_order;
                        }

                        public String getIs_thumbnails() {
                            return is_thumbnails;
                        }

                        public void setIs_thumbnails(String is_thumbnails) {
                            this.is_thumbnails = is_thumbnails;
                        }

                        public String getIs_detail() {
                            return is_detail;
                        }

                        public void setIs_detail(String is_detail) {
                            this.is_detail = is_detail;
                        }
                    }

                    public static class GalleryBean {
                        /**
                         * image : /2/01/20161007110608_50811.jpg
                         * label :
                         * sort_order :
                         * is_thumbnails : 1
                         * is_detail : 1
                         */

                        private String image;
                        private String label;
                        private String sort_order;
                        private String is_thumbnails;
                        private String is_detail;

                        public String getImage() {
                            return image;
                        }

                        public void setImage(String image) {
                            this.image = image;
                        }

                        public String getLabel() {
                            return label;
                        }

                        public void setLabel(String label) {
                            this.label = label;
                        }

                        public String getSort_order() {
                            return sort_order;
                        }

                        public void setSort_order(String sort_order) {
                            this.sort_order = sort_order;
                        }

                        public String getIs_thumbnails() {
                            return is_thumbnails;
                        }

                        public void setIs_thumbnails(String is_thumbnails) {
                            this.is_thumbnails = is_thumbnails;
                        }

                        public String getIs_detail() {
                            return is_detail;
                        }

                        public void setIs_detail(String is_detail) {
                            this.is_detail = is_detail;
                        }
                    }
                }
            }
        }
    }
}
