package com.gtjh.classify.model.enetity;

import java.util.List;
import java.util.Map;

/**
 * Created by android on 2018/7/4.
 */

public class Menu {
    private String _id;
    private int level;
    private String name;
    private String thumbnail_image;
    private String url;
    private Map<String,MenuChild> child;

    public String get_id() {
        return _id;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail_image() {
        return thumbnail_image;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, MenuChild> getChild() {
        return child;
    }

    public class  MenuChild{
        public String _id;
        public int level;
        public String name;
        public String thumbnail_image;
        public String url;
    }
}
