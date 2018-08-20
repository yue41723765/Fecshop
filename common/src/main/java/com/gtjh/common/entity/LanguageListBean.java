package com.gtjh.common.entity;

/**
 * Created by android on 2018/8/8.
 */

public class LanguageListBean {

    /**
     * code : fr
     * language : fr_FR
     * languageName : Français
     */

    private String code;
    private String language;
    private String languageName;
    private int checked; //0选中 1未选中

    public LanguageListBean(String code,String language,String languageName,int checked){
        setCode(code);setLanguage(language);setLanguageName(languageName);setChecked(checked);
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getChecked() {
        return checked;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
