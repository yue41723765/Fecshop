package com.gtjh.user.bean;

import java.util.List;

/**
 * Created by android on 2018/7/16.
 */

public class CollectBean {

    /**
     * productList : [{"_id":{"$oid":"580835d0f656f240742f0b7c"},"name":"袖子信件印刷船员颈部运动衫kahaki xl","url_key":"/raglan-sleeves-letter-printed-crew-neck-sweatshirt-53386451-77774122","price":6.05,"special_price":5.05,"special_from":0,"special_to":0,"image":{"gallery":[{"image":"/2/01/20160905101021_56532.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101022_25969.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101022_79159.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101021_28071147710702992998.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160905101021_28071147710703579813.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/2/01/20160905101021_28071.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}},"updated_at":"2018-07-16 14:14:51","favorite_id":"5b4c37db63a9f00608724803","imgUrl":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160905101021_28071.jpg","price_info":{"price":{"symbol":"$","value":6.05,"code":"USD"},"special_price":{"symbol":"$","value":5.05,"code":"USD"}},"product_id":"580835d0f656f240742f0b7c"},{"_id":{"$oid":"57c7daecf656f273013bf570"},"name":"意大利面条打印背面Bodycon衣服","url_key":"/spaghetti-strap-print-backless-bodycon-dress","price":33,"special_price":0,"special_from":0,"special_to":0,"image":{"gallery":[{"image":"/2/01/20160820092721_36812.JPG","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160820092721_61725.JPG","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/2/01/20160606112453_71094147323202778861.JPG","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}},"updated_at":"2018-07-16 14:14:31","favorite_id":"5b4c37c763a9f006094f0792","imgUrl":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160606112453_71094147323202778861.JPG","price_info":{"price":{"symbol":"$","value":33,"code":"USD"}},"product_id":"57c7daecf656f273013bf570"},{"_id":{"$oid":"57c7da4af656f273013bf56e"},"name":"时尚之字形条纹和火焰无袖连衣裙的妇女","url_key":"/fashion-zigzag-stripe-fit-and-flare-sleeveless-dress-for-women","price":22,"special_price":0,"special_from":0,"special_to":0,"image":{"gallery":[{"image":"/2/01/20160707145717_31266.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"},{"image":"/2/01/20160707145717_54076.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/2/01/20160707145718_97803.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}},"updated_at":"2018-07-16 14:14:02","favorite_id":"5b4c37aa63a9f0060511eed2","imgUrl":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160707145718_97803.jpg","price_info":{"price":{"symbol":"$","value":22,"code":"USD"}},"product_id":"57c7da4af656f273013bf56e"}]
     * count : 3
     * numPerPage : null
     */

    private int count;
    private Object numPerPage;
    private List<ProductListBean> productList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(Object numPerPage) {
        this.numPerPage = numPerPage;
    }

    public List<ProductListBean> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductListBean> productList) {
        this.productList = productList;
    }

    public static class ProductListBean {
        /**
         * _id : {"$oid":"580835d0f656f240742f0b7c"}
         * name : 袖子信件印刷船员颈部运动衫kahaki xl
         * url_key : /raglan-sleeves-letter-printed-crew-neck-sweatshirt-53386451-77774122
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

        private String name;
        private double price;
        private double special_price;
        private String updated_at;
        private String favorite_id;
        private String imgUrl;
        private PriceInfoBean price_info;
        private String product_id;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getSpecial_price() {
            return special_price;
        }

        public void setSpecial_price(double special_price) {
            this.special_price = special_price;
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


        public static class PriceInfoBean {
            /**
             * price : {"symbol":"$","value":6.05,"code":"USD"}
             * special_price : {"symbol":"$","value":5.05,"code":"USD"}
             */

            private PriceBean price;
            private Object special_price;

            public void setSpecial_price(Object special_price) {
                this.special_price = special_price;
            }

            public Object getSpecial_price() {
                return special_price;
            }

            public PriceBean getPrice() {
                return price;
            }

            public void setPrice(PriceBean price) {
                this.price = price;
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
    }

}
