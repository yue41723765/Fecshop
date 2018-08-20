package com.gtjh.classify.bean;

import java.util.List;

/**
 * Created by android on 2018/7/19.
 */

public class ClassifyBean {
    private String name;
    private String image;
    private QueryItemBean query_item; //排序方式
    private Object filter_info;//细节条件
    private FilterPriceBean filter_price;//钱
    private Object filter_category; //分类条件
    private int page_count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public QueryItemBean getQuery_item() {
        return query_item;
    }

    public void setQuery_item(QueryItemBean query_item) {
        this.query_item = query_item;
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

    public Object getFilter_category() {
        return filter_category;
    }

    public void setFilter_category(Object filter_category) {
        this.filter_category = filter_category;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public class QueryItemBean{

       private List<FilterItemsBean> frontSort;


        public List<FilterItemsBean> getFrontSort() {
            return frontSort;
        }

        public void setFrontSort(List<FilterItemsBean> frontSort) {
            this.frontSort = frontSort;
        }

    }

    public class FilterPriceBean{
        private List<FilterItemsBean> price;

        public void setPrice(List<FilterItemsBean> price) {
            this.price = price;
        }

        public List<FilterItemsBean> getPrice() {
            return price;
        }

    }
}
