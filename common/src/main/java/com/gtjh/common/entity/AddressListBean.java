package com.gtjh.common.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by android on 2018/7/10.
 */

public class AddressListBean implements Parcelable {
    /**
     * address_id : 117
     * first_name : 111
     * email : 34343@3232.com
     * last_name : 222
     * company : null
     * telephone : 3232
     * fax : null
     * street1 : 3232
     * street2 : 3232
     * city : 3232
     * state : BJ
     * zip : ewewew
     * country : CN
     * customer_id : 46
     * created_at : 1506397313
     * updated_at : 1509161659
     * is_default : 2
     * stateName : 北京市
     * countryName : China
     */

    private String address_id;
    private String first_name;
    private String email;
    private String last_name;
    private Object company;
    private String telephone;
    private Object fax;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String customer_id;
    private String created_at;
    private String updated_at;
    private String is_default;
    private String stateName;
    private String countryName;

    public AddressListBean(){}
    protected AddressListBean(Parcel in) {
        address_id = in.readString();
        first_name = in.readString();
        email = in.readString();
        last_name = in.readString();
        telephone = in.readString();
        street1 = in.readString();
        street2 = in.readString();
        city = in.readString();
        state = in.readString();
        zip = in.readString();
        country = in.readString();
        customer_id = in.readString();
        created_at = in.readString();
        updated_at = in.readString();
        is_default = in.readString();
        stateName = in.readString();
        countryName = in.readString();
    }

    public static final Creator<AddressListBean> CREATOR = new Creator<AddressListBean>() {
        @Override
        public AddressListBean createFromParcel(Parcel in) {
            return new AddressListBean(in);
        }

        @Override
        public AddressListBean[] newArray(int size) {
            return new AddressListBean[size];
        }
    };

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Object getFax() {
        return fax;
    }

    public void setFax(Object fax) {
        this.fax = fax;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address_id);
        dest.writeString(first_name);
        dest.writeString(email);
        dest.writeString(last_name);
        dest.writeString(telephone);
        dest.writeString(street1);
        dest.writeString(street2);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(zip);
        dest.writeString(country);
        dest.writeString(customer_id);
        dest.writeString(created_at);
        dest.writeString(updated_at);
        dest.writeString(is_default);
        dest.writeString(stateName);
        dest.writeString(countryName);
    }
}
