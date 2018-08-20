package com.gtjh.classify.bean;

/**
 * Created by android on 2018/7/19.
 */

public class CategoryMapBean {
    /**
     * name : Shirts
     * url_key : /shirts
     * parent_id : 57b6ac42f656f246653bf576
     * current : false
     * url : catalog/category/57beb692f656f24e623bf578
     */

    private String name;
    private String url_key;
    private String parent_id;
    private boolean current;
    private String url;

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

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
