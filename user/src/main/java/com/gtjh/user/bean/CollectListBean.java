package com.gtjh.user.bean;

import com.gtjh.common.util.SPUtil;

import java.util.List;

/**
 * Created by android on 2018/7/16.
 */

public class CollectListBean {


    /**
     * _id : {"$oid":"580835d0f656f240742f0b7c"}
     * name : 袖子信件印刷船员颈部运动衫kahaki xl
     * url_key : /raglan-sleeves-letter-prStringed-crew-neck-sweatshirt-53386451-77774122
     * price : 6.05
     * special_price : 5.05
     * special_from : 0
     * special_to : 0
     * image : {"gallery":[{"image":"/2/01/20160905101021_56532.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101022_25969.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101022_79159.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101021_28071147710702992998.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101021_28071147710703579813.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/2/01/20160905101021_28071.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}}
     * updated_at : 2018-07-16 14:14:51
     * favorite_id : 5b4c37db63a9f00608724803
     * imgUrl : http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160905101021_28071.jpg
     * price_info : {"price":{"symbol":"$","value":6.05,"code":"USD"},"special_price":{"symbol":"$","value":5.05,"code":"USD"}}
     * product_id : 580835d0f656f240742f0b7c
     */

    private IdBean _id;
    private String name;
    private String url_key;
    private String price;
    private String special_price;
    private String special_from;
    private String special_to;
    private ImageBean image;
    private String updated_at;
    private String favorite_id;
    private String imgUrl;
    private PriceInfoBean price_info;
    private String product_id;

    public IdBean get_id() {
        return _id;
    }

    public void set_id(IdBean _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_key() {
        return url_key;
    }

    public void setUrl_key(String url_key) {
        this.url_key = url_key;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecial_price() {
        return special_price;
    }

    public void setSpecial_price(String special_price) {
        this.special_price = special_price;
    }

    public String getSpecial_from() {
        return special_from;
    }

    public void setSpecial_from(String special_from) {
        this.special_from = special_from;
    }

    public String getSpecial_to() {
        return special_to;
    }

    public void setSpecial_to(String special_to) {
        this.special_to = special_to;
    }

    public ImageBean getImage() {
        return image;
    }

    public void setImage(ImageBean image) {
        this.image = image;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(String favorite_id) {
        this.favorite_id = favorite_id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public PriceInfoBean getPrice_info() {
        return price_info;
    }

    public void setPrice_info(PriceInfoBean price_info) {
        this.price_info = price_info;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public static class ImageBean {
        /**
         * gallery : [{"image":"/2/01/20160905101021_56532.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101022_25969.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101022_79159.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101021_28071147710702992998.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101021_28071147710703579813.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}]
         * main : {"image":"/2/01/20160905101021_28071.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}
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
             * image : /2/01/20160905101021_28071.jpg
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
             * image : /2/01/20160905101021_56532.jpg
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

        public static class SpecialPriceBean {
            /**
             * symbol : $
             * value : 5.05
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
}
