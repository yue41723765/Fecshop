package com.gtjh.classify.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.activity.ClassifyActivity;
import com.gtjh.classify.model.enetity.Menu;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;

import java.util.List;

/**
 * Created by android on 2018/7/4.
 */

public class MenuChildAdapter extends CommonAdapter<Menu.MenuChild> {

    public MenuChildAdapter(List<Menu.MenuChild> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_menu_child;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, final Menu.MenuChild menuChild) {
        TextView tv_name = holder.findViewById(R.id.tv_name);
        ImageView iv_img = holder.findViewById(R.id.iv_img);
        LinearLayout all=holder.findViewById(R.id.ll_all);
        ImageLoaderPresenter.getInstance().loadCircle(context, menuChild.thumbnail_image, iv_img);
        tv_name.setText(menuChild.name);

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ClassifyActivity.class);
                intent.putExtra("categoryId",menuChild._id);
                context.startActivity(intent);
            }
        });
    }
}
