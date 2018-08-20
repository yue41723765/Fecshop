package com.gtjh.classify.bean;

/**
 * Created by android on 2018/8/2.
 */

public class CustomOptionListBean  {
    /**
     * key : S
     * val : S
     */

    private String key;
    private String val;
    private int isChecked; //0选中，1 可选 ，2不可选
    private String image;
    private String value;
    private int pos;

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPos() {
        return pos;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
