package com.gtjh.user.bean;

/**
 * Created by android on 2018/7/12.
 */

public class AddressCountyBean {
    /**
     * stateIsSelect : 1
     * stateArr : {"BJ":"北京市","SH":"上海市","TJ":"天津市","CQ":"重庆市","HEB":"河北省","SAX":"山西省","LN":"辽宁省","JL":"吉林省","HLJ":"黑龙江省","JS":"江苏省","ZJ":"浙江省","AH":"安徽省","FJ":"福建省","JX":"江西省","SD":"山东省","HEN":"河南省","HUB":"湖北省","HUN":"湖南省","GD":"广东省","HN":"海南省","SC":"四川省","HZ":"贵州省","YN":"云南省","SNX":"陕西省","GS":"甘肃省","QH":"青海省","TW":"台湾省","GX":"广西壮族自治区","NMG":"内蒙古自治区","XZ":"西藏自治区","NX":"宁夏回族自治区","XJ":"新疆维吾尔自治区","XG":"香港特别行政区"}
     */

    private int stateIsSelect;
    private Object stateArr;

    public int getStateIsSelect() {
        return stateIsSelect;
    }

    public void setStateIsSelect(int stateIsSelect) {
        this.stateIsSelect = stateIsSelect;
    }

    public Object getStateArr() {
        return stateArr;
    }

    public void setStateArr(Object stateArr) {
        this.stateArr = stateArr;
    }

}
