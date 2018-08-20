package com.gtjh.classify.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.model.enetity.Menu;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;

import java.util.List;

/**
 * Created by android on 2018/7/4.
 */

public class MenuAdapter extends CommonAdapter<Menu> {
    private int selectPosition = 0;

    public MenuAdapter(List<Menu> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_menu;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, Menu menu) {
        TextView tv_menu_name = holder.findViewById(R.id.tv_menu_name);
        View line = holder.findViewById(R.id.line);
        tv_menu_name.setText(menu.getName());
        if (position == selectPosition) {
            line.setVisibility(View.VISIBLE);
        } else {
            line.setVisibility(View.INVISIBLE);
        }
    }

    public void setSelectPosition(int selectPosition) {
        notifyItemChanged( this.selectPosition);
        this.selectPosition = selectPosition;
        notifyItemChanged(selectPosition);
    }
}
