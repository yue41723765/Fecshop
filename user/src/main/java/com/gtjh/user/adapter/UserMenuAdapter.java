package com.gtjh.user.adapter;

import android.content.Context;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;

import java.util.List;

/**
 * Created by android on 2018/7/6.
 */

public class UserMenuAdapter extends CommonAdapter<Object> {

    public UserMenuAdapter(List<Object> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return 0;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, Object o) {

    }
}
