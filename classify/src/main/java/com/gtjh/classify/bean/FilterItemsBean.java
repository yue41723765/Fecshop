package com.gtjh.classify.bean;

/**
 * Created by android on 2018/7/20.
 */

public class FilterItemsBean {
    /**
     * selected : false
     * label : ---$10
     * val : 0-10
     */

    private boolean selected;
    private String label;
    private String val;
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

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
