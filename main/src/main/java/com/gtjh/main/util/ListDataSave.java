package com.gtjh.main.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by android on 2018/7/17.
 */

public  class ListDataSave {

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    private static final String TAG="LISTDATASAVE";
    private static final String NAME="HISTORYSAVE";

    public ListDataSave(Context mContext) {
        preferences = mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    /**
     * 保存List
     * @param datalist
     */
    public   void setDataList(List<String> datalist) {
        if (null == datalist || datalist.size() <= 0)
            return;
        editor.remove(TAG).commit();
        Gson gson = new Gson();
        //转换成json数据，再保存
        String strJson = gson.toJson(removeDuplicateWithOrder(datalist));
        editor.clear();
        editor.putString(TAG, strJson);
        editor.commit();

    }

    /**
     * 获取List
     * @return
     */
    public   List<String> getDataList() {
        List<String> datalist=new ArrayList<>();
        String strJson = preferences.getString(TAG, null);
        if (null == strJson) {
            return datalist;
        }
        Gson gson = new Gson();
        datalist = gson.fromJson(strJson, new TypeToken<List<String>>() {
        }.getType());
        return datalist;

    }

    //去掉重复
    public  List removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }
    //清除
    public  void clear(){
        editor.remove(TAG).commit();
    }
}
