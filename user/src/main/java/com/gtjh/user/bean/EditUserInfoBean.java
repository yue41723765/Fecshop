package com.gtjh.user.bean;

/**
 * Created by android on 2018/7/10.
 */

public class EditUserInfoBean {
    /**
     * email : 2358269014@qq.com
     * firstname : 44444
     * lastname : 666
     * minNameLength : 1
     * maxNameLength : 30
     * minPassLength : 6
     * maxPassLength : 30
     */

    private String email;
    private String firstname;
    private String lastname;
    private String minNameLength;
    private String maxNameLength;
    private String minPassLength;
    private String maxPassLength;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMinNameLength() {
        return minNameLength;
    }

    public void setMinNameLength(String minNameLength) {
        this.minNameLength = minNameLength;
    }

    public String getMaxNameLength() {
        return maxNameLength;
    }

    public void setMaxNameLength(String maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public String getMinPassLength() {
        return minPassLength;
    }

    public void setMinPassLength(String minPassLength) {
        this.minPassLength = minPassLength;
    }

    public String getMaxPassLength() {
        return maxPassLength;
    }

    public void setMaxPassLength(String maxPassLength) {
        this.maxPassLength = maxPassLength;
    }
}
