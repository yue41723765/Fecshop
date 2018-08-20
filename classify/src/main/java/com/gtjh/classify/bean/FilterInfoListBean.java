package com.gtjh.classify.bean;

import java.util.List;

/**
 * Created by android on 2018/7/19.
 */

public class FilterInfoListBean {
    /**
     * label : color
     * items : [{"_id":"khaki","count":5,"selected":false},{"_id":"multicolor","count":2,"selected":false},{"_id":"black","count":5,"selected":false}]
     */

    private String label;
    private List<ItemsBean> items;
    private String val;

    public void setVal(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * _id : khaki
         * count : 5
         * selected : false
         */

        private String _id;
        private int count;
        private boolean selected;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }
}
