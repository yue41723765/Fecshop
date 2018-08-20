package com.gtjh.main.model;

import java.util.HashMap;

/**
 * Created by android on 2018/7/3.
 */

public interface IMainModel {
    void loadMainInfo(int tag);

    //搜索 -搜索结果
    void searchResult(HashMap<String,Object> param,int tag);
    //搜索 -搜索筛选
    void searchFiltrate(HashMap<String,Object> param,int tag);
}
