package com.gtjh.shop_car.bean;

import java.util.List;

/**
 * Created by android on 2018/7/24.
 */

public class OrderProductsListBean {

    /**
     * item_id : 107
     * active : 1
     * product_id : 57c3aaa9f656f24f353bf56e
     * sku : sk2001-blue-zo
     * name : 对时尚按钮点缀空心网状针织靴子妇女的袖口
     * qty : 1
     * custom_option_sku :
     * product_price : 143.56
     * product_row_price : 143.56
     * base_product_price : 143.56
     * base_product_row_price : 143.56
     * product_name : {"name_en":"Pair of Stylish Button Embellished Hollow Out Mesh Shape Knitted Boot Cuffs For Women","name_fr":"Paire de Bouton élégant Agrémentée évider Mesh Shape tricoté Boot poignets pour les femmes","name_de":"","name_es":"","name_ru":"","name_pt":"","name_zh":"对时尚按钮点缀空心网状针织靴子妇女的袖口"}
     * product_weight : 0
     * product_row_weight : 0
     * product_volume_weight : null
     * product_row_volume_weight : 0
     * product_volume : 0.00
     * product_row_volume : 0
     * product_url : /pair-of-stylish-button-embellished-hollow-out-mesh-shape-knitted-boot-cuffs-for-women
     * product_image : {"gallery":[{"image":"/2/01/20160722142719_96573.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}],"main":{"image":"/2/01/20160722142719_52348.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}}
     * custom_option : []
     * spu_options : {"color":"white","size":"M"}
     * imgUrl : http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/100/100/2/01/20160722142719_52348.jpg
     * custom_option_info : {"color":"white","size":"M"}
     */

    private String sku;
    private String name;
    private int qty;
    private double product_price;
    private String imgUrl;


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


    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



    public static class ProductNameBean {
        /**
         * name_en : Pair of Stylish Button Embellished Hollow Out Mesh Shape Knitted Boot Cuffs For Women
         * name_fr : Paire de Bouton élégant Agrémentée évider Mesh Shape tricoté Boot poignets pour les femmes
         * name_de :
         * name_es :
         * name_ru :
         * name_pt :
         * name_zh : 对时尚按钮点缀空心网状针织靴子妇女的袖口
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
         * gallery : [{"image":"/2/01/20160722142719_96573.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}]
         * main : {"image":"/2/01/20160722142719_52348.jpg","label":"","sort_order":"","is_thumbnails":"1","is_detail":"1"}
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
             * image : /2/01/20160722142719_52348.jpg
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
             * image : /2/01/20160722142719_96573.jpg
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

    public static class SpuOptionsBean {
        /**
         * color : white
         * size : M
         */

        private String color;
        private String size;

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
    }

    public static class CustomOptionInfoBean {
        /**
         * color : white
         * size : M
         */

        private String color;
        private String size;

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
    }
}
