package com.gtjh.main.presenter;

import java.util.HashMap;

/**
 * Created by android on 2018/7/3.
 */

public interface IMainpresenter {

    void loadMainInfo(int tag);

    void searchResult(HashMap<String,Object> param,int tag);
    void searchFiltrate(HashMap<String,Object> param,int tag);
}
