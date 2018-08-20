package com.gtjh.classify.model;

import android.view.View;

import java.util.HashMap;

/**
 * Created by android on 2018/7/4.
 */

public interface IClassifyModel {
    void loadData(int tag);
    //分类信息 -筛选
    void classifyFilter(HashMap<String,Object> param,int tag);
    //分类信息 -内容
    void classifyContent(HashMap<String,Object> param,int tag);
    //详情 -初始化
    void getDetails(HashMap<String,Object> param,int tag);
    //收藏 -加入收藏
    void addFavorite(HashMap<String,Object> param,int tag);
    //评论 -列表
    void evaList(HashMap<String,Object> param,int tag);
    //详情 -加入购物车
    void addCart(HashMap<String,Object> param,int tag);
}
