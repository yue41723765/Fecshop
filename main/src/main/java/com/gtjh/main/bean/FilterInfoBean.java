package com.gtjh.main.bean;

import java.util.List;

/**
 * Created by android on 2018/7/18.
 */

public class FilterInfoBean {
    /**
     * label : color
     * items : [{"_id":"red","count":1,"selected":false},{"_id":"multicolor","count":1,"selected":false},{"_id":"","count":3,"selected":false},{"_id":"white & black","count":1,"selected":false}]
     */

    private String label;
    private List<ItemsBean> items;

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
         * _id : red
         * count : 1
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
