package com.gtjh.main.bean;

import java.util.List;

/**
 * Created by android on 2018/7/18.
 */

public class SearchFiltrateBean {
    /**
     * searchText : dress
     * searchCount : 13
     * products : [{"one":{"name":"Off-the-Shoulder Long Sleeve High-Low Day Dress Green","sku":"kilw-green","_id":"","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/1/22/12229472_3147185361598497.jpg","price":{"symbol":"$","value":"341.99","code":"USD"},"special_price":"","url":"/catalog/product/57bab43bf656f2e8103bf56e","product_id":"57bab43bf656f2e8103bf56e"},"two":{"name":"Reindeer Pattern Glitter Christmas Dress","sku":"22221","_id":"","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20161101155240_26690.jpg","price":{"symbol":"$","value":"22.68","code":"USD"},"special_price":{"symbol":"$","value":"21.68","code":"USD"},"url":"/catalog/product/581ae91ff656f20f052f0b77","product_id":"581ae91ff656f20f052f0b77"}},{"one":{"name":"Leaves Pattern Waisted Zippered Dress","sku":"sk10002","_id":"","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160723113745_77121.jpg","price":{"symbol":"$","value":"33.00","code":"USD"},"special_price":"","url":"/catalog/product/57d60c6cf656f2b57ddf9deb","product_id":"57d60c6cf656f2b57ddf9deb"},"two":{"name":"Stylish Striped Criss-Cross Women's Dress","sku":"sk0008","_id":"","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160810112221_81491.jpg","price":{"symbol":"$","value":"33.00","code":"USD"},"special_price":"","url":"/catalog/product/57c7da1ef656f20c713bf56e","product_id":"57c7da1ef656f20c713bf56e"}},{"one":{"name":"Spaghetti Strap Print Backless Bodycon Dress","sku":"sk0002","_id":"","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/2/01/20160606112453_71094147323202778861.JPG","price":{"symbol":"$","value":"33.00","code":"USD"},"special_price":"","url":"/catalog/product/57c7daecf656f273013bf570","product_id":"57c7daecf656f273013bf570"},"two":{"name":"Round Collar Floral Print Sleeveless Dress For Women ","sku":"432432","_id":"","image":"http://img.shop.saneim.com/media/catalog/product/cache/bd935443df1c50537d4edaab4af5d446/296/0/1/7/17147202419675158.jpg","price":{"symbol":"$","value":"22.00","code":"USD"},"special_price":"","url":"/catalog/product/57bac5c6f656f2940a3bf570","product_id":"57bac5c6f656f2940a3bf570"}}]
     * refine_by_info : []
     * filter_info : {"color":{"label":"color","items":[{"_id":"khaki","count":1,"selected":false},{"_id":"blue","count":1,"selected":false},{"_id":"black","count":1,"selected":false},{"_id":"red","count":2,"selected":false},{"_id":"white & black","count":2,"selected":false},{"_id":"","count":3,"selected":false},{"_id":"ivory","count":1,"selected":false},{"_id":"green","count":1,"selected":false},{"_id":"multicolor","count":2,"selected":false},{"_id":"white","count":2,"selected":false}]},"size":{"label":"size","items":[{"_id":"S","count":1,"selected":false},{"_id":"L","count":4,"selected":false},{"_id":"","count":7,"selected":false},{"_id":"M","count":3,"selected":false},{"_id":"XL","count":1,"selected":false}]}}
     * filter_price : {"price":[{"selected":false,"label":"---$10","val":"0-10"},{"selected":false,"label":"$10---$20","val":"10-20"},{"selected":false,"label":"$20---$30","val":"20-30"},{"selected":false,"label":"$30---$50","val":"30-50"},{"selected":false,"label":"$50---$100","val":"50-100"},{"selected":false,"label":"$100---$150","val":"100-150"},{"selected":false,"label":"$150---$300","val":"150-300"},{"selected":false,"label":"$300---$500","val":"300-500"},{"selected":false,"label":"$500---$1000","val":"500-1000"},{"selected":false,"label":"$1000---","val":"1000-"}]}
     */

    private String searchText;
    private int searchCount;
    private Object filter_info;
    private FilterPriceBean filter_price;
    private List<InfoBean> refine_by_info;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    public Object getFilter_info() {
        return filter_info;
    }

    public void setFilter_info(Object filter_info) {
        this.filter_info = filter_info;
    }

    public FilterPriceBean getFilter_price() {
        return filter_price;
    }

    public void setFilter_price(FilterPriceBean filter_price) {
        this.filter_price = filter_price;
    }


    public List<InfoBean> getRefine_by_info() {
        return refine_by_info;
    }

    public void setRefine_by_info(List<InfoBean> refine_by_info) {
        this.refine_by_info = refine_by_info;
    }

    public class InfoBean{

        /**
         * attr : clearAll
         * val : clear all
         */

        private String attr;
        private String val;

        public String getAttr() {
            return attr;
        }

        public void setAttr(String attr) {
            this.attr = attr;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

    public class FilterPriceBean{
        private List<PriceBean> price;

        public List<PriceBean> getPrice() {
            return price;
        }

        public void setPrice(List<PriceBean> price) {
            this.price = price;
        }

        public class PriceBean{
            private boolean selected;
            private String label;
            private String val;

            public boolean isSelected() {
                return selected;
            }

            public void setSelected(boolean selected) {
                this.selected = selected;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getVal() {
                return val;
            }

            public void setVal(String val) {
                this.val = val;
            }
        }
    }

}
