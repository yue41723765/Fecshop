package com.gtjh.shop_car.bean;

/**
 * Created by android on 2018/7/24.
 */

public class MethodsListBean  {
    /**
     * label : Check / Money Order
     * imageUrl :
     * supplement : Off-line Money Payments
     *    /**
     * method : free_shipping
     * name : HKBRAM
     * cost : 0.00
     * symbol : €
     * checked :
     * shipping_i : 1
     */

    private String label;
    private String imageUrl;
    private String supplement;
    private String method;
    private String name;
    private String cost;
    private String symbol;
    private String checked;
    private int shipping_i;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public int getShipping_i() {
        return shipping_i;
    }

    public void setShipping_i(int shipping_i) {
        this.shipping_i = shipping_i;
    }
}
