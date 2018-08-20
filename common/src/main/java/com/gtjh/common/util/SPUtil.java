package com.gtjh.common.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Administrator on 2017/2/20.
 * 作者：任洋
 * 功能：
 */
public class SPUtil {
    private static final String SP_NAME = "GTJH";
    private static final String ACCOUNT="ACCOUNT";//账号信息
    private static final String TOKEN="TOKEN";
    private static final String UID="UID";
    private static final String ISLOGIN="isLogin";//是否已经登录
    private static final String ISFIRST="ISFIRST";
    private static final String LANGUAGE="language";
    private static final String CURRENCY="currency";


    //保存/获取/清除 货币
    public static void saveCurrency(Context context, String v){add(context,CURRENCY,v);}
    public static String  getCurrency(Context context){ return getString(context,CURRENCY,"CNY");}
    public static void clearCurrency(Context context){clear(context,CURRENCY);}
    //保存/获取/清除 语言
    public static void saveLanguage(Context context, String v){add(context,LANGUAGE,v);}
    public static String  getLanguage(Context context){ return getString(context,LANGUAGE,"zh");}
    public static void clearLanguage(Context context){clear(context,LANGUAGE);}
    //保存/获取/清除 是否第一次安装
    public static void saveIsFirst(Context context, Boolean v){add(context,ISFIRST,v);}
    public static Boolean  getIsFirst(Context context){ return getBoolean(context,ISFIRST);}
    public static void clearIsFirst(Context context){clear(context,ISFIRST);}
    //保存/获取/清除 是否已经登录
    public static void saveIsLogin(Context context, Boolean v){add(context,ISLOGIN,v);}
    public static Boolean  getIsLogin(Context context){ return getBoolean(context,ISLOGIN);}
    public static void clearIsLogin(Context context){clear(context,ISLOGIN);}
    //保存/获取/清除 UID
    public static void saveUid(Context context,String token){add(context,UID,token);}
    public static String getUid(Context context) {
        return getString(context,UID,"");
    }
    public static void clearUid(Context context){
        clear(context,UID);
    }
    //保存/获取/清除token
    public static void saveToken(Context context,String token){add(context,TOKEN,token);}
    public static String getToken(Context context) {
        return getString(context,TOKEN,"");
    }
    public static void clearToken(Context context){
        clear(context,TOKEN);
    }
    //保存/获取/清除 账号信息
    public static void saveAccount(Context context, String v){add(context,ACCOUNT,v);}
    public static String  getAccount(Context context){ return getString(context,ACCOUNT,"");}
    public static void clearAccount(Context context){clear(context,ACCOUNT);}


    public static void add(Context context, String name, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, value);
        editor.commit();
    }
    public static void add(Context context, String name, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(name, value);
        editor.commit();
    }

    public static String getString(Context context, String key,String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, true);
    }

    public static void clear(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).commit();
    }
}
