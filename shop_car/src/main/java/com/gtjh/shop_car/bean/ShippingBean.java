package com.gtjh.shop_car.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by android on 2018/8/16.
 */

public class ShippingBean {

    /**
     * cart_info : {"cart_id":"179","store":"appserver.shop.saneim.com","items_count":1,"coupon_code":null,"shipping_method":"middle_shipping","payment_method":"check_money","grand_total":"140.10","shipping_cost":"1.50","coupon_cost":"0.00","product_total":"138.60","base_grand_total":"23.50","base_shipping_cost":"1.50","base_coupon_cost":"0.00","base_product_total":"22.00","products":[{"item_id":342,"active":1,"product_id":"57bac5c6f656f2940a3bf570","sku":"432432","name":"圆领女士花卉印花无袖连衣裙","qty":1,"custom_option_sku":"white-xxl","product_price":138.6,"product_row_price":138.6,"base_product_price":22,"base_product_row_price":22,"product_name":{"name_en":"Round Collar Floral Print Sleeveless Dress For Women ","name_fr":"","name_de":"","name_es":"","name_ru":"","name_pt":"","name_zh":"圆领女士花卉印花无袖连衣裙"},"product_weight":3,"product_row_weight":3,"product_volume_weight":null,"product_row_volume_weight":0,"product_volume":"0.00","product_row_volume":0,"product_url":"/round-collar-floral-print-sleeveless-dress-for-women","product_image":{"gallery":[{"image":"/2/14/21471858107441.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/1/8/18147202419689046.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/e/n_/en_147202419693721.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/e/n_/en_a147202419684540.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/1/7/17147202419675158.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}},"custom_option":{"red-s":{"my_color":"red","my_size":"S","sku":"red-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-s":{"my_color":"white","my_size":"S","sku":"white-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-l":{"my_color":"white","my_size":"L","sku":"white-l","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-xxl":{"my_color":"white","my_size":"XXL","sku":"white-xxl","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}},"spu_options":[],"imgUrl":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/100/100/1/7/17147202419675158.jpg","custom_option_info":{"My color":"white","My size":"XXL"},"image":"/1/7/17147202419675158.jpg"}],"product_weight":"3.00","product_volume_weight":"0.00","product_volume":"0.00"}
     * shippings : [{"method":"middle_shipping","label":"middle shipping( 6-15 work days)","name":"HKBRAM","cost":"1.50","symbol":"￥","checked":true,"shipping_i":1}]
     */

    private CartInfoBean cart_info;
    private List<MethodsListBean> shippings;

    public CartInfoBean getCart_info() {
        return cart_info;
    }

    public void setCart_info(CartInfoBean cart_info) {
        this.cart_info = cart_info;
    }

    public List<MethodsListBean> getShippings() {
        return shippings;
    }

    public void setShippings(List<MethodsListBean> shippings) {
        this.shippings = shippings;
    }

    public static class CartInfoBean {
        /**
         * cart_id : 179
         * store : appserver.shop.saneim.com
         * items_count : 1
         * coupon_code : null
         * shipping_method : middle_shipping
         * payment_method : check_money
         * grand_total : 140.10
         * shipping_cost : 1.50
         * coupon_cost : 0.00
         * product_total : 138.60
         * base_grand_total : 23.50
         * base_shipping_cost : 1.50
         * base_coupon_cost : 0.00
         * base_product_total : 22.00
         * products : [{"item_id":342,"active":1,"product_id":"57bac5c6f656f2940a3bf570","sku":"432432","name":"圆领女士花卉印花无袖连衣裙","qty":1,"custom_option_sku":"white-xxl","product_price":138.6,"product_row_price":138.6,"base_product_price":22,"base_product_row_price":22,"product_name":{"name_en":"Round Collar Floral Print Sleeveless Dress For Women ","name_fr":"","name_de":"","name_es":"","name_ru":"","name_pt":"","name_zh":"圆领女士花卉印花无袖连衣裙"},"product_weight":3,"product_row_weight":3,"product_volume_weight":null,"product_row_volume_weight":0,"product_volume":"0.00","product_row_volume":0,"product_url":"/round-collar-floral-print-sleeveless-dress-for-women","product_image":{"gallery":[{"image":"/2/14/21471858107441.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/1/8/18147202419689046.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/e/n_/en_147202419693721.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/e/n_/en_a147202419684540.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/1/7/17147202419675158.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}},"custom_option":{"red-s":{"my_color":"red","my_size":"S","sku":"red-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-s":{"my_color":"white","my_size":"S","sku":"white-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-l":{"my_color":"white","my_size":"L","sku":"white-l","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-xxl":{"my_color":"white","my_size":"XXL","sku":"white-xxl","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}},"spu_options":[],"imgUrl":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/100/100/1/7/17147202419675158.jpg","custom_option_info":{"My color":"white","My size":"XXL"},"image":"/1/7/17147202419675158.jpg"}]
         * product_weight : 3.00
         * product_volume_weight : 0.00
         * product_volume : 0.00
         */

        private String cart_id;
        private String store;
        private int items_count;
        private Object coupon_code;
        private String shipping_method;
        private String payment_method;
        private String grand_total;
        private String shipping_cost;
        private String coupon_cost;
        private String product_total;
        private String base_grand_total;
        private String base_shipping_cost;
        private String base_coupon_cost;
        private String base_product_total;
        private String product_weight;
        private String product_volume_weight;
        private String product_volume;
        private List<ProductsBean> products;

        public String getCart_id() {
            return cart_id;
        }

        public void setCart_id(String cart_id) {
            this.cart_id = cart_id;
        }

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
        }

        public int getItems_count() {
            return items_count;
        }

        public void setItems_count(int items_count) {
            this.items_count = items_count;
        }

        public Object getCoupon_code() {
            return coupon_code;
        }

        public void setCoupon_code(Object coupon_code) {
            this.coupon_code = coupon_code;
        }

        public String getShipping_method() {
            return shipping_method;
        }

        public void setShipping_method(String shipping_method) {
            this.shipping_method = shipping_method;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public String getGrand_total() {
            return grand_total;
        }

        public void setGrand_total(String grand_total) {
            this.grand_total = grand_total;
        }

        public String getShipping_cost() {
            return shipping_cost;
        }

        public void setShipping_cost(String shipping_cost) {
            this.shipping_cost = shipping_cost;
        }

        public String getCoupon_cost() {
            return coupon_cost;
        }

        public void setCoupon_cost(String coupon_cost) {
            this.coupon_cost = coupon_cost;
        }

        public String getProduct_total() {
            return product_total;
        }

        public void setProduct_total(String product_total) {
            this.product_total = product_total;
        }

        public String getBase_grand_total() {
            return base_grand_total;
        }

        public void setBase_grand_total(String base_grand_total) {
            this.base_grand_total = base_grand_total;
        }

        public String getBase_shipping_cost() {
            return base_shipping_cost;
        }

        public void setBase_shipping_cost(String base_shipping_cost) {
            this.base_shipping_cost = base_shipping_cost;
        }

        public String getBase_coupon_cost() {
            return base_coupon_cost;
        }

        public void setBase_coupon_cost(String base_coupon_cost) {
            this.base_coupon_cost = base_coupon_cost;
        }

        public String getBase_product_total() {
            return base_product_total;
        }

        public void setBase_product_total(String base_product_total) {
            this.base_product_total = base_product_total;
        }

        public String getProduct_weight() {
            return product_weight;
        }

        public void setProduct_weight(String product_weight) {
            this.product_weight = product_weight;
        }

        public String getProduct_volume_weight() {
            return product_volume_weight;
        }

        public void setProduct_volume_weight(String product_volume_weight) {
            this.product_volume_weight = product_volume_weight;
        }

        public String getProduct_volume() {
            return product_volume;
        }

        public void setProduct_volume(String product_volume) {
            this.product_volume = product_volume;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * item_id : 342
             * active : 1
             * product_id : 57bac5c6f656f2940a3bf570
             * sku : 432432
             * name : 圆领女士花卉印花无袖连衣裙
             * qty : 1
             * custom_option_sku : white-xxl
             * product_price : 138.6
             * product_row_price : 138.6
             * base_product_price : 22
             * base_product_row_price : 22
             * product_name : {"name_en":"Round Collar Floral Print Sleeveless Dress For Women ","name_fr":"","name_de":"","name_es":"","name_ru":"","name_pt":"","name_zh":"圆领女士花卉印花无袖连衣裙"}
             * product_weight : 3
             * product_row_weight : 3
             * product_volume_weight : null
             * product_row_volume_weight : 0
             * product_volume : 0.00
             * product_row_volume : 0
             * product_url : /round-collar-floral-print-sleeveless-dress-for-women
             * product_image : {"gallery":[{"image":"/2/14/21471858107441.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/1/8/18147202419689046.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/e/n_/en_147202419693721.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/e/n_/en_a147202419684540.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/1/7/17147202419675158.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}}
             * custom_option : {"red-s":{"my_color":"red","my_size":"S","sku":"red-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-s":{"my_color":"white","my_size":"S","sku":"white-s","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-l":{"my_color":"white","my_size":"L","sku":"white-l","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"},"white-xxl":{"my_color":"white","my_size":"XXL","sku":"white-xxl","qty":444,"price":0,"image":"/1/7/17147202419675158.jpg"}}
             * spu_options : []
             * imgUrl : http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/100/100/1/7/17147202419675158.jpg
             * custom_option_info : {"My color":"white","My size":"XXL"}
             * image : /1/7/17147202419675158.jpg
             */

            private int item_id;
            private int active;
            private String product_id;
            private String sku;
            private String name;
            private int qty;
            private String custom_option_sku;
            private double product_price;
            private double product_row_price;
            private int base_product_price;
            private int base_product_row_price;
            private ProductNameBean product_name;
            private int product_weight;
            private int product_row_weight;
            private Object product_volume_weight;
            private int product_row_volume_weight;
            private String product_volume;
            private int product_row_volume;
            private String product_url;
            private ProductImageBean product_image;
            private CustomOptionBean custom_option;
            private String imgUrl;
            private CustomOptionInfoBean custom_option_info;
            private String image;
            private List<?> spu_options;

            public int getItem_id() {
                return item_id;
            }

            public void setItem_id(int item_id) {
                this.item_id = item_id;
            }

            public int getActive() {
                return active;
            }

            public void setActive(int active) {
                this.active = active;
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

            public int getQty() {
                return qty;
            }

            public void setQty(int qty) {
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

            public int getBase_product_price() {
                return base_product_price;
            }

            public void setBase_product_price(int base_product_price) {
                this.base_product_price = base_product_price;
            }

            public int getBase_product_row_price() {
                return base_product_row_price;
            }

            public void setBase_product_row_price(int base_product_row_price) {
                this.base_product_row_price = base_product_row_price;
            }

            public ProductNameBean getProduct_name() {
                return product_name;
            }

            public void setProduct_name(ProductNameBean product_name) {
                this.product_name = product_name;
            }

            public int getProduct_weight() {
                return product_weight;
            }

            public void setProduct_weight(int product_weight) {
                this.product_weight = product_weight;
            }

            public int getProduct_row_weight() {
                return product_row_weight;
            }

            public void setProduct_row_weight(int product_row_weight) {
                this.product_row_weight = product_row_weight;
            }

            public Object getProduct_volume_weight() {
                return product_volume_weight;
            }

            public void setProduct_volume_weight(Object product_volume_weight) {
                this.product_volume_weight = product_volume_weight;
            }

            public int getProduct_row_volume_weight() {
                return product_row_volume_weight;
            }

            public void setProduct_row_volume_weight(int product_row_volume_weight) {
                this.product_row_volume_weight = product_row_volume_weight;
            }

            public String getProduct_volume() {
                return product_volume;
            }

            public void setProduct_volume(String product_volume) {
                this.product_volume = product_volume;
            }

            public int getProduct_row_volume() {
                return product_row_volume;
            }

            public void setProduct_row_volume(int product_row_volume) {
                this.product_row_volume = product_row_volume;
            }

            public String getProduct_url() {
                return product_url;
            }

            public void setProduct_url(String product_url) {
                this.product_url = product_url;
            }

            public ProductImageBean getProduct_image() {
                return product_image;
            }

            public void setProduct_image(ProductImageBean product_image) {
                this.product_image = product_image;
            }

            public CustomOptionBean getCustom_option() {
                return custom_option;
            }

            public void setCustom_option(CustomOptionBean custom_option) {
                this.custom_option = custom_option;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public CustomOptionInfoBean getCustom_option_info() {
                return custom_option_info;
            }

            public void setCustom_option_info(CustomOptionInfoBean custom_option_info) {
                this.custom_option_info = custom_option_info;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public List<?> getSpu_options() {
                return spu_options;
            }

            public void setSpu_options(List<?> spu_options) {
                this.spu_options = spu_options;
            }

            public static class ProductNameBean {
                /**
                 * name_en : Round Collar Floral Print Sleeveless Dress For Women
                 * name_fr :
                 * name_de :
                 * name_es :
                 * name_ru :
                 * name_pt :
                 * name_zh : 圆领女士花卉印花无袖连衣裙
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

            public static class ProductImageBean {
                /**
                 * gallery : [{"image":"/2/14/21471858107441.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/1/8/18147202419689046.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/e/n_/en_147202419693721.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/e/n_/en_a147202419684540.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}]
                 * main : {"image":"/1/7/17147202419675158.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}
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
                     * image : /1/7/17147202419675158.jpg
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
                     * image : /2/14/21471858107441.jpg
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
                private String _$MyColor165; // FIXME check this code
                @SerializedName("My size")
                private String _$MySize248; // FIXME check this code

                public String get_$MyColor165() {
                    return _$MyColor165;
                }

                public void set_$MyColor165(String _$MyColor165) {
                    this._$MyColor165 = _$MyColor165;
                }

                public String get_$MySize248() {
                    return _$MySize248;
                }

                public void set_$MySize248(String _$MySize248) {
                    this._$MySize248 = _$MySize248;
                }
            }
        }
    }


}
