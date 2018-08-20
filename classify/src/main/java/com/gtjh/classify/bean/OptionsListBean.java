package com.gtjh.classify.bean;

/**
 * Created by android on 2018/7/27.
 */

public class OptionsListBean  {
    private String value;
    private String id;
    private String active;
    private String img;


    public OptionsListBean(String value,String id,String active,String img){
        setActive(active);
        setId(id);
        setValue(value);
        setImg(img);
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
