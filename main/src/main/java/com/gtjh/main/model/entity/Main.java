package com.gtjh.main.model.entity;

import com.gtjh.common.entity.Price;
import com.gtjh.common.util.GsonUtils;
import com.gtjh.common.util.RYLog;

import java.util.List;

/**
 * Created by android on 2018/7/3.
 */

public class Main {
    private List<Product> productList;
    private Advert advertiseImg;

    public Advert getAdvertiseImg() {
        return advertiseImg;
    }

    public List<Product> getProductList() {
        return productList;
    }

    //产品
    public class Product {
        public ProductChild one;
        public ProductChild two;

        public class ProductChild {
            private String name;
            private String sku;
            private String _id;
            private String image;
            private Price price;
            private Object special_price;
            private String url;
            private String product_id;

            public String getName() {
                return name;
            }

            public String getSku() {
                return sku;
            }

            public String get_id() {
                return _id;
            }

            public String getImage() {
                return image;
            }

            public Price getPrice() {
                return price;
            }

            public Price getSpecial_price() {
                if (special_price instanceof String)
                    return null;
                String str=GsonUtils.getGson().toJson(special_price);
                return GsonUtils.getGson().fromJson(str, Price.class);
            }

            public String getUrl() {
                return url;
            }

            public String getProduct_id() {
                return product_id;
            }
        }
    }

    //广告
    public class Advert {
        public List<AdvertInfo> bigImgList;
        public List<AdvertInfo> smallImgList;

        public class AdvertInfo {
            public String imgUrl;
            public String title;
        }
    }

}
